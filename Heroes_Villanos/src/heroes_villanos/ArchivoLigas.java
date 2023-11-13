package heroes_villanos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ArchivoLigas {
	private String nombre;

	public ArchivoLigas(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Liga> leerArchivo(ArrayList<Unidad> listaPersonajes) {
		Scanner scanner = null;
		HashMap<String,Competidor> mapaCompetidores = new HashMap<String,Competidor>();
		ArrayList<Liga> ligasCargadas = null;		
		
		try {
			File file = new File("casos de prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			ligasCargadas = new ArrayList<>();
			for (int i = 0; i < listaPersonajes.size(); i++) {
				Unidad unidadDeLaLista = listaPersonajes.get(i);
				mapaCompetidores.put(unidadDeLaLista.getNombre(), unidadDeLaLista);
			}
			
			while(scanner.hasNext()) {
				
				String campos[] = scanner.nextLine().split(", ");
				
				String nombre = campos[0];
				Liga nueva;
				
				if(mapaCompetidores.containsKey(campos[1]) && mapaCompetidores.get(campos[1]).getTipo().equals("villano"))
					nueva = new LigaVillanos(nombre);
				else nueva = new LigaHeroes(nombre);
				
				for (int i = 1; i < campos.length; i++) {
					Competidor competidor = mapaCompetidores.get(campos[i]);
					if(competidor == null)
						throw new RuntimeException("no hay suficiente informacion de personajes disponible para cargar ligas");
					nueva.agregar(competidor);
				}
				mapaCompetidores.put(nombre, nueva);
				ligasCargadas.add(nueva);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return ligasCargadas;
	}

	public void guardarArchivo(List<Liga> listaLigas) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
			printerWriter = new PrintWriter(file);

			for (int i = 0; i < listaLigas.size(); i++) {
				// Imprime los datos y hace un salto de linea
				printerWriter.println(listaLigas.get(i));
			}
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
