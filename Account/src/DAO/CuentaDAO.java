package DAO;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	private Iterator<Premio> cp;
	protected List<Premio> premios = new ArrayList<>();
	protected List<Cuenta> cuentas = new ArrayList<>();
    protected Cuenta cuenta= new Cuenta();
    
	public void saveAccount(Cuenta cuenta) throws Throwable {

		st = Conectar.connectDB().createStatement();

		// en cp saco la lista con posibles elementos, si los hay genera la
		// insercion de el idCuenta del objeto con el idPremio del objeto de la
		// collectio en la tabla inermedia


		if (cuenta.getPremiosCuenta()!=null) {
			 cp = cuenta.getPremiosCuenta().iterator();
			 
			 while (cp.hasNext()) {	   	 
				 //Integer idc =cuenta.getId();
				// Integer idp=cp.next().getIdPremio();
				  sql= "INSERT INTO CuentaPremio ( idcuenta, idpremio ) VALUES ("+ cuenta.getId() +" , " + cp.next().getIdPremio() + ")";
			
				  try {
					st.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 		 
		}
		  
		 
		  //tengo el next arriba que es el que continua con el puntero en la collection y voy 
		 //insertando en la tabla intermedia los idPremios que esten en el objeto y tambien el idCuenta		   
		  }

		
		
		//insertando el objeto cuenta en la bd
    	sql2 ="INSERT INTO Cuenta (idcuenta, nombre, apellido, email, puntos) VALUES ('" + cuenta.getId() + "', '" + cuenta.getNombre()+ "',"
          		+ "'" + cuenta.getApellido() + "','" + cuenta.getEmail() + "','" + cuenta.getPuntos()+ "') ";
	
			try {
				st.executeUpdate(sql2);
			} catch (SQLException e) {
				updateAccount(cuenta);
				//e.printStackTrace();
			}	//un update en el error
		
		
	}

	public void  setNewSigleAccount(Cuenta cuenta) throws SQLException {
		st=Conectar.connectDB().createStatement();
		
		sql2 ="INSERT INTO Cuenta (nombre, apellido, email, puntos) VALUES ('" + cuenta.getNombre()+ "',"
	      		+ "'" + cuenta.getApellido() + "','" + cuenta.getEmail() + "','" + cuenta.getPuntos()+ "') ";
		
		rst2=st.executeQuery(sql);
		
	}	
	
	
	public Cuenta findAccountById(Integer id) throws SQLException {
		// este ID es de de cuenta
		st = Conectar.connectDB().createStatement();

		// etapa donde se obtiene todos los premios asociados al paremetro
		// idcuenta/id
		sql="select premio.idpremio, nombrePremio, premio.puntos "
				+ "from  cuentapremio join premio on cuentapremio.idpremio = premio.idpremio "
				+ "where cuentapremio.idcuenta ='"+id.toString()+"'";
	
		try {
			rst2=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}  
        try {
			while (rst2.next()){  
				Premio premio= new Premio();


				premio.setIdPremio(rst2.getInt("idpremio")); //fijrme los tipos
				premio.setNombrePremio("nombrePremio");
				premio.setPuntos(rst2.getInt("puntos"));
				premios.add(premio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        

		// etapa donde se asigna los valoes al objeto uenta , insluco las lista
		// de premios
        sql="select cuenta.idcuenta, cuenta.nombre, cuenta.apellido, cuenta.email, cuenta.puntos from cuenta where cuenta.idcuenta="+id.toString();
		  
		  try {
				rst1=st.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        try {
				while (rst1.next()){  
					Cuenta cuenta= new Cuenta();	
					cuenta.setId(rst1.getInt("idcuenta")); //fijrme los tipos
					cuenta.setNombre(rst1.getString("nombre"));
					cuenta.setApellido(rst1.getString("apellido"));
					cuenta.setEmail(rst1.getString("email"));
					cuenta.setPuntos(rst1.getInt("puntos"));;
					cuenta.setPremiosCuenta(premios);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
		  
	        return cuenta ;

	}

	public void deleteAccount(Integer id) throws SQLException {

		st=Conectar.connectDB().createStatement();
		
		sql="DELETE FROM  cuenta WHERE idCuenta="+id+"";
		
		st.execute(sql);
		
		sql="DELETE FROM  cuentaPremio WHERE idCuenta="+id+"";
		st.execute(sql);
	}

	public void updateAccount(Cuenta cuenta) throws Throwable {

		 st=Conectar.connectDB().createStatement();
		  
	      sql2 ="UPDATE cuenta SET nombre='" + cuenta.getNombre()+ "', apellido='" + cuenta.getApellido()+ "', "
	      		+ "email='" + cuenta.getEmail()+ "', puntos=" + cuenta.getPuntos()+""
	      				+ " where idcuenta= "+cuenta.getId()+" ";
	      st.executeUpdate(sql2);

	}

	public List<Cuenta> getOnlyAccounts() throws SQLException {
		st=Conectar.connectDB().createStatement();
			
			while (rst2.next()){  
				
				cuenta.setId(rst2.getInt("idpremio")); //fijrme los tipos
				cuenta.setNombre(rst2.getString("nombre"));
				cuenta.setApellido(rst2.getString("apellido"));
				cuenta.setEmail(rst2.getString("email"));
				cuenta.setPuntos(rst2.getInt("puntos"));
				cuentas.add(cuenta);
			}	
		 
		return	cuentas;
	}
	
}