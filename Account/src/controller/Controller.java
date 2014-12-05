package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cuenta;
import model.Premio;

public class Controller {

	Scanner sc = new Scanner(System.in);

	// Attributes
	private List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
	private List<Premio> listaPremios = new ArrayList<Premio>();

	// Methods
	
	public void Controller() {
		
	}
	public boolean registrarCuentaController(int id, String nombre, String apellido, String email) {
		int puntos = 0;
		List<Premio> premiosCuenta = new ArrayList<Premio>();
		// Utilizar el método buscarCuenta y compararlo con null me parece
		// horrible, pensar una mejor manera.
		//CuentaDAO dao = new CuentaDAO();
		//El metodo para obtener cuenta de la lista supone que se levanta todas las cuentas y se la guarda en una lista. Hay algo que podría cambiarse en este punto y que se levante la cuenta directamente:
		
		
		if (this.buscarCuentaController(id) != null) {
			Cuenta c = new Cuenta(id, nombre, apellido, email, puntos,
					premiosCuenta);
			this.getListaCuentas().add(c);
			return true;
		}
		return false;
	}

	public Cuenta buscarCuentaController(int id) {
		// Returns Cuenta if account with mail is included in list.
		List<Cuenta> list = this.getListaCuentas();
		Cuenta c = null;
		boolean ok = false;
		int counter = 0;
		int limit = list.size();
		while (!ok && counter < limit) {
			if (list.get(counter).getId() == id) {
				ok = true;
				c = list.get(counter);
			}
			counter++;
		}
		return c;
	}

	public void cargarPuntosController() {

	}

	public void restarPuntosController() {

	}

	public Cuenta validarCuenta(int idCanjear) {
		for (Cuenta cuenta : listaCuentas) {
			if (cuenta.getId() == idCanjear) {
				return cuenta;
			}
		}
		return null;
	}

	public Premio validarPremio(int idPremio) {
		for (Premio premio : listaPremios) {
			if (idPremio == premio.getIdPremio()) {
				return premio;
			}
		}
		return null;
	}

	public boolean canjearPuntosController(int idCuenta, int idPremio) {
		if (validarPremio(idPremio).getPuntos() <= validarCuenta(idCuenta)
				.getPuntos()) {
			validarCuenta(idCuenta).setPuntos(
					validarCuenta(idCuenta).getPuntos()
							- validarPremio(idCuenta).getPuntos());
			validarCuenta(idCuenta).getPremiosCuenta().add(
					validarPremio(idPremio));
			return true;
		} else {
			return false;
		}
	}

	// Getters and Setters
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
