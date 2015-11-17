package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.controller.Controller;
import fr.istic.aoc.model.impl.HorlogeImpl;

public class StopClock implements Command {
	
	public Controller moCtrl;
	
	public StopClock(Controller poController) {
		this.moCtrl = poController;
	}

	public void execute() {
		this.moCtrl.getMoMoteur().getMoHorloge().stop();
	}

}
