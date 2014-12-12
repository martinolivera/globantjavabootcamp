package helpers;

import java.sql.SQLException;
import java.util.List;

import DAO.CuentaDAO;
import DAO.PremioDAO;
import model.Cuenta;
import model.Premio;

public class CuentaProxy {
	
	private Cuenta miCuenta;
	
	//Constructor
	public CuentaProxy(Cuenta unaCuenta) {
		miCuenta = unaCuenta;
	}

	public int getPuntos() {
		return miCuenta.getPuntos();
	}
	
	public void setPuntos(int puntos) {
		miCuenta.setPuntos(puntos);
	}
	
	public List<Premio> getPremiosCuenta() throws SQLException {
		if (miCuenta.getPremiosCuenta() == null) {
			PremioDAO dao = new PremioDAO();
			List<Premio> lista = dao.findByCuenta (miCuenta.getId());
			miCuenta.setPremiosCuenta(lista);
		}
		
		return miCuenta.getPremiosCuenta();
	}
	
	
}
