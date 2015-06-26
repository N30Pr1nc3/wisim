package de.myralia.wisim.main;

import de.myralia.wisim.npc.Npc;

public class Main {

	public static void main(String[] args) {
		System.out.println("Loading NPCS");
		Npc.LoadNpcs();
		
		boolean doit = true;
		Integer ticCounter = 0;
		long time = System.currentTimeMillis()/1000;
		System.out.println("time"+time);
		while(doit){
			while(doit){
				if(time - System.currentTimeMillis()/1000 == 0){
					continue;
				}
				time = System.currentTimeMillis()/1000;
				break;
			}
			
			Npc.liveCicle(ticCounter);
			ticCounter ++;
			System.out.println("new Tic -------------------"+ticCounter);
						
		}

	}

}
