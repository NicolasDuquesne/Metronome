package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.model.Horloge;

/**
 * Implémente la commande UpdateBPM
 */
public class UpdateBPM implements Command{

	private Horloge horloge;
	private int bpm;

	 /**
	 * @return the bpm
	 */
	public int getBpm() {
		return bpm;
	}

	/**
	*Maj bpm pour ensuite lancer les méthodes de l'horloge avec le nouveau bpm via execute()
	* @param bpm the bpm to set
	*/
	public void setBpm(int bpm){
		this.bpm = bpm;
	}
	
	public void execute() {
		//calcul le temps par rapport au BPM
		float timeBPM;
		timeBPM = 60/this.bpm;
		
		//Appel méthode start de l'horloge pour executer les bips par rapport au temps
		horloge.start(timeBPM);
	}

}