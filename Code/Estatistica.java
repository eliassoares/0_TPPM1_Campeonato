import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

class Estatistica {

	void setarEstatisticas(ArrayList<Esporte> esp, ArrayList<Partida> part) {
		Iterator<Partida> ipartida = part.iterator();
		// Vamos navegar pelas partidas e depois pelos esportes, associando os
		// ids das seleções da partida com
		// as seleções do esporte.
		while (ipartida.hasNext()) {
			Partida partida = (Partida) ipartida.next();
			Iterator<Esporte> iesporte = esp.iterator();
			while (iesporte.hasNext()) {
				Esporte esporte = (Esporte) iesporte.next();
				Iterator<Selecao> iselecaoA = esporte.getSelecao().iterator();

				while (iselecaoA.hasNext()) {
					Selecao selecaoA = (Selecao) iselecaoA.next();
					if (selecaoA.getId() == partida.getIdA()) {
						selecaoA.setPartida(partida);
						Iterator<Selecao> iselecaoB = esporte.getSelecao()
								.iterator();

						while (iselecaoB.hasNext()) {
							Selecao selecaoB = (Selecao) iselecaoB.next();
							if (selecaoB.getId() == partida.getIdB()) {
								selecaoB.setPartida(partida);
							}
						}
					}
				}
			}
		}
	}

	// Temos um conjunto de esporte e seleções, agora vamos "ligar" as seleções
	// com seus respectivos esportes
	void linkarEsporteESelecao(ArrayList<Esporte> esp, ArrayList<Selecao> sel) {
		Iterator<Selecao> iselecao = sel.iterator();
		// Vamos passando de seleção por seleção, analisando o id de seu
		// respectivo esporte
		// para cada id, vamos conectar a seleção com o esporte correspondente
		// ao id.
		while (iselecao.hasNext()) {
			Selecao selecao = (Selecao) iselecao.next();
			Iterator<Esporte> iesporte = esp.iterator();
			while (iesporte.hasNext()) {
				Esporte esporte = (Esporte) iesporte.next();
				if (selecao.getIdEsporte() == esporte.getId()) {
					selecao.setNameEsporte(esporte.getName());
					esporte.insertSelecoes(selecao);
				}
			}
		}
	}

	void linkarSelecaoAtletas(ArrayList<Esporte> esp, ArrayList<Atletas> atl) {
		Iterator<Atletas> atletas = atl.iterator();
		while (atletas.hasNext()) {
			Atletas atletas2 = (Atletas) atletas.next();
			Iterator<Esporte> iesporte = esp.iterator();
			while (iesporte.hasNext()) {
				Esporte esporte = iesporte.next();
				Iterator<Selecao> isel = esporte.getSelecao().iterator();
				while (isel.hasNext()) {
					Selecao selecao = (Selecao) isel.next();
					if (atletas2.getIdSelecao() == selecao.getId()) {
						selecao.insertAthlete(atletas2);
					}
				}
			}
		}
	}

	public void geraEstatistica(ArrayList<Integer[]> ent, EntradaESaida es,
			ArrayList<Esporte> esp) throws FileNotFoundException {

		Iterator<Integer[]> staSaida = ent.iterator();

		while (staSaida.hasNext()) {
			Integer[] integers = (Integer[]) staSaida.next();
			if (integers[0] == 1) {
				es.saidaEstatistica1(esp, integers[1]);
			} else if (integers[0] == 2) {
				es.saidaEstatistica2(esp, integers[1]);
			}

		}

	}

}
