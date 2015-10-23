package fr.istic.aoc.model.impl;

import fr.istic.aoc.model.Moteur;
import fr.istic.aoc.command.Command;
import fr.istic.aoc.command.impl.UpdateBPM;
import fr.istic.aoc.enumeration.Evenement;

public class MoteurImpl implements Moteur{
	
	private int bpm;
	private int measure;
	
	 /**
	 * @return the bpm
	 */
	public int getBpm() {
		return bpm;
	}

	/**
	* @param bpm the bpm to set
	*/
	public void setBpm(int bpm) {
		this.bpm = bpm;
	}
		
	
	/**
	 * @return the measure
	 */
	public int getMeasure() {
		return measure;
	}

	/**
	 * @param measure the measure to set
	 */
	public void setMeasure(int measure) {
		this.measure = measure;
	}

	// Méthode lançant la bonne commande execute() appelé par le controller
    public void setCmd(Evenement evt, Command ctlCmd) {
        if(evt.equals(Evenement.UpdateBPM)){
        	UpdateBPM updateBpm = (UpdateBPM) ctlCmd;
        	updateBpm.execute();
        }
    }
    

}
