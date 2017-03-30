public class Scheduler {
	
	data inputData;
	int nRoom,nClass,map[];
	float fitness;
	
	public Scheduler(data D){
		this.inputData= D;
		nRoom = D.crD.size();
		nClass = D.cD.size();
		map = new int[nClass];
		createInitialRandom();
	}
	
	public void createInitialRandom(){
		for(int i=0;i<nClass;++i){
			int des = (int)( Math.random()*40*nRoom);
			map[i] = des;
		}
	}
	public void calFitness(){
		
	}
	
}
