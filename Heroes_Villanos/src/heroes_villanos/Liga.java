package heroes_villanos;
import java.util.ArrayList;

public abstract class Liga extends Competidor {

	ArrayList<Competidor> liga = new ArrayList<Competidor>();

	public abstract boolean agregar(Competidor u);

	public Liga(String tipo, String nombreLiga) {
		this.tipo = tipo;
		this.nombre = nombreLiga;
	}

	@Override
	public String toString() {
		String retorno = nombre + ", ";
		for (Competidor u : liga) {
			retorno = retorno.concat(u.getNombre() + ", ");
		}
		retorno = retorno.substring(0, retorno.length() - 2);
		return retorno;
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

	public double getVelocidad() {
		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				prom += ((Liga) unidad).sumaVelocidades();
				cant += ((Liga) unidad).sumaCantidades();
			} else {
				prom += unidad.getVelocidad();
				cant++;
			}
		}

		return prom / cant;
	}

	private double sumaVelocidades() {
		double suma = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				suma += ((Liga) unidad).sumaVelocidades();
			} else {
				suma += unidad.getVelocidad();
			}
		}
		return suma;
	}

	private int sumaCantidades() {
		int suma = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				suma += ((Liga) unidad).sumaCantidades();
			} else {
				suma++;
			}
		}
		return suma;
	}

	public double getResistencia() {
		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				prom += ((Liga) unidad).sumaResistencia();
				cant += ((Liga) unidad).sumaCantidades();
			} else {
				prom += unidad.getResistencia();
				cant++;
			}
		}

		return prom / cant;
	}

	private double sumaResistencia() {
		double suma = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				suma += ((Liga) unidad).sumaResistencia();
			} else {
				suma += unidad.getResistencia();
			}
		}
		return suma;
	}

	public double getDestreza() {
		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				prom += ((Liga) unidad).sumaDestreza();
				cant += ((Liga) unidad).sumaCantidades();
			} else {
				prom += unidad.getDestreza();
				cant++;
			}
		}
		return prom / cant;
	}

	private double sumaDestreza() {
		double suma = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				suma += ((Liga) unidad).sumaDestreza();
			} else {
				suma += unidad.getDestreza();
			}
		}
		return suma;
	}

	public double getFuerza() {
		double prom = 0;
		int cant = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				prom += ((Liga) unidad).sumaFuerza();
				cant += ((Liga) unidad).sumaCantidades();
			} else {
				prom += unidad.getFuerza();
				cant++;
			}
		}
		return prom / cant;
	}

	private double sumaFuerza() {
		double suma = 0;
		for (Competidor unidad : liga) {
			if (unidad instanceof Liga) {
				suma += ((Liga) unidad).sumaFuerza();
			} else {
				suma += unidad.getFuerza();
			}
		}
		return suma;
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

	protected boolean eliminarLiga(Competidor v) {
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
