
public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unidad u1 = new Unidad("villano", "ganster", "u1", 1, 0, 0, 0);
		Unidad u2 = new Unidad("villano", "ga", "u2", 2, 0, 0, 0);
		Unidad u3 = new Unidad("villano", "ganster", "u3", 3, 0, 0, 0);
		Unidad u4 = new Unidad("villano", "ganster", "u4", 4, 0, 0, 0);
		Unidad u5 = new Unidad("villano", "ganster", "u5", 5, 0, 0, 0);
		Unidad u6 = new Unidad("villano", "ganster", "u6", 5, 0, 0, 0);
		Unidad u7 = new Unidad("villano", "ganster", "u7", 28, 0, 0, 0);
		LigaVillanos lv = new LigaVillanos("liga");
		LigaVillanos lv2 = new LigaVillanos("liga2");
		LigaVillanos lv3 = new LigaVillanos("liga3");
		LigaVillanos lv4 = new LigaVillanos("liga4");
//		System.out.println(u.getTipo());;
		lv.agregar(u1);
//		System.out.println(lv.toString());
		lv.agregar(u2);
		lv2.agregar(u3);
		lv2.agregar(u4);
		lv.agregar(lv2);
		lv3.agregar(u5);
		lv3.agregar(u6);
		lv.agregar(lv3);
		lv4.agregar(u7);
		lv.agregar(lv4);
		lv.eliminarVillano(u7);
		System.out.println(lv);
		System.out.println(lv4);
//		System.out.println(lv.getVelocidad());
		
//		System.out.println(Liga.extisteEnEstaLiga(lv,u4));
	}

}
