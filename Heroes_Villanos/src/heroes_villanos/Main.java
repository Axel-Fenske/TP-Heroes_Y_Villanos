package heroes_villanos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	protected static Scanner menup;

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
				AdministracionDePersonajes.menu(listaCompetidores);
				break;
			case ("2"):
				AdministracionDeLigas.menu(listaCompetidores, listaLigas);
				break;
			case ("3"):
				RealizacionDeCombates.menu(listaCompetidores, listaLigas);
				break;
			case ("4"):
				Reportes.menu(listaCompetidores, listaLigas);
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

	// FUNCIONES GENERICAS DE MAIN UTILIZADAS POR LOS SUB-MENUS
	protected static <E> boolean listar(List<E> listaCompetidores, String mensajeError){
		int i;
		
		if (listaCompetidores.size() >= 1) {
			for (i = 0; i < listaCompetidores.size(); i++) {
				System.out.println("------------------------------------------------------");
				System.out.println(listaCompetidores.get(i).getClass().getSimpleName() + " Nro: " + (i + 1) + "\n" + listaCompetidores.get(i).toString());
				System.out.println("------------------------------------------------------\n");
			}
			return true;

		} else {
			System.out.println(mensajeError);
		}
		return false;
	}

	protected static <E> int buscarCompetidor(ArrayList<E> lista, String nombre) {
		int indice = -1;
	    int i = 0;

	    while (i < lista.size() && indice == -1) {

	        if (lista.get(i) instanceof Competidor) {
	            Competidor competidor = (Competidor) lista.get(i);
	            if (competidor.getNombre().equals(nombre)) {
	                indice = i;
	            }
	        }

	        i++;
	    }

	    return indice;
	}

	protected static Double cargarDouble(String cadena) {
		double valor;
		do {
			try {
				System.out.println(cadena);
				valor = Double.parseDouble(menup.nextLine());

			} catch (Exception e) {
				System.out.println("error " + e);
				valor = -1;
			}

		} while (valor < 0);
		return valor;

	}

	protected static String cargarString(String cadena) {
		String valor="";
			try {
				if (cadena.compareTo("") != 0)
					System.out.println(cadena);
				valor = menup.nextLine();

			} catch (Exception e) {
				System.out.println("error " + e);
			}

		return valor;

	}

	protected static int cargarEntero(String cadena, int min, int max) {
		int valor;
		do {
			try {
				System.out.println(cadena);
				valor = Integer.parseInt(menup.nextLine());

			} catch (Exception e) {
				System.out.println("error " + e);
				valor = min - 1;
			}

		} while (valor < min || valor > max);
		return valor;

	}

	static Caracteristica cargarCaracteristica() {
		int caracteristica;
		System.out.println(
				"Escoga caracteristica:\n1. Velocidad\r\n" + "2. Fuerza\r\n" + "3. Resistencia\r\n" + "4. Destreza");
		caracteristica = cargarEntero("Inserte numero del 1 al 4", 1, 4);

		Caracteristica c2 = null;
		for (Caracteristica c1 : Caracteristica.values()) {
			if (c1.ordinal() == caracteristica - 1)
				c2 = c1;
		}
		return c2;
	}

	protected static void finalMetodo(String mensaje) {
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