/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Point;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ComputerPlayer.
 */
public class ComputerPlayer {

	/** The current hat_. */
	private Hat currentHat_;

	/** The current field_. */
	private Field currentField_;

	/**
	 * Instantiates a new computer player.
	 */
	public ComputerPlayer() {

	}

	/**
	 * Choose hat.
	 *
	 * @param playersHats the players hats
	 */
	public void chooseHat(ArrayList<Hat> playersHats) {
		// ArrayList<Hat> temp = new ArrayList<Hat>();
		// for (Hat t: playersHats)
		// temp.add(t);
		this.currentHat_ = playersHats.get((int) ((Math.random() * playersHats
				.size())));
		for (Hat t : playersHats) {
			if (t.hasCatched()) {
				this.currentHat_ = t;
			}
		}

		this.currentField_ = this.currentHat_.getField();
		this.currentHat_.setSourcePos((Point) this.currentHat_.getPosition());
	}

	/**
	 * Gets the current field.
	 *
	 * @return the current field
	 */
	public Field getCurrentField() {
		return this.currentField_;
	}

	/**
	 * Gets the current hat.
	 *
	 * @return the current hat
	 */
	public Hat getCurrentHat() {
		return this.currentHat_;
	}

	/**
	 * Gets the dest field.
	 *
	 * @param legal the legal
	 * @return the dest field
	 */
	public Field getDestField(ArrayList<Field> legal) {
		if (this.currentHat_.hasCatched()) {
			for (Field f : legal) {
				if (f.isHouse()
						&& (f.getColor() == this.currentHat_.getHadColor())) {
					return f;
				}
			}
		} else {
			for (Field f : legal) {
				if ((f.getHads().size() > 0)
						&& (f.getColor() != this.currentHat_.getHadColor())) {
					return f;
				}
			}
		}

		return legal.get((int) (Math.random() * legal.size()));
	}

}
