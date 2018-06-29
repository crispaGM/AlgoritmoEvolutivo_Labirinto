import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Principal {
	static Labirinto labirinto = new Labirinto();
	static Geracao nova;
	private static char passos[] = { 'C', 'B', 'E', 'D' };

	public static void main(String[] args) {
		labirinto.carregarLabirinto();
		nova = new Geracao(labirinto);
		nova.setPopulacao(populacaoInicial());
		nova.percorrer();
		labirinto.printar(((Robo) nova.getPopulacao().get(0)));
		for(int i = 0; i< 1; i++) {

				
			nova.setLabirinto(labirinto);

			novaGeracao();
			nova.percorrer();
			labirinto.printar(((Robo) nova.getPopulacao().get(0)));	

			
			
           
		 	//System.out.println(((Robo) nova.getPopulacao().get(0)).getTrajeto_final()[0]);
			//System.out.println(((Robo) nova.getPopulacao().get(0)).getTrajeto_final()[1]);
			ArrayList sim = ((((Robo) nova.getPopulacao().get(0)).getTrajeto()));
			//System.out.println(sim.size());

//			for(int p = 0; p<sim.size();p++ ) {
//				char k = (char) sim.get(p);
//				System.out.println(k);
//			}
			//System.out.println(((Robo) nova.getPopulacao().get(0)).getGenes());
			//System.out.println(((Robo) nova.getPopulacao().get(0)).getEnergia());



			//System.out.println(((Robo) nova.getPopulacao().get(0)).inicial()[0]);
			





			//System.out.println(((Robo) nova.getPopulacao().get(0)).getFitness());
		}
		
	}

	public static ArrayList populacaoInicial() {
		ArrayList inicial = new ArrayList();
		Random gerador = new Random();
		int cromossomo;
		char geneCerto [] = {'B','D','D','D','D'};
		Robo certo = new Robo(geneCerto,1,1);
        inicial.add(certo);
		for (int i = 1; i < 1; i++) {

			cromossomo = gerador.nextInt(10) + 1;
			char genes[] = new char[cromossomo];
			for (int j = 0; j < cromossomo; j++) {
				int aux = gerador.nextInt(4);
				genes[j] = passos[aux];
			}
               
			

			Robo novo = new Robo(genes,nova.getPontoInicialX(),nova.getPontoInicialY());
			inicial.add(novo);

		}
		return inicial;

	}

	public static void mutacao(Robo robo) {
		Random gerador = new Random();
		//int tipo = gerador.nextInt(3);
		int tipo=2;
		int taxa_mt = (int) Math.round((0.1 * robo.getEnergia()));
		
        switch (tipo) {

		case 0:
            robo.alterarGene(taxa_mt);
			break;

		case 1:
            robo.aumentarGene(taxa_mt);

			break;
		case 2:
            
           robo.diminuirGene(taxa_mt);

			break;

		}

	}

	public void recombinação(Robo[] pais, int i) {
		Random gerador = new Random();
		int pai = gerador.nextInt(1);
		char[] novoGene = new char[i];
		int chave = 0;

		for (int j = 0; j < (novoGene.length / 2); j++) {
			novoGene[j] = pais[pai].getGenes()[j];

		}
		for (int j = novoGene.length / 2; j < (novoGene.length); j++) {
			if (pai == 1) {
				pai = 0;
			} else if (pai == 0) {
				pai = 1;
			}
			novoGene[j] = pais[pai].getGenes()[j];

		}

	}

	public static void novaGeracao() {
		ArrayList sobreviventes = nova.sobreviventes();
		ArrayList filhos = new ArrayList();
		Robo pai = (Robo) sobreviventes.get(0);
		System.out.println(pai.getGenes());
		System.out.println("desgraça");
	    char []	gene = {'B','D','D','D','D'};

		
		for(int i =0 ; i< 30; i++) {

			Robo filho = new Robo(gene,nova.getPontoInicialX(),nova.getPontoInicialY());
			System.out.println(gene);

			

			mutacao(filho);
			System.out.print("FILHO:");
			System.out.println(filho.getGenes());
			System.out.println("desgraça5");
			filhos.add(filho);
		}
	


		for(int j =1; j<7; j++) {
			Robo pai2 = (Robo)sobreviventes.get(j);
			for(int i =0 ; i< 10; i++) {
				
				Robo filho = new Robo(pai2.getGenes(),nova.getPontoInicialX(),nova.getPontoInicialY());
			

				mutacao(filho);
				filhos.add(filho);
				}
		}
		
		sobreviventes.addAll(filhos);
		nova.setPopulacao(sobreviventes);
		
	}
	
	
}
