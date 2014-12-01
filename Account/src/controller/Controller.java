package controller;

import java.util.ArrayList;
import java.util.List;

import model.Cuenta;
import model.Premio;

public class Controller {

	//Attributes
	List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
	List<Premio> listaPremios = new ArrayList<Premio>();
	
	//Methods
	private void registrarCuentaController() {
		
	}
	
	private void buscarCuentaController() {
		
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