package DAO;

import java.sql.*;

public class Conectar {

	private static Connection conexion;

	public static Connection connectDB() {

		try {
			System.out.println("Armada la  conexion 1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Armada la  conexion 2");
			String url = ("jdbc:mysql://127.0.0.1:3306/cuentas_cesarlalp");
			System.out.println("Armada la  conexion 3");
			conexion = DriverManager.getConnection(url, "root", "1234");

			System.out.println("Armada la  conexion x");

		} catch (ClassNotFoundException e1) {
			System.out.println("Driver no encontrado");

		} catch (SQLException e) {
			System.out.println("Error DB: " + e);
		}
		/*
		 * finally { try { if (conexion != null) conexion.close(); } catch
		 * (SQLException se) { } }
		 */

		System.out.println("Armada la  conexion ssss");

		return conexion;

	}

}
