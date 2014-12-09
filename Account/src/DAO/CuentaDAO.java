package DAO;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import DAO.Conectar;

import model.Cuenta;
import model.Premio;

public class CuentaDAO {

	protected Connection conn1 = null;
	protected Statement st = null;
	protected String sql = null;
	protected String sql2 = null;
	protected ResultSet rst2 = null;
	protected ResultSet rst1 = null;

	public void saveAccount(Cuenta cuenta) throws Throwable {

		st = Conectar.connectDB().createStatement();

		// en cp saco la lista con posibles elementos, si los hay genera la
		// insercion de el idCuenta del objeto con el idPremio del objeto de la
		// collectio en la tabla inermedia
		Iterator<Premio> cp = cuenta.getPremiosCuenta().iterator();

		while (cp.hasNext()) {
			sql = "INSERT INTO CuentaPremio ( idcuenta, idPremio )"
					+ " VALUES ('" + cuenta.getId() + "', '"
					+ cp.next().getIdPremio() + "',)";

			try {
				st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
		//insertando el objeto cuenta en la bd
		sql2 = "INSERT INTO Cuenta (idcuenta, nombre, apellido, email, puntos)"
				+ " VALUES ('" + cuenta.getId() + "', '" + cuenta.getNombre() 
				+ "'," + "'" + cuenta.getApellido() + "','" + cuenta.getEmail()
				+ "','" + cuenta.getPuntos() + "') ";

		try {
			st.executeUpdate(sql2);
		} catch (SQLException e) {
			updateAccount(cuenta);
			// e.printStackTrace();
		} // un update en el error
	}

	public Cuenta findAccountById(Integer id) throws SQLException {
		// este ID es de de cuenta
		st = Conectar.connectDB().createStatement();

		List<Premio> premiosCuenta = null;
		Cuenta cuenta = null;
		Premio premio = null;

		// etapa donde se obtiene todos los premios asociados al paremetro
		// idcuenta/id

		sql = "select premio.idpremio, nombrePremio, premio.puntos "
				+ "from  cuentapremiojoin premio on cuentapremio.idpremio=premio.idpremio "
				+ "where cuentapremio.idcuenta= '" + id + "'";

		try {
			rst2 = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rst2.next()) {

				premio.setIdPremio(rst2.getInt("idpremio")); // fijarme los tipos
				premio.setNombrePremio("nombre");
				premio.setPuntos(rst2.getInt("puntos"));
				premiosCuenta.add(premio);
				System.out.println(rst2.getInt("idpremio") + rst2.getString("nombrePremio") + rst2.getInt("puntos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// etapa donde se asigna los valoes al objeto uenta , insluco las lista
		// de premios
		sql = "SELECT  nombre, apellido, email, puntos FROM cuenta where idcuenta='"
				+ id + "'";

		try {
			rst1 = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rst1.next()) {

				cuenta.setId(rst1.getInt("idcuenta")); // fijrme los tipos
				cuenta.setNombre("nombre");
				cuenta.setApellido("apellido");
				cuenta.setEmail("email");
				cuenta.setPuntos(rst1.getInt("puntos"));
				// cuenta.setPremiosCuenta(premiosCuenta); tengo que hacer una busqueda para
				cuenta.setPremiosCuenta(premiosCuenta);
				System.out.println(rst1.getInt("idCuenta")+ rst1.getString("nombre")+ rst1.getString("apellido") +
									rst1.getString("email") + rst1.getInt("puntos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cuenta;

	}

	public void deleteAccount(Integer id) throws SQLException {

		st = Conectar.connectDB().createStatement();

		sql = "DELETE FROM  cuenta WHERE idCuenta=" + id + "";

		st.execute(sql);
	}

	public void updateAccount(Cuenta cuenta) throws Throwable {

		st = Conectar.connectDB().createStatement();

		sql2 = "UPDATE cuenta "
				+ "SET nombre='" + cuenta.getNombre() + "', apellido='" + cuenta.getApellido() + ", " + "email='"	+ cuenta.getEmail() + ",puntos='" + cuenta.getPuntos() + ","
				+ "where idcuenta='" + cuenta.getId() + "";

		st.executeUpdate(sql2);

	}

	public void seeAll() {

		try {
			st  = Conectar.connectDB().createStatement(); 
			//muestra todo lo que hay en tabla cuentas
				rst1 = st.executeQuery("select * from cuenta");
				int c=0;
				while (rst1.next()){   
					System.out.println("Fila"+ c+" " + rst1.getInt("idcuenta") + " " + rst1.getString("nombre") + "  " + rst1.getString("apellido") + "  " + rst1.getString("email") + " " + rst1.getInt("puntos") );  
					c++;   		
				}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}