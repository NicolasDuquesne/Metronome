package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
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

	public void execute() {
		HorlogeImpl oHorloge = new HorlogeImpl();
		oHorloge.start(miInitBPM/60);
	}

}
