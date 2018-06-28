import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Principal {
	static Labirinto labirinto = new Labirinto();
	static Geracao nova;
	private static char passos[] = { 'C', 'B', 'E', 'D' };

	public static void main(String[] args) {
		labirinto.carregarLabirinto();

		for(int i = 0; i< 300 ; i++) {
			
			nova = new Geracao(labirinto);
			nova.setPopulacao(populacaoInicial());
			nova.percorrer();
			novaGeracao();
           System.out.println(((Robo) nova.getPopulacao().get(0)).getFitness());
		}
		
	}

	public static ArrayList populacaoInicial() {
		ArrayList inicial = new ArrayList();
		Random gerador = new Random();
		int cromossomo;

		for (int i = 0; i < 100; i++) {

			cromossomo = gerador.nextInt(50) + 1;
			char genes[] = new char[cromossomo];
			for (int j = 0; j < cromossomo; j++) {
				int aux = gerador.nextInt(4);
				genes[j] = passos[aux];
			}

			Robo novo = new Robo(genes, nova.getPontoInicial());
			inicial.add(novo);

		}
		return inicial;

	}

	public static void mutacao(Robo robo) {
		Random gerador = new Random();
		int tipo = gerador.nextInt(2);
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
		
		
		for(int j =0; j<sobreviventes.size(); j++) {
			Robo pai = (Robo)sobreviventes.get(j);
			for(int i =0 ; i< 9; i++) {
				Robo filho = new Robo(pai.getGenes(), nova.getPontoInicial());
				mutacao(filho);
				filhos.add(filho);
				}
		}
		
		sobreviventes.addAll(filhos);
		
		nova.setPopulacao(sobreviventes);
		
	}
	
	
}
