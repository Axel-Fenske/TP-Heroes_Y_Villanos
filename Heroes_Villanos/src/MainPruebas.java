//
public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unidad u1 = new Unidad("villano", "ganster", "u1", 1, 2, 3, 0);
		Unidad u2 = new Unidad("villano", "ga", "u2", 2, 3, 3, 0);
		Unidad u3 = new Unidad("villano", "ganster", "u3", 3, 4, 3, 0);
		Unidad u4 = new Unidad("villano", "ganster", "u4", 4, 5, 3, 0);
		Unidad u5 = new Unidad("villano", "ganster", "u5", 5, 6, 3, 0);
		Unidad u6 = new Unidad("villano", "ganster", "u6", 5, 7, 3, 0);
		Unidad u7 = new Unidad("heroe", "ganster", "u7", 28, 8, 3, 0);
		LigaVillanos lv = new LigaVillanos("liga");
		LigaVillanos lv2 = new LigaVillanos("liga2");
		LigaVillanos lv3 = new LigaVillanos("liga3");
		LigaHeroes lv4 = new LigaHeroes("liga4");
//		System.out.println(u.getTipo());;
		lv.agregar(u1);
//		System.out.println(lv.toString());
//		lv.agregar(u2);
		lv2.agregar(u3);
		lv2.agregar(u4);
		lv.agregar(lv2);
		lv3.agregar(u5);
		lv3.agregar(u6);
		lv.agregar(lv3);
		lv4.agregar(u7);
//		lv.agregar(lv4);
		
		System.out.println(lv);
		System.out.println(lv4);
//		System.out.println(lv.getVelocidad());
		
//		System.out.println(Liga.extisteEnEstaLiga(lv,u4));
		Caracteristica c1= Caracteristica.FUERZA;
		System.out.println(lv3.esGanador(lv, c1));
		System.out.println(lv.esGanador(lv4, c1));
	}

}
