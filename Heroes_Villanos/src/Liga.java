import java.util.ArrayList;
import java.util.Objects;

public abstract class Liga extends Bando {

	@Override
	public int hashCode() {
		return Objects.hash(liga);
	}

	@Override
	public String toString() {
		String retorno = nombre + ", ";
		for (Bando u : liga) {
			retorno = retorno.concat(u.getNombre() + ", ");
		}
		retorno = retorno.substring(0, retorno.length() - 2);
		return retorno;
	}

	public static boolean extisteEnEstaLiga(Liga l, Bando u) {
		if (u instanceof Liga) {
			Liga l2 = (Liga) u;
			for (Bando v : l2.liga) {
				if(extisteEnEstaLiga(l, v))
					return true;
			}
		} else {
			for (Bando b : l.liga) {
				if (u.getNombre().compareTo(b.getNombre()) == 0
						|| ((b instanceof Liga) && extisteEnEstaLiga((Liga) b, u)))
					return true;
			}
		}
		return false;
	}

	ArrayList<Bando> liga = new ArrayList<Bando>();
	
	public abstract boolean agregar(Bando u);

	public Liga(String tipo, String nombreLiga) {
		this.tipo = tipo;
		this.nombre = nombreLiga;
	}

	public double getVelocidad() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getVelocidad();
		}

		return  prom / liga.size();
	}

	public double getResistencia() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getResistencia();
		}

		return prom / liga.size();
	}

	public double getDestreza() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getDestreza();
		}

		return prom / liga.size();
	}

	public double getFuerza() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getFuerza();
		}

		return prom / liga.size();
	}

}
