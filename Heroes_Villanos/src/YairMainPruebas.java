import java.util.ArrayList;

public class YairMainPruebas {

	public static void main(String[] args) {
		//											velocidad fuerza resistencia destreza
		Unidad v1 = new Unidad("villano","c3", "cc", 50, 70, 100, 1200);
		Unidad v2 = new Unidad("villano","d4", "dd", 29, 150, 300, 1200);
		Unidad v3 = new Unidad("villano","a1", "aa", 230, 400, 23, 120);
		Unidad v4 = new Unidad("villano","b2", "bb", 100, 500, 10, 30);

		LigaVillanos lv = new LigaVillanos("liga");
		lv.agregar(v1);
		lv.agregar(v2);
		LigaVillanos lv2 = new LigaVillanos("liga2");
		lv2.agregar(v3);
		lv2.agregar(v4);
		lv.agregar(lv2);
		
		Unidad h1 = new Unidad("heroe","h1", "h1", 50, 70, 100, 1200);
		LigaHeroes lh = new LigaHeroes("liga");
		lh.agregar(h1);
		
		System.out.println(lh.esGanador(lv, Caracteristica.DESTREZA));
		System.out.println(lv);
		
		
		System.out.println("PRUEBA DE ARCHIVO LIGAS");
		ArchivoPersonajes archivoPersonajes = new ArchivoPersonajes("personajes");
		ArchivoLigas archivoLigas = new ArchivoLigas("ligaHeroes");
		ArrayList<Liga> ligasHeroes = archivoLigas.leerArchivo(archivoPersonajes.leerArchivo());
		archivoLigas = new ArchivoLigas("ligasVillanos");
		ArrayList<Liga> ligasVillanos = archivoLigas.leerArchivo(archivoPersonajes.leerArchivo());
		
		System.out.println(ligasHeroes);
		System.out.println(ligasVillanos);
		
		System.out.println(ligasHeroes.get(0).esGanador(ligasVillanos.get(2), Caracteristica.DESTREZA));
//		375
//		150
//		200
		
	}

}
