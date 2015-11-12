package fr.istic.aoc.command.impl;

import fr.istic.aoc.controller.Controller;
import fr.istic.aoc.model.Horloge;

public class SendBip {
	
	private Controller ctl;
	private int measure;
	
	public int getMeasure() {
		return measure;
	}
	
	public void setMeasure(int measure) {
		this.measure = measure;
	}
}
