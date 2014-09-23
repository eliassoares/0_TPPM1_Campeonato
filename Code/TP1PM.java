import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TP1PM {

	public static void main(String[] args) throws FileNotFoundException {
		Estatistica est = new Estatistica();
		EntradaESaida dados = new EntradaESaida();
		Esporte esp = new Esporte();

		ArrayList<Esporte> esportes = dados.bankSports();
		ArrayList<Selecao> selecao = dados.bankSelecao();
		ArrayList<Partida> partidas = dados.bankGames();
		ArrayList<Atletas> atletas = dados.bankAthletes();
		ArrayList<Integer[]> estatisticas = dados.bankStatistics();
				
		est.linkarEsporteESelecao(esportes, selecao);
		est.linkarSelecaoAtletas(esportes, atletas);
		est.setarEstatisticas(esportes, partidas);
		esp.setarTodosResultados(esportes);
		est.geraEstatistica(estatisticas, dados, esportes);
	}
}