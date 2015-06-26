package de.myralia.wisim.npc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import de.myralia.wisim.npcAktion.NpcAktion;
import de.myralia.wisim.npcBedarf.NpcBedarf;
import de.myralia.wisim.npcBedarf.NpcBedarf.NpcBedarfType;
import de.myralia.wisim.npcStatus.NpcStatus;
import de.myralia.wisim.npcStatus.NpcStatus.NpcStatusType;

public class Npc {
	private static int idCounter = 0;
	private static HashMap<Integer,Npc> npcList = new HashMap<Integer, Npc>();
	
	private static int intelligenzModifier = 2;
	private static int staerkeModifier = 2;
	
	private int id; 
	private int staerke = 20;
	private int intelligenz = 20;
	private Boolean geschlaecht = true;
	private int geburt = 0;
	private String name;
	private String vorname;

	private HashMap<NpcStatusType,NpcStatus> status = new HashMap<NpcStatus.NpcStatusType, NpcStatus>();
	private HashMap<NpcBedarfType,NpcBedarf> bedarf = new HashMap<NpcBedarf.NpcBedarfType, NpcBedarf>();
	private HashMap<Integer,NpcAktion> aktionen = new HashMap<Integer, NpcAktion>();
	private NpcAktion aktiveAction = null;
		
	public static Npc createNpc(Npc vater, Npc mutter){
		Npc npc = new Npc();
		Random rand = new Random();
		
		npc.intelligenz = 	vater.getIntelligenz()+mutter.getIntelligenz()/2+rand.nextInt(Npc.intelligenzModifier*2)-Npc.intelligenzModifier;		
		npc.staerke =   	vater.getStaerke()+mutter.getStaerke()/2+rand.nextInt(Npc.staerkeModifier*2)-Npc.staerkeModifier;		
		
		return npc;		
	}
	
	public static void LoadNpcs() {
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();
		new Npc();		
	}
	
	public static void liveCicle(Integer ticCounter) {
		for(Entry<Integer,Npc> entry : Npc.npcList.entrySet()){
			entry.getValue().instanceLiveCicle(ticCounter);
		}
	}

	Npc(){
		Random rand = new Random();
		this.id = Npc.idCounter;
		Npc.idCounter++;
		if(rand.nextInt(1) == 1){
			this.geschlaecht = true;
		}else{
			this.geschlaecht = false;
		}		
		Npc.npcList.put(this.id, this);
	}
	
	public int getStaerke() {
		return this.staerke; 
	}

	public int getIntelligenz() {		
		return this.intelligenz;
	}
	
	public void editStatus(NpcStatusType type,Integer value){
		if(!this.status.containsKey(type)){
			this.status.put(type, NpcStatus.create(type));
		}
		if(this.status.get(type) == null){
			return;
		}
		this.status.get(type).editStatus(value, this);
	}
	
	public void editBedarf(NpcBedarfType type,Integer value){
		if(!this.bedarf.containsKey(type)){
			this.bedarf.put(type, NpcBedarf.create(type));
		}
		if(this.bedarf.get(type) == null){
			return;
		}
		this.bedarf.get(type).editStatus(value, this);
	}
	
	
	private void instanceLiveCicle(Integer tick) {
		this.editStatus(NpcStatus.NpcStatusType.FoodStatus, +2);
		
		if(this.aktiveAction == null){
			this.aktiveAction.aktionTick(tick);
		}
	}
}
