
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner menup;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner menup;

	public static void main(String[] args) {

		String menuPrincipal;
		ArrayList<Unidad> listaCompetidores = new ArrayList<Unidad>();
		ArrayList<Liga> listaLigas = new ArrayList<Liga>();

		do {
			System.out.println("----------MENU PRINCIPAL----------\n");
			System.out.println("Seleccione una opcion");
			System.out.println("1- Administracion de Personajes");
			System.out.println("2- Administracion de Ligas");
			System.out.println("3- Realizacion de combates");
			System.out.println("4- Reportes");
			System.out.println("5- Salir");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();

			switch (menuPrincipal) {
			case ("1"):
				administracionDePersonajes(listaCompetidores);
				break;
			case ("2"):
				administracionDeLigas(listaCompetidores, listaLigas);
				break;
			case ("3"):
				realizacionDeCombates();
				break;
			case ("4"):
				reportes();
				break;
			case ("5"):
				System.out.println("Saliendo del juego.........");
				break;
			default:
				System.out.println("\nCaracter no valido!\n");
			}
		} while (!menuPrincipal.equals("5"));

	}

	static void administracionDePersonajes(ArrayList<Unidad> listaCompetidores) {

		String menuPrincipal;

		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" 
					+ "1 Carga desde archivo\r\n" 
					+ "2 Creacion\r\n"
					+ "3 Listado\r\n" 
					+ "4 Guardar en archivo todos los personajes\r\n" 
					+ "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):  crearPersonaje(listaCompetidores);
				break;
			case ("3"):  listadoPersonaje(listaCompetidores);
				break;
			case ("4"):
				break;
			case ("5"):
				System.out.println("\n Volviendo a menu principal\n");
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		limpiarPantalla();
	}

	static void administracionDeLigas(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" 
					+ "1 Carga desde archivo\r\n" 
					+ "2 Creacion\r\n"
					+ "3 Listado\r\n" 
					+ "4 Guardar en archivo todas las ligas\n" 
					+ "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):  crearLiga(listaCompetidores, listaLigas);
				break;
			case ("3"):  listaLigas(listaLigas);
				break;
			case ("4"):
				break;
			case ("5"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		limpiarPantalla();

	}

	static void realizacionDeCombates() {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" 
					+ "1 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "2 Liga contra Liga (definiendo caracteristica)\r\n" 
					+ "3 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):
				break;
			case ("3"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("3"));
		limpiarPantalla();
	}

	static void reportes() {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n"
					+ "1 Todos los personajes o ligas que venzan a un personaje dado para cierta caracteristica\r\n"
					+ "2 Listado ordenado de personajes por multiples caracteristicas\r\n"
					+ "3 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):
				break;
			case ("3"):
				break;
			}
		} while (!menuPrincipal.equals("3"));
		limpiarPantalla();
	}

	static void crearPersonaje(ArrayList<Unidad> listaCompetidores) {
		limpiarPantalla();
		int valor = 1;
		String her_o_vill;
		String heroe_o_villano;
		String nombreReal;
		String nombreCompetidor;
		double velocidad;
		double fuerza;
		double resistencia;
		double destreza;
		Unidad competidor;

		while (valor != 0) {

			System.out.println("-----------CREANDO COMPETIDOR---------");
			do {
				System.out.println("Ingrese 1 si tu competidor es Heroe\n");
				System.out.println("Ingrese 2 si tu competidor es Villano\n");

				her_o_vill = new Scanner(System.in).nextLine();
				if (!her_o_vill.equals("1") && !her_o_vill.equals("2")) {
					System.out.println("\nCaracter invalido\n");
				}
			} while (!her_o_vill.equals("1") && !her_o_vill.equals("2"));

			if (her_o_vill.equals("1")) {
				heroe_o_villano = "Heroe";
			} else {
				heroe_o_villano = "Villano";
			}

			System.out.println("Ingrese nombre real del personaje\n");
			nombreReal = new Scanner(System.in).nextLine();

			System.out.println("Ingrese nombre del personaje\n");
			nombreCompetidor = new Scanner(System.in).nextLine();

			System.out.print("Agregando caracteristicas al personaje.\n" + "Ingrese velocidad del Personaje: ");

			velocidad = Double.parseDouble(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Fuerza del Personaje: ");
			fuerza = Double.parseDouble(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Resistencia del Personaje: ");
			resistencia = Double.parseDouble(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Destreza del Personaje: ");
			destreza = Double.parseDouble(new Scanner(System.in).nextLine());

			competidor = new Unidad(heroe_o_villano, nombreReal, nombreCompetidor, velocidad, fuerza, resistencia,
					destreza);
			listaCompetidores.add(competidor);

			System.out.println(
					"\n--------Ingrese un valor distinto de 0 para seguir ingresando Competidores o Ingrese 0 para salir-----------\n");
			valor = Integer.parseInt(new Scanner(System.in).nextLine());

		}
		limpiarPantalla();

	}

	static void listadoPersonaje(ArrayList<Unidad> listaCompetidores) {

		int i;
		if (listaCompetidores.size() >= 1) {
			for (i = 0; i < listaCompetidores.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println("Competidor Nro: " + (i + 1) + "\n" + listaCompetidores.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
		} else {
			System.out.println("No Hay Lista de Competidores");
		}

	}

	static void limpiarPantalla() {

		int i;
		for (i = 0; i < 10; i++) {
			System.out.println("\n");
		}
	}

	static void crearLiga(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		Liga liga = null;
		String nombreLiga;
		String tipo;
		String input;
		int indice;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n----Creando Liga----\n");
		System.out.println("Ingrese nombre de la liga");

		nombreLiga = scanner.nextLine();
		do {
			System.out.println("Ingrese nombre Tipo de liga (Heroe o Villano)");

			tipo = scanner.nextLine();
			if (tipo.toUpperCase().equals("HEROE")) {
				liga = new LigaHeroes(nombreLiga);
			} else if (tipo.toUpperCase().equals("VILLANO")) {
				liga = new LigaVillanos(nombreLiga);
			} else {
				System.out.println("Tipo incompatible");
			}

		} while (!tipo.toUpperCase().equals("HEROE") && !tipo.toUpperCase().equals("VILLANO"));

		do {
			System.out.println("Desea Agregar Competidores?");
			System.out.println("1- SI");
			System.out.println("2- NO");
			input = scanner.nextLine();
			if (input.equals("1")) {
				System.out.println("Ingrese el personaje que desea agregar a la Liga\n");
				System.out.println("Personajes disponible...");
				listadoPersonaje(listaCompetidores);
				System.out.println("Ingrese Numero de Competidor");
				indice = Integer.parseInt(scanner.nextLine());
				if (indice <= listaCompetidores.size() && indice >= 0) { 
					//validamos si estamos afuera de rango del indice
					if (liga.getTipo().toUpperCase()
							.equals(listaCompetidores.get(indice - 1).getTipo().toUpperCase())) {

						// si se quiere ingresar un competidor del mismo tipo (heroe o villano) que el
						// tipo de la liga se
						// agrega al competidor a la liga y sino Tipo de competidor incompatible con el
						// tipo de la liga

						liga.agregarCompetidor(listaCompetidores.get(indice - 1));
						System.out.println("Personaje agregado exitosamente...");
					} else {
						System.out.println("ATENCION!!! Tipo de la liga: " + liga.getTipo().toLowerCase()
								+ " es incompatible con el tipo de competidor");
					}
				}
				else {
					System.out.println("Personaje Invalido");
				}
			}

		} while (!input.equals("2"));

		listaLigas.add(liga);

	}

	static void listaLigas(ArrayList<Liga> listaLigas) {

		int i;
		if (listaLigas.size() >= 1) {
			for (i = 0; i < listaLigas.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println("Liga Nro: " + (i + 1) + "\n"
				+ listaLigas.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
		} else {
			System.out.println("No Hay Lista de Ligas");
		}

	}

}