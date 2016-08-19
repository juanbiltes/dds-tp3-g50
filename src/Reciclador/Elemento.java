package Reciclador;

public class Elemento {
	
	private String nombre;
	private int totalReciclados = 0;
	
	public Elemento(String nombre) {
		this.nombre = nombre;
	}

	public Elemento reciclar() {
		this.totalReciclados ++;
		return this;
	}
	
	public Elemento clone() {
		Elemento nuevoElemento = new Elemento(this.nombre);
		return nuevoElemento;
	}
	
	//Getters & Setters
	
	public int getTotalReciclados() {
		return this.totalReciclados;
	}
	
	public String getName() {
		return this.nombre;
	}
}
