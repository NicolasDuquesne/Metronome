package fr.istic.aoc.controller.impl;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fr.istic.aoc.command.impl.StartClock;
import fr.istic.aoc.controller.*;
import fr.istic.aoc.enumeration.Evenement;
import fr.istic.aoc.model.impl.MoteurImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class ControllerImpl implements Controller{
	
	private static final String LIGHT_BPM = "LIGHT_BPM";
	private static final String LIGHT_MESURE = "LIGHT_MESURE";
	
	@FXML
	private Slider poSliderBPM;
	
	@FXML
	private TextArea poDisplay;
	
	@FXML
	private RadioButton moLightBPM;
	
	@FXML
	private RadioButton moLightMesure;
	
	private int miCountBip = 0;
	
	private int miMesure = 0;
	
	public ControllerImpl() {
		
	}

	public void onClickInc(ActionEvent poEvent) {
		miMesure++;
	}

	public void onClickDec(ActionEvent poEvent) {
		miMesure--;
	}
	
	public void onClickStart(ActionEvent poEvent) {
		MoteurImpl oMoteur = new MoteurImpl();
		StartClock oCmdStart = new StartClock();
		oMoteur.setCmd(Evenement.StartClock, oCmdStart);
	}
	
	public void onClickStop(ActionEvent poEvent) {
		
	}
	
	public void onModifyBPM() {
		displayBPM(this.poSliderBPM.valueProperty().intValue());
	}

	public void displayBPM(int piValue) {
		this.poDisplay.setText(String.valueOf(piValue));
		ctlBip();
	}
	
	public void ctlBip() {
		miCountBip++;
		displayBip();
		if (miCountBip == miMesure) {
			displayMesure();
			miCountBip = 0;
		}
	}
	
	private void displayDelay(final String psLight) {
		final Timer timer = new Timer();
		TimerTask switchOff = new TimerTask()
		{
			@Override
			public void run() 
			{
				if (LIGHT_BPM.equals(psLight)) {
					moLightBPM.selectedProperty().set(false);
				} else if (LIGHT_MESURE.equals(psLight)) {
					moLightMesure.selectedProperty().set(false);
				}
			}	
		};
		timer.schedule(switchOff, 200);
	}

	public void displayBip() {
		moLightBPM.selectedProperty().set(true);
		displayDelay(LIGHT_BPM);
	}
	
	public void displayMesure() {
		moLightMesure.selectedProperty().set(true);
		displayDelay(LIGHT_MESURE);
	}
	
}
