import java.util.ArrayList;
import java.util.Iterator;

public class Esporte {

	private int id;
	private String name;
	private ArrayList<Selecao> selecoes = new ArrayList<Selecao>();

	// A ideia é passar de seleção a seleção dentro de cada seleção, vou navegar
	// de partida a partida e ir computando vitórias, empates e derrotas. Seta o
	// resultado em apenas um Esporte.
	public void setarResultado() {
		Iterator<Selecao> iselecao = this.selecoes.iterator();
		while (iselecao.hasNext()) {
			Selecao selecao = (Selecao) iselecao.next();
			Iterator<Partida> ipartida = selecao.getPartida().iterator();
			while (ipartida.hasNext()) {
				Partida partida = (Partida) ipartida.next();
				if (partida.getPlacarSelA() > partida.getPlacarSelB()) {
					selecao.aumentarVitorias();
				} else if (partida.getPlacarSelA() < partida.getPlacarSelB()) {
					selecao.aumentarDerrotas();
				} else {
					selecao.aumentarEmpates();
				}
			}
		}
	}

	// Seta resultados em todos esportes do ArrayList<Esporte>.
	public void setarTodosResultados(ArrayList<Esporte> esp) {
		Iterator<Esporte> iesp = esp.iterator();
		while (iesp.hasNext()) {
			Esporte esporte = (Esporte) iesp.next();
			// Se for do tipo VoleyPraia ou FutebolAreia vamos força-lo a chamar
			// o método setarResultado
			// da classe filha, fazendo casting
			if (esporte instanceof VoleyPraia) {
				((VoleyPraia) esporte).setarResultado();
			} else if (esporte instanceof FutebolAreia) {
				((FutebolAreia) esporte).setarResultado();
			} else {
				esporte.setarResultado();
			}
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// Insere as seleções dentro da classe esporte.
	public void insertSelecoes(Selecao sel) {
		Selecao novo = new Selecao();
		novo.setName(sel.getName());
		novo.setId(sel.getId());
		novo.setIdEsporte(this.getId());
		this.selecoes.add(novo);
	}

	public ArrayList<Selecao> getSelecao() {
		return selecoes;
	}

	void mostrarEsportes(ArrayList<Esporte> esp) {
		Iterator<Esporte> iesp = esp.iterator();
		while (iesp.hasNext()) {
			Esporte esporte = (Esporte) iesp.next();
			Iterator<Selecao> isel = esporte.getSelecao().iterator();
			System.out.println(esporte.name);
			while (isel.hasNext()) {
				Selecao selecao = (Selecao) isel.next();
				selecao.mostrarSelecao();
			}
		}
	}
}