package heroes_villanos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdministracionDePersonajes {
	protected static Scanner menup = new Scanner(System.in);

	static void menu(ArrayList<Unidad> listaCompetidores) {

		String menuPrincipal;

		do {
			Main.limpiarPantalla();
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todos los personajes\r\n" + "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				cargarListaPersonajes(listaCompetidores);
				break;
			case ("2"):
				crearPersonaje(listaCompetidores);
				break;
			case ("3"):
				listadoPersonaje(listaCompetidores);
				Main.finalmetodo("listado de personajes\n");
				break;
			case ("4"):
				guardarListaPersonajes(listaCompetidores);
				break;
			case ("5"):
				System.out.println("\n Volviendo a menu principal\n");
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		Main.limpiarPantalla();
	}

	private static void cargarListaPersonajes(ArrayList<Unidad> listaCompetidores) {

		try {
			ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
			listaCompetidores.addAll(archivoPersonajes.leerArchivo().stream()
					.filter(c -> Main.buscarPersonaje(listaCompetidores, c.getNombre()) == -1)
					.collect(Collectors.toList()));

		} catch (Exception e) {
			System.out.println(e);
		}
		Main.finalmetodo("archivo cargado correctamente\n");

	}

	static void crearPersonaje(ArrayList<Unidad> listaCompetidores) {
		Main.limpiarPantalla();
		String valor = "1";
		String her_o_vill;
		String heroe_o_villano;
		String nombreReal;
		String nombreCompetidor;
		double velocidad;
		double fuerza;
		double resistencia;
		double destreza;
		Unidad competidor;

		while (valor.equals("0") == false) {

			System.out.println("-----------CREANDO COMPETIDOR---------");
			do {
				System.out.println("Ingrese 1 si tu competidor es Heroe\n");
				System.out.println("Ingrese 2 si tu competidor es Villano\n");

				her_o_vill = menup.nextLine();
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
			nombreReal = menup.nextLine();

			System.out.println("Ingrese nombre del personaje\n");
			boolean yaExiste;
			do {
				yaExiste = false;
				nombreCompetidor = menup.nextLine();
				if (Main.buscarPersonaje(listaCompetidores, nombreCompetidor) != -1) {
					yaExiste = true;
					System.out.println("Personajes ya existe, ingresar otro nombre:");
				}
			} while (yaExiste);

			System.out.print("Agregando caracteristicas al personaje.\n");
			velocidad = Main.cargarDouble("Ingrese Velocidad del Personaje: ");

			fuerza = Main.cargarDouble("Ingrese Fuerza del Personaje: ");

			resistencia = Main.cargarDouble("Ingrese Resistencia del Personaje: ");

			destreza = Main.cargarDouble("Ingrese Destreza del Personaje: ");

			competidor = new Unidad(heroe_o_villano, nombreReal, nombreCompetidor, velocidad, fuerza, resistencia,
					destreza);
			listaCompetidores.add(competidor);

			System.out.println(
					"\n--------Ingrese un valor distinto de 0 para seguir ingresando Competidores o Ingrese 0 para salir-----------\n");
			valor = menup.nextLine();

		}
		Main.limpiarPantalla();

	}

	static boolean listadoPersonaje(List<Unidad> listaCompetidores) {

		int i;
		if (listaCompetidores.size() >= 1) {
			for (i = 0; i < listaCompetidores.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println("Competidor Nro: " + (i + 1) + "\n" + listaCompetidores.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
			return true;

		} else {
			System.out.println("No Hay Lista de Personajes");
		}
		return false;

	}

	private static void guardarListaPersonajes(ArrayList<Unidad> listaCompetidores) {
		try {

			ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
			archivoPersonajes.guardarArchivo(listaCompetidores);
		} catch (Exception e) {
			System.out.println(e);
		}
		Main.finalmetodo("personajes guardados\n");

	}
}
