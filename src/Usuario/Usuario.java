package Usuario;

import Reciclador.Elemento;
import Reciclador.RepositorioElementos;

public class Usuario {

	private String name;
	private String password;
	private RepositorioElementos elementosLocales;
	
	public Usuario(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Usuario reciclar(Elemento elementoAReciclar) {
		if(elementosLocales.exists(elementoAReciclar)) {
			elementosLocales.buscarElemento(elementoAReciclar).reciclar();
		} else {
			elementosLocales.reciclar(elementoAReciclar);
		}
		return this;
	}

	public Usuario validarPassword(String passwordIngresado) {
		if(passwordIngresado == this.password) return this;
		return null;
	}
	
	//Getters y Setters
	public RepositorioElementos getRepositorioElementos() {
		return this.elementosLocales;
	}
	
	public Usuario setElementosLocales(RepositorioElementos misElementos) {
		this.elementosLocales = misElementos;
		return this;
	}
	
}
