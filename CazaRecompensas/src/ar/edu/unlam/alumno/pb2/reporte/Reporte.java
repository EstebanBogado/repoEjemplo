package ar.edu.unlam.alumno.pb2.reporte;

import java.util.Comparator;
import java.util.List;

import ar.edu.unlam.alumno.pb2.cazador.Cazador;
import ar.edu.unlam.alumno.pb2.profugo.EsCapturable;
import ar.edu.unlam.alumno.pb2.profugo.Profugo;

public class Reporte {
	public static EsCapturable masHabilCapturado(List<Cazador> cazadores) {
		return cazadores.stream().flatMap(c -> c.getCapturados().stream())
				.max(Comparator.comparingInt(Profugo::getHabilidad)).orElse(null);
	}

	public static Cazador cazadorMasExitoso(List<Cazador> cazadores) {
		return cazadores.stream().max(Comparator.comparingInt(Cazador::getCantidadCapturas)).orElse(null);
	}
}
