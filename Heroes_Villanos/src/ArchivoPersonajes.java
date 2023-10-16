import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ArchivoPersonajes {
	private String nombre;

	public ArchivoPersonajes(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Competidor> leerArchivo() {
		Scanner scanner = null;
		ArrayList<Competidor> datos = null;

		try {
			File file = new File("casos de prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);
			// Especifica la configuración regional que se va a utilizar
			scanner.useLocale(Locale.ENGLISH);
			// Para la configuración regional de Argentina, utilizar:
			// arch.useLocale(new Locale("es_AR"));
			
			datos = new ArrayList<>();
			scanner.nextLine();
			while(scanner.hasNext()) {
				
				String campos[] = scanner.nextLine().split(",");
				datos.add(new Competidor(campos[0], campos[1], campos[2], 
						Integer.valueOf(campos[3]), Integer.valueOf(campos[4]), Integer.valueOf(campos[5]), Integer.valueOf(campos[6])));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			scanner.close();
		}
		return datos;
	}

	public void guardarArchivo(ArrayList<Competidor> datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
			printerWriter = new PrintWriter(file);

			for (int i = 0; i < datos.size(); i++) {
				// Imprime los datos y hace un salto de linea
				printerWriter.println(datos.get(i));
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
