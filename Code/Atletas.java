import java.util.ArrayList;
import java.util.Iterator;

//A classe Selecao "TEM" Atletas, portanto, Atletas compôe Selecao.
public class Atletas {
	private String name;
	private int id;
	private int idSelecao;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSelecao() {
		return this.idSelecao;
	}

	public void setIdSelecao(int idSel) {
		this.idSelecao = idSel;
	}

	void mostrarAtletas(ArrayList<Atletas> atl) {
		Iterator<Atletas> iatl = atl.iterator();
		while (iatl.hasNext()) {
			Atletas atletas = (Atletas) iatl.next();
			System.out.println(atletas.getName());
		}
	}
}