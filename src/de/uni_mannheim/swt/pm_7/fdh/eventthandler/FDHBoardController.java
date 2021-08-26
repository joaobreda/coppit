/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.eventthandler;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import de.uni_mannheim.swt.pm_7.fdh.domain.FDHGame;
import de.uni_mannheim.swt.pm_7.fdh.domain.Field;
import de.uni_mannheim.swt.pm_7.fdh.domain.Hat;
import de.uni_mannheim.swt.pm_7.fdh.domain.PersistenceData;
import de.uni_mannheim.swt.pm_7.fdh.domain.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHBoardController.
 */
public class FDHBoardController extends Observable implements Observer {

	/** The highlited field_. */
	private Field highlitedField_ = null;

	/** The help boolean_. */
	private boolean helpBoolean_ = false;

	/** The mousec cick point_. */
	private Point mousecCickPoint_;

	/** The present mouse point_. */
	private Point presentMousePoint_ = null;

	/** The reachable field list_. */
	private ArrayList<Field> reachableFieldList_ = null;

	/** The selected hat_. */
	private Hat selectedHat_ = null;

	/** The move done_. */
	private boolean moveDone_;

	/** The playes game_. */
	private FDHGame playesGame_;

	/** The data for replay_. */
	private ArrayList<PersistenceData> dataForReplay_;;

	/** The sequence of replay_. */
	private int sequenceOfReplay_;
	
	private boolean tutorialState = false;

	/**
	 * Instantiates a new fDH board controller.
	 */
	public FDHBoardController() {
		super();
		this.playesGame_ = new FDHGame();
		this.playesGame_.addObserver(this);
		for (Hat t : this.playesGame_.getHats()) {
			t.addObserver(this);
		}
	}

	/**
	 * Gets the active player index.
	 *
	 * @return the active player index
	 */
	public int getActivePlayerIndex() {
		return this.playesGame_.getPlayers().indexOf(
				this.playesGame_.getActivePlayer());
	}

	/**
	 * Gets the backcolor.
	 *
	 * @return the backcolor
	 */
	public Paint getBackcolor() {
		return this.playesGame_.getBackColor();
	}

	/**
	 * Gets the diced status.
	 *
	 * @return the diced status
	 */
	public boolean getDicedStatus() {
		return this.playesGame_.getDice().isUsed();
	}

