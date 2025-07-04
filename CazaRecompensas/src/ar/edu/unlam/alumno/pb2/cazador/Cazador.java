package ar.edu.unlam.alumno.pb2.cazador;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.alumno.pb2.profugo.Profugo;
import ar.edu.unlam.alumno.pb2.zona.Zona;

public abstract class Cazador {
	public Integer experiencia;
	protected String nombre;
	protected List<Profugo> capturados = new ArrayList<>();

	public Cazador(String nombre) {
		this.nombre = nombre;
		this.experiencia = 0;
	}

	public abstract Boolean puedeCapturar(Profugo p);

	public abstract void intimidarProfugo(Profugo p);

	public void capturarZona(Zona zona) {
		List<Profugo> removidos = new ArrayList<>();
		List<Integer> habilidadesIntimidados = new ArrayList<>();

		for (Profugo p : zona.getProfugos()) {
			if (experiencia > p.getInocencia() && puedeCapturar(p)) {
				capturados.add(p);
				removidos.add(p);
			} else {
				p.intimidar(this);
				habilidadesIntimidados.add(p.getHabilidad());
			}
		}

		zona.removerProfugos(removidos);

		Integer minHabilidad = habilidadesIntimidados.stream().min(Integer::compare).orElse(0);

		experiencia += minHabilidad + 2 * removidos.size();
	}

	public Integer getCantidadCapturas() {
		return capturados.size();
	}

	public List<Profugo> getCapturados() {
		return capturados;
	}

	public String getNombre() {
		return nombre;
	}
}
