package ar.edu.unlam.alumno.pb2.profugo;

import ar.edu.unlam.alumno.pb2.cazador.Cazador;

public class Profugo implements EsCapturable {
	protected Integer inocencia;
	public Integer habilidad;
	public Boolean nervioso;

	public Profugo(Integer inocencia, Integer habilidad, Boolean nervioso) {
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
	}

	public void intimidar(Cazador cazador) {
		inocencia = Math.max(0, inocencia - 2);
		cazador.intimidarProfugo(this);
	}

	public Integer getInocencia() {
		return inocencia;
	}

	public Integer getHabilidad() {
		return habilidad;
	}

	public Boolean isNervioso() {
		return nervioso;
	}

	// Métodos para entrenamientos
	public void artesMarciales() {
		habilidad = Math.min(100, habilidad * 2);
	}

	public void entrenamientoElite() {
		nervioso = false;
	}

	public void proteccionLegal() {
		if (inocencia < 40)
			inocencia = 40;
	}

	@Override
	public Boolean esCapturable(Cazador cazador) {
		// TODO Auto-generated method stub
		return null;
	}
}