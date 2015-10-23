package fr.istic.aoc.model;

import fr.istic.aoc.command.Command;

public class Moteur {
	
	
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
