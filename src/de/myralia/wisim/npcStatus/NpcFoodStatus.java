package de.myralia.wisim.npcStatus;

import de.myralia.wisim.npc.Npc;
import de.myralia.wisim.npcBedarf.NpcBedarf.NpcBedarfType;

public class NpcFoodStatus extends NpcStatus{
	
	public NpcFoodStatus() {
		this.type = NpcStatus.NpcStatusType.FoodStatus;
	}
	
	@Override
	public int editStatus(int value, Npc owner) {
		if(this.status+value>10000){
			this.status = 10000;
		}else if(this.status+value<0){
			this.status = 0;
		}else{
			this.status+=value;
		}
		//jeh nach hunger wird nun ein bedarf nach essen modifiziert
		if(this.status>1000){
			owner.editBedarf(NpcBedarfType.Essen, 1);
		}
		if(this.status>3000){
			owner.editBedarf(NpcBedarfType.Essen, 2);
		}	
		if(this.status>7000){
			owner.editBedarf(NpcBedarfType.Essen, 3);
		}	
		
		return this.status;
	}
}
