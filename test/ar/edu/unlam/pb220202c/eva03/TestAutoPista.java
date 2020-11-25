package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	@Test
	public void queSePuedaRegistrarTelepase() {
		Autopista autopista = new Autopista();
		Automovil auto = new Automovil("ats234", 100, 130);
		Boolean seRegistro = autopista.registrarTelepase(1, auto);
		assertTrue("no se agrego", seRegistro);

	}
	@Test
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista();
		Automovil auto = new Automovil("ats234", 110, 130);

		try {
			autopista.salirAutpista(auto);
		} catch (VehiculoNotFounException e) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente()
			throws VehiculoNotFounException {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("aa", 120, 130);
		Camion auto2 = new Camion("ab", 40, 80, 4);
		Automovil auto3 = new Automovil("ac", 90, 130);
		auto1.setVelocidadActual(200);
		auto2.setVelocidadActual(130);
		auto3.setVelocidadActual(235);
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, auto3);
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);
		autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		String a = auto1.getPatente();
		String z = auto3.getPatente();
		assertEquals(a, autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first().getPatente());
		assertEquals(z, autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last().getPatente());
	}
	@Test
	public void queNoHaya2autosIguales() {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("aa", 100, 130);
		Automovil auto2 = new Automovil("aa", 90, 130);
		autopista.registrarTelepase(1, auto1);
		Boolean a = autopista.registrarTelepase(2, auto2);
		assertFalse(a);
	}
	@Test
	public void queDeCorrectamenteLaCantidadDeVehiculosEnCirculacion() throws VehiculoNotFounException {
		Autopista autopista = new Autopista();
		Automovil auto1 = new Automovil("aa", 100, 130);
		Automovil auto3 = new Automovil("ab", 110, 130);
		Automovil auto4 = new Automovil("ac", 90, 130);
		auto1.setVelocidadActual(250);
		auto3.setVelocidadActual(220);
		auto4.setVelocidadActual(235);
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto3);
		autopista.registrarTelepase(3, auto4);
		autopista.ingresarAutopista(1);
		autopista.ingresarAutopista(2);
		autopista.ingresarAutopista(3);
		Integer a = autopista.cantidadDeVehiculosENCirculacion();
		Integer hay = 3;
		assertEquals(a, hay);

	}
}