package ar.edu.unlam.alumno.pb2.cazador;

import ar.edu.unlam.alumno.pb2.profugo.Profugo;

public class CazadorRural extends Cazador {

	public CazadorRural(String nombre) {
		super(nombre);
	}

	public Boolean puedeCapturar(Profugo p) {
		return p.isNervioso();
	}

	public void intimidarProfugo(Profugo p) {
		p.nervioso = true;
	}
}