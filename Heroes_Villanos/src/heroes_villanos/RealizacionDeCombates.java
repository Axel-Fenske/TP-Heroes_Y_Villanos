package heroes_villanos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealizacionDeCombates {
	static void menu(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		Main.limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Personaje contra Personaje\r\n"
					+ "2 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "3 Liga contra Liga (definiendo caracteristica)\r\n" + "4 Atras");

			menuPrincipal = Main.cargarString("");
			try {
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
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!menuPrincipal.equals("4"));
		Main.limpiarPantalla();
	}

	private static void personajeContraPersonaje(ArrayList<Unidad> listaCompetidores) {

		String salir = "1";
		List<Unidad> l = null;
		if (listaCompetidores.size() == 0)
			throw new RuntimeException("error, lista vacia");
		do {
			l = listaCompetidores.stream().filter(c -> c.getTipo().equals("heroe")).collect(Collectors.toList());
			Main.listar(l, "");
			int indice = Main.cargarEntero("Inserte numero del Heroe del 1 al " + l.size(), 1, l.size());
			Unidad personaje = l.get(indice - 1);

			l = listaCompetidores.stream().filter(c -> c.getTipo().equals("villano")).collect(Collectors.toList());
			Main.listar(l, "");
			indice = Main.cargarEntero("Inserte numero del Villano del 1 al " + l.size(), 1, l.size());
			Unidad personaje2 = l.get(indice - 1);

			if (personaje.esGanador(personaje2, Main.cargarCaracteristica()))
				System.out.println("El " + personaje.getTipo() + " llamado " + personaje.getNombre() + " ha triunfado");
			else
				System.out
						.println("El " + personaje2.getTipo() + " llamado " + personaje2.getNombre() + " ha triunfado");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");
		} while (!salir.equals("0"));
		Main.finalMetodo("");
	}

	private static void personajeContraLiga(ArrayList<Unidad> listComp, ArrayList<Liga> listliga) {
		String salir = "1";
		List<Liga> l = null;

		if (listComp.size() == 0 || listliga.size() == 0)
			throw new RuntimeException("error, lista vacia");
		do {
			Main.listar(listComp, "");
			int indice = Main.cargarEntero("Inserte numero del Personaje del 1 al " + listComp.size(), 1,
					listComp.size());
			Unidad personaje = listComp.get(indice - 1);

			if (personaje.getTipo().compareTo("heroe") == 0) {
				l = listliga.stream().filter(c -> c.getTipo().equals("villano")).collect(Collectors.toList());
			} else {
				l = listliga.stream().filter(c -> c.getTipo().equals("heroe")).collect(Collectors.toList());
			}

			Main.listar(l, "");
			indice = Main.cargarEntero("Inserte numero del la Liga del 1 al " + l.size(), 1, l.size());
			Liga liga = l.get(indice - 1);

			if (personaje.esGanador(liga, Main.cargarCaracteristica()))
				System.out.println("El " + personaje.getTipo() + " llamado " + personaje.getNombre() + " ha triunfado");
			else
				System.out.println("La liga de " + liga.getTipo() + "s llamada " + liga.getNombre() + " ha triunfado");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");

		} while (!salir.equals("0"));
		Main.finalMetodo("");
	}

	private static void ligaContraLiga(ArrayList<Liga> listaLigas) {
		String salir = "1";
		List<Liga> l = null;
		if (listaLigas.size() == 0)
			throw new RuntimeException("error, lista vacia");
		do {
			l = listaLigas.stream().filter(c -> c.getTipo().equals("heroe")).collect(Collectors.toList());
			Main.listar(l, "");
			int indice = Main.cargarEntero("Inserte numero de liga de Heroes del 1 al " + l.size(), 1, l.size());
			Liga c1 = l.get(indice - 1);

			l = listaLigas.stream().filter(c -> c.getTipo().equals("villano")).collect(Collectors.toList());
			Main.listar(l, "");
			indice = Main.cargarEntero("Inserte numero de liga de Villanos del 1 al " + l.size(), 1, l.size());
			Liga c2 = l.get(indice - 1);

			if (c1.esGanador(c2, Main.cargarCaracteristica()))
				System.out.println("La liga de " + c1.getTipo() + "s llamada " + c1.getNombre() + " ha triunfado");
			else
				System.out.println("La liga de " + c2.getTipo() + "s llamada " + c2.getNombre() + " ha triunfado");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = Main.cargarString("");
		} while (!salir.equals("0"));
		Main.finalMetodo("");

	}

}
