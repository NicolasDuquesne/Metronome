package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.controller.Controller;
import fr.istic.aoc.controller.impl.ControllerImpl;

public class SendBip implements Command{
	
	private Controller ctl;
	
	public Controller getCtl() {
		return ctl;
	}

	public void setCtl(Controller ctl) {
		this.ctl = ctl;
	}

	public void execute() {
		//Appel la méthode du Controller qui vérifiera si on affiche la led BPM ou les deux
		ctl.ctlBip();
	}
}
