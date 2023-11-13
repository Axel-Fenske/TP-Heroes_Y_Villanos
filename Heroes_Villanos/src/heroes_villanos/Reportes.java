package heroes_villanos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class  Reportes {
	

	public static void guardarArchivo(String tipoReporte, String datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		 LocalDateTime datetime = LocalDateTime.now();
		try {
			file = new FileWriter( "casos de prueba/reportes/" + tipoReporte + " "+
					datetime.getYear()+"-" + datetime.getMonthValue() + "-" + datetime.getDayOfMonth()
					+ " "+ datetime.getHour() + "-" + datetime.getMinute() + ".out");
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
