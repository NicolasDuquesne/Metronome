package fr.istic.aoc.model;

import fr.istic.aoc.controller.Controller;

public interface Horloge {
	void start(long timeBPM, Controller poCtrl);
	boolean stop();
}
