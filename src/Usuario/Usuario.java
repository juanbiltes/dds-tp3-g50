package Usuario;

import Reciclador.Elemento;
import Reciclador.RepositorioElementos;

public class Usuario {

	private String name;
	private String password;
	private RepositorioElementos repositorioElementos;
	
	public Usuario(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Usuario reciclar(Elemento elementoAReciclar) {
		if(repositorioElementos.exists(elementoAReciclar)) {
			repositorioElementos.reciclarExistente(elementoAReciclar);
		} else {
			repositorioElementos.reciclar(elementoAReciclar);
		}
		return this;
	}

	public Usuario validarPassword(String passwordIngresado) {
		if(passwordIngresado == this.password) return this;
		return null;
	}
	
	//Getters y Setters
	public RepositorioElementos getRepositorioElementos() {
		return this.repositorioElementos;
	}
	
	public Usuario setElementosLocales(RepositorioElementos misElementos) {
		this.repositorioElementos = misElementos;
		return this;
	}
	
	

	
	
	
}
