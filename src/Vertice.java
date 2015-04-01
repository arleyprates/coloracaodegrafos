import java.util.ArrayList;


public class Vertice {
	
	private String nome;
	private ArrayList<Vertice> adjacencia;
	private Cor cor;
	
	public Vertice() {
		nome = "";
		adjacencia = new ArrayList<Vertice>();
		cor = null;
	}
	
	public Vertice(char n) {
		nome = "" + n;
		adjacencia = new ArrayList<Vertice>();
		cor = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Vertice> getAdjacencia() {
		return adjacencia;
	}

	public void setAdjacencia(ArrayList<Vertice> adjacencia) {
		this.adjacencia = adjacencia;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void addAdjacencia(Vertice v) {
		adjacencia.add(v);
	}
	
	public int getgrau() {
		return (adjacencia.size());
	}

	public boolean colorido() {
		// TODO Auto-generated method stub
		return false;
	}
}
