package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Autopista {
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los atributos o metodos que
	// crean convenientes
	private HashMap<Integer, Vehiculo> telapase = new HashMap<Integer, Vehiculo>();
	private HashSet<Vehiculo> vehiculosEnCirculacion = new HashSet<Vehiculo>();
	private TreeSet<Vehiculo> excesoVelocidad = new TreeSet<Vehiculo>();

	public Boolean registrarTelepase(Integer numeroTelpase, Vehiculo vehiculo) {
		Boolean seAgrego = false;
		if (vehiculo != null && numeroTelpase != null && numeroTelpase > 0) {
			telapase.put(numeroTelpase, vehiculo);
			seAgrego = true;
		}
		return seAgrego;
	}

	public Boolean ingresarAutopista(Integer numeroTelepase) throws VehiculoNotFounException {
		Boolean ingresoPermitido = false;
		// si el telepase no esta registrado lanza una Exceptios del tipo
		// VehiculoNotFounException
		// y no permite ingresar al autopista
		for (Integer key : telapase.keySet()) {
			if (numeroTelepase.equals(key)) {
				ingresoPermitido = true;
				vehiculosEnCirculacion.add(telapase.get(key));
			} else {
				throw new VehiculoNotFounException("no esta en el telepase");
			}
		}
		return ingresoPermitido;
	}

	public void salirAutpista(Vehiculo vehiculo) throws VehiculoNotFounException {
		// lanza Una exception VehiculoNotFounException si no esta en circulacion
		for (Vehiculo vehiculo1 : vehiculosEnCirculacion) {
			if (vehiculo1.equals(vehiculo)) {
				vehiculosEnCirculacion.remove(vehiculo);
			} else {
				throw new VehiculoNotFounException("no esta en la autopista");
			}
		}
	}

	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente() {
		for (Vehiculo vehiculo1 : excesoVelocidad) {
			if (vehiculo1.enInfraccion() == true) {
				excesoVelocidad.add(vehiculo1);
			}
		}

		return excesoVelocidad;
	}

	public Integer cantidadDeVehiculosENCirculacion() {

		return vehiculosEnCirculacion.size();
	}
}
