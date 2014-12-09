package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Premio;


public class PremioDAO {
	
	protected Connection conn1 = null;  
	protected Statement  st  = null;  
	protected String     sql  = null;  
	protected String     sql2  = null;  
	protected ResultSet  rst1 = null;
      
	public void saveReward(Premio reward) throws Throwable {
		
		//conecto a la bd
		st=Conectar.connectDB().createStatement();

  		  //armo query sql, para insertar un reward/premio
          	sql ="INSERT INTO premio (idPremio, nombrePremio, puntos) "
          			+ "VALUES ('" + reward.getIdPremio() + "', '" + reward.getNombrePremio()+ "','" + reward.getPuntos() + "') ";
          	
          	
			try {
				//execute query dentro de sql
				st.executeUpdate(sql);
			} catch (SQLException e) {
				updateReward(reward);
				e.printStackTrace();
			}
	}
	
	public void saveSeveralAwards() {
	}

	public Premio findRewardById(Integer id) throws SQLException {
		
		st=Conectar.connectDB().createStatement();
		
		
		// Para cada premio, cuenta.getPremios(), para cada premio CuentaPremio.save(idCuenta, idPremio).
		Premio reward =null;
		
				  sql= "select idPremio, nombrePremio, puntos from  premio where idPremio=" + id + "  ";
				  
				  try {
						rst1=st.executeQuery(sql);
					} catch (SQLException e) {
						e.printStackTrace();
					}  
			        try {
						while (rst1.next()){  
							
							reward.setIdPremio(rst1.getInt("idpremio")); //fijrme los tipo
							reward.setNombrePremio("nombrePremio");
							reward.setPuntos(rst1.getInt("puntos"));
							 System.out.println(rst1.getInt("idpremio") + " " + rst1.getString("nombrePremio") + " " + rst1.getInt("puntos") ); 
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} 
				  			  
		return reward ;		
	}
	
	
	public void deleteCuentaById(Integer id) {
		
		try {
			st=Conectar.connectDB().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql="DELETE FROM  premio WHERE idpremio="+id+"";
		
		try {
			st.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}
	
	public void updateReward(Premio reward) throws Throwable {
		
      st=Conectar.connectDB().createStatement();

      sql2 ="UPDATE premio "
      		+ "SET   nombrePremio='" + reward.getNombrePremio()+ "' , puntos='" + reward.getPuntos()+"'"
      				+ " where idpremio=" + reward.getIdPremio() + "";
      st.executeUpdate(sql2);
				
	}
	
	public void seeAll() {

		try {
			st  = Conectar.connectDB().createStatement(); 
			//muestra todo lo que hay en tabla cuentas
				rst1 = st.executeQuery("select * from premio");
				int c=0;
				while (rst1.next()){   
					System.out.println("Fila"+ c+" " + rst1.getInt("idpremio") + " " + rst1.getString("nombrePremio") + " " + rst1.getInt("puntos") );  
					c++;   		
				}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}
