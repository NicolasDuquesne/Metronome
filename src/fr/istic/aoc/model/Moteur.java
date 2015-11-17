package fr.istic.aoc.model;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.enumeration.Evenement;

public interface Moteur {

	public int getBpm();
	
	public void setBpm(int bpm);

	public int getMeasure();
	
	public void setMeasure(int measure);
	
    public void setCmd(Evenement evt, Command ctlCmd);
    
    Horloge getMoHorloge();

	void setMoHorloge(Horloge moHorloge);
    
}
