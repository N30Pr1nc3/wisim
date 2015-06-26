package de.myralia.wisim.npcAktion;

import de.myralia.wisim.npc.Npc;

public abstract class NpcAktion {	
	public abstract void aktionTick(Integer tick, Npc npc);
}