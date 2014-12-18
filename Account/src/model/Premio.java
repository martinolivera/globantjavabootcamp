package model;

import state.State;
import state.StateOn;

public class Premio {
	
	//Attributes
	private int idPremio;
	private String nombrePremio;
	private int puntos;
	private State state;
	
	//Constructor
	public Premio(int idPremio, String nombrePremio, int puntos) {
		super();
		this.idPremio = idPremio;
		this.nombrePremio = nombrePremio;
		this.puntos = puntos;
		this.state = new StateOn();
	}
	
	public Premio() {
		super();
		// constructor por defecto
	}
	
	//Getters and Setters
	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}
	
	public String getNombrePremio() {
		return nombrePremio;
	}

	public void setNombrePremio(String nombrePremio) {
		this.nombrePremio = nombrePremio;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	//Métodos para manipular la disponibilidad del premio, el estado en sí:
	public boolean availability (){
		//Retorna si está disponible el premio
		return this.state.state();
	}
	
	public void nonAvailable (){
		//Seteo la variable en estado no disponible:
		this.state = state.stateNonAvailable();
	}
	
	public void available(){
		//Seteo la variable en estado disponible:
		this.state = state.stateAvailable();
	}
}
