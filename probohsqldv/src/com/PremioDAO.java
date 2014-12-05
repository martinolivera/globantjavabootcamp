package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class PremioDAO {
	
	protected Connection conn1 = null;  
	protected Statement  st  = null;  
	protected String     sql  = null;  
	protected String     sql2  = null;  
	protected ResultSet  rst1 = null;
      
    
	
	/*
	public void modAccountByID(Integer idCuenta) {
		st.executeUpdate("UPDATE empleados SET IdCuenta='2334' WHERE idCuenta=100003");
		
	}
	
	public void name() {
		
	}
*/
	
	// sacar los static 
	// tirar a arriba las exceptions
	
	public void saveReward(Premio reward) throws Throwable {
		
		// saco los valores de cuenta y los atributos los meto en un insert
		// Para cada premio, cuenta.getPremios(), para cada premio CuentaPremio.save(idCuenta, idPremio).
		 try {
				conn1=Conectar.connectDB();
			} catch (SQLException e) {
				System.out.println("no conecto");
				e.getCause();
			}
		
		  try {
				st  = conn1.createStatement();
				System.out.println("78");
			} catch (SQLException e) {
				System.out.println("no sr");
				e.getCause();
			}   
		  

  		  
          	sql2 ="INSERT INTO premio (idCuenta, nombre, apellido, email, puntos) VALUES ('" + reward.getIdPremio() + "', '" + reward.getNombrePremio()+ "',"
          		+ "'" + reward.getPuntos() + "') ";
	
			try {
				st.executeUpdate(sql2);
			} catch (SQLException e) {
				updateReward(reward);
				//e.printStackTrace();
			}	//un update en el error
	}
	
	public Premio findRewardById(Integer id) {
		// Para cada premio, cuenta.getPremios(), para cada premio CuentaPremio.save(idCuenta, idPremio).
		Premio reward = new Premio(id, null, id);
		
				try {
					conn1=Conectar.connectDB();
				} catch (SQLException e) {
					System.out.println("no conecto");
					e.getCause();
				}
				
				  try {
						st  = conn1.createStatement();
						System.out.println("78");
					} catch (SQLException e) {
						System.out.println("no sr");
						e.getCause();
					}   
				  
			
				  sql= "select idPremio, nombrePremio, puntos from  premio";
				  
				  try {
						rst1=st.executeQuery(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			        try {
						while (rst1.next()){  
							
							reward.setIdPremio(Integer.parseInt("idPremio")); //fijrme los tipo
							reward.setNombrePremio("nombrePremio");
							reward.setPuntos(Integer.parseInt("puntos"));
							
						    System.out.println(rst1.getInt("idPremio") + " " + rst1.getString("nombrePremio") + " " + rst1.getString("puntos") );  
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  
				  
		return reward ;
		
		//select * from cuenta where id.cuenta=id; throwearlo 
		
	}
	
	
	public void delCuentaById(Integer id) {
		
		//DELETE FROM cuenta WHERE idCuenta=id ;
	}
	
	public void updateReward(Premio reward) throws Throwable {
		
		try {
			conn1=Conectar.connectDB();
		} catch (SQLException e) {
			System.out.println("no conecto");
			e.getCause();
		}
		
		  try {
				st  = conn1.createStatement();
				System.out.println("78");
			} catch (SQLException e) {
				System.out.println("no sr");
				e.getCause();
			}
		  
      sql2 ="UPDATE Cuenta SET (idCuenta='" + reward.getIdPremio() + ", nombre='" + reward.getNombrePremio()+ "', puntos='" + reward.getPuntos()+"') ";
      	
      st.executeUpdate(sql2);
		
		//UPDATE cuenta SET (todos los campos nombre= cuenta.getNombre()) WHERE IdCuenta=cuenta.getID() ;
		
	}
	
	
	
}
