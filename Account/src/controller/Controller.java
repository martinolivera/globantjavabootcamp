package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Cuenta;
import model.Premio;

public class Controller {

	//Attributes
	private List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
	private List<Premio> listaPremios = new ArrayList<Premio>();
	
	//Methods
	public void registrarCuentaController(int id, String nombre, String apellido, String email,
			int puntos, List<Premio> premiosCuenta) {
		Cuenta c = new Cuenta(id, nombre, apellido, email, puntos, premiosCuenta);
		this.getListaCuentas().add(c);	
	}
	
	//Method should to receive email to compare with saved methods (corrijanme si escribo como el culo)
	public boolean buscarCuentaController(String email) {
		//Returns true if Account with mail it is included in list.
		List<Cuenta> list = this.getListaCuentas();
		boolean ok = false;
		int counter=0;
		int limit = list.size();
		while (!ok && counter < limit){
			if (list.get(counter).getEmail().equals(email))
				ok= true;
			counter++;
		}
		return ok;
	}
	
	private void cargarPuntosController() {
		
	}
	
	private void restarPuntosController() {
		
	}
	
	//Getters and Setters
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	public List<Premio> getListaPremios() {
		return listaPremios;
	}
	public void setListaPremios(List<Premio> listaPremios) {
		this.listaPremios = listaPremios;
	}
	
	
}