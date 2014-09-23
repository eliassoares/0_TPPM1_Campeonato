// Será uma classe para armazenar resultados das partidas de uma determinada seleção
//É uma classe que gera um objeto partida que opera guardando os resultados de uma partida e retornando os valores da partida
public class Partida {

	private int id;
	private int idTeamA;
	private int idTeamB;

	private int placarSelA;
	private int placarSelB;

	public void setId(int ident) {
		this.id = ident;
	}

	// Set game guarda uma instancia de uma partida
	public void setGame(int id, int idA, int idB, int PlacA, int PlacB) {
		this.id = id;
		this.idTeamA = idA;
		this.idTeamB = idB;
		this.placarSelA = PlacA;
		this.placarSelB = PlacB;
	}

	public void setIdTeamA(int idA) {
		this.idTeamA = idA;
	}

	public void setIdTeamB(int idB) {
		this.idTeamB = idB;
	}

	public void setPlacarTeamA(int PlacA) {
		this.placarSelA = PlacA;
	}

	public void setPlacarTeamB(int PlacB) {
		this.placarSelB = PlacB;
	}

	public int getId() {
		return this.id;
	}

	public int getIdA() {
		return this.idTeamA;
	}

	public int getIdB() {
		return this.idTeamB;
	}

	public int getPlacarSelA() {
		return this.placarSelA;
	}

	public int getPlacarSelB() {
		return this.placarSelB;
	}

}