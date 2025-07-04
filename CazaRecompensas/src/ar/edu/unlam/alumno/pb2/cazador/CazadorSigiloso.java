package ar.edu.unlam.alumno.pb2.cazador;

import ar.edu.unlam.alumno.pb2.profugo.Profugo;

public class CazadorSigiloso extends Cazador {

	public CazadorSigiloso(String nombre) {
		super(nombre);
	}

	public Boolean puedeCapturar(Profugo p) {
		return p.getHabilidad() < 50;
	}

	public void intimidarProfugo(Profugo p) {
		p.habilidad = Math.max(0, p.habilidad - 5);
	}
}