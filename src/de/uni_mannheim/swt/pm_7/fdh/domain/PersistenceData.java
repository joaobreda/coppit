/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PersistenceData.
 */
public class PersistenceData implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3396166019658450297L;

	/** The source click point_. */
	private Point sourceClickPoint_;

	/** The destination click point_. */
	private Point destinationClickPoint_;

	/** The diced number of turn_. */
	private int dicedNumberOfTurn_;

	/** The game sequence number_. */
	private int gameSequenceNumber_;

	/** The game is finished_. */
	private boolean gameIsFinished_;

	/** The list of player colors_. */
	private Color[] listOfPlayerColors_;

	/** The list of player names_. */
	private String[] listOfPlayerNames_;

	/** The list of is computer player_. */
	private boolean[] listOfIsComputerPlayer_;

	/**
	 * Instantiates a new persistence data.
	 */
	public PersistenceData() {

	}

	/**
	 * Instantiates a new persistence data.
	 *
	 * @param a the a
	 * @param b the b
	 * @param diced the diced
	 * @param seq the seq
	 * @param finished the finished
	 * @param iscomp the iscomp
	 * @param name the name
	 * @param col the col
	 */
	public PersistenceData(Point a, Point b, int diced, int seq,
			boolean finished, boolean[] iscomp, String[] name, Color[] col) {
		this.sourceClickPoint_ = a;
		this.destinationClickPoint_ = b;
		this.dicedNumberOfTurn_ = diced;
		this.gameSequenceNumber_ = seq;
		this.gameIsFinished_ = finished;
		this.listOfPlayerColors_ = col;
		this.listOfPlayerNames_ = name;
		this.listOfIsComputerPlayer_ = iscomp;

		// for (Field f: game.getFields())
		// for (Hat h: game.getHats())
		// {
		// if (h.getField() == f)
		// this.FieldHadPlayerTuple.put(game.getFields().indexOf(f),h);
		// }

	}

	/**
	 * Gets the colors.
	 *
	 * @return the colors
	 */
	public Color[] getColors() {
		return this.listOfPlayerColors_;
	}

	/**
	 * Gets the dest.
	 *
	 * @return the dest
	 */
	public Point getDest() {
		return this.destinationClickPoint_;
	}

	/**
	 * Gets the game sequence.
	 *
	 * @return the game sequence
	 */
	public int getGameSequence() {
		return this.gameSequenceNumber_;
	}

	/**
	 * Gets the checks if is computer.
	 *
	 * @return the checks if is computer
	 */
	public boolean[] getIsComputer() {
		return this.listOfIsComputerPlayer_;
	}

	/**
	 * Gets the names.
	 *
	 * @return the names
	 */
	public String[] getNames() {
		return this.listOfPlayerNames_;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return this.dicedNumberOfTurn_;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public Point getSource() {
		return this.sourceClickPoint_;
	}

	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return this.gameIsFinished_;
	}

	/**
	 * Sets the colors.
	 *
	 * @param colors the new colors
	 */
	public void setColors(Color[] colors) {
		this.listOfPlayerColors_ = colors;
	}

	/**
	 * Sets the dest.
	 *
	 * @param dest the new dest
	 */
	public void setDest(Point dest) {
		this.destinationClickPoint_ = dest;
	}

	/**
	 * Sets the finished.
	 *
	 * @param finished the new finished
	 */
	public void setFinished(boolean finished) {
		this.gameIsFinished_ = finished;
	}

	/**
	 * Sets the game sequence.
	 *
	 * @param gameSequence the new game sequence
	 */
	public void setGameSequence(int gameSequence) {
		this.gameSequenceNumber_ = gameSequence;
	}

	/**
	 * Sets the checks if is computer.
	 *
	 * @param isComputer the new checks if is computer
	 */
	public void setIsComputer(boolean[] isComputer) {
		this.listOfIsComputerPlayer_ = isComputer;
	}

	/**
	 * Sets the names.
	 *
	 * @param names the new names
	 */
	public void setNames(String[] names) {
		this.listOfPlayerNames_ = names;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.dicedNumberOfTurn_ = number;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(Point source) {
		this.sourceClickPoint_ = source;
	}

}
