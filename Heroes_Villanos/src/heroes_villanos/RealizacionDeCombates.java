package heroes_villanos;

import java.util.ArrayList;
import java.util.Scanner;

public class RealizacionDeCombates {
	static void menu(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		Main.limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Personaje contra Personaje\r\n"
					+ "2 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "3 Liga contra Liga (definiendo caracteristica)\r\n" + "4 Atras");


			menuPrincipal = Main.cargarString("");
			switch (menuPrincipal) {
			case ("1"):
				personajeContraPersonaje(listaCompetidores);
				break;
			case ("2"):
				personajeContraLiga(listaCompetidores, listaLigas);
				break;
			case ("3"):
				ligaContraLiga(listaLigas);
				break;
			case ("4"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("4"));
		Main.limpiarPantalla();
	}

	private static void personajeContraPersonaje(ArrayList<Unidad> listaCompetidores) {
		String nombrePersonaje;
		String nombrePersonaje2;
		String salir = "1";

		do {

			System.out.println("Ingrese el personaje que desee que luche: ");
			nombrePersonaje = Main.cargarString("");
			System.out.println("Ingrese al personaje que desee que luche: ");
			nombrePersonaje2 = Main.cargarString("");

			int indicePersonaje = Main.buscarPersonaje(listaCompetidores, nombrePersonaje);
			int indicePersonaje2 = Main.buscarPersonaje(listaCompetidores, nombrePersonaje2);

			if (indicePersonaje != -1 && indicePersonaje2 != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Unidad personaje = listaCompetidores.get(indicePersonaje);
				Unidad personaje2 = listaCompetidores.get(indicePersonaje2);

				if (personaje.getTipo() != personaje2.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (personaje.esGanador(personaje2, Main.caracteristicaPorTeclado()))
						System.out
								.println("\nTu " + personaje.getTipo() + " " + personaje.getNombre() + " ha triunfado");
					else
						System.out.println(personaje.getNombre() + " ha sido derrotado.");
				} else
					System.out.println("Dos personajes no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del o los personajes.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");
		} while (!salir.equals("0"));
		Main.finalmetodo("");
	}

	private static void personajeContraLiga(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String nombrePersonaje;
		String nombreLiga;
		String salir = "1";

		do {

			System.out.println("Ingrese el personaje que desee que luche: ");
			nombrePersonaje = Main.cargarString("");
			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga = Main.cargarString("");

			int indicePersonaje = Main.buscarPersonaje(listaCompetidores, nombrePersonaje);
			int indiceLiga = Main.buscarLiga(listaLigas, nombreLiga);

			if (indicePersonaje != -1 && indiceLiga != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Unidad personaje = listaCompetidores.get(indicePersonaje);
				Liga equipo = listaLigas.get(indiceLiga);
personaje.getTipo();
equipo.getTipo();
				if (personaje.getTipo() != equipo.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (personaje.esGanador(equipo, Main.caracteristicaPorTeclado()))
						System.out
								.println("\nTu " + personaje.getTipo() + " " + personaje.getNombre() + " ha triunfado");
					else
						System.out.println(personaje.getNombre() + " ha sido derrotado.");
				} else
					System.out.println("Un personaje y una liga no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del personaje o liga.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");
		} while (!salir.equals("0"));
		Main.finalmetodo("");
	}

	private static void ligaContraLiga(ArrayList<Liga> listaLigas) {
		String nombreLiga2;
		String nombreLiga;
		String salir = "1";

		do {

			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga = Main.cargarString("");
			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga2 = Main.cargarString("");

			int indiceLiga1 = Main.buscarLiga(listaLigas, nombreLiga);
			int indiceLiga2 = Main.buscarLiga(listaLigas, nombreLiga2);

			if (indiceLiga1 != -1 && indiceLiga2 != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Liga l1 = listaLigas.get(indiceLiga1);
				Liga l2 = listaLigas.get(indiceLiga2);

				if (l1.getTipo() != l2.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (l1.esGanador(l2, Main.caracteristicaPorTeclado()))
						System.out.println("\nTu liga " + l1.getNombre() + " ha triunfado");
					else
						System.out.println(l1.getNombre() + "ha sido derrotado.");
				} else
					System.out.println("Dos ligas no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del o las ligas.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");
		} while (!salir.equals("0"));
		Main.finalmetodo("");
	}

}
