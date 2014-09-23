import java.util.Iterator;

public class FutebolAreia extends Futebol {
	@Override
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