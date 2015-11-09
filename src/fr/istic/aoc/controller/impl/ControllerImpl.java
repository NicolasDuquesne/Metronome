package fr.istic.aoc.controller.impl;

import fr.istic.aoc.controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.text.TextFlow;

public class ControllerImpl implements Controller{
	
	@FXML
	private Slider poSliderBPM;
	
	@FXML
	private TextFlow poDisplay;
	
	public ControllerImpl() {
		
	}

	public void onClickInc(ActionEvent poEvent) {
		
	}

	public void onClickDec(ActionEvent poEvent) {

	}
	
	public void onClickStart(ActionEvent poEvent) {

	}
	
	public void onClickStop(ActionEvent poEvent) {

	}
	
	public void onModifyBPM() {
		displayBPM(this.poSliderBPM.valueProperty().intValue());
	}

	public void displayBPM(int piValue) {
		System.out.println(piValue);
		this.poDisplay.accessibleTextProperty().set(String.valueOf(piValue));
	}
	
}
