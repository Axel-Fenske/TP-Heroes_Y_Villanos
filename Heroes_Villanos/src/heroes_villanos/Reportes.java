package heroes_villanos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.stream.Collectors;

public class Reportes {
	static void menu(ArrayList<Unidad> listaCompetidores, ArrayList<Liga> listaLigas) {

		String menuPrincipal;
		Main.limpiarPantalla();
		do {
			System.out.println("Seleccione una opcion\n"
					+ "1 Todos los personajes o ligas que venzan a un personaje dado para cierta caracteristica\r\n"
					+ "2 Listado ordenado de personajes por multiples caracteristicas\r\n" + "3 Atras");

			menuPrincipal = Main.cargarString("");
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
		Main.limpiarPantalla();
	}

	private static void todosLosQueVencenAPersonajeEnCaracteristica(ArrayList<Unidad> l, ArrayList<Liga> listaLigas) {

		String s = "";
		Main.listar(l,"");
		System.out.println("Ingresar numero de personaje a vencer:");
		int indice = Main.cargarEntero("Inserte numero del 1 al " + l.size(), 1, l.size());
		Caracteristica c = Main.cargarCaracteristica();
		Competidor personajeAVencer = l.get(indice - 1);
		s = s.concat(personajeAVencer + "\nes vencido en \n" + c + "\npor:\n");
		s = s.concat("PERSONAJES\n");
		boolean vencidoXPersonaje = false;
		for (Unidad unidad : l) {
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
		Main.finalMetodo("reporte guardado\n");
	}

	private static void listadoOrdenadoPersonajes(ArrayList<Unidad> listaCompetidores) {
		String s = "";
		Caracteristica c = Main.cargarCaracteristica();
		s = s.concat("lista ordenada por " + c.name() + "\n");
		for (Unidad unidad : listaCompetidores.stream().sorted(new CompetidorComparador(c))
				.collect(Collectors.toList())) {
			s = s.concat(unidad + "\n");

		}
		Reportes.guardarArchivo("ListaOrdenada por " + c.name() + " ", s);

		Main.finalMetodo("reporte guardado\n");
	}

	public static void guardarArchivo(String tipoReporte, String datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		LocalDateTime datetime = LocalDateTime.now();
		try {
			file = new FileWriter("casos de prueba/reportes/" + tipoReporte + " " + datetime.getYear() + "-"
					+ datetime.getMonthValue() + "-" + datetime.getDayOfMonth() + " " + String.format("%01d",datetime.getHour()) + "-"
					+ String.format("%01d",datetime.getMinute()) + "-" + String.format("%01d",datetime.getSecond()) + ".out");
			printerWriter = new PrintWriter(file);

			// Imprime los datos y hace un salto de linea
			printerWriter.println(datos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
