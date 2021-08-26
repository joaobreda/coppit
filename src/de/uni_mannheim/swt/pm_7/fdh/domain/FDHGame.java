/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHGame.
 */
@SuppressWarnings("deprecation")
public class FDHGame extends Observable {

	/** The dice of game_. */
	private Dice diceOfGame_;

	/** The is game started_. */
	private boolean isGameStarted_;

	/** The players in game_. */
	private ArrayList<Player> playersInGame_;

	/** The board of game_. */
	private Board boardOfGame_;

	/** The next player_. */
	private Player nextPlayer_;

	/** The active player_. */
	private Player activePlayer_;

	/** The save game xm l_. */
	private XMLParser saveGameXML_;

	/** The turn number_. */
	private int turnNumber_;

	/** The is game finished_. */
	private boolean isGameFinished_;

	/** The move of game_. */
	private ArrayList<PersistenceData> moveOfGame_;

	/** The temp player_. */
	private Player tempPlayer_;

	/** The temp hat_. */
	private Hat tempHat_;

	/** The game is replay mode_. */
	private boolean gameIsReplayMode_;

	/**
	 * Instantiates a new fDH game.
	 */
	public FDHGame() {
		super();
		this.diceOfGame_ = new Dice();
		this.boardOfGame_ = new Board();
		this.moveOfGame_ = new ArrayList<PersistenceData>();
		this.playersInGame_ = new ArrayList<Player>();
		this.saveGameXML_ = new XMLParser();
	}

	/**
	 * Adds the players.
	 *
	 * @param name the name
	 * @param c the c
	 * @param comp the comp
	 */
	public void addPlayers(String name, Color c, boolean comp) {
		this.tempPlayer_ = new Player(name, c, comp);
		this.playersInGame_.add(this.tempPlayer_);
	}

	/**
	 * Catch hads.
	 *
	 * @param s the s
	 * @param t the t
	 */
	public void catchHads(Field s, Hat t) {
		if (!s.isWaitField()) {
			for (Hat h : this.getHats()) {
				if (s.getField().contains(h.getPosition())
						&& (h.getHadColor() != t.getHadColor())
						&& !h.isInactive() && !h.equals(t)) {
					s.removeHat(h);
					t.catchHat(h);
					for (Player p : this.getPlayers()) {
						p.getHads().remove(h);
						for (Hat u : h.getAllCatched()) {
							p.getHads().remove(u);
						}
					}

					this.change();
				}
				t.translate(s.getPosToHad());
			}
		}

	}

	/**
	 * Change.
	 */
	public void change() {
		super.setChanged();
		this.notifyObservers();
	}

