package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.controller.Controller;
import fr.istic.aoc.controller.impl.ControllerImpl;
import fr.istic.aoc.model.Horloge;
import fr.istic.aoc.model.impl.HorlogeImpl;

public class StartClock implements Command {
	
	/**
	 * 
	 */
	public int miInitBPM = 0;
	
	/**
	 * 
	 */
	public int miDelay = 0;
	
	public Controller moCtrl;
	
	public StartClock(Controller poCtrl) {
		this.moCtrl = poCtrl;
	}

	public int getMiInitBPM() {
		return miInitBPM;
	}

	public void setMiInitBPM(int miInitBPM) {
		this.miInitBPM = miInitBPM;
	}

	public int getMiDelay() {
		return miDelay;
	}

	public void setMiDelay(int miDelay) {
		this.miDelay = miDelay;
	}

	public void execute() {
		long fInit = (long) (((float) 60/miInitBPM) * 1000);
		moCtrl.getMoMoteur().getMoHorloge().start(fInit, moCtrl);
	}

}
