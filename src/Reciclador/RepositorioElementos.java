package Reciclador;

import java.util.ArrayList;

public class RepositorioElementos {
	
	ArrayList<Elemento> elementos = new ArrayList<Elemento>();
	
	public void reciclar(Elemento elementoReciclado) {		
		if(elementos.contains(elementoReciclado)) {
			elementoReciclado.reciclar();
		} else {
			this.elementos.add(elementoReciclado.reciclar());
		}
	}

	public boolean exists(Elemento elementoAReciclar) {
		return elementos.stream().anyMatch(elemento -> elementoAReciclar.getName() == elemento.getName());
	}
	
	public Elemento buscarElemento(Elemento elementoBuscado) {
		return 
		elementos.stream()
		 .filter(elemento -> elemento.getName() == elementoBuscado.getName())
		 .findFirst()
		 .get();
	}
	
	//Getters & Setters
	public ArrayList<Elemento> getElementos() {
		return this.elementos;
	}
}
