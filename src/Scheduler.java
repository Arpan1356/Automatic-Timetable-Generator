public class Scheduler {
	
	data inputData;
	int nRoom,nClass,map[],count[],tot;
	float fitness;
	
	public Scheduler(data D){
		this.inputData= D;
		nRoom = D.crD.size();
		nClass = D.cD.size();
		map = new int[nClass];
		count = new int[40*nRoom];
		createInitialRandom();
		calFitness();
	}
	
	public void createInitialRandom(){
		for(int i=0;i<nClass;++i){
			int des = (int)( Math.random()*40*nRoom);
			map[i] = des;
			count[des]++;
		}
	}
	public void calFitness(){
		
		int temp=0; 
		for(int i=0; i<nClass; ++i){// MAIN LOOP THROUGH CLASSES
			
			
			//spare room
			if(count[map[i]]==1)
				temp++;
			
			//strength of stud_group vs size of room
			int room = (map[i]%48)/8;
			
			int studnum=0;
			int roomSize = inputData.crD.get(room).size;
			
			for(int j=0;j<inputData.sgD.size();++j){
				if(inputData.sgD.get(j).id == inputData.cD.get(i).batch_id){
					studnum = inputData.sgD.get(j).strength;
					break;
				}
			}
			
			if(studnum < roomSize){
				temp++;
			}
			
			//computer available
			
			boolean studComp = inputData.cD.get(i).computer_req;
			boolean roomComp = inputData.crD.get(room).computer;
			
			if( studComp == true && roomComp == true)
				temp++;
			else if(studComp == false)
				temp++;
			
			//stud_group has any other class at that time
			int flag1=0;
			for(int j=0;j<nClass;++j){
				if(inputData.cD.get(j).batch_id == inputData.cD.get(i).batch_id){
					if((map[i]/48) == (map[j]/48)){ // located in same day
						if((map[i]%48)/8 == (map[j]%48)/8){ // at same time
						flag1++;
						break;
						}
					}
						
				}
			}
			if(flag1==1)
				temp++;
			
			//prof has any other class at that time
			flag1=0;
			/*
			for(int j=0;j<nClass;++j){
				if(inputData.pD.get(j).id == inputData.cD.get(i).professor_id){
					flag1++;
						
				}
			}
			if(flag1==1)
				temp++;
				*/
			
			
			tot = temp;
			

			
		}
		
	}
	
}
