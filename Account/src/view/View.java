package view;

import java.util.List;
import java.util.Scanner;

import model.Premio;
import controller.Controller;
 
public class View {

	Scanner sc = new Scanner(System.in);
	Controller controller = new Controller();

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
			buscarCuenta();
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
		//Al llamar al método correspondiente, deberá enviarse los datos a agregar, inicialmente no tiene puntos agregados.
		//controller.registrarCuentaController(int id, String nombre, String apellido, String email,
		//int puntos, List<Premio> premiosCuenta)
	}
	
	private void buscarCuenta() {
		//De alguna manera necesitamos saber el mail con el cual buscar, para después. 
		//Se envía un mensaje al objeto controller. 
	}
	
	private void cargarPuntosEnCuenta() {
		
	}
	
	private void canjearPremios() {
		
		
	}
	
	private void listarPremiosDeUnaCuenta() {
		
	}
	
	private void restarPuntos(){
		
	}

}