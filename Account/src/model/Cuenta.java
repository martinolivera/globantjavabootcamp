package model;

import java.util.List;

public class Cuenta {
	
	//Attributes
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private int puntos;
	private List<Premio> premiosCuenta;
	
	//Constructor
	public Cuenta(int id, String nombre, String apellido, String email,
			int puntos, List<Premio> premiosCuenta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.puntos = puntos;
		this.premiosCuenta = premiosCuenta;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<Premio> getPremiosCuenta() {
		return premiosCuenta;
	}

	public void setPremiosCuenta(List<Premio> premiosCuenta) {
		this.premiosCuenta = premiosCuenta;
	}
}
