package Reciclador;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Usuario.Login;
import Usuario.RepositorioDeUsuarios;
import Usuario.Usuario;

public class Reciclador {
	
	RepositorioDeUsuarios usuarios = new RepositorioDeUsuarios();
	Usuario usuarioLogged;
			
	private RepositorioElementos elementosGlobales;
	
	public Reciclador(Usuario user, String password, RepositorioElementos elementosGlobales) {
		this.setElementosDelUser(user);
		usuarios.agregarUsuario(user);
		usuarioLogged = Login.iniciarSesion(user, password);
		this.elementosGlobales = elementosGlobales;
	}

	private void setElementosDelUser(Usuario user) {
		RepositorioElementos elementosLocalesDelUser = new RepositorioElementos();
		user.setElementosLocales(elementosLocalesDelUser);
	}
	
	public void cambiarUsuario(Usuario user, String password) {
		this.setElementosDelUser(user);
		usuarios.agregarUsuario(user);
		usuarioLogged = Login.iniciarSesion(user, password);
	}
	
	public Reciclador reciclar(Elemento elementoAReciclar) {
		usuarioLogged.reciclar(elementoAReciclar.clone());
		elementosGlobales.reciclar(elementoAReciclar);
		return this;
	}
	
	public RepositorioElementos getRecicladosDelDia() {
		return this.elementosGlobales;
	}
		
	public int getRecicladosDelDiaParaElElemento(Elemento elemento) {
		return this.elementosGlobales.buscarElemento(elemento).getTotalReciclados();
	}
	
	public int getRecicladosDelUserParaElElemento(Elemento elemento) {
		return this.usuarioLogged.getRepositorioElementos().buscarElemento(elemento).getTotalReciclados();
	}
	

	
	
	
	
	
}
