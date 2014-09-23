import java.util.Iterator;

public class VoleyPraia extends Voley {
	// método da classe superior foi sobrescrito

	// @Override
	public void setarResultado() {
		Iterator<Selecao> iselecao = this.getSelecao().iterator();
		while (iselecao.hasNext()) {
			Selecao selecao = (Selecao) iselecao.next();
			Iterator<Partida> ipartida = selecao.getPartida().iterator();
			while (ipartida.hasNext()) {
				Partida partida = (Partida) ipartida.next();
				if (partida.getPlacarSelA() > partida.getPlacarSelB()) {
					selecao.aumentarDerrotas();
				} else if (partida.getPlacarSelA() == partida.getPlacarSelB()) {
					selecao.aumentarEmpates();
				} else {
					selecao.aumentarVitorias();
				}
			}
		}
	}

}