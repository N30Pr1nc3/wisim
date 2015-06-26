package de.myralia.wisim.npcBedarf;

import de.myralia.wisim.npc.Npc;

public class NpcBedarfEssen extends NpcBedarf {

	@Override
	public int editStatus(int value, Npc owner) {
		this.bedarf += value;
		if(this.bedarf<0){
			this.bedarf = 0;
		}		
		return this.bedarf;
	}

}