	/**
	 * Creates the game.
	 */
	public void CreateGame() {
		try {

			for (Player p : this.getPlayers()) {
				p.getHads().clear();
				p.getScoreHads().clear();
			}
			this.turnNumber_ = 0;

			this.playersInGame_.get(0).setactive(true);
			this.activePlayer_ = this.playersInGame_.get(0);
			this.nextPlayer_ = this.playersInGame_.get(0);
			for (Player p : this.playersInGame_) {
				if (p != null) {
					this.boardOfGame_.getHouse()
							.get(this.playersInGame_.indexOf(p))
							.setColor(p.getColor());

					for (int i = 0; i < 6; i++) {
						this.tempHat_ = new Hat(p.getColor(), i,
								this.boardOfGame_.getStartPoisitions(
										p.getColor()).get(i),
								this.boardOfGame_
										.getFieldtoPoint(this.boardOfGame_
												.getStartPoisitions(
														p.getColor()).get(i)));
						p.addHat(this.tempHat_);
					}
				}

			}
			if (this.activePlayer_.isComputer()) {
				this.gameKiMove();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Game ki move.
	 */
	public void gameKiMove() {
		this.change();
		this.diceOfGame_.roll();
		this.activePlayer_.initKImove();
		for (Hat t : this.getHats()) {
			if (t.equals(this.activePlayer_.getKIHat())) {
				t.setSourcePos((Point) this.activePlayer_.getKIHat()
						.getPosition());
			}
		}
		Field temp = this.activePlayer_
				.KImakeMove(this.getLegalReachable(
						this.activePlayer_.getKIField(),
						this.activePlayer_.getKIHat()));

		this.makeMove(this.activePlayer_.getKIHat(), temp);
	}

	/**
	 * Gets the activeplayer.
	 *
	 * @return the activeplayer
	 */
	public Player getActiveplayer() {
		return this.activePlayer_;
	}

	/**
	 * Gets the active player.
	 *
	 * @return the active player
	 */
	public Player getActivePlayer() {
		return this.activePlayer_;
	}

	/**
	 * Gets the back color.
	 *
	 * @return the back color
	 */
	public Paint getBackColor() {
		return this.boardOfGame_.getBackcolor();
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return this.boardOfGame_;
	}

	/**
	 * Gets the dice.
	 *
	 * @return the dice
	 */
	public Dice getDice() {
		return this.diceOfGame_;

	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public ArrayList<Field> getFields() {
		return this.boardOfGame_.getFields();
	}

	/**
	 * Gets the hats.
	 *
	 * @return the hats
	 */
	public ArrayList<Hat> getHats() {
		ArrayList<Hat> temp = new ArrayList<Hat>();

		for (Player p : this.playersInGame_) {
			temp.addAll(p.getHads());
		}

		return temp;
	}

	/**
	 * Gets the hosues.
	 *
	 * @return the hosues
	 */
	public ArrayList<Field> getHosues() {
		return this.boardOfGame_.getHouse();
	}

	/**
	 * Gets the legal reachable.
	 *
	 * @param s the s
	 * @param h the h
	 * @return the legal reachable
	 */
	public ArrayList<Field> getLegalReachable(Field s, Hat h) {
		ArrayList<Field> temp = new ArrayList<Field>();
		ArrayList<Field> temp_del = new ArrayList<Field>();
		temp = this.boardOfGame_.getReachableFields(
				this.diceOfGame_.getLastNumber(), s);
		for (Field f : temp) {
			if (!this.legalmove(f, h)) {
				temp_del.add(f);
			}
		}

		temp.removeAll(temp_del);

		return temp;
	}

	/**
	 * Gets the move.
	 *
	 * @return the move
	 */
	public ArrayList<PersistenceData> getMove() {
		return this.moveOfGame_;
	}

	/**
	 * Gets the move number.
	 *
	 * @return the move number
	 */
	public int getMoveNumber() {
		return this.turnNumber_;
	}

	/**
	 * Gets the nextplayer.
	 *
	 * @return the nextplayer
	 */
	public Player getNextplayer() {
		return this.nextPlayer_;
	}

	/**
	 * Gets the pars.
	 *
	 * @return the pars
	 */
	public XMLParser getPars() {
		return this.saveGameXML_;
	}

	/**
	 * Gets the player colors.
	 *
	 * @return the player colors
	 */
	public Color[] getPlayerColors() {
		int i = 0;
		Color[] temp = new Color[this.getPlayers().size()];
		for (Player p : this.getPlayers()) {
			temp[i] = p.getColor();
			i++;
		}
		return temp;

	}

	/**
	 * Gets the playeris computer.
	 *
	 * @return the playeris computer
	 */
	public boolean[] getPlayerisComputer() {
		int i = 0;
		boolean[] temp = new boolean[this.getPlayers().size()];
		for (Player p : this.getPlayers()) {
			temp[i] = p.isComputer();
			i++;
		}
		return temp;

	}

	/**
	 * Gets the player names.
	 *
	 * @return the player names
	 */
	public String[] getPlayerNames() {
		int i = 0;
		String[] temp = new String[this.getPlayers().size()];
		for (Player p : this.getPlayers()) {
			temp[i] = p.getName();
			i++;
		}
		return temp;

	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return this.playersInGame_;
	}

	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return this.isGameFinished_;
	}

	/**
	 * Checks if is replay mode.
	 *
	 * @return true, if is replay mode
	 */
	public boolean isReplayMode() {
		return this.gameIsReplayMode_;
	}

	/**
	 * Checks if is started.
	 *
	 * @return true, if is started
	 */
	public boolean isStarted() {
		return this.isGameStarted_;
	}

	/**
	 * Legalmove.
	 *
	 * @param s the s
	 * @param h the h
	 * @return true, if successful
	 */
	public boolean legalmove(Field s, Hat h) {
		if (s.isWaitField()) {
			if (s.getHads().size() > 3) {
				return false;
			}
		}
		if (s.isHouse()) {
			if ((s.getColor() != h.getHadColor())
					|| ((s.getColor() == h.getHadColor()) && (h.getCatchedNum() == 0))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Make move.
	 *
	 * @param t the t
	 * @param s the s
	 */
	public void makeMove(Hat t, Field s) {

		t.setField(s);
		s.setHads(t);

		// if (this.getFields().contains(s))
		try {
			this.boardOfGame_.getFieldtoPoint(t.getSourcePoint()).removeHat(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.translate(s.getPosToHad());
		this.catchHads(s, t);
		this.releaseHads(s, t);
		this.getDice().setUsed();
		this.moveOfGame_.add(new PersistenceData(t.getSourcePoint()
				.getLocation(), (Point) t.getPosition(), this.diceOfGame_
				.getCurrentNumber(), this.turnNumber_, this.isGameFinished_,
				this.getPlayerisComputer(), this.getPlayerNames(), this
						.getPlayerColors()));
		this.turnNumber_++;

		this.moveDone();
	}

	/**
	 * Move done.
	 */
	public void moveDone() {
		int endgamecount = 0;
		for (Player p : this.getPlayers()) {
			if (p.getHads().isEmpty()) {
				endgamecount++;
			}
		}

		if (endgamecount == this.getPlayers().size() - 1) {
			this.setFinished(true);
		} else {

			this.nextplayer();
			while (this.activePlayer_.getHads().isEmpty()) {
				this.nextplayer();
			}

			if (this.activePlayer_.isComputer()) {
				this.activePlayer_.initKImove();
				this.gameKiMove();
//				this.activePlayer_.initKImove();
				// this.change();
				// this.run();
			}
		}

	}

	/**
	 * Nextplayer.
	 */
	public void nextplayer() {
		boolean helpbool = false;
		for (Player p : this.playersInGame_) {
			if (p.isIsactive() && !helpbool) {

				System.out.println("First: "
						+ this.playersInGame_.lastIndexOf(p));
				this.nextPlayer_ = this.playersInGame_.get((this.playersInGame_
						.indexOf(p) + 1) % this.playersInGame_.size());
				System.out.println("Sec: "
						+ (this.playersInGame_.indexOf(p) + 1)
						% this.playersInGame_.size());
				this.playersInGame_.get(
						(this.playersInGame_.indexOf(p) + 1)
								% this.playersInGame_.size()).setactive(true);
				this.activePlayer_ = this.playersInGame_
						.get((this.playersInGame_.indexOf(p) + 1)
								% this.playersInGame_.size());
				p.setactive(false);
				helpbool = true;
			}
		}

	}

	/**
	 * Next playerindex.
	 *
	 * @return the int
	 */
	public int nextPlayerindex() {
		if (this.diceOfGame_.getLastNumber() == 0) {
			return this.playersInGame_.indexOf(this.activePlayer_);
		}
		return this.playersInGame_.indexOf(this.nextPlayer_);
	}

	/**
	 * Release hads.
	 *
	 * @param s the s
	 * @param t the t
	 */
	private void releaseHads(Field s, Hat t) {
		if (s.isHouse() && t.hasCatched()) {
			for (Hat x : t.getAllCatched()) {
				if (x.getHadColor().equals(t.getHadColor())) {
					for (Player p : this.getPlayers()) {
						if (p.getColor().equals(x.getHadColor())) {
							p.addHat(x);
						}
					}
					t.removeCatched(x);
					x.translate(this.boardOfGame_.getStartPoisitions(
							x.getHadColor()).get(0));
				} else {
					for (Player p : this.getPlayers()) {
						if (p.getColor().equals(t.getHadColor())) {
							p.addScoreHat(x);
							Point temppoint = new Point();
							temppoint.setLocation(
									this.boardOfGame_.getScorePosition(
											t.getHadColor()).getX() + 55,
									this.boardOfGame_.getScorePosition(
											t.getHadColor()).getY()
											- 40 + p.getScoreHads().size() * 6);
							x.translate(temppoint);
						}
					}
					t.removeCatched(x);

				}
			}
		}

	}

	/**
	 * Roll dice.
	 */
	public void rollDice() {
		if (this.diceOfGame_.getLastNumber() == 0) {
			this.diceOfGame_.roll();
		} else if (this.diceOfGame_.isUsed()) {

			this.diceOfGame_.roll();

		}

	}

	/**
	 * Sets the activeplayer.
	 *
	 * @param activeplayer the new activeplayer
	 */
	public void setActiveplayer(Player activeplayer) {
		this.activePlayer_ = activeplayer;
	}

	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(Board board) {
		this.boardOfGame_ = board;
	}

	/**
	 * Sets the dice.
	 *
	 * @param dice the new dice
	 */
	public void setDice(Dice dice) {
		this.diceOfGame_ = dice;
	}
		
	/**
	 * Sets the finished.
	 *
	 * @param isFinished the new finished
	 */
	public void setFinished(boolean isFinished) {
		this.isGameFinished_ = isFinished;
	}

	/**
	 * Sets the move number.
	 *
	 * @param moveNumber the new move number
	 */
	public void setMoveNumber(int moveNumber) {
		this.turnNumber_ = moveNumber;
	}

	/**
	 * Sets the nextplayer.
	 *
	 * @param nextplayer the new nextplayer
	 */
	public void setNextplayer(Player nextplayer) {
		this.nextPlayer_ = nextplayer;
	}

	/**
	 * Sets the pars.
	 *
	 * @param pars the new pars
	 */
	public void setPars(XMLParser pars) {
		this.saveGameXML_ = pars;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.playersInGame_ = players;
	}

	/**
	 * Sets the replay mode.
	 *
	 * @param replayMode the new replay mode
	 */
	public void setReplayMode(boolean replayMode) {
		this.gameIsReplayMode_ = replayMode;
	}

	/**
	 * Sets the started.
	 *
	 * @param isStarted the new started
	 */
	public void setStarted(boolean isStarted) {
		this.isGameStarted_ = isStarted;
	}

	/**
	 * Write object.
	 *
	 * @param out the out
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

}
