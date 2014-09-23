import java.util.ArrayList;
import java.util.Iterator;

//Composição, a classe Esporte "TEM" uma classe seleção. Apenas classes filhas e do pacote poderão acessar Selecao.
public class Selecao {

	private String name;
	private int id;
	private int idEsporte;
	private String NameEsporte;
	private ArrayList<Atletas> atletas = new ArrayList<Atletas>();
	// Uma seleção vai guardar as pasridas que ela jogou.
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	private int vitorias;
	private int empates;
	private int derrotas;

	public void aumentarVitorias() {
		this.vitorias++;
	}

	public void aumentarDerrotas() {
		this.derrotas++;
	}

	public void aumentarEmpates() {
		this.empates++;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public int getIdEsporte() {
		return this.idEsporte;
	}

	public void setNameEsporte(String name) {
		this.NameEsporte = name;
	}

	String getNameEsporte() {
		return this.NameEsporte;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdEsporte(int id) {
		this.idEsporte = id;
	}

	public int getDerrotas() {
		return this.derrotas;
	}

	public int getVitorias() {
		return this.vitorias;
	}

	public int getEmpates() {
		return this.empates;
	}

	public ArrayList<Atletas> getAtletas() {
		return this.atletas;
	}

	void setPartida(Partida part) {
		Partida novo = new Partida();
		// Vou deixar como padrão que o time (A) sempre será a seleção atual do
		// objeto.
		if (part.getIdA() == this.id) {
			novo.setIdTeamA(part.getIdA());
			novo.setPlacarTeamA(part.getPlacarSelA());
			novo.setIdTeamB(part.getIdB());
			novo.setPlacarTeamB(part.getPlacarSelB());
		} else {
			novo.setIdTeamA(part.getIdB());
			novo.setPlacarTeamA(part.getPlacarSelB());
			novo.setIdTeamB(part.getIdA());
			novo.setPlacarTeamB(part.getPlacarSelA());
		}
		this.partidas.add(novo);
	}

	ArrayList<Partida> getPartida() {
		return this.partidas;
	}

	// Inserindo atletas na seleção.
	public void insertAthlete(Atletas atleta) {
		Atletas novo = new Atletas();
		novo.setName(atleta.getName());
		novo.setId(atleta.getId());
		novo.setIdSelecao(this.id);
		this.atletas.add(novo);
	}

	void mostrarSelecao() {
		Iterator<Atletas> iatl = atletas.iterator();
		System.out.println(this.getName());
		while (iatl.hasNext()) {
			Atletas atletas = (Atletas) iatl.next();
			System.out.println(atletas.getName());
		}
	}

	void mostrarTodasSelecoes(ArrayList<Selecao> sel) {
		Iterator<Selecao> isel = sel.iterator();
		while (isel.hasNext()) {
			Selecao selecao = (Selecao) isel.next();
			selecao.mostrarSelecao();
			Iterator<Partida> ipart = selecao.getPartida().iterator();
			System.out.println("Id Selecão Atual: " + selecao.id + " Nome: "
					+ selecao.name + " V: " + selecao.getVitorias() + " D: "
					+ selecao.getDerrotas() + " E: " + selecao.getEmpates());
			while (ipart.hasNext()) {
				Partida partida = (Partida) ipart.next();
				System.out.println("Partidas: IdA: " + partida.getIdA()
						+ " IdB: " + partida.getIdB() + " PlacarA: "
						+ partida.getPlacarSelA() + " Placar: "
						+ partida.getPlacarSelB());

			}
		}
	}
}