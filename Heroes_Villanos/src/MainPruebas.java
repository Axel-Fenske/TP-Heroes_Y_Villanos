
public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unidad u = new Unidad("villano", "ganster", "megaman", 1, 0, 0, 0);
		Unidad u2 = new Unidad("villano", "ga", "mefisto", 2, 0, 0, 0);
		Unidad u3 = new Unidad("villano", "ganster", "lechuga_man", 3, 0, 0, 0);
		Unidad u4 = new Unidad("villano", "ganster", "lechuga_man2", 4, 0, 0, 0);
		Unidad u5 = new Unidad("villano", "ganster", "lechuga_man2", 5, 0, 0, 0);
		LigaVillanos lv = new LigaVillanos("liga");
		LigaVillanos lv2 = new LigaVillanos("liga2");
		LigaVillanos lv3 = new LigaVillanos("liga3");
		LigaVillanos lv4 = new LigaVillanos("liga4");
//		System.out.println(u.getTipo());;
		lv.agregar(u);
		lv.agregar(u4);
//		System.out.println(lv.toString());
		lv2.agregar(u2);
		lv2.agregar(u3);
		lv.agregar(lv2);
//		lv.agregar(lv4);
//		lv4.agregar(u5);
		System.out.println(lv.getVelocidad());
		
//		System.out.println(Liga.extisteEnEstaLiga(lv,u4));
	}

}
