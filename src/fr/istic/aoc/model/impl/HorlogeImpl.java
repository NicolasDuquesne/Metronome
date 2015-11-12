package fr.istic.aoc.model.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.model.Horloge;

public class HorlogeImpl implements Horloge{
	
	//déclaration du ScheduledExecutorService avec un démarrage au bout d'une seconde
	ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
	
	public void start(float timeBPM){				

		//indiquer la commande qui mettra à jour la vue (clignotement de la led 1)
		//voir pour utiliser les lambda expression
		s.scheduleAtFixedRate(command, 0, timeBPM, TimeUnit.SECONDS);
	}

	//liste des méthodes faisant les actions de tics et mesures
	
	// ScheduleExecutorService s = Executors.newScheduledThreadPool(1)
	// s.scheduleAtFixedRate(cmd::execute);
}
