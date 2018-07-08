import java.util.ArrayList;
import java.util.Iterator;

public class Geracao {
    
	private ArrayList populacao = new ArrayList();
	private ArrayList melhores = new ArrayList();
//	private int pontoFinal [] = new int[2];
//	private int pontoInicial [] = new int[2];
	int pontoFinalX = 13;
	int pontoFinalY = 1;
	int pontoInicialX = 1;
	int pontoInicialY = 1;
	Labirinto labirinto;
	boolean solucao = false;


	public Geracao(Labirinto labirinto) {
		
	    
		//pontos(labirinto.getLabirintoaux());
	    this.labirinto =labirinto;
	}
	
	 
	public ArrayList getPopulacao() {
		return populacao;
	}


	public void setPopulacao(ArrayList populacao) {
		this.populacao = populacao;
	}


//	public int[] getPontoFinal() {
//		return pontoFinal;
//	}
//
//	public int[] getPontoInicial() {
//		return pontoInicial;
//	}
//
//	public void pontos(char[][]labirinto) {
//		for(int i =0; i<10; i ++) {
//			
//			
//			for(int j = 0; j<15; j++) {
//				
//				char aux = labirinto[i][j];
//				if(aux == 'F') {
//					this.pontoFinal[0]= i;
//					this.pontoFinal[1]= j;
//				}
//				else if(aux == 'I') {
//					this.pontoInicial[0]= i;
//					this.pontoInicial[1]= j;
//				}
//				
//			}
//			
//			
//		}
//	}
	
	
	
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
		if(solucao == false) {
			solucao = labirinto.percorrer(aux);	

		}
		 
		else {
			labirinto.percorrer(aux);	

		}
		
		}
		menorEnergia();
		calcularFitness();
		
	}
	
	public boolean isSolucao() {
		return solucao;
	}


	public void menorEnergia() {
		ArrayList auxiliar= new ArrayList();
        Robo aux;
        Robo escolhido = null;
        int maisenergia = 0;
        int contador = 0;
		for(int i =0; i< populacao.size();i++) {
			Iterator it = populacao.iterator();

			while(it.hasNext()) {
	    		int menor = 99999;
	        	aux = (Robo) it.next();	
	    		
	    		if(aux.getEnergia() < menor && !auxiliar.contains(aux)) {
	    			escolhido = aux;
	    			menor = aux.getEnergia();
	    			
	    		}
			
			
		}
			
			
			
		}
        
		auxiliar.add(escolhido);
		
		
		for(int i = 0; i< auxiliar.size();i++) {
			 if(i> 0 && i<10) {
				 
					((Robo) auxiliar.get(i)).setMenorGasto(false,1);

			 }
			 
			 
			 else if(i> 10 && i<30) {
				 ((Robo) auxiliar.get(i)).setMenorGasto(false,2);
				}
				
				else if(i> 30 && i<60) {
					((Robo) auxiliar.get(i)).setMenorGasto(false,3);
				}
				
				else if(i> 60 && i<99) {
					((Robo) auxiliar.get(i)).setMenorGasto(false,4);
				}
			 
			 
		}
		
		
		
		
		
		
	}
	
	public void calcularFitness() {
		
		Iterator it = populacao.iterator();
        Robo aux;
       
       
        
        
        while(it.hasNext()) {
    		aux = (Robo) it.next();	
    		
    		if(!aux.isMorreu()) {
    			int fitness = aux.avaliarTrajeto(pontoFinalX,pontoFinalY)+ aux.punicao();// + aux.getGasto();
    		    aux.calcularFitness(fitness);
    			
    		}
    		
    		
		
	}
	

 
	
	
}

	 public int getPontoInicialX() {
		return pontoInicialX;
	}


	public int getPontoInicialY() {
		return pontoInicialY;
	}


	public ArrayList<Robo> sobreviventes() {
		 
		Iterator it = populacao.iterator();
	     ArrayList auxiliar = new ArrayList();
		  Robo aux;
		  char gene [] = {'a','a','a','a'};
		  int cont = 0;

		  Robo melhor = new Robo(gene,pontoInicialX, pontoInicialY);
	      int maior = -9999;
		 
	      for(int i = 0; i< 10 ; i++) {
	    	  maior = -9999;
	    	
	      while(it.hasNext()) {
			  aux = (Robo) it.next();
			  if(aux.getFitness() > maior && !auxiliar.contains(aux) && aux.isMorreu() == false ) {
				 
			    
				  melhor = aux;
			      maior = aux.getFitness(); 
			  
			  }
		  
			  // criterio de desempate é o cromossomo com menor passos
			  else if(aux.getFitness() == melhor.getFitness()) { 
				  
				  if(aux.getAcertou() && melhor.getAcertou()) {
				 if(aux.getEnergia()< melhor.getEnergia()) {
					  melhor = aux;
				      maior = aux.getFitness();
				 }
				  
			  }
			  }
			  
//			  else if(aux.getFitness() == maior) {
//			    	 if(aux.getEnergia()< melhor.getEnergia()) {
//			    		 melhor = aux;
//					      maior = aux.getFitness();
//			    	 }
//			     }
			  
			  
	      
	      }
	     
		  if(i ==0) {
			  System.out.println(" O melhor aqui pow : ");

			  System.out.println(melhor.getFitness());
		  }
	      
	      Robo novo = new Robo(melhor.getGenes(),pontoInicialX, pontoInicialY);
	      auxiliar.add(novo);

	    
	      

		  
	      }
	      
	      if(auxiliar.size()< 10) {
	    	  
	    	  System.out.println("Deuuu Ruimmmm");
	    	  for(int i = auxiliar.size(); i<10; i++) {
    			  Robo aux2  = (Robo) populacao.get(i);
                  
	    		  if(auxiliar.contains(aux2)) {
		    		  auxiliar.add(aux2);
	    		  }
	    		  
	    	  }
	      }
	      
	      
				  System.out.println(" Sobreviente melhor  :  " );
				  System.out.println(((Robo) auxiliar.get(0)).getGenes());

	    		  return auxiliar;
	 
	 }


	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	 
	 
	 
	
	
	
	
	

}