import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {
   private int qtd = 0;
   private  List<char[][]> labirintos = new ArrayList<char[][]>();
   private char labirintoaux[][] = new char[10][15];
	
	
	public Labirinto() {
		
	}
	



   public void carregarLabirinto() {
	   
	  
	   
	    String nome = "C://Users//Crispa//eclipse-workspace//AlgoritmoEvolutivo//src/teste.txt";
	 
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
		    	  
		    	  char auxiliar [][] = labirintoaux;
		    	  labirintos.add(auxiliar);
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

















public List getLabirintos() {
	return labirintos;
}
	   
   }




