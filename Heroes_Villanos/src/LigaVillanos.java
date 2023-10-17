public class LigaVillanos extends Liga{


	LigaVillanos(String nombreLiga) {
		
		super("villano", nombreLiga);
	}

	public boolean agregar(Bando villano) {
		if(villano.getTipo().toUpperCase().compareTo("VILLANO")!=0) {
			System.out.println("No se puede insertar heroe en una liga de villanos");
			return false;
		}
		super.liga.add(villano);
		return true;
	}
	
	public void eliminarVillano(Unidad v) {
		super.liga.remove(v);
	}


	
	
}
