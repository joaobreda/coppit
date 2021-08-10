/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.eventthandler;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import de.uni_mannheim.swt.pm_7.fdh.domain.FDHGame;
import de.uni_mannheim.swt.pm_7.fdh.domain.PersistenceData;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHGameFacade.
 */
public class FDHGameFacade {

	/**
	 * Instantiates a new fDH game facade.
	 *
	 * @param control the control
	 * @param file the file
	 */
	public FDHGameFacade(FDHBoardController control, File file) {
		ArrayList<PersistenceData> moves;
		moves = control.getFDHGame().getPars().decodeMoves(file);
		for (int i = 0; i < moves.get(0).getIsComputer().length; i++) {
			moves.get(0).getIsComputer()[i] = false;
		}

		this.addPlayers(moves.get(0).getNames(), moves.get(0).getColors(),
				moves.get(0).getIsComputer(), control.getFDHGame());
		control.getFDHGame().CreateGame();
		control.replayGame(moves);
	}

	/**
	 * Instantiates a new fDH game facade.
	 *
	 * @param control the control
	 * @param names the names
	 * @param colors the colors
	 * @param computer the computer
	 */
	public FDHGameFacade(FDHBoardController control, String[] names,
			Color[] colors, boolean[] computer) {
		FDHGame game = control.getFDHGame();
		this.addPlayers(names, colors, computer, game);
		control.getFDHGame().CreateGame();
		game.setStarted(true);
	}

	/**
	 * Adds the players.
	 *
	 * @param names the names
	 * @param colors the colors
	 * @param computer the computer
	 * @param game the game
	 */
	public void addPlayers(String[] names, Color[] colors, boolean[] computer,
			FDHGame game) {
		int i = 0;
		for (String s : names) {
			game.addPlayers(s, colors[i], computer[i]);
			i++;
		}
		game.setReplayMode(false);
	}

}
