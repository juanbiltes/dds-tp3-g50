package Reciclador;

import Usuario.Login;
import Usuario.Usuario;

public class Reciclador {
	
	Usuario usuarioLogged;
			
	private RepositorioElementos elementosGlobales;
	
	public Reciclador(Usuario user, String password, RepositorioElementos elementosGlobales) {
		this.setElementosDelUser(user);
		usuarioLogged = Login.iniciarSesion(user, password);
		this.elementosGlobales = elementosGlobales;
	}

	private void setElementosDelUser(Usuario user) {
		RepositorioElementos elementosLocalesDelUser = new RepositorioElementos();
		user.setElementosLocales(elementosLocalesDelUser);
	}
	
	public Reciclador cambiarUsuario(Usuario user, String password) {
		this.setElementosDelUser(user);
		usuarioLogged = Login.iniciarSesion(user, password);
		return this;
	}
	
	public Reciclador reciclar(Elemento elementoAReciclar) {
		usuarioLogged.reciclar(elementoAReciclar.clone());
		elementosGlobales.reciclar(elementoAReciclar);
		return this;
	}
	
	public RepositorioElementos getRecicladosDelDia() {
		return this.elementosGlobales;
	}
	
	public RepositorioElementos getRecicladosDelUser() {
		return this.usuarioLogged.getRepositorioElementos();
	}
		
	public int getRecicladosDelDiaParaElElemento(Elemento elemento) {
		return this.elementosGlobales.buscarElemento(elemento).getTotalReciclados();
	}
	
	public int getRecicladosDelUserParaElElemento(Elemento elemento) {
		return this.usuarioLogged.getRepositorioElementos().buscarElemento(elemento).getTotalReciclados();
	}
	

	
	
	
	
	
}
