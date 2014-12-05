package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class CuentaDAO {
	
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
	
	public void save(Cuenta cuenta) throws Throwable {
		
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
		  
		  //en cp saco la lista con posibles elementos, si  los hay genera la insercion de el idCuenta del objeto con el idPremio del objeto de la collectio en la tabla inermedia
		  Iterator<Premio> cp = cuenta.getPremiosCuenta().iterator();
		  
		  while (cp.hasNext()) {	   	  
			  sql= "INSERT INTO CuentaPremio (idCuenta, idPremio) VALUES ('" + cuenta.getId() + "', '" + cp.next().getIdPremio()+ "',)";
			  try {
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  //tengo el next arriba que es el que continua con el puntero en la collection y voy 
		 //insertando en la tabla intermedia los idPremios que esten en el objeto y tambien el idCuenta		   
		  }
  		  
          	sql2 ="INSERT INTO Cuenta (idCuenta, nombre, apellido, email, puntos) VALUES ('" + cuenta.getId() + "', '" + cuenta.getNombre()+ "',"
          		+ "'" + cuenta.getApellido() + "','" + cuenta.getEmail() + "','" + cuenta.getPuntos()+ "') ";
	
			try {
				st.executeUpdate(sql2);
			} catch (SQLException e) {
				update(cuenta);
				//e.printStackTrace();
			}	//un update en el error
	}
	
	public Cuenta findById(Integer id) {
		// Para cada premio, cuenta.getPremios(), para cada premio CuentaPremio.save(idCuenta, idPremio).
		
		Cuenta cuenta = new Cuenta(id, null, null, null, id, null);
		Premio premio = new Premio(id, null, id);
		
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
				  
				  
			/*	  sql="SELECT idCuenta, nombre, apellido, email, puntos FROM cuentaPremio "
				  		+ "join premio on cuentaPremio.idPremio=premio.idPremio "
				  		+ "join cuenta on cuenta.idcuenta=cuentapremio.idCuenta where cuenta.idCuenta= '"+id+"' ";
			
				  sql= "select idPremio, nombre, puntos from cuentapremio join  "; usar premio creado arriba y meter 
				  los objetos premio en la cuenta tambien creada arriba*/
				  
				  try {
						rst1=st.executeQuery(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			        try {
						while (rst1.next()){  
							
							cuenta.setId(Integer.parseInt("idCuenta")); //fijrme los tipo
							cuenta.setNombre("nombre");
							cuenta.setApellido("apellido");
							cuenta.setEmail("email");
							cuenta.setPuntos(Integer.parseInt("puntos"));;
				//			cuenta.setPremiosCuenta(premiosCuenta); tengo que hacer una busqueda para
							
						    System.out.println(rst1.getInt("idCuenta") + " " + rst1.getString("nombre") + " " + rst1.getString("apellido")+" "+ rst1.getString("email")+" "+ rst1.getInt("puntos") );  
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  
				  
		return cuenta ;
		
		//select * from cuenta where id.cuenta=id; throwearlo 
		
	}
	
	
	public void delCuentaById(Integer id) {
		
		//DELETE FROM cuenta WHERE idCuenta=id ;
	}
	
	public void update(Cuenta cuenta) throws Throwable {
		
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
		  
      sql2 ="UPDATE Cuenta SET (idCuenta='" + cuenta.getId() + ", nombre='" + cuenta.getNombre()+ "', apellido='" + cuenta.getNombre()+ "', email='" + cuenta.getEmail() + "', puntos='" + cuenta.getPuntos()+ "') ";
      	
      st.executeUpdate(sql2);
		
		//UPDATE cuenta SET (todos los campos nombre= cuenta.getNombre()) WHERE IdCuenta=cuenta.getID() ;
		
	}
	
	
	
}
