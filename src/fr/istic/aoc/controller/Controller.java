package fr.istic.aoc.controller;

import fr.istic.aoc.controller.impl.ControllerImpl;
import fr.istic.aoc.model.Moteur;
import javafx.event.ActionEvent;

public interface Controller {
	
	void onClickInc(ActionEvent poEvent);
	
	void onClickDec(ActionEvent poEvent);
	
	void onClickStart(ActionEvent poEvent);
	
	void onClickStop(ActionEvent poEvent);
	
	void onModifyBPM();
	
	void displayBPM(int piValue);
	
	void ctlBip();
	
	void displayBip();
	
	void displayMesure();
	
	Moteur getMoMoteur();

	void setMoMoteur(Moteur moMoteur);
	
}
