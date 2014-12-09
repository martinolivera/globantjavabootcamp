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
		
		st=Conectar.connectDB().createStatement();

  		  
          	sql ="INSERT INTO premio (idPremio, nombrePremio, puntos) "
          			+ "VALUES ('" + reward.getIdPremio() + "', '" + reward.getNombrePremio()+ "','" + reward.getPuntos() + "') ";
          	
          	
			try {
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
		Premio reward = new Premio(id, null, id);
		
				  sql= "select idPremio, nombrePremio, puntos from  premio where idPremio=" + id + "  ";
				  
				  try {
						rst1=st.executeQuery(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  
				  
		return reward ;
		
		//select * from cuenta where id.cuenta=id; throwearlo 
		
	}
	
	
	public void deleteCuentaById(Integer id) {
		
		try {
			st=Conectar.connectDB().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql="DELETE FROM  premio WHERE idpremio="+id+"";
		
		try {
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void updateReward(Premio reward) throws Throwable {
		
      st=Conectar.connectDB().createStatement();

      sql2 ="UPDATE premio SET   nombrePremio='" + reward.getNombrePremio()+ "' , puntos='" + reward.getPuntos()+"' where idpremio=" + reward.getIdPremio() + "";
      st.executeUpdate(sql2);
				
	}
	
	
	
}
