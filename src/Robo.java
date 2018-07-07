import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Robo {

private int fitness ;
private char genes [];
private int trajeto_finalY;
private int trajeto_finalX;
private int trajeto_InicialY;
private int trajeto_InicialX;
private int posicao_inicial[];

private ArrayList trajeto;
public int getTrajeto_InicialY() {
	return trajeto_InicialY;
}

public int getTrajeto_InicialX() {
	return trajeto_InicialX;
}

//private final int MELHOR_trajeto_final= 60;
private final int CHEGAR_NO_FINAL= 1000;
private final int PAREDE= -200;
private boolean acertou = false;
private boolean gastoumenos = false;
private int parede = 0;
private int gasto = 0;
private char comandos [] = {'C','B','E','D'};
private boolean morreu;

private int [] tabela_pontos = {25,15,10,5,1};


	
	
	
	public void setParede() {
	this.parede++ ;
}

	public void setMenorGasto(boolean gasto,int i) {
		this.gastoumenos = gasto;
		this.gasto = tabela_pontos[i];
	}





	public Robo(char genes[],int pontoInicialX, int pontoInicialY) {
		this.genes = genes;
		trajeto =  new ArrayList();
		this.trajeto_finalX = pontoInicialX;
		this.trajeto_finalY = pontoInicialY;
		this.trajeto_InicialX = pontoInicialX;
		this.trajeto_InicialY = pontoInicialY;
        this.morreu = false;
		this.fitness = 0;
		gasto = 0;
	}


public boolean isMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

public int [] inicial() {
	return this.posicao_inicial;
}




public void percorrer() {
	
	for(int i = 0; i< genes.length;i++) {
		char aux = genes[i];
		 switch(aux) {
		 
		 case 'C':
			 trajeto_finalY=trajeto_finalY-1;
			 trajeto.add('C');
			 break;
		
		 case 'B':
			 trajeto_finalY=trajeto_finalY+1;
			 trajeto.add('B');


			 break;
		 
		 case 'D':
			 trajeto_finalX=trajeto_finalX+1;
			 trajeto.add('D');

			 break;
		
		 case 'E':
			 trajeto_finalX=trajeto_finalX-1;
			 trajeto.add('E');

			 break;
		 
		 }
	}
}


public ArrayList getTrajeto() {
	return trajeto;
}



public  int punicao() {
	
	return PAREDE * parede;
}
public  int getEnergia() {
	
	return genes.length;
}

public char [] getGenes() {
	return genes;
}

public  boolean getAcertou() {
	
	return acertou;
}

public  int getFitness() {
	
	return fitness;
}
public void calcularFitness(int fitness) {
	
	
	
	
	
  this.fitness = fitness;	
	
}

public int avaliarTrajeto(int corretoX, int corretoY) {
	if(this.acertou == true) {
		return CHEGAR_NO_FINAL;
	}
	int caminhoY ;
	int caminhoX ;
	
	if(trajeto_finalY >= corretoY) {
		 caminhoY = trajeto_finalY- corretoY;
	}
	else {
		 caminhoY = trajeto_finalY- corretoY * -1;

	}
	
	if(trajeto_finalX >= corretoX) {
		 caminhoX = trajeto_finalX- corretoX;
	}
	else {
		 caminhoX = trajeto_finalX- corretoX * -1;

	}
	
	return caminhoY + caminhoX* -1;
}

public void acertou(boolean acertou) {
	this.acertou = acertou;
}


public int getGasto() {
	return gasto;

}

public void alterarGene(int taxa_mt) {
	Random gerador = new Random();
	
	for(int i = 0; i<taxa_mt; i++) {
		int posicao = gerador.nextInt(getEnergia());
		int comando =gerador.nextInt(4);
		this.genes[posicao] = comandos[comando];  
	}
	
	
}

/**
 * @param taxa_mt
 * @return
 */
public void diminuirGene(int taxa_mt) {
	Random gerador = new Random();
	//int posicao = gerador.nextInt(getEnergia()-1)+1;
	int posicao = gerador.nextInt(getEnergia());
	

	
	
	char aux[] = new char[genes.length- taxa_mt];
	
	int j =0;
	for(int k = 0; k<taxa_mt; k++) {
		
		
		for(int i =0; i<genes.length;i++) {
			  
			if(posicao == i && i!= genes.length-1 ) {
				i++;
		  
		  }
			
			

						if(j< genes.length - taxa_mt) {
							aux [j] = genes[i];	

							
						}
						j = j +1 ;
					
						

                        
				    
				
			
		   
			
		}
		
		j = 0;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	genes = aux;
	
}

public void setGenes(char[] genes) {
	this.genes = genes.clone();
}

public void aumentarGene(int taxa_mt) {
	Random gerador = new Random();
	int posicao = 0;
	int comando = 0;
	char aux[] = new char[genes.length + taxa_mt];
	
	//genes[posicao] = 's';
	
	
	for(int j = 0; j<taxa_mt ; j++) {
		posicao = gerador.nextInt(getEnergia()-1);
		comando =gerador.nextInt(comandos.length-1);

	   
	for(int i =0; i<posicao;i++) {
	      	
		aux [i] = genes[i];	

	    
		
	}
	
	for(int i =posicao; i<genes.length;i++) {
      	
		aux [i+1] = genes[i];	

	    
		
	}
	
	aux[posicao] = comandos[comando];
	}
	
	genes = aux;
}

public int getTrajeto_finalX() {
	// TODO Auto-generated method stub
	return trajeto_finalX;
}

public int getTrajeto_finalY() {
	return trajeto_finalY;
	
}



}
