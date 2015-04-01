import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;


public class Desenha {
	
	ArrayList<Vertice> vertices;
	ArrayList<Aresta> arestas;
	ArrayList<Cor> cores;
	
	public static void main(String[] args) {
		Desenha p = new Desenha();
		p.start();
	}
	
	private void start() {
		
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();
		cores = new ArrayList<Cor>();
		
		//pede o numero de vertices e popula lista de vertices
		int qvertices;
		qvertices = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de vertices"));
		int c;
		
		for (int i = 0; i < qvertices; i++) {
			c = 65 + i;
			char ca = (char)c;
			vertices.add(new Vertice(ca));
		}
		
		// pede as arestas com as regras de valores invalidos
		c = 65 + vertices.size() - 1;
		char ultimo = (char) c;
		
		String a, atemp;
		
		a = "";
		
		boolean valido = true;
		
		do {
			valido = true;
			a = JOptionPane.showInputDialog(null, "Defina as arestas dos Vertices A...." + ultimo +" searando por virul ex AB, AC, EA" + a);
			a = a.toUpperCase();
			a = a.replace(" ", "");
			a = a.replace(";", ",");
			a = a.replace(".", ",");
			
			if (a.substring(0, 1).equals(",")) {
				a = a.substring(1);
			}
			
			if (a.substring(0,  a.length() - 1).equals(",")) {
				a = a.substring(0,  a.length() - 1);
			}
			
			atemp = a.replace(",", "");
			
			char cv[] = atemp.toCharArray();
			
			for (char d : cv) {
				if (d > ultimo) {
					JOptionPane.showMessageDialog(null, "Vertice " + d + " invalido.");
					valido = false;
				}
			}
			
			atemp = a;
			
			do {
				String av = "";
				if (atemp.indexOf(",") > -1) {
					av = atemp.substring(0, atemp.indexOf(","));
					atemp = atemp.substring(atemp.indexOf(",") + 1);
				} else {
					av = atemp;
					atemp = "";
				}
				
				if (av.length() > 2) {
					JOptionPane.showMessageDialog(null, "arestas sao definidas de um vertice");
					valido = false;					
				}
			} while (atemp.length() > 0);
			
		} while (!valido);
		
		// popula a lista de arestas 
		atemp = a;
		
		do {
			String av = "";
			
			if (atemp.indexOf(",") > -1) {
				av = atemp.substring(0, atemp.indexOf(","));
				atemp = atemp.substring(atemp.indexOf(",") + 1);
			} else {
				av = atemp;
				atemp = "";
			}
			
			arestas.add(new Aresta( buscavertice (av.substring(0, 1)), buscavertice(av.substring(0,0)), buscavertice(av.substring(0, 1)) ));
			
		} while (atemp.length() > 0);
		
		//Collections.sort (vertices, new ComparatorVertices(false));
		
		populacores();
		
		for (Vertice vi : vertices) {
			
			Colore_Vertice(vi);
			
		}
		
		printgrafo(false);
		
		printgrafo(true);
		
		JOptionPane.showMessageDialog(null, "Seus grafos foram criados nos arquivos");
		
	}
	
	private Vertice buscavertice(String n) {
		
		Vertice retorno;
		retorno = null;
		
		for (Vertice v : vertices) {
			if (v.getNome().equals(n)) {
				retorno = v;
				break;
			}
		}
		return (retorno);
	}
	
	private void populacores() {
		cores.clear();
		cores.add(new Cor("#ff0000", "#ffffff"));
		cores.add(new Cor("#ff00ff", "#000000"));
		cores.add(new Cor("#0000ff", "#ffffff"));
		cores.add(new Cor("#00ffff", "#000000"));
		cores.add(new Cor("#ffff00", "#000000"));
		cores.add(new Cor("#000000", "#ffffff"));
	}
	
	private void Colore_Vertice(Vertice vk) {
		
		Cor c;
		c = null;
		if (!vk.colorido()) {
			for (Cor cc : cores) {
				boolean podeusarcor;
				podeusarcor = true;
				for (Vertice vj : vk.getAdjacencia()) {
					if (vj.colorido()) {
						if (vj.getCor().equals(cc)) {
							podeusarcor = false;
							break;
						}
					}
				}
				if (podeusarcor) {
					c = cc;
					break;
				}
			}
			
			vk.setCor(c);
			for (Vertice vj : vk.getAdjacencia()) {
				Colore_Vertice(vj);
			}
		}
	}
	
	private void printgrafo(boolean colorido) {
		String saida;
		
		if (colorido) {
			saida = "colorido.gif";
		} else {
			saida = "original.gif";
		}
		
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		
		for (Vertice v : vertices) {
			if (colorido) {
				gv.addln(v.getNome() + " [ color=\"" + v.getCor().getCor()+"\", font");
			} else {
				gv.addln(v.getNome()+";");
			}
		}
		
		for (Aresta aa : arestas) {
			gv.addln(aa.getVorigem().getNome() + " -> " + aa.getVdestino().getNome());
		}
	}
	/*
	class ComparatorVertices implements Comparator {
		boolean crescente = true;
		
		public ComparatorVertices(boolean crescente) {
			this.crescente = crescente;
		}
		
		public int compare(Object o1, Object o2) {
			Vertice p1 = (Vertice) o1;
			Vertice p2 = (Vertice) o2;
			if (crescente) {
				return p1.getgrau() < p2.getgrau() ? -1 : (p1.getgrau() > p2.getgrau());
			} else {
				return p1.getgrau() < p2.getgrau() ? +1 : (p1.getgrau() > p2.getgrau());
			}
		}
	}*/
}
