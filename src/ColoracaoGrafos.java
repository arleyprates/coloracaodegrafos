import java.util.ArrayList;
import java.util.List;


public class ColoracaoGrafos {

	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	private ArrayList<Cor> cores;
	private ArrayList<Vertice> adjacentes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColoracaoGrafos coloracao = new ColoracaoGrafos();
		coloracao.start();
	}
	
	public void start() {
	
		vertices = new ArrayList<Vertice>();
		
		adjacentes = new ArrayList<Vertice>();
		
		arestas = new ArrayList<Aresta>();
		
		cores = new ArrayList<Cor>();
		
		char v1 = 'A';
		char v2 = 'B';
		char v3 = 'C';
		char v4 = 'D';
		
		Vertice v = new Vertice(v1);		
		
		Vertice ad = new Vertice(v2);		
		adjacentes.add(ad);		
		ad = new Vertice(v3);		
		adjacentes.add(ad);		
		v.setAdjacencia(adjacentes);
		vertices.add(v);		
		adjacentes = new ArrayList<Vertice>();
		
		
		v = new Vertice(v2);		
		vertices.add(v);
		
		ad = new Vertice(v4);
		adjacentes.add(ad);
		v = new Vertice(v3);
		v.setAdjacencia(adjacentes);
		vertices.add(v);
		adjacentes = new ArrayList<Vertice>();
		
		ad = new Vertice(v2);
		adjacentes.add(ad);
		v = new Vertice(v4);
		v.setAdjacencia(adjacentes);
		vertices.add(v);
		
		String a1 = "AB";
		String a2 = "AC";
		String a3 = "CD";
		String a4 = "DB";
		
		Aresta e = new Aresta(a1, vertices.get(0), vertices.get(1));		
		arestas.add(e);
		
		e = new Aresta(a2, vertices.get(0), vertices.get(2));		
		arestas.add(e);
		
		e = new Aresta(a3, vertices.get(2), vertices.get(3));		
		arestas.add(e);
		
		e = new Aresta(a4, vertices.get(3), vertices.get(1));		
		arestas.add(e);
		
		System.out.print("V: { ");
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() + " ");
		}
		System.out.println("}");
		
		System.out.print("E: {");
		for (Aresta aresta : arestas) {
			System.out.print(aresta.getNome() + " ");
		}
		System.out.println("}");
		
		System.out.println("LA: {");
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() +" -> ");
			for (Vertice adjacente : vertice.getAdjacencia()) {
					System.out.print(adjacente.getNome() + " ");
			} 
			System.out.print(vertice.getgrau() + " ");
			System.out.println("");
		}
		System.out.println("}");
		
		
		//pegar o vertice de maior grau e colori
	}
}
