import java.awt.datatransfer.SystemFlavorMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int menuPrincipal;
		ArrayList<Competidor> listaCompetidores = new ArrayList<Competidor>();
		do {
			System.out.println("----------MENU PRINCIPAL----------\n");
			System.out.println("Seleccione una opcion");
			System.out.println("1- Administracion de Personajes");
			System.out.println("2- Administracion de Ligas");
			System.out.println("3- Realizacion de combates");
			System.out.println("4- Reportes");
			System.out.println("5- Salir");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();

			switch (menuPrincipal) {
			case (1):  administracionDePersonajes(listaCompetidores);
				break;
			case (2):  administracionDeLigas();
				break;
			case (3):  realizacionDeCombates();
				break;
			case (4):  reportes();
				break;
			}
		} while ((1 < menuPrincipal || 4 > menuPrincipal) && (menuPrincipal != 5));

	}

	static void administracionDePersonajes(ArrayList<Competidor> listaCompetidores) {

		int menuPrincipal;


		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todos los personajes\r\n" + "5 Atras");

			Scanner menup = new Scanner(System.in);
			menuPrincipal = menup.nextInt();
			switch (menuPrincipal) {
			case (1):
				break;
			case (2):  crearPersonaje(listaCompetidores);
				break;
			case (3): listadoPersonaje(listaCompetidores);
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

	static void crearPersonaje(ArrayList<Competidor> listaCompetidores) {

		int valor = 1;
		Scanner input = new Scanner(System.in);
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

				valor = Integer.parseInt(input.nextLine());
			} while (!(valor >= 1 && valor <= 2));

			if (valor == 1) {
				heroe_o_villano = "Heroe";
			} else {
				heroe_o_villano = "Villano";
			}

			System.out.println("Ingrese nombre real del personaje\n");
			nombreReal = input.nextLine();

			System.out.println("Ingrese nombre del personaje\n");
			nombreCompetidor = input.nextLine();

			System.out.print("Agregando caracteristicas al personaje.\n" + "Ingrese velocidad del Personaje: ");

			velocidad = Integer.parseInt(input.nextLine());

			System.out.print("Ingrese Fuerza del Personaje: ");
			fuerza = Integer.parseInt(input.nextLine());

			System.out.print("Ingrese Resistencia del Personaje: ");
			resistencia = Integer.parseInt(input.nextLine());

			System.out.print("Ingrese Destreza del Personaje: ");
			destreza = Integer.parseInt(input.nextLine());

			competidor = new Competidor(heroe_o_villano, nombreReal, nombreCompetidor, velocidad, fuerza, resistencia,
					destreza);
			listaCompetidores.add(competidor);

			System.out.println(
					"\n--------Ingrese un valor distinto de 0 para seguir ingresando Competidores o Ingrese 0 para salir-----------\n");
			valor = Integer.parseInt(input.nextLine());

		}

	}
	
	static void listadoPersonaje(ArrayList<Competidor> listaCompetidores)
	{
		
		int i;
		for(i=0;i<listaCompetidores.size();i++) {
			System.out.println("----------------------------------------------------\n");
			System.out.println("Competidor Nro: "+(i+1)+"\nEs un: "
			+listaCompetidores.get(i).getHeroe_o_villano()
			+"\nSu Nombre Real es: "
			+listaCompetidores.get(i).getNombreReal()
			+"\nSu Nombre del Personaje es: "
			+listaCompetidores.get(i).getNombrePersonaje()
			+"\nSu Velocidad es: "
			+listaCompetidores.get(i).getVelocidad()
			+"\nSu Fuerza es: "
			+listaCompetidores.get(i).getFuerza()
			+"\nSu Resistencia es: "
			+listaCompetidores.get(i).getResistencia()
			+"\nSu Destreza es: "
			+listaCompetidores.get(i).getDestreza());
			System.out.println("------------------------------------------------------\n");
		}
		

		
	}

}
