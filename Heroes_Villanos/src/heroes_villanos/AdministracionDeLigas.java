package heroes_villanos;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class AdministracionDeLigas {

	static void menu(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		Main.limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todas las ligas\n" + "5 Atras");


			menuPrincipal = Main.cargarString("");
			switch (menuPrincipal) {
			case ("1"):
				cargarListaLigas(listaCompetidores, listaLigas);
				break;
			case ("2"):
				crearLiga(listaCompetidores, listaLigas);
				break;
			case ("3"):
				if (listaLigas(listaLigas))
					Main.finalmetodo("listado de ligas\n");
				else
					Main.finalmetodo("");
				break;
			case ("4"):
				guardarListaLigas(listaLigas);
				break;
			case ("5"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		Main.limpiarPantalla();

	}

	private static void cargarListaLigas(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {
		try {
			ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
			ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");

			listaLigas.addAll(archivoHeroes.leerArchivo(listaCompetidores).stream()
					.filter(c -> Main.buscarLiga(listaLigas, c.getNombre()) == -1).collect(Collectors.toList()));
			listaLigas.addAll(archivoVillanos.leerArchivo(listaCompetidores).stream()
					.filter(c -> Main.buscarLiga(listaLigas, c.getNombre()) == -1).collect(Collectors.toList()));
			Main.finalmetodo("ligas cargadas correctamente\n");
		} catch (Exception e) {
			System.out.println("error al cargar el archivo" + e);
		}

	}

	static void crearLiga(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		Liga liga = null;
		String nombreLiga;
		String tipo;
		String input;
		int indice = 0;
		System.out.println("\n----Creando Liga----\n");

		boolean yaExiste;
		do {
			yaExiste = false;
			System.out.println("Ingrese nombre de la liga:");
			nombreLiga = Main.cargarString("");
			if (Main.buscarLiga(listaLigas, nombreLiga) != -1) {
				System.out.println("Liga ya existente, ingresar un nombre diferente:");
				yaExiste = true;
			}
		} while (yaExiste);

		do {
			System.out.println("Ingrese Tipo de liga \n 1 - Heroes \n 2 - Villanos");

			tipo = Main.cargarString("");
			if (tipo.equals("1")) {
				liga = new Liga("heroe", nombreLiga);
			} else if (tipo.equals("2")) {
				liga = new Liga("villano", nombreLiga);
			} else {
				System.out.println("Tipo incompatible");
			}

		} while (tipo.compareTo("1") != 0 && tipo.compareTo("2") != 0);

		do {
			System.out.println("Que Desea Agregar?");
			System.out.println("1- Personaje");
			System.out.println("2- Liga");
			System.out.println("0- Salir");
			input = Main.cargarString("");

			if (input.equals("1")) { // personaje
				System.out.println("Ingrese el personaje que desea agregar a la Liga\n");
				System.out.println("Personajes disponibles...");

				List<Unidad> l = null;

				if (tipo.compareTo("1") == 0) {
					l = listaCompetidores.stream().filter(c -> c.getTipo().equals("heroe"))
							.collect(Collectors.toList());
				} else if (tipo.compareTo("2") == 0) {
					l = listaCompetidores.stream().filter(c -> c.getTipo().equals("villano"))
							.collect(Collectors.toList());
				}
				if (AdministracionDePersonajes.listadoPersonaje(l)) {

					indice = Main.cargarEntero("Inserte numero del 1 al " + l.size()
							,1,l.size());

					if (liga.agregar(l.get(indice - 1)))
						System.out.println("Personaje agregado exitosamente...");
					else
						System.out.println("\nNo se puede agregar nuevamente");
				}
			} else if (input.equals("2")) {// liga
				System.out.println("Ingrese la Liga que desea agregar a la Liga\n");
				System.out.println("Ligas disponibles...");

				List<Liga> l = null;

				if (tipo.compareTo("1") == 0) {
					l = listaLigas.stream().filter(c -> c.getTipo().equals("heroe")).collect(Collectors.toList());
				} else if (tipo.compareTo("2") == 0) {
					l = listaLigas.stream().filter(c -> c.getTipo().equals("villano")).collect(Collectors.toList());
				}

				if (listaLigas(l)) {
					
					indice = Main.cargarEntero("Inserte numero del 1 al " + l.size(),1,l.size());
					if (liga.agregar(l.get(indice - 1)))
						System.out.println("Liga agregada exitosamente...");
					else
						System.out.println("\nNo se puede agregar nuevamente");
				}
			}
		} while (!input.equals("0"));

		listaLigas.add(liga);
		Main.finalmetodo("");
	}

	static boolean listaLigas(List<Liga> listaLigas) {

		int i;
		if (listaLigas.size() >= 1) {
			for (i = 0; i < listaLigas.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println("Liga Nro: " + (i + 1) + "\n" + listaLigas.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
			return true;
		} else {
			System.out.println("No Hay Lista de Ligas");
		}
		return false;

	}

	private static void guardarListaLigas(ArrayList<Liga> listaLigas) {
		ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
		archivoHeroes.guardarArchivo(listaLigas.stream().filter(c -> c.esLigaDeHeroes()).collect(Collectors.toList()));

		ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");
		archivoVillanos.guardarArchivo(
				listaLigas.stream().filter(c -> c.esLigaDeHeroes() == false).collect(Collectors.toList()));
		Main.finalmetodo("lista guardada\n");
	}

}
