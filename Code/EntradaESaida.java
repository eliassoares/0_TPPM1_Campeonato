import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EntradaESaida {

	// Leitura e tratamento de exceção do arquivo esportes.txt.
	ArrayList<String> readSports() {
		ArrayList<String> archive = new ArrayList<String>();
		try {
			Scanner sports = new Scanner(new FileReader("esportes.txt"));
			while (sports.hasNextLine()) {
				String linha = sports.nextLine();
				archive.add(linha);
			}
			sports.close();
		} catch (IOException sports) {
			System.err
					.print("Problema na leitura do arquivo esportes.txt. \nVerifique se o nome está correto ou se o arquivo se encontra no diretório\n");
		}
		return archive;
	}

	ArrayList<Esporte> bankSports() {
		ArrayList<Esporte> ListEsport = new ArrayList<Esporte>();

		EntradaESaida file = new EntradaESaida();

		ArrayList<String> lines = new ArrayList<String>();

		lines = file.readSports();

		Iterator<String> singLine = lines.iterator();

		while (singLine.hasNext()) {
			// Quebra o texto em palavras separando por ";"
			String line = singLine.next();
			String linEsport[] = line.split(";");
			if (linEsport[1].equals("Basquete")) {
				Basquete esp = new Basquete();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else if ((linEsport[1].equals("Volei"))
					|| (linEsport[1].equals("Vôlei"))) {
				VoleyQuadra esp = new VoleyQuadra();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else if (linEsport[1].equals("Futebol")) {
				FutebolGrama esp = new FutebolGrama();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else if ((linEsport[1].equals("Volei de praia"))
					|| (linEsport[1].equals("Vôlei de praia"))) {
				VoleyPraia esp = new VoleyPraia();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else if (linEsport[1].equals("Futebol de areia")) {
				FutebolAreia esp = new FutebolAreia();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else if ((linEsport[1].equals("Futebol de salão"))
					|| (linEsport[1].equals("Futebol de salao"))) {
				FutebolSalao esp = new FutebolSalao();
				esp.setId(Integer.parseInt(linEsport[0]));
				esp.setName(linEsport[1]);
				ListEsport.add(esp);
			} else {
				System.out.println("O esporte não se encontra registrado!");
				System.exit(0);
			}
		}

		return ListEsport;
	}

	// Leitura e tratamento de exceção do arquivo selecoes.txt.
	ArrayList<String> readSelecoes() {
		ArrayList<String> archive = new ArrayList<String>();
		try {
			Scanner selecoes = new Scanner(new FileReader("selecoes.txt"));
			// Lendo a primeira linha. Depois disso vou ler linha por linha.
			while (selecoes.hasNextLine()) {
				String linha = selecoes.nextLine();
				archive.add(linha);
			}
			selecoes.close();
		} catch (IOException selecoes) {
			System.err
					.print("Problema na leitura do arquivo selecoes.txt. \nVerifique se o nome está correto ou se o arquivo se encontra no diretório\n");

		}
		return archive;
	}

	ArrayList<Selecao> bankSelecao() {
		ArrayList<Selecao> ListSelec = new ArrayList<Selecao>();

		EntradaESaida file = new EntradaESaida();

		ArrayList<String> lines = new ArrayList<String>();

		lines = file.readSelecoes();

		Iterator<String> singLine = lines.iterator();

		while (singLine.hasNext()) {
			// Quebra o texto em palavras separando por ";"
			String line = singLine.next();

			String linSelec[] = line.split(";");

			Selecao esp = new Selecao();

			// após separar os itens da linha eles são inseridos em um
			// objeto do tipo Selecao
			esp.setId(Integer.parseInt(linSelec[0]));
			esp.setIdEsporte(Integer.parseInt(linSelec[1]));
			esp.setName(linSelec[2]);

			// adiciona o esp no Arraylist
			ListSelec.add(esp);
		}

		return ListSelec;
	}

	// Leitura e tratamento de exceção do arquivo atletas.txt.
	ArrayList<String> readAthletes() {
		ArrayList<String> archive = new ArrayList<String>();
		try {
			Scanner athletes = new Scanner(new FileReader("atletas.txt"));
			while (athletes.hasNextLine()) {
				String linha = athletes.nextLine();
				archive.add(linha);
			}
			athletes.close();
		} catch (IOException athletes) {
			System.err
					.print("Problema na leitura do arquivo atletas.txt. \nVerifique se o nome está correto ou se o arquivo se encontra no diretório\n");
		}
		return archive;
	}

	ArrayList<Atletas> bankAthletes() {
		ArrayList<Atletas> ListAthletes = new ArrayList<Atletas>();

		EntradaESaida file = new EntradaESaida();

		ArrayList<String> lines = new ArrayList<String>();

		lines = file.readAthletes();

		Iterator<String> singLine = lines.iterator();

		while (singLine.hasNext()) {
			// Quebra o texto em palavras separando por ";"
			String line = singLine.next();

			String linAthlet[] = line.split(";");

			Atletas atl = new Atletas();

			// após separar os itens da linha eles são inseridos em um
			// objeto do tipo Atleta
			atl.setId(Integer.parseInt(linAthlet[0]));
			atl.setIdSelecao(Integer.parseInt(linAthlet[1]));
			atl.setName(linAthlet[2]);

			// adiciona o esp no Arraylist
			ListAthletes.add(atl);
		}

		return ListAthletes;
	}

	// Leitura e tratamento de exceção do arquivo partidas.txt.
	ArrayList<String> readGames() {
		ArrayList<String> archive = new ArrayList<String>();
		try {
			Scanner games = new Scanner(new FileReader("partidas.txt"));
			while (games.hasNextLine()) {
				String linha = games.nextLine();
				archive.add(linha);
			}
			games.close();
		} catch (IOException games) {
			System.err
					.print("Problema na leitura do arquivo partidas.txt. \nVerifique se o nome está correto ou se o arquivo se encontra no diretório\n");
		}
		return archive;
	}

	ArrayList<Partida> bankGames() {
		ArrayList<Partida> ListGame = new ArrayList<Partida>();

		EntradaESaida file = new EntradaESaida();

		ArrayList<String> lines = new ArrayList<String>();

		lines = file.readGames();

		Iterator<String> singLine = lines.iterator();

		while (singLine.hasNext()) {
			// Quebra o texto em palavras separando por ";"
			String line = singLine.next();

			String linGame[] = line.split(";");

			Partida gam = new Partida();

			// após separar os itens da linha eles são inseridos em um
			// objeto do tipo Partida
			gam.setGame(Integer.parseInt(linGame[0]),
					Integer.parseInt(linGame[1]), Integer.parseInt(linGame[2]),
					Integer.parseInt(linGame[3]), Integer.parseInt(linGame[4]));

			// adiciona o esp no Arraylist
			ListGame.add(gam);
		}

		return ListGame;
	}

	// Leitura e tratamento de exceção do arquivo estatisticas.txt.
	ArrayList<String> readStatistics() {
		ArrayList<String> archive = new ArrayList<String>();
		try {
			Scanner statistics = new Scanner(new FileReader("estatisticas.txt"));
			// Lendo a primeira linha. Depois disso vou ler linha por linha.
			while (statistics.hasNextLine()) {
				String linha = statistics.nextLine();
				archive.add(linha);
			}
			statistics.close();
		} catch (IOException statistics) {
			System.err
					.print("Problema na leitura do arquivo estatisticas.txt. \nVerifique se o nome está correto ou se o arquivo se encontra no diretório\n");
		}
		return archive;
	}

	ArrayList<Integer[]> bankStatistics() {
		ArrayList<Integer[]> ListStatistics = new ArrayList<Integer[]>();

		EntradaESaida file = new EntradaESaida();

		ArrayList<String> lines = new ArrayList<String>();

		lines = file.readStatistics();

		Iterator<String> singLine = lines.iterator();

		while (singLine.hasNext()) {
			// Quebra o texto em palavras separando por ";"
			Integer[] statist = new Integer[2];
			String line = singLine.next();

			String linStatist[] = line.split(";");
			statist[0] = Integer.parseInt(linStatist[0]);
			statist[1] = Integer.parseInt(linStatist[1]);

			// adiciona o esp no Arraylist
			ListStatistics.add(statist);
		}

		return ListStatistics;
	}

	// retorna o nome de uma seleção a partir de um id e iterando dentro do
	// ArrayList de seleção
	public String nomeSelec(ArrayList<Selecao> sel, int idSel)
			throws FileNotFoundException {
		Iterator<Selecao> SelSaida = sel.iterator();
		while (SelSaida.hasNext()) {
			Selecao selecao = (Selecao) SelSaida.next();
			if (idSel == selecao.getId()) {
				return selecao.getName();
			}
		}
		return "Não há seleção para este id";
	}

	// Este método retorna a saida da estatistica do tipo 1-1 referente aos
	// esportes

	public void saidaEstatistica1(ArrayList<Esporte> esp, int idEsporte)
			throws FileNotFoundException {
		int tem = 0;
		PrintStream saida = new PrintStream("estatistica-1-1.txt");
		Iterator<Esporte> espSaida = esp.iterator();

		while (espSaida.hasNext()) {
			Esporte esporte = (Esporte) espSaida.next();
			if (idEsporte == esporte.getId()) {
				tem = 1;
				saida.println(esporte.getName());
				saida.println("Times	V	E	D");
				Iterator<Selecao> selSaida = esporte.getSelecao().iterator();
				while (selSaida.hasNext()) {
					Selecao selecao = (Selecao) selSaida.next();
					saida.println(selecao.getName() + "	"
							+ selecao.getVitorias() + "	"
							+ selecao.getEmpates() + "	"
							+ selecao.getDerrotas());
				}
			}
			// trata o caso em que não há um
			if (tem != 1) {
				tem = 0;
				System.out
						.println("Id de Seleção não encontrado, esporte não participou de partida");
			}
		}
		saida.close();
	}

	// Este método retorna a saida da estatistica do tipo 2-1 referente as
	// seleções
	public void saidaEstatistica2(ArrayList<Esporte> esp, int idSelecao)
			throws FileNotFoundException {
		int tem = 0;
		PrintStream saida = new PrintStream("estatistica-2-1.txt");
		Iterator<Esporte> espSaida = esp.iterator();
		while (espSaida.hasNext()) {
			Esporte esporte = (Esporte) espSaida.next();
			Iterator<Selecao> selSaida = esporte.getSelecao().iterator();
			while (selSaida.hasNext()) {
				Selecao selecao = (Selecao) selSaida.next();
				if (idSelecao == selecao.getId()) {
					saida.println(selecao.getName() + "-" + esporte.getName());
					Iterator<Atletas> atlSaida = selecao.getAtletas()
							.iterator();
					saida.println("Atletas");
					while (atlSaida.hasNext()) {
						Atletas atletas = (Atletas) atlSaida.next();
						saida.println(atletas.getName());
						Iterator<Partida> parSaida = selecao.getPartida()
								.iterator();

						if (!atlSaida.hasNext()) {
							saida.println("Adversários		Placar");
							while (parSaida.hasNext()) {
								Partida partida = (Partida) parSaida.next();
								if (idSelecao == partida.getIdA()) {
									tem = 1;
									saida.println(nomeSelec(
											esporte.getSelecao(),
											partida.getIdB())
											+ "		"
											+ partida.getPlacarSelA()
											+ "x" + partida.getPlacarSelB());
								} else if (idSelecao == partida.getIdB()) {
									tem = 1;
									saida.println(nomeSelec(
											esporte.getSelecao(),
											partida.getIdB())
											+ "		"
											+ partida.getPlacarSelB()
											+ "x" + partida.getPlacarSelA());
								}
							}
						}
					}
				}
			}
		}
		// trata o caso em que não há um
		if (tem != 1) {
			tem = 0;
			System.out
					.println("Id de Seleção não encontrado, esporte não participou de partida");
		}
		saida.close();
	}
}