package pak2;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		String menuPrincipal;
		do {
			imprimirLineasEnBlanco();
			System.out.println("----------MENU PRINCIPAL----------\n");
			System.out.println("Seleccione una opcion");
			System.out.println("1- Administracion de Personajes");
			System.out.println("2- Administracion de Ligas");
			System.out.println("3- Realizacion de combates");
			System.out.println("4- Reportes");
			System.out.println("5- Salir");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.next();

			switch (menuPrincipal) {
			case ("1"):
				administracionDePersonajes();
				break;
			case ("2"):
				administracionDeLigas();
				break;
			case ("3"):
				realizacionDeCombates();
				break;
			case ("4"):
				reportes();
				break;
			default:
				System.out.println("caracter no valido, ingrese nuevamente");
			}
		} while ( (menuPrincipal != "5"));

	}

	static void administracionDePersonajes() {

		int menuPrincipal;

		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todos los personajes\r\n" + "5 Atras");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();
			switch (menuPrincipal) {
			case (1):
				break;
			case (2):
//			crearPersonajes();
				break;
			case (3):
				break;
			case (4):
				break;
			}
		} while ((1 < menuPrincipal || 4 > menuPrincipal) && (menuPrincipal != 5));
	}

	static void administracionDeLigas() {

		int menuPrincipal;

		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todas las ligas\n" + "5 Atras");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();
			switch (menuPrincipal) {
			case (1):
				break;
			case (2):
				break;
			case (3):
				break;
			case (4):
				break;
			}
		} while ((1 < menuPrincipal || 4 > menuPrincipal) && (menuPrincipal != 5));

	}

	static void realizacionDeCombates() {

		int menuPrincipal;

		do {
			System.out.println("Seleccione una opcion\n" + "1 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "2 Liga contra Liga (definiendo caracteristica)\r\n" + "3 Atras");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();
			switch (menuPrincipal) {
			case (1):
				break;
			case (2):
				break;
			}
		} while ((1 < menuPrincipal || 2 > menuPrincipal) && (menuPrincipal != 3));
	}

	static void reportes() {

		int menuPrincipal;

		do {
			System.out.println("Seleccione una opcion\n"
					+ "1 Todos los personajes o ligas que venzan a un personaje dado para cierta caracteristica\r\n"
					+ "2 Listado ordenado de personajes por multiples caracteristicas\r\n" + "3 Atras");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();
			switch (menuPrincipal) {
			case (1):
				break;
			case (2):
				break;
			}
		} while ((1 < menuPrincipal || 2 > menuPrincipal) && (menuPrincipal != 3));
	}
	public static void imprimirLineasEnBlanco() {
		for (int i = 0; i < 5000; i++) {
			
			System.out.println();
		}
		
	}
}




	
	

