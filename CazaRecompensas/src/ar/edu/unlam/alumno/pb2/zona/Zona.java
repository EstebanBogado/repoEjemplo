package ar.edu.unlam.alumno.pb2.zona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.alumno.pb2.profugo.Profugo;

public class Zona {
	private String nombre;
	private List<Profugo> profugos;

	public Zona(String nombre) {
		this.setNombre(nombre);
		this.profugos = new ArrayList<>();
	}

	public void agregarProfugo(Profugo p) {
		profugos.add(p);
	}

	public List<Profugo> getProfugos() {
		return profugos;
	}

	public void removerProfugos(List<Profugo> lista) {
		profugos.removeAll(lista);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
