package view;

import java.util.Scanner;

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
		
	}
	
	private void buscarCuenta() {
		
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