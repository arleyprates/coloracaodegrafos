
public class Aresta {
	
	private String nome;
	private Vertice vorigem;
	private Vertice vdestino;
	
	public Aresta(String n, Vertice o, Vertice d) {
		nome = n;
		vorigem = o;
		vdestino = d;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vertice getVorigem() {
		return vorigem;
	}

	public void setVorigem(Vertice vorigem) {
		this.vorigem = vorigem;
	}

	public Vertice getVdestino() {
		return vdestino;
	}

	public void setVdestino(Vertice vdestino) {
		this.vdestino = vdestino;
	}	

}
