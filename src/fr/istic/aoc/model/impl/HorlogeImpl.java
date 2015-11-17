package fr.istic.aoc.model.impl;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.command.impl.SendBip;
import fr.istic.aoc.controller.Controller;
import fr.istic.aoc.model.Horloge;

public class HorlogeImpl implements Horloge{
	
	private static ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
	
	SendBip sendBip = new SendBip();
	
	public void start(long timeBPM, Controller poCtrl){
		
		TimerTask clock = new TimerTask()
		{
			@Override
			public void run() 
			{
				sendBip.setCtl(poCtrl);
				sendBip.execute();
			}	
		};
		//timer.schedule(switchOff, (long)timeBPM);
		
    	//indiquer la commande qui mettra à jour la vue (clignotement de la led 1)
		//voir pour utiliser les lambda expression
		s.scheduleAtFixedRate(clock, 0L, timeBPM, TimeUnit.MILLISECONDS);
	}

	//liste des méthodes faisant les actions de tics et mesures
	
	// ScheduleExecutorService s = Executors.newScheduledThreadPool(1)
	// s.scheduleAtFixedRate(cmd::execute);
}
