package CazadoresTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.alumno.pb2.cazador.Cazador;
import ar.edu.unlam.alumno.pb2.cazador.CazadorRural;
import ar.edu.unlam.alumno.pb2.cazador.CazadorSigiloso;
import ar.edu.unlam.alumno.pb2.cazador.CazadorUrbano;
//import ar.edu.unlam.alumno.pb2.profugo.EsCapturable;
import ar.edu.unlam.alumno.pb2.profugo.Profugo;
import ar.edu.unlam.alumno.pb2.reporte.Reporte;
import ar.edu.unlam.alumno.pb2.zona.Zona;

public class CazadoresDosTest {

	@Test
	public void testIntimidacionReduceInocenciaYHabilidad() {
		CazadorSigiloso cazadorSombra = new CazadorSigiloso("Sombra");
		Zona zona = new Zona("ZonaX");

		Profugo profugo = new Profugo(50, 60, false);
		zona.agregarProfugo(profugo);

		cazadorSombra.experiencia = 30;
		cazadorSombra.capturarZona(zona);

		assertEquals(48, profugo.getInocencia(), 0.1);
		assertEquals(55, profugo.getHabilidad(), 0.1);
	}

	@Test
	public void testCapturaPorCazadorRural() {
		CazadorRural cazadorRamiro = new CazadorRural("Ramiro");
		Zona zona = new Zona("Campo");

		Profugo p = new Profugo(20, 30, true);
		zona.agregarProfugo(p);

		cazadorRamiro.experiencia = 30;
		cazadorRamiro.capturarZona(zona);

		assertTrue(cazadorRamiro.getCapturados().contains(p));
	}

	@Test
	public void testEntrenamientoEliteEliminaNerviosismo() {
		Profugo profugo = new Profugo(40, 20, true);
		assertTrue(profugo.isNervioso());

		profugo.entrenamientoElite();
		assertFalse(profugo.isNervioso());
	}

	@Test
	public void testProteccionLegalSubeInocenciaAMinimo() {
		Profugo profugo = new Profugo(25, 30, false);
		profugo.proteccionLegal();

		assertEquals(40, profugo.getInocencia(), 0.1);
	}

	@Test
	public void testArtesMarcialesNoSuperaMaximo() {
		Profugo profugo = new Profugo(30, 60, true);
		profugo.artesMarciales();

		assertEquals(100, profugo.getHabilidad(), 0.1);
	}

	@Test
	public void testCazadorMasCapturas() {
		Cazador cazadoraLaura = new CazadorUrbano("Laura");
		Cazador cazadoraSilvia = new CazadorSigiloso("Silvia");

		Profugo profugo1 = new Profugo(10, 30, false);
		Profugo profugo2 = new Profugo(5, 20, false);
		Profugo profugo3 = new Profugo(5, 45, true);

		Zona zona = new Zona("Central");
		zona.agregarProfugo(profugo1);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);

		cazadoraSilvia.experiencia = 50;
		cazadoraSilvia.capturarZona(zona);

		List<Cazador> cazadores = Arrays.asList(cazadoraLaura, cazadoraSilvia);
		Cazador mejor = Reporte.cazadorMasExitoso(cazadores);

		assertEquals("Silvia", mejor.getNombre());
		assertEquals(3, mejor.getCantidadCapturas(), 0.1);
	}
}