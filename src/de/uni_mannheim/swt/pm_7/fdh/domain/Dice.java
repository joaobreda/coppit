/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Dice.
 */
public class Dice implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4235074803462912063L;

	/** The dice is used_. */
	private boolean diceIsUsed_;

	/** The number history_. */
	private transient ArrayList<Integer> numberHistory_;

	/** The current diced number_. */
	private int currentDicedNumber_;

	/**
	 * Instantiates a new dice.
	 */
	public Dice() {
		this.diceIsUsed_ = true;
		this.numberHistory_ = new ArrayList<Integer>();
	}

	/**
	 * Gets the current number.
	 *
	 * @return the current number
	 */
	public int getCurrentNumber() {
		return this.currentDicedNumber_;
	}

	/**
	 * Gets the last number.
	 *
	 * @return the last number
	 */
	public Integer getLastNumber() {
		if (this.numberHistory_.isEmpty()) {
			return 0;
		} else {
			return this.numberHistory_.get(this.numberHistory_.size() - 1);
		}
	}

	/**
	 * Gets the number history.
	 *
	 * @return the number history
	 */
	public ArrayList<Integer> getNumberHistory() {
		return this.numberHistory_;
	}

	/**
	 * Checks if is used.
	 *
	 * @return true, if is used
	 */
	public boolean isUsed() {
		return this.diceIsUsed_;
	}

	/**
	 * Roll.
	 */
	public void roll() {

		int number = (int) (Math.random() * 6 + 1);
		this.numberHistory_.add(number);
		this.setCurrentNumber(number);
		this.diceIsUsed_ = false;

	}

	/**
	 * Sets the current number.
	 *
	 * @param currentNumber the new current number
	 */
	public void setCurrentNumber(int currentNumber) {
		this.currentDicedNumber_ = currentNumber;
		this.numberHistory_.add(currentNumber);
	}

	/**
	 * Sets the number history.
	 *
	 * @param numberHistory the new number history
	 */
	public void setNumberHistory(ArrayList<Integer> numberHistory) {
		this.numberHistory_ = numberHistory;
	}

	/**
	 * Sets the used.
	 */
	public void setUsed() {
		this.diceIsUsed_ = true;
	}

	/**
	 * Sets the used.
	 *
	 * @param used the new used
	 */
	public void setUsed(boolean used) {
		this.diceIsUsed_ = used;
	}

}
