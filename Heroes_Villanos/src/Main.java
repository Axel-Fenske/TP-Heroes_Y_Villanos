
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner menup;

	public static void main(String[] args) {

				
		
		
		
		String menuPrincipal;
		ArrayList<Competidor> listaCompetidores = new ArrayList<Competidor>();
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
			case ("1"):  administracionDePersonajes(listaCompetidores);
				break;
			case ("2"):  administracionDeLigas();
				break;
			case ("3"):  realizacionDeCombates();
				break;
			case ("4"):  reportes();
				break;
			case("5"): System.out.println("Saliendo del juego.........");
			break;
				default:
					System.out.println("\nCaracter no valido!\n");
			}
		} while (!menuPrincipal.equals("5"));

	}

	static void administracionDePersonajes(ArrayList<Competidor> listaCompetidores) {

		String menuPrincipal;

		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todos los personajes\r\n" + "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal= menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):  crearPersonaje(listaCompetidores);
				break;
			case ("3"):  listadoPersonaje(listaCompetidores);
				break;
			case ("4"):
				break;
			case("5"): System.out.println("\n Volviendo a menu principal\n");
			break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		limpiarPantalla();
	}

	static void administracionDeLigas() {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todas las ligas\n" + "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal =menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				break;
			case ("2"):
				break;
			case ("3"):
				break;
			case ("4"):
				break;
			case("5"):
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
			System.out.println("Seleccione una opcion\n" + "1 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "2 Liga contra Liga (definiendo caracteristica)\r\n" + "3 Atras");

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
					+ "2 Listado ordenado de personajes por multiples caracteristicas\r\n" + "3 Atras");

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

	static void crearPersonaje(ArrayList<Competidor> listaCompetidores) {
		limpiarPantalla();
		int valor = 1;
		String her_o_vill;
		String heroe_o_villano;
		String nombreReal;
		String nombreCompetidor;
		int velocidad;
		int fuerza;
		int resistencia;
		int destreza;
		Competidor competidor;

		while (valor != 0) {

			System.out.println("-----------CREANDO COMPETIDOR---------");
			do {
				System.out.println("Ingrese 1 si tu competidor es Heroe\n");
				System.out.println("Ingrese 2 si tu competidor es Villano\n");

				her_o_vill = new Scanner(System.in).nextLine();
				if(!her_o_vill.equals("1")&&!her_o_vill.equals("2")) {
					System.out.println("\nCaracter invalido\n");
				}
			} while (!her_o_vill.equals("1")&&!her_o_vill.equals("2"));

			if (her_o_vill == "1") {
				heroe_o_villano = "Heroe";
			} else {
				heroe_o_villano = "Villano";
			}

			System.out.println("Ingrese nombre real del personaje\n");
			nombreReal = new Scanner(System.in).nextLine();

			System.out.println("Ingrese nombre del personaje\n");
			nombreCompetidor = new Scanner(System.in).nextLine();

			System.out.print("Agregando caracteristicas al personaje.\n" + "Ingrese velocidad del Personaje: ");

			velocidad = Integer.parseInt(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Fuerza del Personaje: ");
			fuerza = Integer.parseInt(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Resistencia del Personaje: ");
			resistencia = Integer.parseInt(new Scanner(System.in).nextLine());

			System.out.print("Ingrese Destreza del Personaje: ");
			destreza = Integer.parseInt(new Scanner(System.in).nextLine());

			competidor = new Competidor(heroe_o_villano, nombreReal, nombreCompetidor, velocidad, fuerza, resistencia,
					destreza);
			listaCompetidores.add(competidor);

			System.out.println(
					"\n--------Ingrese un valor distinto de 0 para seguir ingresando Competidores o Ingrese 0 para salir-----------\n");
			valor = Integer.parseInt(new Scanner(System.in).nextLine());

		}
		limpiarPantalla();

	}
	
	static void listadoPersonaje(ArrayList<Competidor> listaCompetidores)
	{
		limpiarPantalla();
		int i;
		if(listaCompetidores.size()>=1) {
		for(i=0;i<listaCompetidores.size();i++) {
			System.out.println("------------------------------------------------------");
			System.out.println("Competidor Nro: "+(i+1)+"\n"+listaCompetidores.get(i).toString());
			System.out.println("------------------------------------------------------\n");
			}
		}
		else {
			System.out.println("No Hay Lista de Competidores");
		}
		

		
	}
	static void limpiarPantalla() {
		
		int i;
		for(i=0;i<10;i++) {
			System.out.println("\n");
		}
	}

}
