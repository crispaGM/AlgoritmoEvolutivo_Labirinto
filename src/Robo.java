import java.util.ArrayList;

public class Robo {

private int fitness;
private char genes [];
private int trajeto_final[];
private ArrayList trajeto;
private final int MELHOR_trajeto_final= 60;
private final int CHEGAR_NO_FINAL= 100;
private final int PAREDE= -50;
private final int MENOR_GASTO= 30;
private boolean acertou = false;
private int parede = 0;




	
	
	
	public void setParede() {
	this.parede++ ;
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





public int calcularFitness(int [] correto) {
	int fitness = 0;
	int caminhoY = trajeto_final[0]- correto [0];
	int caminhoX = trajeto_final[1] - correto[1];
	
	
	
	
  return 0;	
	
}

public void acertou(boolean acertou) {
	this.acertou = acertou;
}




}
