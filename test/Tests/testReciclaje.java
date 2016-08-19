package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Reciclador.Elemento;
import Reciclador.Reciclador;
import Reciclador.RepositorioElementos;
import Usuario.Usuario;


public class testReciclaje {
	
	Usuario Pepe;
	Usuario Pepita;
	Usuario Pepon;

	
	Reciclador recicladorEstacionUno;
	Reciclador recicladorEstacionDos;
	RepositorioElementos elementosGlobales = new RepositorioElementos();

	Elemento latasDeCoca = new Elemento("Lata de Coca-Cola");
	Elemento pilasViejas = new Elemento("PilasViejas");
	Elemento papeles = new Elemento("Papeles");

	
	@Before
	public void setUp() throws Exception {
		
		Pepe = new Usuario("Pepe", "123456");
		Pepita = new Usuario("Pepita", "123456");
		Pepon = new Usuario("Pepon", "123456");
		
		recicladorEstacionUno = new Reciclador(Pepe, "123456", elementosGlobales);
		recicladorEstacionDos = new Reciclador(Pepon, "123456", elementosGlobales);

		
	}

	@Test
	public void testReciclarElementoDesdeUnaEstacion() throws Exception {
		recicladorEstacionUno.reciclar(pilasViejas);
		recicladorEstacionUno.cambiarUsuario(Pepita, "123456");
		recicladorEstacionUno.reciclar(pilasViejas);
		assertTrue(recicladorEstacionUno.getRecicladosDelDiaParaElElemento(pilasViejas) == 2);
		assertTrue(recicladorEstacionUno.getRecicladosDelUserParaElElemento(pilasViejas) == 1);
	};
	
	@Test
	public void testAlReciclarLosTotalesDeLasEstacionesSonIguales() throws Exception {
		recicladorEstacionUno.reciclar(pilasViejas);
		recicladorEstacionUno.cambiarUsuario(Pepita, "123456");
		recicladorEstacionUno.reciclar(pilasViejas);
		recicladorEstacionDos.reciclar(pilasViejas);
		assertTrue(recicladorEstacionUno.getRecicladosDelDiaParaElElemento(pilasViejas) == 3);
		assertTrue(recicladorEstacionDos.getRecicladosDelDiaParaElElemento(pilasViejas) == 3);
	};
	
	@Test
	public void testReciclarElementoParaMultiplesElementos() throws Exception {
		recicladorEstacionUno.reciclar(pilasViejas).reciclar(latasDeCoca).reciclar(latasDeCoca);
		recicladorEstacionDos.reciclar(latasDeCoca);
		assertTrue(recicladorEstacionUno.getRecicladosDelDiaParaElElemento(pilasViejas) == 1);
		assertTrue(recicladorEstacionUno.getRecicladosDelDiaParaElElemento(latasDeCoca) == 3);
		assertTrue(recicladorEstacionUno.getRecicladosDelUserParaElElemento(pilasViejas) == 1);
		assertTrue(recicladorEstacionDos.getRecicladosDelUserParaElElemento(latasDeCoca) == 1);
		
	};
}
