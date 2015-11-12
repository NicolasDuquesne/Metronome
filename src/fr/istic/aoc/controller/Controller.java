package fr.istic.aoc.controller;

import javafx.event.ActionEvent;

public interface Controller {
	
	void onClickInc(ActionEvent poEvent);
	
	void onClickDec(ActionEvent poEvent);
	
	void onClickStart(ActionEvent poEvent);
	
	void onClickStop(ActionEvent poEvent);
	
	void onModifyBPM();
	
	void displayBPM(int piValue);
	
	void displayBip();
	
	void displayMesure();
}
