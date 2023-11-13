package heroes_villanos;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
				reportes(listaCompetidores,listaLigas);
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
			case ("1"):  cargarListaPersonajes(listaCompetidores);
				break;
			case ("2"):  crearPersonaje(listaCompetidores);
				break;
			case ("3"):  listadoPersonaje(listaCompetidores);
				break;
			case ("4"):  guardarListaPersonajes(listaCompetidores);
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

	private static void guardarListaPersonajes(ArrayList<Unidad> listaCompetidores) {
		ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
		archivoPersonajes.guardarArchivo(listaCompetidores);
	}

	private static void cargarListaPersonajes(ArrayList<Unidad> listaCompetidores) {
		ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
		listaCompetidores.addAll(archivoPersonajes.leerArchivo().stream().filter(c->buscarPersonaje(listaCompetidores, c.getNombre())==-1).collect(Collectors.toList()));
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
			case ("1"):  cargarListaLigas(listaCompetidores,listaLigas);
				break;
			case ("2"):  crearLiga(listaCompetidores, listaLigas);
				break;
			case ("3"):  listaLigas(listaLigas);
				break;
			case ("4"):  guardarListaLigas(listaLigas);
				break;
			case ("5"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("5"));
		limpiarPantalla();

	}

	private static void guardarListaLigas(ArrayList<Liga> listaLigas) {
		ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
		archivoHeroes.guardarArchivo(listaLigas.stream().filter(c -> c.esLigaDeHeroes()).collect(Collectors.toList()));
		
		ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");
		archivoVillanos.guardarArchivo(listaLigas.stream().filter(c -> c.esLigaDeHeroes() == false).collect(Collectors.toList()));
	}

	private static void cargarListaLigas(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {
			ArchivoLigas archivoHeroes = new ArchivoLigas("ligaHeroes");
			ArchivoLigas archivoVillanos = new ArchivoLigas("ligasVillanos");
			
			listaLigas.addAll(archivoHeroes.leerArchivo(listaCompetidores).stream().filter(c->buscarLiga(listaLigas, c.getNombre())==-1).collect(Collectors.toList()));
			listaLigas.addAll(archivoVillanos.leerArchivo(listaCompetidores).stream().filter(c->buscarLiga(listaLigas, c.getNombre())==-1).collect(Collectors.toList()));
	}

	static void realizacionDeCombates(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n" 
					+ "1 Personaje contra Personaje\r\n"
					+ "2 Personaje contra Liga (definiendo caracteristica)\r\n"
					+ "3 Liga contra Liga (definiendo caracteristica)\r\n"
					+ "4 Atras");

			menup = new Scanner(System.in);
			menuPrincipal = menup.nextLine();
			switch (menuPrincipal) {
			case ("1"): personajeContraPersonaje(listaCompetidores);
				break;
			case ("2"): personajeContraLiga(listaCompetidores, listaLigas);
				break;
			case ("3"): ligaContraLiga(listaLigas);
				break;
			case ("4"):
				break;
			default:
				System.out.println("\nCaracter no valido\n");
			}
		} while (!menuPrincipal.equals("4"));
		limpiarPantalla();
	}

	private static int buscarPersonaje(ArrayList<Unidad> listaCompetidores, String nombre)
	{
		int indice=-1;
		int i=0;
		
		while(i<listaCompetidores.size() && indice == -1)
		{
			if(listaCompetidores.get(i).getNombre().equals(nombre))
				indice = i;
			
			i++;
		}
		
		return indice;
	}

	private static int buscarLiga(ArrayList<Liga> listaLigas, String nombre)
	{
		int indice=-1;
		int i=0;
		
		while(i<listaLigas.size() && indice == -1)
		{
			if(listaLigas.get(i).getNombre().equals(nombre))
				indice = i;
			
			i++;
		}
		
		return indice;
	}
	private static void ligaContraLiga(ArrayList <Liga> listaLigas)
	{
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
		
		
		if (indiceLiga1 != -1 && indiceLiga2 != -1)		//VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
		{
			Liga l1 = listaLigas.get(indiceLiga1);
			Liga l2 = listaLigas.get(indiceLiga2);
			
			if(l1.getTipo() != l2.getTipo())		//VERIFICO SI NO SON DEL MISMO BANDO
			{
				if(l1.esGanador(l2, caracteristicaPorTeclado()))
					System.out.println("\nTu liga " + l1.getNombre() + " ha triunfado");
				else
					System.out.println(l1.getNombre() + "ha sido derrotado.");
			}
			else
				System.out.println("Dos ligas no pueden luchar entre si si son del mismo bando.");

		}
		else
			System.out.println("No existe el nombre del o las ligas.");
		
		System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
		salir = menup.nextLine();
		}while(!salir.equals("0"));
	}
	private static void personajeContraPersonaje(ArrayList <Unidad> listaCompetidores)
	{
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
		
		
		if (indicePersonaje != -1 && indicePersonaje2 != -1)		//VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
		{
			Unidad personaje = listaCompetidores.get(indicePersonaje);
			Unidad personaje2 = listaCompetidores.get(indicePersonaje2);
			
			if(personaje.getTipo() != personaje2.getTipo())		//VERIFICO SI NO SON DEL MISMO BANDO
			{
				if(personaje.esGanador(personaje2, caracteristicaPorTeclado()))
					System.out.println("\nTu " + personaje.getTipo() + " "+personaje.getNombre() + " ha triunfado");
				else
					System.out.println(personaje.getNombre() + " ha sido derrotado.");
			}
			else
				System.out.println("Dos personajes no pueden luchar entre si si son del mismo bando.");

		}
		else
			System.out.println("No existe el nombre del o los personajes.");
		
		System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
		salir = menup.nextLine();
		}while(!salir.equals("0"));
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
		
		
		if (indicePersonaje != -1 && indiceLiga != -1)		//VERIFICO SI EXISTE LO QUE PIDE EL USUARIO
		{
			Unidad personaje = listaCompetidores.get(indicePersonaje);
			Liga equipo = listaLigas.get(indiceLiga);
			
			if(personaje.getTipo() != equipo.getTipo())		//VERIFICO SI NO SON DEL MISMO BANDO
			{
				if(personaje.esGanador(equipo, caracteristicaPorTeclado()))
					System.out.println("\nTu " + personaje.getTipo() + " " + personaje.getNombre() + " ha triunfado");
				else
					System.out.println(personaje.getNombre() + " ha sido derrotado.");
			}
			else
				System.out.println("Un personaje y una liga no pueden luchar entre si si son del mismo bando.");

		}
		else
			System.out.println("No existe el nombre del personaje o liga.");
		
		System.out.println("Presione 0 para salir al menu. Presione cualquier tecla si desea volver a comenzar.");
		salir = menup.nextLine();
		}while(!salir.equals("0"));
		
	}
	
	static void reportes(ArrayList<Unidad> listaCompetidores,ArrayList<Liga> listaLigas) {

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
			case ("1"):  todosLosQueVencenAPersonajeEnCaracteristica(listaCompetidores,listaLigas);
				break;
			case ("2"):  listadoPersonaje(listadoOrdenadoPersonajes(listaCompetidores));
				break;
			case ("3"):
				break;
			}
		} while (!menuPrincipal.equals("3"));
		limpiarPantalla();
	}

	private static void todosLosQueVencenAPersonajeEnCaracteristica(ArrayList<Unidad> listaCompetidores,
			ArrayList<Liga> listaLigas) {
		
		System.out.println("Ingresar nombre de personaje a vencer:");
		String nombre = menup.nextLine();
		Caracteristica c = caracteristicaPorTeclado();
		
		Competidor personajeAVencer = listaCompetidores.get(buscarPersonaje(listaCompetidores, nombre));
		System.out.println(personajeAVencer + "\nes vencido por:");
		System.out.println("PERSONAJES");
		boolean vencidoXPersonaje = false;
		for (Unidad unidad : listaCompetidores) {
			if(personajeAVencer != unidad && !personajeAVencer.getTipo().equals(unidad.getTipo()) && unidad.esGanador(personajeAVencer, c)) {
				System.out.println(unidad);
				vencidoXPersonaje = true;
			}
		}
		if(!vencidoXPersonaje) System.out.println("NINGUNO");
		
		boolean vencidoXLiga = false;
		System.out.println("\nLIGAS");
		for (Liga liga : listaLigas) {
			if(!personajeAVencer.getTipo().equals(liga.getTipo()) && liga.esGanador(personajeAVencer, c)) {
				System.out.println(liga);
				vencidoXLiga = true;
			}
		}
		if(!vencidoXLiga) System.out.println("NINGUNA");
		System.out.println();
		
	}

	private static List<Unidad> listadoOrdenadoPersonajes(ArrayList<Unidad> listaCompetidores) {
		Caracteristica c = caracteristicaPorTeclado();
		return listaCompetidores.stream().sorted(new CompetidorComparador(c)).collect(Collectors.toList());
	}

	private static Caracteristica caracteristicaPorTeclado() {
		int caracteristica;
		System.out.println("Escoga caracteristica:\n1. Velocidad\r\n"
				+ "2. Fuerza\r\n"
				+ "3. Resistencia\r\n"
				+ "4. Destreza");
		caracteristica = menup.nextInt();
		
		while(caracteristica>4 || caracteristica<1 )
		{
			System.out.println("Opcion no valida. Vuelva a intentar");
			caracteristica = menup.nextInt();
		}
		
		Caracteristica c2=null;
		for (Caracteristica c1 : Caracteristica.values()) {
			if(c1.ordinal()==caracteristica-1)
				c2=c1;
		}
		return c2;
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
		System.out.println("\n----Creando Liga----\n");
		System.out.println("Ingrese nombre de la liga");

		nombreLiga = menup.nextLine();
		do {
			System.out.println("Ingrese nombre Tipo de liga (Heroe o Villano)");

			tipo = menup.nextLine();
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
			input = menup.nextLine();
			if (input.equals("1")) {
				System.out.println("Ingrese el personaje que desea agregar a la Liga\n");
				System.out.println("Personajes disponible...");
				listadoPersonaje(listaCompetidores);
				System.out.println("Ingrese Numero de Competidor");
				indice = Integer.parseInt(menup.nextLine());
				if (indice <= listaCompetidores.size() && indice >= 0) { 
					//validamos si estamos afuera de rango del indice
					if (liga.getTipo().toUpperCase()
							.equals(listaCompetidores.get(indice - 1).getTipo().toUpperCase())) {

						// si se quiere ingresar un competidor del mismo tipo (heroe o villano) que el
						// tipo de la liga se
						// agrega al competidor a la liga y sino Tipo de competidor incompatible con el
						// tipo de la liga

						liga.agregar(listaCompetidores.get(indice - 1));
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