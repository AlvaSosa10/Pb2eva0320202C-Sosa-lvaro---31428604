package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo {
	// Si es necesario Utilice herencia o implemente de Interfaces
	// Se debe crear contructeres getters y Setters y los que crean conveniente
	private final Integer EXCESO_VELOCIDAD = 80;
	private Integer cantidadDeEjes;

	// el Limite de velociadad para autos es de 80km
	// en caso que supere dicho limite el este sera multado
	public Camion(String patente, Integer velocidadActual, Integer limiteVelocidad, Integer cantidadDeEjes) {
		super(patente, velocidadActual, limiteVelocidad);
		this.cantidadDeEjes = cantidadDeEjes;
	}

	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}

	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}

	@Override
	public Boolean enInfraccion() {
		Boolean enInfraccion = false;
		if (this.VelocidadActual > EXCESO_VELOCIDAD) {
			enInfraccion = true;
		}
		return enInfraccion;
	}

}
