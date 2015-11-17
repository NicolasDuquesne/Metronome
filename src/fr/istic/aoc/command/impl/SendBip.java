package fr.istic.aoc.command.impl;

import fr.istic.aoc.command.Command;
import fr.istic.aoc.controller.Controller;

public class SendBip implements Command{
	
	private Controller ctl;
	
	public void execute() {
		//Appel la méthode du Controller qui vérifiera si on affiche la led BPM ou les deux
		ctl.ctlBip();
	}
	
	public Runnable run(){
		this.execute();
		return null;
	}
}
