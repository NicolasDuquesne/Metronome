package fr.istic.aoc.controller.impl;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fr.istic.aoc.command.impl.StartClock;
import fr.istic.aoc.command.impl.StopClock;
import fr.istic.aoc.command.impl.UpdateBPM;
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
	private static final int DEFAULT_BPM = 120;
	
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
		MoteurImpl oMoteur = new MoteurImpl();
		StartClock oCmdStart = new StartClock(this);
		oCmdStart.setMiInitBPM(DEFAULT_BPM);
		oMoteur.setCmd(Evenement.StartClock, oCmdStart);
	}
	
	public void onClickStop(ActionEvent poEvent) {
		MoteurImpl oMoteur = new MoteurImpl();
		StopClock oCmdStop = new StopClock();
		oMoteur.setCmd(Evenement.StopClock, oCmdStop);
	}
	
	public void onModifyBPM() {
		MoteurImpl oMoteur = new MoteurImpl();
		UpdateBPM oCmdUpd = new UpdateBPM(this);
		oMoteur.setBpm(this.poSliderBPM.valueProperty().intValue());
		oMoteur.setCmd(Evenement.UpdateBPM, oCmdUpd);
		displayBPM(oMoteur.getBpm());
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
		System.out.println("Bip ! ");
		moLightBPM.selectedProperty().set(true);
		displayDelay(LIGHT_BPM);
	}
	
	public void displayMesure() {
		System.out.println("Mesure");
		moLightMesure.selectedProperty().set(true);
		displayDelay(LIGHT_MESURE);
	}
	
}
