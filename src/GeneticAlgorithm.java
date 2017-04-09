import java.util.Collections;
import java.util.Vector;
import java.util.Comparator;
public class GeneticAlgorithm {
	
	Vector<Scheduler> population;
	final float mutationRate=(float)0.1;
	final float crossoverRate=(float)0.5;
	final int eliteSchedule=1;
	final int selectionSize=3;
	final int populationSize=10;
	data da;
	
	public GeneticAlgorithm(data d){
		this.da = d;
		population = new Vector<Scheduler>();
		for(int i=0; i<populationSize; ++i){  // Getting a intial random population of chromosomes
			population.add(new Scheduler(d));
		}
		Collections.sort(population,new sortComparator());
	}
	public void display(){
		for(int i=0; i<populationSize;++i){
			for(int j=0; j<population.get(i).map.length;++j){
				System.out.print(population.get(i).map[j] + " ");
			}
			System.out.println("Fitness: " + population.get(i).fitness + "\n");
		}
	}
	
	Vector<Scheduler> crossoverPopulation(Vector<Scheduler> pop){
		Collections.sort(population,new sortComparator());
		Vector<Scheduler> crossPop =new Vector<Scheduler>();
		for(int i=0; i<eliteSchedule;++i){
			Scheduler eS = population.get(i);
			crossPop.add(eS);
		}
		for(int i=eliteSchedule;i<populationSize; ++i){
			if(crossoverRate > Math.random()){
				 Vector<Scheduler> pop1 = populationSelection();
				 Vector<Scheduler> pop2 = populationSelection();
				 Collections.sort(pop1,new sortComparator());
				 Collections.sort(pop2,new sortComparator());
				 crossPop.add(scheduleCrossover(pop1.get(0),pop2.get(0)));
			}
			else
				crossPop.add(population.get(i));
		}
		Collections.sort(crossPop, new sortComparator());
		return crossPop;
		
	}
	
	
	public Scheduler scheduleCrossover(Scheduler s1, Scheduler s2){
		Scheduler s = new Scheduler(s1);
		s.map = new int[s.nClass];
		s.count = new int[40*s.nRoom];
		for(int i=0; i<s.nClass; ++i){
			if(Math.random()<0.5){
				s.map[i]=s1.map[i];
				s.count[s1.map[i]]++;
			}
			else{
				s.map[i]=s2.map[i];
				s.count[s2.map[i]]++;
			}
		}
		s.calFitness();
		return s;
		
	}
	
	public Vector<Scheduler> populationSelection(){
		Vector<Scheduler> selectedPop = new Vector<Scheduler>();
		for(int i=0;i<selectionSize; ++i){
			int r =(int) (Math.random()*populationSize);
			selectedPop.add(population.get(r));
		}
		return selectedPop;
	}
	
	public Vector<Scheduler> evolve(Vector<Scheduler> pop){
		return mutatePopulation(crossoverPopulation(pop));
	}
	
	
	public Vector<Scheduler> mutatePopulation(Vector<Scheduler> crossPop){
		Vector<Scheduler> mutatePop = new Vector<Scheduler>();
		for(int i=0;i<eliteSchedule;++i){
			mutatePop.add(crossPop.get(i));
		}
		for(int i=eliteSchedule; i<populationSize; ++i){
			Scheduler s1 = new Scheduler(da);
			Scheduler s = crossPop.get(i);
			for(int j=0; j<s.nClass; ++j){
				if(mutationRate >Math.random()){
					s.count[s.map[j]]--;
					s.map[j]=s1.map[j];
					s.count[s.map[j]]++;
				}
			}
			s.calFitness();
			mutatePop.add(crossPop.get(i));
		}
		Collections.sort(mutatePop, new sortComparator());
		return mutatePop;
	}


	public class sortComparator implements Comparator<Scheduler>{
		public int compare(Scheduler o1, Scheduler o2) {
			return (int)o2.fitness - (int)o1.fitness;
		}
	}
}