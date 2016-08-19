package Reciclador;

import java.util.ArrayList;

public class Elemento {
	
	private String nombre;
	private int recicladosLocal = 0;
	
	public Elemento(String nombre) {
		this.nombre = nombre;
	}

	public Elemento reciclar() {
		this.recicladosLocal ++;
		return this;
	}
	
	public int getTotalReciclados() {
		return this.recicladosLocal;
	}
	
	public Elemento clone() {
		Elemento nuevoElemento = new Elemento(this.nombre);
		return nuevoElemento;
	}
	
	public String getName() {
		return this.nombre;
	}
	
}
