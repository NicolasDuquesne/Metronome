package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;

/**
 * Implémente la commande UpdateBPM
 * Appelle la méthode action1() lorsque la commande est exécutée.
 */
public class UpdateBPM implements Command{

	private MoteurImpl moteur;
	    
	public UpdateBPM(MoteurImpl m) {
        moteur = m;
    }
	    
    public void execute() {
        moteur.UpdateBPMView();
    }
    
}