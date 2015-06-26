package de.myralia.wisim.npcBedarf;

import de.myralia.wisim.npc.Npc;
import de.myralia.wisim.npcStatus.NpcFoodStatus;
import de.myralia.wisim.npcStatus.NpcStatus;
import de.myralia.wisim.npcStatus.NpcStatus.NpcStatusType;

public abstract class NpcBedarf {
	protected int bedarf = 0;
	protected NpcBedarfType type; 
	
	public static enum NpcBedarfType{
		Essen;
	}
	
	public static NpcBedarf create(NpcBedarfType type) {
		switch(type){
			//case Essen: return new NpcFoodStatus();
		}
		return null;
	}
	
	public int getBedarf() {
		return this.bedarf;
	}	
	abstract public int editStatus(int value,Npc owner);
	
	public NpcBedarfType getStatusId() {
		return this.type;
	}

	public String getStatusName() {		
		return "Unbekannter Bedarf";
	}
}
