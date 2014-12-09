package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.CuentaDAO;
import model.Cuenta;
import model.Premio;

public class Controller {

	Scanner sc = new Scanner(System.in);

	// Attributes
	private List<Cuenta> listaCuentas = new ArrayList<Cuenta>();
	private List<Premio> listaPremios = new ArrayList<Premio>();
	private CuentaDAO cuentaDAO;

	//Constructor
	
	public Controller() {
		setCuentaDAO(new CuentaDAO());
	}
	
	// Methods
	
	public void registrarCuentaController(int id, String nombre, String apellido, String email) throws Throwable  {
		int puntos = 0;
		List<Premio> premiosCuenta = new ArrayList<Premio>();
		Cuenta c = new Cuenta(id, nombre, apellido, email, puntos,
				premiosCuenta);
		this.getCuentaDAO().saveAccount(c);
	}

	public Cuenta buscarCuentaController(int id) throws SQLException {
		Cuenta c = this.getCuentaDAO().findAccountById(id);
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

	public CuentaDAO getCuentaDAO() {
		return cuentaDAO;
	}

	public void setCuentaDAO(CuentaDAO cuentaDAO) {
		this.cuentaDAO = cuentaDAO;
	}
	
}
