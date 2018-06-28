import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Robo {

private int fitness;
private char genes [];
private int trajeto_final[];
private ArrayList trajeto;
private final int MELHOR_trajeto_final= 60;
private final int CHEGAR_NO_FINAL= 100;
private final int PAREDE= -50;
private boolean acertou = false;
private boolean gastoumenos = false;
private int parede = 0;
private int gasto = 0;
private char comandos [] = {'C','B','E','D'};

private int [] tabela_pontos = {25,15,10,5,1};


	
	
	
	public void setParede() {
	this.parede++ ;
}

	public void setMenorGasto(boolean gasto,int i) {
		this.gastoumenos = gasto;
		this.gasto = tabela_pontos[i];
	}





	public Robo(char genes[],int[] pontoInicial) {
		this.genes = genes;
		trajeto =  new ArrayList();
		this.trajeto_final = pontoInicial;
		
	}





public int[] percorrer() {
	
	for(int i = 0; i< genes.length;i++) {
		char aux = genes[i];
		 switch(aux) {
		 
		 case 'C':
			 trajeto_final[0]=trajeto_final[0]-1;
			 trajeto.add(trajeto_final);
			 break;
		
		 case 'B':
			 trajeto_final[0]=trajeto_final[0]+1;
			 trajeto.add(trajeto_final);

			 break;
		 
		 case 'D':
			 trajeto_final[1]=trajeto_final[1]+1;
			 trajeto.add(trajeto_final);

			 break;
		
		 case 'E':
			 trajeto_final[1]=trajeto_final[1]-1;
			 trajeto.add(trajeto_final);

			 break;
		 
		 }
	}
	return trajeto_final;
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

public int avaliarTrajeto(int [] correto) {
	if(this.acertou == true) {
		return CHEGAR_NO_FINAL;
	}
	int caminhoY = trajeto_final[0]- correto [0];
	int caminhoX = trajeto_final[1] - correto[1];
	int dist = caminhoY + caminhoX;
	
	return dist;
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
		int posicao = gerador.nextInt(getEnergia()-1);
		int comando =gerador.nextInt(comandos.length-1);
		genes[posicao] = comandos[comando];  
	}
	
	
}

public void diminuirGene(int taxa_mt) {
	Random gerador = new Random();
	int posicao = gerador.nextInt(getEnergia()-1);
	
	char aux[] = new char[genes.length- taxa_mt];
	
	genes[posicao] = 's';
	for(int i =0; i<genes.length-taxa_mt;i++) {
	  
		if(genes[i]!= 's') {
	    	
			aux [i] = genes[i];	

	    }
		
	}
	
	genes = aux;
	
}

public void aumentarGene(int taxa_mt) {
	Random gerador = new Random();
	int posicao = gerador.nextInt(getEnergia()-1);
	int comando =gerador.nextInt(comandos.length-1);
	char aux[] = new char[genes.length + taxa_mt];
	
	//genes[posicao] = 's';
	
	
	for(int j = 0; j<taxa_mt ; j++) {
		
	
	for(int i =0; i<posicao;i++) {
	      	
		aux [i] = genes[i];	

	    
		
	}
	
	for(int i =posicao; i<genes.length + taxa_mt;i++) {
      	
		aux [i+1] = genes[i];	

	    
		
	}
	
	aux[posicao] = comandos[comando];
	}
	
	genes = aux;
}



}
