package heroes_villanos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class  Reportes {
	// Todos los personajes o ligas que venzan a un personaje dado para cierta característica
	
	public static void guardarArchivo(String datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("reporte de ganadores.out");
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
