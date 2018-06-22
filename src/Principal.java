import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {
  static Labirinto labirinto = new Labirinto();
  static Geracao nova;
  private static char passos [] = {'C','B','E','D'};

	public static void main(String[] args) {
		labirinto.carregarLabirinto();
		
			
		
		nova = new Geracao((char[][]) labirinto.getLabirintos().get(0));
		nova.setPopulacao(populacaoInicial());
		
	}




public static ArrayList populacaoInicial() {
    ArrayList inicial = new ArrayList();
    Random gerador = new Random();
    int cromossomo;
    
    for(int i = 0; i<100; i++) {
    	 
    	 cromossomo = gerador.nextInt(100)+1;
    	 char genes[] = new char[cromossomo];
    	 for(int j = 0; j<cromossomo;j++) {
    		 int aux = gerador.nextInt(4);
    		 genes[j]= passos[aux];
    	 }
    	 
    	 Robo novo = new Robo(genes);
    	 inicial.add(novo);
    	 
    	 
    	 
    	 
     }
    return inicial; 

}


}
