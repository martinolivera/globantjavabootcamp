package DAO;

import java.sql.*;

public class Conectar {
	
	
	static Connection conexion = null;
	
	/*public static void  conectando() throws SQLException {  
		System.out.println("3");
		try {  
			// Cargamos el controlador JDBC  
			Class.forName("org.hsqldb.jdbcDriver");  
			System.out.println("Se Cargo el controlador JDBC1"); 
			System.out.println("4");
		} catch (Exception e){  
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;  
		}

		System.out.println("5");
	}
	
	
	 public static Connection connectDB() throws SQLException
	    {System.out.println("6");
	          // Connectamos o creamos la BD sino existe 
	            conectando(); 
	    
	            try {
	            	System.out.println("Se Conecto"); 
	            	System.out.println("6b");
					return DriverManager.getConnection("jdbc:hsqldb:file:/usuarios"); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
					return null;
				}
				
	        
	    }*/
	 
	 
	 
	 public static Connection connectDB() throws SQLException {
			try {
				System.out.println("Armada la  conexion 1");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Armada la  conexion 2");
				String url = ("jdbc:mysql://localhost:3306/cesarbd");
				System.out.println("Armada la  conexion 3");
				//return 			
				conexion = DriverManager.getConnection(url, "root", "cesarlalp");

				//System.out.println("Armada la  conexion x");

			} catch (ClassNotFoundException e1) {
				System.out.println("Driver no encontrado");

			} finally {
				try {
					if (conexion != null)
						conexion.close();
				} catch (SQLException e1) {
				}
			}

			System.out.println("Armada la  conexion ssss");
			return conexion;

		}
	 
}
