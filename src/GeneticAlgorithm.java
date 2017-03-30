import java.util.Vector;
public class GeneticAlgorithm {
	
	Vector<Scheduler> population;
	final int populationSize=10;
	
	public GeneticAlgorithm(data d){
		population = new Vector<Scheduler>();
		for(int i=0; i<populationSize; ++i){ 
			population.add(new Scheduler(d));
		}
		
		for(int i=0; i<populationSize;++i){
			for(int j=0; j<population.get(i).map.length;++j){
				System.out.println(population.get(i).map[j]);
			}
			System.out.println();
			
		}
	}
	
}
