package view;

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
			//Informar de éxito o fracaso en la operación.
			break;
		case 2:
			actual = buscarCuenta();
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
	
	private boolean registrarCuenta() {
		System.out.println("Ingrese el código ID de la nueva cuenta: ");
		int id = sc.nextInt();
		System.out.println ("Ingrese un email: ");
		String email= sc.next();
		System.out.println("Ingrese un nombre de propietario de nueva cuenta: ");
		String name = sc.next();
		System.out.println("Ingrese un apellido de propietario de nueva cuenta: ");
		String surname = sc.next();
		return controller.registrarCuentaController(id, name, surname, email);
		//Cuenta c = controller.registrarCuentaController(id, name, surname, email);
		//this.readData();
		//Probando si esto funciona, imprimo datos del objeto creado:
		//System.out.println(name);
	}
	
	private Cuenta buscarCuenta() {
		System.out.println ("Ingrese el email de la cuenta que desea buscar: ");
		String email= sc.next();		
		//Utilizar excepción ya que account puede ser nulo.
		return controller.buscarCuentaController(email);
	}
	
	private void cargarPuntosEnCuenta() {
		
	}
	
	private void canjearPremios() {
		
		
	}
	
	private void listarPremiosDeUnaCuenta() {
		
	}
	
	private void restarPuntos(){
		
	}
	
	//Metodo que almacena valores de teclado:
	private void readData (){
		

	}

}