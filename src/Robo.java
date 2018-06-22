
public class Robo {

private int fitness;
private char genes [];
private int trajeto[];

	
	
	
	public Robo(char genes[]) {
		this.genes = genes;
		
	}





public int[] percorrer(int[]inicio) {
	this.trajeto = inicio;
	for(int i = 0; i< genes.length;i++) {
		char aux = genes[i];
		 switch(aux) {
		 
		 case 'C':
			 trajeto[0]=trajeto[0]-1;
			 break;
		
		 case 'B':
			 trajeto[0]=trajeto[0]+1;
			 break;
		 
		 case 'D':
			 trajeto[1]=trajeto[1]+1;
			 break;
		
		 case 'E':
			 trajeto[1]=trajeto[1]-1;
			 break;
		 
		 }
	}
	return trajeto;
}







}
