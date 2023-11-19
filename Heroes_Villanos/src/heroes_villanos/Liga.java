package heroes_villanos;

import java.util.ArrayList;

public class Liga extends Competidor {

	ArrayList<Competidor> liga = new ArrayList<Competidor>();

	public boolean agregar(Competidor c) {

		if (c.getTipo().toUpperCase().compareTo(this.getTipo().toUpperCase()) != 0) {
			System.out.println("No se puede insertar un " + c.getTipo() + " en una liga de " + this.getTipo());
			return false;
		}
		if (Liga.existeEnEstaLiga(this, c)) {
			if (c instanceof Unidad)
				System.out.println("el " + c.getTipo() + " \"" + c.nombre.toUpperCase() + "\" ya pertenece a la liga");
			else
				System.out.println("un " + c.getTipo() + " de la liga \"" + c.nombre.toUpperCase()
						+ "\" ya pertenece a la liga actual");
			return false;
		}
		liga.add(c);
		return true;
	}

	public Liga(String tipo, String nombreLiga) {

		this.tipo = tipo.toLowerCase();
		this.nombre = nombreLiga;
	}

	@Override
	public String toString() {
		String retorno = "[" + nombre + ", ";
		for (int i = 0; i < liga.size(); i++) {
			retorno = retorno.concat(liga.get(i).getNombre());
			retorno = retorno.concat((i != liga.size() - 1) ? ", " : "]");
		}
		return retorno;
	}

	public boolean esLigaDeHeroes() {
		return this.getClass().getSimpleName().equals("LigaHeroes");
	}

	public static boolean existeEnEstaLiga(Liga l, Competidor u) {
		if (u instanceof Liga) {
			Liga l2 = (Liga) u;
			for (Competidor v : l2.liga) {
				if (existeEnEstaLiga(l, v))
					return true;
			}
		} else {
			for (Competidor b : l.liga) {
				if (u.getNombre().compareTo(b.getNombre()) == 0
						&& u.getClass()==b.getClass()
						|| ((b instanceof Liga) && existeEnEstaLiga((Liga) b, u)))
					return true;
			}
		}
		return false;
	}

	public double getCaracteristica(Caracteristica c) {
		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			prom += unidad.getCaracteristica(c);
			cant++;
		}
		return prom / cant;
	}
}
