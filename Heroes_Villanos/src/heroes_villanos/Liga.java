package heroes_villanos;

import java.util.ArrayList;

public class Liga extends Competidor {

	ArrayList<Competidor> liga = new ArrayList<Competidor>();

	public boolean agregar(Competidor c) {

		if (c.getTipo().toUpperCase().compareTo(this.getTipo().toUpperCase()) != 0) {
			System.out.println("No se puede insertar un " + c.getTipo() + " en una liga de " + this.getTipo());
			return false;
		}
		if (Liga.extisteEnEstaLiga(this, c)) {
			if (c instanceof Unidad)
				System.out.println("el " + c.getTipo() + " \""+ c.nombre.toUpperCase() +"\" ya pertenece a la liga");
			else
				System.out.println("un " + c.getTipo()+ " de la liga \"" +c.nombre.toUpperCase() + "\" ya pertenece a la liga actual");
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

	public static boolean extisteEnEstaLiga(Liga l, Competidor u) {
		if (u instanceof Liga) {
			Liga l2 = (Liga) u;
			for (Competidor v : l2.liga) {
				if (extisteEnEstaLiga(l, v))
					return true;
			}
		} else {
			for (Competidor b : l.liga) {
				if (u.getNombre().compareTo(b.getNombre()) == 0
						|| ((b instanceof Liga) && extisteEnEstaLiga((Liga) b, u)))
					return true;
			}
		}
		return false;
	}

	public double getCaracteristica(Caracteristica c) {

		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				prom += unidad.getCaracteristica(c);
				
			} else {
				prom += unidad.getCaracteristica(c);

			}
			cant++;
		}

		return prom / cant;
	}

	protected boolean eliminar(Competidor v) {

		for (Competidor bando : liga) {
			if (bando instanceof Liga) {
				if (extisteEnEstaLiga((Liga) bando, v))
					if (((Liga) bando).eliminar(v)) {
						if (((Liga) bando).liga.size() == 0) {
							return this.eliminarLiga(bando);
						} else {
							return true;
						}
					}
			} else if (bando.getNombre().compareTo(v.getNombre()) == 0)
				return liga.remove(v);
		}
		return false;
	}

	public boolean eliminarLiga(Competidor v) {
		for (Competidor bando : liga) {
			if (bando.getNombre().compareTo(v.getNombre()) == 0 && bando instanceof Liga) {
				System.out.println(
						"liga '" + v.getNombre() + "' eliminada de '" + this.getNombre() + "' porque estaba vacia");
				return this.liga.remove(bando);
			}

		}
		return false;
	}
}
