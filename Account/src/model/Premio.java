package model;

public class Premio {
	
	//Attributes
	private int idPremio;
	private String nombrePremio;
	private int puntos;
	  
	//Constructor
	public Premio(int idPremio, String nombrePremio, int puntos) {
		super();
		this.idPremio = idPremio;
		this.nombrePremio = nombrePremio;
		this.puntos = puntos;
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
	
}