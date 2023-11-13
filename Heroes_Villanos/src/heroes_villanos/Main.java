package heroes_villanos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

public class Main {

	private static Scanner menup;

	public static void main(String[] args) {

		String menuPrincipal;
		ArrayList<Unidad> listaCompetidores = new ArrayList<Unidad>();
		ArrayList<Liga> listaLigas = new ArrayList<Liga>();
		menup = new Scanner(System.in);

		do {

			System.out.println("----------MENU PRINCIPAL----------\n");
			System.out.println("Seleccione una opcion");
			System.out.println("1- Administracion de Personajes");
			System.out.println("2- Administracion de Ligas");
			System.out.println("3- Realizacion de combates");
			System.out.println("4- Reportes");
			System.out.println("5- Salir");

			menuPrincipal = menup.nextLine();

			switch (menuPrincipal) {
			case ("1"):
				administracionDePersonajes(listaCompetidores);
				break;
			case ("2"):
				administracionDeLigas(listaCompetidores, listaLigas);
				break;
			case ("3"):
				realizacionDeCombates(listaCompetidores, listaLigas);
				break;
			case ("4"):
				reportes(listaCompetidores, listaLigas);
				break;
			case ("5"):
				System.out.println("Saliendo del juego.........");
				break;
			default:
				System.out.println("\nCaracter no valido!\n");
			}
		} while (!menuPrincipal.equals("5"));
		menup.close();

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////

	static void administracionDePersonajes(ArrayList<Unidad> listaCompetidores) {

		String menuPrincipal;

		do {
			limpiarPantalla();
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
		limpiarPantalla();
	}

	private static void cargarListaPersonajes(ArrayList<Unidad> listaCompetidores) {

		try {
			ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
			listaCompetidores.addAll(archivoPersonajes.leerArchivo().stream()
					.filter(c -> buscarPersonaje(listaCompetidores, c.getNombre()) == -1).collect(Collectors.toList()));

		} catch (Exception e) {
			System.out.println(e);
		}
		finalmetodo("archivo cargado correctamente\n");

	}

	static void crearPersonaje(ArrayList<Unidad> listaCompetidores) {
		limpiarPantalla();
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

		while (valor.equals("0")==false) {

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
				if (buscarPersonaje(listaCompetidores, nombreCompetidor) != -1) {
					yaExiste = true;
					System.out.println("Personajes ya existe, ingresar otro nombre:");
				}
			} while (yaExiste);

			System.out.print("Agregando caracteristicas al personaje.\n" + "Ingrese velocidad del Personaje: ");

			velocidad = Double.parseDouble(menup.nextLine());

			System.out.print("Ingrese Fuerza del Personaje: ");
			fuerza = Double.parseDouble(menup.nextLine());

			System.out.print("Ingrese Resistencia del Personaje: ");
			resistencia = Double.parseDouble(menup.nextLine());

			System.out.print("Ingrese Destreza del Personaje: ");
			destreza = Double.parseDouble(menup.nextLine());

			competidor = new Unidad(heroe_o_villano, nombreReal, nombreCompetidor, velocidad, fuerza, resistencia,
					destreza);
			listaCompetidores.add(competidor);

			System.out.println(
					"\n--------Ingrese un valor distinto de 0 para seguir ingresando Competidores o Ingrese 0 para salir-----------\n");
			valor = menup.nextLine();

		}
		limpiarPantalla();

	}

	static void listadoPersonaje(List<Unidad> listaCompetidores) {

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
		finalmetodo("listado de personajes\n");

	}

	private static void guardarListaPersonajes(ArrayList<Unidad> listaCompetidores) {
		try {

			ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
			archivoPersonajes.guardarArchivo(listaCompetidores);
		} catch (Exception e) {
			System.out.println(e);
		}
		finalmetodo("personajes guardados\n");

	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	static void administracionDeLigas(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Carga desde archivo\r\n" + "2 Creacion\r\n"
					+ "3 Listado\r\n" + "4 Guardar en archivo todas las ligas\n" + "5 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"):
				cargarListaLigas(listaCompetidores, listaLigas);
				break;
			case ("2"):
				crearLiga(listaCompetidores, listaLigas);
				break;
			case ("3"):
				listaLigas(listaLigas);
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
		limpiarPantalla();

	}

	private static void cargarListaLigas(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {
		try {
			ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
			ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");

			listaLigas.addAll(archivoHeroes.leerArchivo(listaCompetidores).stream()
					.filter(c -> buscarLiga(listaLigas, c.getNombre()) == -1).collect(Collectors.toList()));
			listaLigas.addAll(archivoVillanos.leerArchivo(listaCompetidores).stream()
					.filter(c -> buscarLiga(listaLigas, c.getNombre()) == -1).collect(Collectors.toList()));
		finalmetodo("ligas cargadas correctamente\n");
		} catch (Exception e) {
			System.out.println("error al cargar el archivo" + e);
		}

	}

	static void crearLiga(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {
		
		Liga liga = null;
		String nombreLiga;
		String tipo;
		String input;
		int indice;
		System.out.println("\n----Creando Liga----\n");

		boolean yaExiste;
		do {
			yaExiste = false;
			System.out.println("Ingrese nombre de la liga:");
			nombreLiga = menup.nextLine();
			if (buscarLiga(listaLigas, nombreLiga) != -1) {
				System.out.println("Liga ya existente, ingresar un nombre diferente:");
				yaExiste = true;
			}
		} while (yaExiste);

		do {
			System.out.println("Ingrese Tipo de liga \n 1 - Heroes \n 2 - Villanos");

			tipo = menup.nextLine();
			if (tipo.equals("1")) {
				liga = new LigaHeroes(nombreLiga);
			} else if (tipo.equals("2")) {
				liga = new LigaVillanos(nombreLiga);
			} else {
				System.out.println("Tipo incompatible");
			}

		} while (tipo.compareTo("1")!=0&&tipo.compareTo("2")!=0);

		do {
			System.out.println("Que Desea Agregar?");
			System.out.println("1- Personaje");
			System.out.println("2- Liga");
			System.out.println("0- Salir");
			input = menup.nextLine();
			
			if (input.equals("1")) { //personaje
				System.out.println("Ingrese el personaje que desea agregar a la Liga\n");
				System.out.println("Personajes disponible...");

				List <Unidad> l = null;
				
	
				if(tipo.compareTo("1")==0) {
					l=listaCompetidores.stream().filter(c->c.getTipo().equals("heroe"))
							.collect(Collectors.toList());
				}
				else if(tipo.compareTo("2")==0){
					l=listaCompetidores.stream().filter(c->c.getTipo().equals("villano"))
							.collect(Collectors.toList());
				}
				listadoPersonaje(l);
				
				System.out.println("Ingrese Numero de Competidor");
				indice = Integer.parseInt(menup.nextLine());
				if (indice <= l.size() && indice >= 0) {
					// validamos si estamos afuera de rango del indice
					if (liga.getTipo().toUpperCase()
							.equals(l.get(indice - 1).getTipo().toUpperCase())) {

						// si se quiere ingresar un competidor del mismo tipo (heroe o villano) que el
						// tipo de la liga se
						// agrega al competidor a la liga y sino Tipo de competidor incompatible con el
						// tipo de la liga

						liga.agregar(l.get(indice - 1));
						System.out.println("Personaje agregado exitosamente...");
					} else {
						System.out.println("ATENCION!!! Tipo de la liga: " + liga.getTipo().toLowerCase()
								+ " es incompatible con el tipo de competidor");
					}
				} else {
					System.out.println("Personaje Invalido");
				}
			}
			else if(input.equals("2")) {//liga
				System.out.println("Ingrese la Liga que desea agregar a la Liga\n");
				System.out.println("Ligas disponibles...");

				List <Liga> l=null;
				
				if(tipo.compareTo("1")==0) {
					l=listaLigas.stream().filter(c->c.getTipo().equals("heroe"))
							.collect(Collectors.toList());
				}
				else if(tipo.compareTo("2")==0) {
					l=listaLigas.stream().filter(c->c.getTipo().equals("villano"))
							.collect(Collectors.toList());
				}
				listaLigas(l);
				
				System.out.println("Ingrese Numero de Liga");
				indice = Integer.parseInt(menup.nextLine());
				if (indice <= l.size() && indice >= 0) {
					// validamos si estamos afuera de rango del indice
					if (liga.getTipo().toUpperCase()
							.equals(l.get(indice - 1).getTipo().toUpperCase())) {

						// si se quiere ingresar un competidor del mismo tipo (heroe o villano) que el
						// tipo de la liga se
						// agrega al competidor a la liga y sino Tipo de competidor incompatible con el
						// tipo de la liga

						liga.agregar(l.get(indice - 1));
						System.out.println("Liga agregada exitosamente...");
					} else {
						System.out.println("ATENCION!!! Tipo de la liga: " + liga.getTipo().toLowerCase()
								+ " es incompatible con el tipo de Liga");
					}
				} else {
					System.out.println("Liga Invalido");
				}
			}

		} while (!input.equals("0"));
		
		listaLigas.add(liga);
		finalmetodo("");
	}

	static void listaLigas(List<Liga> listaLigas) {

		int i;
		if (listaLigas.size() >= 1) {
			for (i = 0; i < listaLigas.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println("Liga Nro: " + (i + 1) + "\n" + listaLigas.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
		} else {
			System.out.println("No Hay Lista de Ligas");
		}
		finalmetodo("listado de ligas\n");
	}

	private static void guardarListaLigas(ArrayList<Liga> listaLigas) {
		ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
		archivoHeroes.guardarArchivo(listaLigas.stream().filter(c -> c.esLigaDeHeroes()).collect(Collectors.toList()));

		ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");
		archivoVillanos.guardarArchivo(
				listaLigas.stream().filter(c -> c.esLigaDeHeroes() == false).collect(Collectors.toList()));
		finalmetodo("lista guardada\n");
	}

	////////////////////////////////////////////////////////////////////////////////////////////

	static void realizacionDeCombates(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" + "1 Personaje contra Personaje\r\n"
					+ "2 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "3 Liga contra Liga (definiendo caracteristica)\r\n" + "4 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
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
		limpiarPantalla();
	}

	private static void personajeContraPersonaje(ArrayList<Unidad> listaCompetidores) {
		String nombrePersonaje;
		String nombrePersonaje2;
		String salir = "1";

		do {

			System.out.println("Ingrese el personaje que desee que luche: ");
			nombrePersonaje = menup.nextLine();
			System.out.println("Ingrese al personaje que desee que luche: ");
			nombrePersonaje2 = menup.nextLine();

			int indicePersonaje = buscarPersonaje(listaCompetidores, nombrePersonaje);
			int indicePersonaje2 = buscarPersonaje(listaCompetidores, nombrePersonaje2);

			if (indicePersonaje != -1 && indicePersonaje2 != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Unidad personaje = listaCompetidores.get(indicePersonaje);
				Unidad personaje2 = listaCompetidores.get(indicePersonaje2);

				if (personaje.getTipo() != personaje2.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (personaje.esGanador(personaje2, caracteristicaPorTeclado()))
						System.out
								.println("\nTu " + personaje.getTipo() + " " + personaje.getNombre() + " ha triunfado");
					else
						System.out.println(personaje.getNombre() + " ha sido derrotado.");
				} else
					System.out.println("Dos personajes no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del o los personajes.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = menup.nextLine();
		} while (!salir.equals("0"));
		finalmetodo("");
	}

	private static void personajeContraLiga(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String nombrePersonaje;
		String nombreLiga;
		String salir = "1";

		do {

			System.out.println("Ingrese el personaje que desee que luche: ");
			nombrePersonaje = menup.nextLine();
			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga = menup.nextLine();

			int indicePersonaje = buscarPersonaje(listaCompetidores, nombrePersonaje);
			int indiceLiga = buscarLiga(listaLigas, nombreLiga);

			if (indicePersonaje != -1 && indiceLiga != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Unidad personaje = listaCompetidores.get(indicePersonaje);
				Liga equipo = listaLigas.get(indiceLiga);

				if (personaje.getTipo() != equipo.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (personaje.esGanador(equipo, caracteristicaPorTeclado()))
						System.out
								.println("\nTu " + personaje.getTipo() + " " + personaje.getNombre() + " ha triunfado");
					else
						System.out.println(personaje.getNombre() + " ha sido derrotado.");
				} else
					System.out.println("Un personaje y una liga no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del personaje o liga.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = menup.nextLine();
		} while (!salir.equals("0"));
		finalmetodo("");
	}

	private static void ligaContraLiga(ArrayList<Liga> listaLigas) {
		String nombreLiga2;
		String nombreLiga;
		String salir = "1";

		do {

			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga = menup.nextLine();
			System.out.println("Ingrese la liga que desee que luche: ");
			nombreLiga2 = menup.nextLine();

			int indiceLiga1 = buscarLiga(listaLigas, nombreLiga);
			int indiceLiga2 = buscarLiga(listaLigas, nombreLiga2);

			if (indiceLiga1 != -1 && indiceLiga2 != -1) // VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
			{
				Liga l1 = listaLigas.get(indiceLiga1);
				Liga l2 = listaLigas.get(indiceLiga2);

				if (l1.getTipo() != l2.getTipo()) // VERIFICO SI NO SON DEL MISMO BANDO
				{
					if (l1.esGanador(l2, caracteristicaPorTeclado()))
						System.out.println("\nTu liga " + l1.getNombre() + " ha triunfado");
					else
						System.out.println(l1.getNombre() + "ha sido derrotado.");
				} else
					System.out.println("Dos ligas no pueden luchar entre si si son del mismo bando.");

			} else
				System.out.println("No existe el nombre del o las ligas.");

			System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
			salir = menup.nextLine();
		} while (!salir.equals("0"));
		finalmetodo("");
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	static void reportes(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

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
				todosLosQueVencenAPersonajeEnCaracteristica(listaCompetidores, listaLigas);
				break;
			case ("2"):
				listadoOrdenadoPersonajes(listaCompetidores);
				break;
			case ("3"):
				break;
			}
		} while (!menuPrincipal.equals("3"));
		limpiarPantalla();
	}

	private static void todosLosQueVencenAPersonajeEnCaracteristica(ArrayList<Unidad> listaCompetidores,
			ArrayList<Liga> listaLigas) {

		String s = "";

		System.out.println("Ingresar nombre de personaje a vencer:");
		String nombre = menup.nextLine();

		int ban = buscarPersonaje(listaCompetidores, nombre);

		while (ban < 0 || nombre == "0") {
			System.out.println(ban);
			System.out.println(nombre);
			System.out.println("Nombre no encontrado, ingrese nuevamente o inserte 0 para salir");
			nombre = menup.nextLine();
			ban = buscarPersonaje(listaCompetidores, nombre);
		}
		if (nombre != "0") {
			Caracteristica c = caracteristicaPorTeclado();
			Competidor personajeAVencer = listaCompetidores.get(ban);
			s = s.concat(personajeAVencer + "\nes vencido por:\n");
			s = s.concat("PERSONAJES\n");
			boolean vencidoXPersonaje = false;
			for (Unidad unidad : listaCompetidores) {
				if (personajeAVencer != unidad && !personajeAVencer.getTipo().equals(unidad.getTipo())
						&& unidad.esGanador(personajeAVencer, c)) {
					s = s.concat(unidad.toString() + "\n");
					vencidoXPersonaje = true;
				}
			}

			if (!vencidoXPersonaje)
				s = s.concat("NINGUNO \n");

			boolean vencidoXLiga = false;
			s = s.concat("\nLIGAS\n");
			for (Liga liga : listaLigas) {
				if (!personajeAVencer.getTipo().equals(liga.getTipo()) && liga.esGanador(personajeAVencer, c)) {
					s = s.concat(liga.toString() + "\n");
					vencidoXLiga = true;
				}
			}
			if (!vencidoXLiga)
				s = s.concat("NINGUNA\n");

			Reportes.guardarArchivo("VencenA", s);

			finalmetodo("reporte guardado\n");
		}
	}

	private static void listadoOrdenadoPersonajes(ArrayList<Unidad> listaCompetidores) {
		String s = "";
		Caracteristica c = caracteristicaPorTeclado();
		s = s.concat("lista ordenada por " + c.name() + "\n");
		for (Unidad unidad : listaCompetidores.stream().sorted(new CompetidorComparador(c))
				.collect(Collectors.toList())) {
			s = s.concat(unidad + "\n");

		}
		Reportes.guardarArchivo("ListaOrdenada por " + c.name() + " ", s);

		finalmetodo("reporte guardado\n");
	}

	// FUNCIONES NO UTILIZADAS DIRECTAMENTE POR EL USUARIO
	private static int buscarPersonaje(ArrayList<Unidad> listaCompetidores, String nombre) {
		int indice = -1;
		int i = 0;

		while (i < listaCompetidores.size() && indice == -1) {
			if (listaCompetidores.get(i).getNombre().equals(nombre))
				indice = i;

			i++;
		}

		return indice;
	}

	private static int buscarLiga(ArrayList<Liga> listaLigas, String nombre) {
		int indice = -1;
		int i = 0;

		while (i < listaLigas.size() && indice == -1) {
			if (listaLigas.get(i).getNombre().equals(nombre))
				indice = i;

			i++;
		}

		return indice;
	}

	static Caracteristica caracteristicaPorTeclado() {
		int caracteristica;
		System.out.println(
				"Escoga caracteristica:\n1. Velocidad\r\n" + "2. Fuerza\r\n" + "3. Resistencia\r\n" + "4. Destreza");
		caracteristica = menup.nextInt();

		while (caracteristica > 4 || caracteristica < 1) {
			System.out.println("Opcion no valida. Vuelva a intentar");
			caracteristica = menup.nextInt();
		}

		Caracteristica c2 = null;
		for (Caracteristica c1 : Caracteristica.values()) {
			if (c1.ordinal() == caracteristica - 1)
				c2 = c1;
		}
		return c2;
	}

	private static void finalmetodo(String mensaje) {
		System.out.println(mensaje + "presione cualquier tecla para continuar");
		menup.nextLine();
		limpiarPantalla();
	}

	static void limpiarPantalla() {

		int i;
		for (i = 0; i < 10; i++) {
			System.out.println("\n");
		}
	}

}