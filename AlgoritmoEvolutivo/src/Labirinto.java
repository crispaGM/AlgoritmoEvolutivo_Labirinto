import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Labirinto {
   private int qtd = 0;
  // private  List<char[][]> labirintos = new ArrayList<char[][]>();
   private char labirintoaux[][] = new char[10][15];
	
	
	public char[][] getLabirintoaux() {
	return labirintoaux;
}




	public Labirinto() {
		
	}
	



   public void carregarLabirinto() {
	   
	  
	   
	    String nome = "C://Users//Crispa//eclipse-workspace//AlgoritmoEvolutivo//src/teste1.txt";
	 
	    try {
	      FileReader arq = new FileReader(nome);
	      BufferedReader lerArq = new BufferedReader(arq);
	      int contagem = 0;
	      String linha = lerArq.readLine();
	      int qtdLabirintos = Integer.parseInt(linha);
	        

	      while ((linha = lerArq.readLine()) != null) {
	     
	             
	        contagem++;

	        char aux [] = linha.toCharArray();
	        for(int j =0; j<aux.length;j++) {

		    	  labirintoaux [contagem-1][j] = aux[j];
		    
		      }
		      
		      if(contagem == 10) {
		    	
//		    	  for(int i =0; i<10; i++) {
//		    		 
//		    		  for(int j =0; j<aux.length;j++) {
//		                     
//		  		        
//		    			  System.out.print(labirintoaux[i][j]);
//		  		    		  
//		  			    	
//		  			    
//		  			      }
//	    			  System.out.println(" ");
//
//		    	  }
//		    	  System.out.println(" ");
		    	  
//		    	  char auxiliar [][] = labirintoaux;
//		    	  labirintos.add(auxiliar);
		    	  contagem =0;
		      }
		      
		      
	      
	      }
	 
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	 
	  }








public int getQtd() {
	return qtd;
}



public void percorrer(Robo robo) {
	
ArrayList trajeto = robo.getTrajeto();

Iterator it = trajeto.iterator();
char aux ;
int movimentoX = 1;
int movimentoY =1;





String posicao;
while(it.hasNext()) {
	
	
	
	aux = (char) it.next();
	
	 switch(aux) {
	 
	 case 'C':
		 movimentoY = movimentoY -1;
		 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
				
				
				
				if(labirintoaux [movimentoY][movimentoX] == '#') {
					robo.setParede();
				}
				
				if(labirintoaux [movimentoY][movimentoX] == 'F') {
					robo.acertou(true);
				}
				
			}
			
			else {
				robo.setMorreu(true);
				break;
			}
		 
		 break;
	
	 case 'B':
		 movimentoY = movimentoY +1;
            
		 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
				
				
				
				if(labirintoaux [movimentoY][movimentoX] == '#') {
					robo.setParede();
				}
				
				if(labirintoaux [movimentoY][movimentoX] == 'F') {
					robo.acertou(true);
				}
				
			}
			
			else {
				robo.setMorreu(true);
				break;

			}


		 break;
	 
	 case 'D':
		 movimentoX = movimentoX +1;
        
		 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
				
				
				
				if(labirintoaux [movimentoY][movimentoX] == '#') {
					robo.setParede();
				}
				
				if(labirintoaux [movimentoY][movimentoX] == 'F') {
					robo.acertou(true);
				}
				
			}
			
			else {
				robo.setMorreu(true);
				break;

			}
		 break;
	
	 case 'E':
		 movimentoX = movimentoX -1;

		 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
				
				
				
				if(labirintoaux [movimentoY][movimentoX] == '#') {
					robo.setParede();
				}
				
				if(labirintoaux [movimentoY][movimentoX] == 'F') {
					robo.acertou(true);
				}
				
			}
			
			else {
				robo.setMorreu(true);
				break;

			}
		 
		 break;
	 
	 }
	
	
	
	
	
	
//	if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
//		
//		
//		
//		if(labirintoaux [movimentoY][movimentoX] == '#') {
//			robo.setParede();
//		}
//		
//		if(labirintoaux [movimentoY][movimentoX] == 'F') {
//			robo.acertou(true);
//		}
//		
//	}
//	
//	else {
//		robo.calcularFitness(0);
//	}
	
	
}


	 
	
	
	



	
}


public void printar(Robo robo) {
	ArrayList trajeto = robo.getTrajeto();
	Iterator it = trajeto.iterator();
	char aux ;
	int movimentoX =robo.getTrajeto_InicialX();
	int movimentoY =robo.getTrajeto_InicialY();

char[] [] desenho = labirintoaux.clone();

String posicao;
while(it.hasNext()) {
	
	
	
	aux = (char) it.next();
	
	 switch(aux) {
	 
	 case 'C':
		 movimentoY = movimentoY -1;
		 break;
	
	 case 'B':
		 movimentoY = movimentoY +1;



		 break;
	 
	 case 'D':
		 movimentoX = movimentoX +1;

		 break;
	
	 case 'E':
		 movimentoX = movimentoX -1;

		 break;
	 
	 }
	
	
	 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
			
         desenho[ movimentoY][movimentoX] = 'o';
		
		
		
		
		
	}
	
	
	
	
}


	 for(int i =0; i<10; i++) {
		 
		  for(int j =0; j<15;j++) {
                 
		        
			  System.out.print(desenho[i][j]);
		    		  
			    	
			    
			      }
		  System.out.println(" ");

	  }
	  System.out.println(" ");
	
	
	
	  carregarLabirinto();


	
}





public void printarFinal(Robo robo) {
	char aux ;
	int movimentoX =robo.getTrajeto_finalX();
	int movimentoY =robo.getTrajeto_finalY();

char[] [] desenho = labirintoaux.clone();

String posicao;

	
	 
	
	
	 if(!( movimentoY < 0 || movimentoY>9 || movimentoX < 0 || movimentoX > 14)) {
			
         desenho[ movimentoY][movimentoX] = 'o';
			
	
	
	
	
}


	 for(int i =0; i<10; i++) {
		 
		  for(int j =0; j<15;j++) {
                 
		        
			  System.out.print(desenho[i][j]);
		    		  
			    	
			    
			      }
		  System.out.println(" ");

	  }
	  System.out.println(" ");
	
	
	



	
}








	   
   }




