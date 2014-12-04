package controller;

import java.util.ArrayList;
import java.util.List;

import model.Cuenta;
import model.Premio;

public class Controller {

	//Attributes
	private List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
	private List<Premio> listaPremios = new ArrayList<Premio>();
	
	//Methods
	public boolean registrarCuentaController(int id, String nombre, String apellido, String email) {
		int puntos = 0; 
		List<Premio> premiosCuenta = new ArrayList<Premio>();
		//Utilizar el método buscarCuenta y compararlo con null me parece horrible, pensar una mejor manera.
		if (this.buscarCuentaController(email) != null){
			Cuenta c = new Cuenta(id, nombre, apellido, email, puntos, premiosCuenta);
			this.getListaCuentas().add(c);
			return true;
		}
		return false;
	}
	
	//Method should to receive email to compare with saved Cuentas (corrijanme si escribo como el culo)
	public Cuenta buscarCuentaController(String email) {
		//Returns Cuenta if account with mail is included in list.
		List<Cuenta> list = this.getListaCuentas();
		Cuenta c = null;
		boolean ok = false;
		int counter=0;
		int limit = list.size();
		while (!ok && counter < limit){
			if (list.get(counter).getEmail().equals(email)){
				ok= true;
				c = list.get(counter);
			}
			counter++;
		}
		return c;
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