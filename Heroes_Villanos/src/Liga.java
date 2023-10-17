import java.util.ArrayList;

public abstract class Liga extends Bando {

	@Override
	public String toString() {
		String retorno = nombre + ", ";
		for (Bando u : liga) {
			retorno = retorno.concat(u.getNombre() + ", ");
		}
		retorno = retorno.substring(0, retorno.length() - 2);
		return retorno;
	}

	ArrayList<Bando> liga = new ArrayList<Bando>();

	public abstract boolean agregar(Bando u);

	public Liga(String tipo, String nombreLiga) {
		this.tipo = tipo;
		this.nombre = nombreLiga;
	}

	public int getVelocidad() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getVelocidad();
		}

		return (int) (prom / liga.size());
	}

	public int getResistencia() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getResistencia();
		}

		return (int) (prom / liga.size());
	}

	public int getDestreza() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getDestreza();
		}

		return (int) (prom / liga.size());
	}

	public int getFuerza() {
		double prom = 0;

		for (Bando unidad : liga) {
			prom += unidad.getFuerza();
		}

		return (int) (prom / liga.size());
	}

}
