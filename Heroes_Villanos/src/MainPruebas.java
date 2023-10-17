
public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unidad u = new Unidad("villano", "ganster", "megaman", 0, 0, 0, 0);
		Unidad u2 = new Unidad("villano", "ga", "mefisto", 0, 0, 0, 0);
		Unidad u3 = new Unidad("villano", "ganster", "lechuga_man", 0, 0, 0, 0);
		LigaVillanos lv = new LigaVillanos("liga");
		LigaVillanos lv2 = new LigaVillanos("liga2");
//		System.out.println(u.getTipo());;
		lv.agregar(u);
		System.out.println(lv.toString());
		lv2.agregar(u2);
		lv2.agregar(u3);
		lv.agregar(lv2);
		System.out.println(lv.toString());
	}

}
