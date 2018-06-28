import java.util.ArrayList;
import java.util.Iterator;

public class Geracao {
    
	private ArrayList populacao = new ArrayList();
	private ArrayList melhores = new ArrayList();
	private int pontoFinal [] = new int[2];
	private int pontoInicial [] = new int[2];
	Labirinto labirinto;


	public Geracao(Labirinto labirinto) {
		pontos(labirinto.getLabirintoaux());
	    this.labirinto =labirinto;
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
			
		    
		
		   // calcularFitness de todos e salvar em "melhores" somente os 10 com maior fitness;
		}
	
	   return melhores; 
	
	
	}
	
	
	public void percorrer() {
		Iterator it = populacao.iterator();
        Robo aux;

		String posicao;
		while(it.hasNext()) {
		aux = (Robo) it.next();	
		aux.percorrer();
		labirinto.percorrer(aux);	
		}
		menorEnergia();
		calcularFitness();
		
	}
	
	public void menorEnergia() {
		ArrayList auxiliar= new ArrayList();
		
		Iterator it = populacao.iterator();
        Robo aux;
        Robo escolhido = null;
        int maisenergia = 0;
        int contador = 0;
		for(int i =0; i< populacao.size();i++) {
			
			while(it.hasNext()) {
	    		int menor = 99999;
	        	aux = (Robo) it.next();	
	    		
	    		if(aux.getEnergia() < menor) {
	    			escolhido = aux;
	    			menor = aux.getEnergia();
	    			
	    		}
			
			
		}
			
			if(i == 0) {
				escolhido.setMenorGasto(true,0);
			}
			else if(i> 0 && i<10) {
				escolhido.setMenorGasto(true,1);
			}
			
			else if(i> 10 && i<30) {
				escolhido.setMenorGasto(true,2);
			}
			
			else if(i> 30 && i<60) {
				escolhido.setMenorGasto(true,3);
			}
			
			else if(i> 60 && i<99) {
				escolhido.setMenorGasto(true,4);
			}
			
		}
        
		
		
	}
	
	public void calcularFitness() {
		
		Iterator it = populacao.iterator();
        Robo aux;
       
        
        
        
        while(it.hasNext()) {
    		aux = (Robo) it.next();	
    		
    		int fitness = aux.avaliarTrajeto(pontoFinal)+ aux.punicao() + aux.getGasto();
		    aux.calcularFitness(fitness);
		
	}
	

 
	
	
}

	 public ArrayList<Robo> sobreviventes() {
		  Iterator it = populacao.iterator();
	      ArrayList auxiliar = new ArrayList();
		  Robo aux;
		  Robo melhor;
	      int maior = -9999;
		 
	      for(int i = 0; i< 10 ; i++) {
	    	  
	    	
	      while(it.hasNext()) {
			  aux = (Robo) it.next();
			  if(aux.getFitness() > maior && !auxiliar.contains(aux)) {
				  melhor = aux;
			  }
		  }
		  auxiliar.add(maior);
		  
		  
	      }
	
	   return auxiliar;
	 
	 }
	
	
	
	
	

}