	/**
	 * Gets the fDH game.
	 *
	 * @return the fDH game
	 */
	public FDHGame getFDHGame() {
		return this.playesGame_;

	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public ArrayList<Field> getFields() {
		return this.playesGame_.getFields();
	}

	/**
	 * Gets the hats.
	 *
	 * @return the hats
	 */
	public ArrayList<Hat> getHats() {
		return this.playesGame_.getHats();
	}

	/**
	 * Gets the highlited.
	 *
	 * @return the highlited
	 */
	public Field getHighlited() {
		return this.highlitedField_;
	}

	/**
	 * Gets the houses.
	 *
	 * @return the houses
	 */
	public ArrayList<Field> getHouses() {
		return this.playesGame_.getHosues();
	}

	/**
	 * Gets the mouseclickpoint.
	 *
	 * @return the mouseclickpoint
	 */
	public Point getMouseclickpoint() {
		return this.mousecCickPoint_;
	}

	/**
	 * Gets the mouse point.
	 *
	 * @return the mouse point
	 */
	public Point getMousePoint() {
		return this.presentMousePoint_;
	}

	/**
	 * Gets the next player index.
	 *
	 * @return the next player index
	 */
	public int getNextPlayerIndex() {
		return this.playesGame_.nextPlayerindex();
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return this.playesGame_.getDice().getLastNumber();
	}

	/**
	 * Gets the player colors.
	 *
	 * @return the player colors
	 */
	public Color[] getPlayerColors() {
		Color[] temp = new Color[this.playesGame_.getPlayers().size()];
		for (Player p : this.playesGame_.getPlayers()) {
			temp[this.playesGame_.getPlayers().indexOf(p)] = p.getColor();
		}
		return temp;
	}

	/**
	 * Gets the player names.
	 *
	 * @return the player names
	 */
	public String[] getPlayerNames() {
		String[] temp = new String[this.playesGame_.getPlayers().size()];
		for (Player p : this.playesGame_.getPlayers()) {
			temp[this.playesGame_.getPlayers().indexOf(p)] = p.getName();
		}
		return temp;
	}

	/**
	 * Gets the players scored hats.
	 *
	 * @return the players scored hats
	 */
	public ArrayList<Hat> getPlayersScoredHats() {
		ArrayList<Hat> temp = new ArrayList<Hat>();
		for (Player p : this.playesGame_.getPlayers()) {
			temp.addAll(p.getScoreHads());
		}
		return temp;
	}

	/**
	 * Gets the reachable.
	 *
	 * @return the reachable
	 */
	public ArrayList<Field> getReachable() {
		return this.reachableFieldList_;
	}

	/**
	 * Gets the sel had.
	 *
	 * @return the sel had
	 */
	public Hat getSelHad() {
		return this.selectedHat_;
	}

	/**
	 * Gets the sequence.
	 *
	 * @return the sequence
	 */
	public int getSequence() {
		return this.sequenceOfReplay_;
	}

	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public Player getWinner() {
		int j = this.playesGame_.getPlayers().get(0).getScoreHads().size();
		Player temp = this.playesGame_.getPlayers().get(0);
		if (this.playesGame_.isFinished()) {
			for (Player p : this.playesGame_.getPlayers()) {
				if (p.getScoreHads().size() > j) {
					temp = p;
				}
			}
			return temp;
		} else {
			return null;
		}

	}
	
	public boolean getTutorialState() {
		return this.tutorialState;
	}
	
	public void setTutorialState() {
		if(this.tutorialState)
			this.tutorialState = false;
		else
			this.tutorialState = true;
	}

	/**
	 * Highlight fields.
	 */
	public synchronized void highlightFields()

	{
		super.setChanged();
		super.notifyObservers();
		ArrayList<Hat> temp = this.playesGame_.getActivePlayer().getHads();
		for (Field s : this.playesGame_.getFields()) {
			for (Hat h : temp) {
				if (s.getField()
						.contains(this.presentMousePoint_.getLocation())
						&& h.contains(this.presentMousePoint_)) {
					this.highlitedField_ = s;
					if ((this.selectedHat_ == null)
							&& !this.playesGame_.getDice().isUsed()) {
						this.reachableFieldList_ = this.playesGame_
								.getLegalReachable(s, h);
					}
					super.setChanged();
					super.notifyObservers();
					this.helpBoolean_ = true;
				}
			}
		}
		for (Field s : this.playesGame_.getHosues()) {
			for (Hat h : temp) {
				if (s.getField()
						.contains(this.presentMousePoint_.getLocation())
						&& h.contains(this.presentMousePoint_)) {
					this.highlitedField_ = s;
					if ((this.selectedHat_ == null)
							&& !this.playesGame_.getDice().isUsed()) {
						this.reachableFieldList_ = this.playesGame_
								.getLegalReachable(s, h);
					}
					this.helpBoolean_ = true;
				}
			}
		}
		if (!this.helpBoolean_) {
			this.highlitedField_ = null;
			if (this.selectedHat_ == null) {
				this.reachableFieldList_ = null;
			}
			super.setChanged();
			super.notifyObservers();
		} else {
			this.helpBoolean_ = false;
		}

	}

	/**
	 * Checks if is move done.
	 *
	 * @return true, if is move done
	 */
	public boolean isMoveDone() {
		return this.moveDone_;
	}

	/**
	 * Checks if is started.
	 *
	 * @return true, if is started
	 */
	public boolean isStarted() {
		return this.playesGame_.isStarted();
	}

	/**
	 * Left.
	 */
	public void left() {

		if (this.sequenceOfReplay_ > 0) {
			this.playesGame_.CreateGame();
			for (int i = 0; i < this.sequenceOfReplay_; i++) {
				this.playesGame_.getDice().setCurrentNumber(
						this.dataForReplay_.get(i).getNumber());
				this.playesGame_.getDice().setUsed(false);
				this.onMouseMove(this.dataForReplay_.get(i).getSource());
				this.onMouseClick(this.dataForReplay_.get(i).getSource());
				System.out.println(this.dataForReplay_.get(i).getSource());
				this.onMouseClick(this.dataForReplay_.get(i).getDest());
				System.out.println(this.dataForReplay_.get(i).getDest());
			}
			this.sequenceOfReplay_--;
			super.setChanged();
			super.notifyObservers();
		}
	}

	/**
	 * Move size.
	 *
	 * @return the int
	 */
	public int moveSize() {
		return this.dataForReplay_.size();
	}

	/**
	 * Next.
	 */
	public  synchronized void  next() {
		if (this.sequenceOfReplay_ < this.dataForReplay_.size()) {
			this.playesGame_.getDice()
					.setCurrentNumber(
							this.dataForReplay_.get(this.sequenceOfReplay_)
									.getNumber());
			this.playesGame_.getDice().setUsed(false);

			this.onMouseMove(this.dataForReplay_.get(this.sequenceOfReplay_)
					.getSource());
			this.onMouseClick(this.dataForReplay_.get(this.sequenceOfReplay_)
					.getSource());
			
			super.setChanged();
			super.notifyObservers();
			
			destClick();

			super.setChanged();
			super.notifyObservers();
			this.sequenceOfReplay_++;

		}
	}

	public synchronized void destClick() {
		System.out.println(this.dataForReplay_.get(this.sequenceOfReplay_)
				.getSource());
		this.onMouseMove(this.dataForReplay_.get(this.sequenceOfReplay_)
				.getDest());
		
		this.onMouseClick(this.dataForReplay_.get(this.sequenceOfReplay_)
				.getDest());
		System.out.println(this.dataForReplay_.get(this.sequenceOfReplay_)
				.getDest());
	}

	/**
	 * Next end.
	 */
	public synchronized void nextEnd() {
		while (this.sequenceOfReplay_ < this.dataForReplay_.size()) {
			this.next();
		}

	}

	/**
	 * On mouse click.
	 *
	 * @param e the e
	 */
	public  synchronized void onMouseClick(Point e) {
		this.mousecCickPoint_ = e;
		for (Hat h : this.playesGame_.getActiveplayer().getHads()) {
			System.out.println("Entrei 1");
			if (h.contains(e) && !this.playesGame_.getDice().isUsed()
					&& (this.playesGame_.getDice().getLastNumber() != 0)
					&& (this.reachableFieldList_ != null) && (!h.isInactive())
			) {
				System.out.println("Entrei 2");
				this.selectedHat_ = h;
				h.setSourcePos(e);
				super.setChanged();
				this.notifyObservers();
			}
			if (this.reachableFieldList_ != null) {
				System.out.println("Entrei 3");
				for (Field s : this.reachableFieldList_) {
					if ((s.getField().contains((e)))
							&& this.reachableFieldList_.contains(s)) {

						for (Hat t : this.playesGame_.getHats()) {
							t.setActive();
							if (t.equals(this.selectedHat_)) {
								System.out.println("Entrei 4");
								this.selectedHat_ = null;
								this.playesGame_.makeMove(t, s);
							}
						}

						super.setChanged();
						this.notifyObservers();
					}
				}
			}

		}

	}

	/**
	 * On mouse click release.
	 *
	 * @param e the e
	 */
	public void onMouseClickRelease(MouseEvent e) {

	}

	/**
	 * On mouse move.
	 *
	 * @param arg0 the arg0
	 */
	public synchronized  void  onMouseMove(Point arg0) {
		this.presentMousePoint_ = arg0;
		this.highlightFields();

		if ((this.mousecCickPoint_ != null) && (this.selectedHat_ != null)) {
			this.selectedHat_.translate(arg0);
			super.setChanged();
			this.notifyObservers();

		}
		this.mousecCickPoint_ = arg0;

	}

	/**
	 * Replay game.
	 *
	 * @param data the data
	 */
	public void replayGame(ArrayList<PersistenceData> data) {
		this.dataForReplay_ = data;
		this.playesGame_.setStarted(true);
		this.playesGame_.setReplayMode(true);
		this.sequenceOfReplay_ = 0;

	}

	/**
	 * Roll dice.
	 *
	 * @return the int
	 */
	public int rollDice() {
		this.playesGame_.rollDice();
		this.moveDone_ = false;
		return this.playesGame_.getDice().getLastNumber();
	}

	/**
	 * Sets the computer.
	 */
	public void setComputer() {
		int i = 0;
		for (Player p : this.playesGame_.getPlayers()) {
			p.setComputer(this.dataForReplay_.get(1).getIsComputer()[i]);
			i++;
		}
	}

	/**
	 * Sets the sequence.
	 *
	 * @param sequence the new sequence
	 */
	public void setSequence(int sequence) {
		this.sequenceOfReplay_ = sequence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		super.setChanged();
		this.notifyObservers();
		this.rollDice();
	}

}
