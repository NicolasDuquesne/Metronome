package fr.istic.aoc.model.impl;

import fr.istic.aoc.model.Moteur;
import fr.istic.aoc.command.Command;

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



	// Références vers les commandes
    private Command updateBPM;
    
   
	// Méthodes pour invoquer les commandes
    public void invokeUpdateBPM() {
        if(updateBPM != null) {
            updateBPM.execute();
        }
    }
    
    // Méthodes pour fixer les commandes
    public void setUpdateBPM(Command newUpdateBPM) {
        updateBPM = newUpdateBPM;
    }
    

}
