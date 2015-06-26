package de.myralia.wisim.npcStatus;

import de.myralia.wisim.npc.Npc;
import de.myralia.wisim.npcStatus.NpcStatus.NpcStatusType;

public abstract class NpcStatus {
	protected int status = 0;
	protected NpcStatusType type; 
	
	public static enum NpcStatusType{
		FoodStatus;
	}
	
	public static NpcStatus create(NpcStatusType type) {
		switch(type){
			case FoodStatus: return new NpcFoodStatus();
		}
		return null;
	}
	
	public int getStatus() {
		return this.status;
	}	
	abstract public int editStatus(int value,Npc owner);
	
	public int getStatusId() {
		if(this.getClass().equals("npcFoodStatus")) return 0;
		return -1;
	}

	public String getStatusName() {		
		if(this.getClass().equals("npcFoodStatus")) return "Hunger";
		return "Unbekannter Status";
	}
	
}
