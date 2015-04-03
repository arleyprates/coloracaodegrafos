import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ColoracaoGrafos {

	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	private ArrayList<Cor> cores;
	private ArrayList<Vertice> adjacentes;
	private ArrayList<Vertice> q;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColoracaoGrafos coloracao = new ColoracaoGrafos();
		coloracao.start();
	}
	
	public void start() {
	
		vertices = new ArrayList<Vertice>();
		
		q = new ArrayList<Vertice>();
		
		adjacentes = new ArrayList<Vertice>();
		
		arestas = new ArrayList<Aresta>();
		
		cores = new ArrayList<Cor>();
		
		//definindo vertices e quantidade
		char v1 = 'A';
		char v2 = 'B';
		char v3 = 'C';
		char v4 = 'D';
		char v5 = 'E';
		
		//instancia vertice, add seus adjacentes e add vertice na lista vertices 
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
		
		ad = new Vertice(v1);
		adjacentes.add(ad);
		ad = new Vertice(v2);
		adjacentes.add(ad);
		ad = new Vertice(v5);
		adjacentes.add(ad);
		v = new Vertice(v4);
		v.setAdjacencia(adjacentes);
		vertices.add(v);
		
		v = new Vertice(v5);
		vertices.add(v);
		
		//definindo nome arestas e quantidades
		String a1 = "AB";
		String a2 = "AC";
		String a3 = "CD";
		String a4 = "DB";
		String a5 = "DE";
		String a6 = "DA";		
		
		//instancia aresta, add o nome, o vertice origem, o vertice destino e add aresta na lista arestas
		Aresta e = new Aresta(a1, vertices.get(0), vertices.get(1));		
		arestas.add(e);
		
		e = new Aresta(a2, vertices.get(0), vertices.get(2));		
		arestas.add(e);
		
		e = new Aresta(a3, vertices.get(2), vertices.get(3));		
		arestas.add(e);
		
		e = new Aresta(a4, vertices.get(3), vertices.get(1));		
		arestas.add(e);
		
		e = new Aresta(a5, vertices.get(3), vertices.get(0));		
		arestas.add(e);
		
		e = new Aresta(a6, vertices.get(3), vertices.get(4));		
		arestas.add(e);

		//intera na lista de vertices
		System.out.print("V: { ");
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() + " ");
		}
		System.out.println("}");
		
		//interca na lista de arestas
		System.out.print("E: {");
		for (Aresta aresta : arestas) {
			System.out.print(aresta.getNome() + " ");
		}
		System.out.println("}");
		
		//intera na lista de vertices, imprimi o vertice, seus adjacentes e o grau
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
		
		//ordenar a vertices pelo grau		
		Collections.sort(vertices, new CompareVerticeAdjacentes());
		
		//intera na lista de vertices ordanada
		System.out.print("VO: { ");
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() + " ");
		}
		System.out.println("}");
		
		//instancia lista cores
		populacores();
		
		/*for (Cor c : cores) {
			System.out.println(c.getCor());
		}*/
				
		//pegar o vertice de maior grau e colori
		for (Vertice vi : vertices) {
			Colore_Vertice(vi);				
		}
		
		//intera na lista de vertices
		System.out.print("V: { ");
		for (Vertice vertice : vertices) {
			System.out.print(vertice.getNome() + " " + vertice.getCor().getCor() + "-");
			for (Vertice ad1 : vertice.getAdjacencia()) {
				System.out.println(ad1.getCor().getCor() + "- ");
			}
		}
		System.out.println("}");
	}
	
	private void populacores() {
		// TODO Auto-generated method stub
		cores.clear();
		cores.add(new Cor("#ff0000", "#ffffff"));
		cores.add(new Cor("#ff00ff", "#000000"));
		cores.add(new Cor("#0000ff", "#ffffff"));
		cores.add(new Cor("#00ffff", "#000000"));
		cores.add(new Cor("#ffff00", "#000000"));
		cores.add(new Cor("#000000", "#ffffff"));
	}

	private void Colore_Vertice(Vertice vk) {
		//vertice de maior grau n eh colorido?
		if (!vk.colorido()) {
			//intera lista de cores
			for (Cor cor : cores) {
				boolean podeusar = true;
				//intera nos adjacentes de vk
				for (Vertice vj : vk.getAdjacencia()) {
					//adjacente de vk tem cor?
					if (vj.colorido()) {
						//cor de vj eh igual a cor atual da lista
						if (vj.getCor().equals(cor)){
							podeusar = false;
							//adjacente de cor igual. intera!
							break;
						}
					}
				}
				//adjacente sem cor, atribua cor
				if (podeusar) {
					vk.setCor(cor);
					break;
				}
			}
			//ultimo adjacente sem cor
			for (Vertice vj : vk.getAdjacencia()) {
				Colore_Vertice(vj);
			}
		}
	}

	private class CompareVerticeAdjacentes implements Comparator {
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Vertice v1 = (Vertice) o1;
			Vertice v2 = (Vertice) o2;
			
			if (v1.getgrau() < v2.getgrau()) {
				 return 1;
			} else if (v1.getgrau() > v2.getgrau()) {
				return -1;
			}			
			return 0;
		}
		
	}
}
