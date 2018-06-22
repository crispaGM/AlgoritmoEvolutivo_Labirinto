import java.lang.reflect.Array;
import java.util.ArrayList;

public class Geracao {
    
	private ArrayList populacao = new ArrayList();
	private ArrayList melhores = new ArrayList();
	private int pontoFinal [] = new int[2];
	private int pontoInicial [] = new int[2];

	public Geracao(char[][] labirinto) {
		pontos(labirinto);
	
	}
	
	 
	public ArrayList getPopulacao() {
		return populacao;
	}


	public void setPopulacao(ArrayList populacao) {
		this.populacao = populacao;
	}


	public int[] getPontoFinal() {
		return pontoFinal;
	}

	public int[] getPontoInicial() {
		return pontoInicial;
	}

	public void pontos(char[][]labirinto) {
		for(int i =0; i<10; i ++) {
			
			
			for(int j = 0; j<15; j++) {
				
				char aux = labirinto[i][j];
				if(aux == 'F') {
					this.pontoFinal[0]= i+1;
					this.pontoFinal[1]= j+1;
				}
				else if(aux == 'I') {
					this.pontoInicial[0]= i+1;
					this.pontoInicial[1]= j+1;
				}
				
			}
			
			
		}
	}
	
	
	
	public ArrayList selecao() {
		
		for(int i =0; i<populacao.size();i++) {
			Robo aux = (Robo) populacao.get(i);
			
		    calcularFitness(aux.percorrer(pontoInicial));	
		
		   // calcularFitness de todos e salvar em "melhores" somente os 10 com maior fitness;
		}
	
	   return melhores; 
	
	
	}
	
	
	public void calcularFitness(int [] trajeto) {
		
		
		
	}
	
}
