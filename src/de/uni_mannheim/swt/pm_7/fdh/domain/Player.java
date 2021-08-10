/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7968062946641069545L;

	/** The color of player_. */
	private Color colorOfPlayer_;

	/** The name of player_. */
	private String nameOfPlayer_;

	/** The is computer payer_. */
	private transient boolean isComputerPayer_;

	/** The player is active_. */
	private transient boolean playerIsActive_;

	/** The computer player_. */
	private transient ComputerPlayer computerPlayer_;

	/** The hads of player_. */
	private transient ArrayList<Hat> hadsOfPlayer_;

	/** The scored hads of players_. */
	private ArrayList<Hat> scoredHadsOfPlayers_;

	/**
	 * Instantiates a new player.
	 */
	public Player() {

	}

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param color the color
	 * @param isComputer the is computer
	 */
	public Player(String name, Color color, boolean isComputer) {
		if (isComputer) {
			this.computerPlayer_ = new ComputerPlayer();
		}
		this.hadsOfPlayer_ = new ArrayList<Hat>();
		this.scoredHadsOfPlayers_ = new ArrayList<Hat>();
		this.colorOfPlayer_ = color;
		this.nameOfPlayer_ = name;
		this.isComputerPayer_ = isComputer;
	}

	/**
	 * Adds the hat.
	 *
	 * @param had the had
	 */
	public void addHat(Hat had) {
		this.hadsOfPlayer_.add(had);
	}

	/**
	 * Adds the score hat.
	 *
	 * @param x the x
	 */
	public void addScoreHat(Hat x) {
		this.scoredHadsOfPlayers_.add(x);

	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return this.colorOfPlayer_;
	}

	/**
	 * Gets the hads.
	 *
	 * @return the hads
	 */
	public ArrayList<Hat> getHads() {
		return this.hadsOfPlayer_;
	}

	// public void writeObject(java.io.ObjectOutputStream out)
	// throws IOException
	// {
	// out.writeObject(color);
	// out.writeObject(name);
	// }
	//
	// public void readObject(java.io.ObjectInputStream in)
	// throws IOException, ClassNotFoundException
	// {
	// // String name = (String)in.readObject();
	// // Color color = (Color)in.readObject();
	// // boolean comp = in.readBoolean();
	// //
	// // this.setColor(getColor());
	//
	// }

	/**
	 * Gets the kI.
	 *
	 * @return the kI
	 */
	public ComputerPlayer getKI() {
		return this.computerPlayer_;
	}

	/**
	 * Gets the kI field.
	 *
	 * @return the kI field
	 */
	public Field getKIField() {
		return this.computerPlayer_.getCurrentField();
	}

	/**
	 * Gets the kI hat.
	 *
	 * @return the kI hat
	 */
	public Hat getKIHat() {
		return this.computerPlayer_.getCurrentHat();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.nameOfPlayer_;
	}

	/**
	 * Gets the score hads.
	 *
	 * @return the score hads
	 */
	public ArrayList<Hat> getScoreHads() {
		return this.scoredHadsOfPlayers_;
	}

	/**
	 * Inits the k imove.
	 */
	public void initKImove() {
		this.computerPlayer_.chooseHat(this.getHads());
		this.computerPlayer_.getCurrentHat().setSourcePos(
				this.computerPlayer_.getCurrentField().getPosToHad());
	}

	/**
	 * Checks if is computer.
	 *
	 * @return true, if is computer
	 */
	public boolean isComputer() {
		return this.isComputerPayer_;
	}

	/**
	 * Checks if is isactive.
	 *
	 * @return true, if is isactive
	 */
	public boolean isIsactive() {
		return this.playerIsActive_;
	}

	/**
	 * K imake move.
	 *
	 * @param legal the legal
	 * @return the field
	 */
	public Field KImakeMove(ArrayList<Field> legal) {
		return this.computerPlayer_.getDestField(legal);
	}

	/**
	 * Sets the active.
	 *
	 * @param b the new active
	 */
	public void setactive(boolean b) {
		this.playerIsActive_ = b;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.colorOfPlayer_ = color;
	}

	/**
	 * Sets the computer.
	 *
	 * @param comp the new computer
	 */
	public void setComputer(boolean comp) {
		if (comp) {
			this.computerPlayer_ = new ComputerPlayer();
		}
		this.isComputerPayer_ = comp;
	}

	/**
	 * Sets the hads.
	 *
	 * @param hads the new hads
	 */
	public void setHads(ArrayList<Hat> hads) {
		this.hadsOfPlayer_ = hads;
	}

	/**
	 * Sets the isactive.
	 *
	 * @param isactive the new isactive
	 */
	public void setIsactive(boolean isactive) {
		this.playerIsActive_ = isactive;
	}

	/**
	 * Sets the kI.
	 *
	 * @param kI the new kI
	 */
	public void setKI(ComputerPlayer kI) {
		this.computerPlayer_ = kI;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.nameOfPlayer_ = name;
	}

}
