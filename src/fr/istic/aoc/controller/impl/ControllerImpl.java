package fr.istic.aoc.controller.impl;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fr.istic.aoc.command.impl.StartClock;
import fr.istic.aoc.command.impl.StopClock;
import fr.istic.aoc.command.impl.UpdateBPM;
import fr.istic.aoc.controller.*;
import fr.istic.aoc.enumeration.Evenement;
import fr.istic.aoc.model.Moteur;
import fr.istic.aoc.model.impl.MoteurImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class ControllerImpl implements Controller{
	
	private static final String LIGHT_BPM = "LIGHT_BPM";
	private static final String LIGHT_MESURE = "LIGHT_MESURE";
	private static final int DEFAULT_BPM = 120;
	
	private static Moteur moMoteur = new MoteurImpl();
	
	@FXML
	private Slider poSliderBPM;
	
	@FXML
	private TextArea poDisplay;
	
	@FXML
	private RadioButton moLightBPM;
	
	@FXML
	private RadioButton moLightMesure;
	
	private int miCountBip = 0;
	
	private int miMesure = 2;
	
	public ControllerImpl() {
		
	}

	public void onClickInc(ActionEvent poEvent) {
		if (miMesure < 7) {
			miMesure++;
		}
	}

	public void onClickDec(ActionEvent poEvent) {
		if (miMesure > 2) {
			miMesure--;
		}
	}
	
	public void onClickStart(ActionEvent poEvent) {
		StartClock oCmdStart = new StartClock(this);
		oCmdStart.setMiInitBPM(DEFAULT_BPM);
		moMoteur.setCmd(Evenement.StartClock, oCmdStart);
	}
	
	public void onClickStop(ActionEvent poEvent) {
		StopClock oCmdStop = new StopClock(this);
		moMoteur.setCmd(Evenement.StopClock, oCmdStop);
	}
	
	public void onModifyBPM() {
		UpdateBPM oCmdUpd = new UpdateBPM(this);
		moMoteur.setBpm(this.poSliderBPM.valueProperty().intValue());
		moMoteur.setCmd(Evenement.UpdateBPM, oCmdUpd);
		displayBPM(moMoteur.getBpm());
	}

	public void displayBPM(int piValue) {
		this.poDisplay.setText(String.valueOf(piValue));
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
		Timer timer = new Timer();
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
		timer.schedule(switchOff, 100);
	}

	public void displayBip() {
		moLightBPM.selectedProperty().set(true);
		displayDelay(LIGHT_BPM);
	}
	
	public void displayMesure() {
		moLightMesure.selectedProperty().set(true);
		displayDelay(LIGHT_MESURE);
	}

	/**
	 * @return the moMoteur
	 */
	public Moteur getMoMoteur() {
		return moMoteur;
	}

	/**
	 * @param moMoteur the moMoteur to set
	 */
	public void setMoMoteur(Moteur moMoteur) {
		ControllerImpl.moMoteur = moMoteur;
	}
	
}
