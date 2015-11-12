package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.model.Horloge;

/**
 * Implémente la commande IncreaseMeasure
 */
public class UpdateMeasure implements Command{

	private Horloge horloge;
	private int measure;

	 /**
	 * @return the measure
	 */
	public int getMeasure() {
		return measure;
	}

	/**
	* Maj measure pour ensuite lancer les methodes de l'horloge avec la nouvelle measure via execute()
	* @param bpm the bpm to set
	*/
	public void setMeasure(int measure){
		this.measure = measure;
	}
	
	public void execute() {
		//Met à jour la mesure dans le Controller avec le 
	}

}

