package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Cuenta;
import model.Premio;
import controller.Controller;
 
public class View {

	Scanner sc = new Scanner(System.in);
	Controller controller = new Controller();
	Cuenta actual;

	private void menu() {
		System.out.println("***********************************");
		System.out.println("*              MENU               *");
		System.out.println("***********************************");
		System.out.println("1- Crear Cuenta");
		System.out.println("2- Buscar una cuenta");
		System.out.println("3- Cargar puntos a una cuenta");
		System.out.println("4- Canjear premios");
		System.out.println("5- Listar los premios canjeados de una cuenta");
		System.out.println("0- EXIT");
	}

	public void opciones() {
		menu();
		System.out.println("Ingrese la opcion deseada");
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			registrarCuenta();
			break;
		case 2:
			try {
				actual = buscarCuenta();
			} catch (SQLException e) {
				e.getMessage();
				//e.printStackTrace();
			}
			break;
		case 3:
			cargarPuntosEnCuenta();
			break;
		case 4:
			canjearPremios();
			break;
		case 5:
			listarPremiosDeUnaCuenta();
			break;
		default:
			break;
		}

	}
	
	private void registrarCuenta() {
		System.out.println("Ingrese el código ID de la nueva cuenta: ");
		int id = sc.nextInt();
		System.out.println ("Ingrese un email: ");
		String email= sc.next();
		System.out.println("Ingrese un nombre de propietario de nueva cuenta: ");
		String name = sc.next();
		System.out.println("Ingrese un apellido de propietario de nueva cuenta: ");
		String surname = sc.next();
		try {
			controller.registrarCuentaController(id, name, surname, email);
		} catch (Throwable e) {
			e.getMessage();
		}
	}
	
	private Cuenta buscarCuenta() throws SQLException {
		System.out.println ("Ingrese el número de la cuenta que desea buscar: ");
		int id= sc.nextInt();
		//Utilizar excepción ya que account puede ser nulo.
		return controller.buscarCuentaController(id);
	}
	
	private void cargarPuntosEnCuenta() {
		
	}
	
	private void canjearPremios() {
		System.out
				.println("Ingrese el ID de la cuenta deseada para canjear puntos");
		int idCuenta = sc.nextInt();
		if (controller.validarCuenta(idCuenta) != null) {
			System.out.println("El saldo en puntos de la cuenta es: "
					+ controller.validarCuenta(idCuenta).getPuntos());
			System.out.println(" ");
			menuPremio();
			int idPremio = sc.nextInt();
			if (controller.validarPremio(idPremio) != null) {
				if (controller.canjearPuntosController(idCuenta, idPremio)) {
					System.out
							.println("Canje Exitoso, Su nuevo saldo en puntos es: "
									+ controller.validarCuenta(idCuenta)
											.getPuntos());
				} else {
					System.out
							.println("Su cuenta no posee los puntos necesarios para este premio");
					operacionInvalida();
				}
			} else {
				operacionInvalida();
			}
		} else {
			operacionInvalida();
		}
	}

	private void operacionInvalida() {
		System.out.println("Si desea comenzar nuevamente la opracion prione y");
		String op = sc.next();
		if (op.contains("y")) {
			canjearPremios();
		}
	}

	private void menuPremio() {
		System.out.println("PREMIOS: ");
		for (Premio premio : controller.getListaPremios()) {
			System.out.println("Nombre: " + premio.getNombrePremio()
					+ " -- ID: " + premio.getIdPremio() + " -- Puntos: "
					+ premio.getPuntos());
		}
		System.out.println("Ingrese le ID del premio que desea canjear");
	}

	private void listarPremiosDeUnaCuenta() {
		System.out
				.println("Ingrese el ID de cuenta de la cual desea listar los premios");
		int idCuenta = sc.nextInt();
		if (controller.validarCuenta(idCuenta) != null) {
			System.out.println("PREMIOS DE LA CUENTA: ");
			System.out.println(" ");
			int i = 1;
			for (Premio premio : controller.validarCuenta(idCuenta)
					.getPremiosCuenta()) {
				System.out.println(i + "NombrePremio: "
						+ premio.getNombrePremio());
				i++;
			}
		} else {
			System.out
					.println("ID invalido, Si desea comenzar nuevamente la opracion prione y");
			String op = sc.next();
			if (op.contains("y")) {
				listarPremiosDeUnaCuenta();
			}
		}
	}
	
	private void restarPuntos(){
		
	}

}
