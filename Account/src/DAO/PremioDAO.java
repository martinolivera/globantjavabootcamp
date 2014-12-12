package DAO;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;



import model.Cuenta;
import model.Premio;


public class PremioDAO {
	
	protected Connection conn1 = null;  
	protected Statement  st  = null;  
	protected String     sql  = null;  
	protected String     sql2  = null;  
	protected ResultSet  rst1 = null;
	protected ResultSet  rst2 = null;
	private Iterator<Premio> cp; 
    protected ArrayList<Cuenta> cuentas = new ArrayList<>();
    protected ArrayList<Premio> premios = new ArrayList<>();


	public void saveReward(Premio reward) throws Throwable {
		
		//conecto a la bd
		st=Conectar.connectDB().createStatement();

  		  //armo query sql, para insertar un reward/premio
          	sql ="INSERT INTO premio (idPremio, nombrePremio, puntos) VALUES ('" + reward.getIdPremio() + "', '" + reward.getNombrePremio()+ "','" + reward.getPuntos() + "') ";
          	
			try {
				//execute query dentro de sql
				st.executeUpdate(sql);
			} catch (SQLException e) {
				updateReward(reward);
				e.printStackTrace();
			}
	}
	
	public void saveListAwards(ArrayList<Premio> pr) {
		
		pr = new ArrayList<>();
		if (pr!=null) {
			 cp = pr.iterator();
			 
			 while (cp.hasNext()) {	   	 
				  sql= "INSERT INTO Premio ( idPremio, nombrePremio, puntos ) VALUES ("+ cp.next().getIdPremio() +" , " + cp.next().getNombrePremio() + " , " + cp.next().getPuntos() + ")";
			
				  try {
					st.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 		 
		}
		
	}
	}
	
	public Premio findRewardById(Integer id) throws SQLException {
		
		st=Conectar.connectDB().createStatement();
		
		
		// Para cada premio, cuenta.getPremios(), para cada premio CuentaPremio.save(idCuenta, idPremio).
		Premio reward = new Premio();
		
				  sql= "select idPremio, nombrePremio, puntos from  premio where idPremio='"+id.toString()+"'";
				  
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

      sql2 ="UPDATE premio SET nombrePremio='" + reward.getNombrePremio()+ "' , puntos='" + reward.getPuntos()+""
      		+ " where idpremio= "+reward.getIdPremio()+" ";
      st.executeUpdate(sql2);
				
	}
	
	public ArrayList<Cuenta> seeAll() throws SQLException {
		
		 st=Conectar.connectDB().createStatement(); 
			
		rst2= st.executeQuery("select idpremio, nombrePremio, puntos from premio");
			 
		while (rst2.next()){  
			Cuenta cuenta= new Cuenta();

			cuenta.setId(rst2.getInt("idpremio")); //fijrme los tipos
			cuenta.setNombre(rst2.getString("nombre"));
			cuenta.setApellido(rst2.getString("apellido"));
			cuenta.setEmail(rst2.getString("email"));
			cuenta.setPuntos(rst2.getInt("puntos"));
			cuentas.add(cuenta);
		}
	
	 
	return	cuentas;

}
	
	public ArrayList<Premio> findByCuenta(Integer id) throws SQLException {
		 st=Conectar.connectDB().createStatement(); 

			sql="select premio.idpremio, nombrePremio, premio.puntos from  cuentapremio join premio on cuentapremio.idpremio = premio.idpremio where cuentapremio.idcuenta ='"+id.toString()+"'";
			rst2 = st.executeQuery(sql);
			while (rst2.next()){  
				Premio premio= new Premio();

				premio.setIdPremio(rst2.getInt("idpremio")); 
				premio.setNombrePremio(rst2.getString("nombrePremio"));
				premio.setPuntos(rst2.getInt("puntos"));
				premios.add(premio);
			}
		
		 
		return premios;
	}
	
}
