package fr.istis.aoc.command;


/**
 * Implémente la commande UpdateBPM
 * Appelle la méthode action1() lorsque la commande est exécutée.
 */
public class UpdateBPM implements Command{

	private Moteur moteur;
	    
	public UpdateBPM(Moteur m) {
        moteur = m;
    }
	    
    public void execute() {
        moteur.UpdateBPMView();
    }
    
}