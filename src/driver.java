import javax.swing.JOptionPane;


public class driver {
	
	int generationNo=0,maxGeneration=100;
	Scheduler solution;
	
	public driver(data d){
		GeneticAlgorithm g = new GeneticAlgorithm(d);
		//g.display();
		
		System.out.println("*************\n" +g.population.get(0).fitness/100000);
		
		while( (g.population.get(0).fitness < (float)100000.0 ) && generationNo<=maxGeneration){
			generationNo++;
			System.out.println("Generation: " + generationNo);
			g.population = g.evolve(g.population);
			g.display();
			System.out.println("*************\n" +g.population.get(0).fitness);
		}
		if(generationNo <= maxGeneration){
			JOptionPane.showMessageDialog(null, "Successfully made timetable");
			this.solution= g.population.get(0);
			Login.timetableMade=1;
			Login.sessionSolution= solution; 
			//new timetableSelector(solution);
		}
		
	}

}
