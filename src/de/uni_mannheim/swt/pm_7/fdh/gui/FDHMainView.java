/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

import de.uni_mannheim.swt.pm_7.fdh.eventthandler.FDHGameFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHMainView.
 */
public class FDHMainView extends JFrame {

	// TEMP FINISH BUTTON
	private JButton tempFinishButton;
	
	// Button for tutorial ingame
	private JButton tutButton;
		
	private NewGameDialog newGameDialog;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9123787512349084527L;

	/** The click. */
	private JButton click = new JButton(Messages.getString("FDHMainView.0")); //$NON-NLS-1$

	/** The gamepanel_. */
	private FDHBoardView gamepanel_;

	/** The diced number_. */
	private JLabel dicedNumber_ = new JLabel();

	/** The clicked_. */
	private ActionListener clicked_;

	/** The move. */
	private MouseMotionListener move;

	/** The new game. */
	private JButton newGame = new JButton();

	/** The close button_. */
	private JButton closeButton_;

	/** The window. */
	private static ComponentListener window;

	/** The main root pane_. */
	private JRootPane mainRootPane_;

	/** The game facade_. */
	private FDHGameFacade gameFacade_;

	/** The list of players. */
	private JList listOfPlayers;

	/** The endclick_. */
	private ActionListener endclick_;

	/** The replay forward_. */
	private JButton replayForward_;

	/** The progress bar_. */
	private JProgressBar progressBar_;

	/** The replay backward_. */
	private JButton replayBackward_;

	/** The replay forward action_. */
	private MouseListener replayForwardAction_;

	/** The replay backword action_. */
	private MouseListener replayBackwordAction_;

	/** The auto play replay_. */
	private JButton autoPlayReplay_;

	/** The played clicked_. */
	private MouseListener playedClicked_;

	/**
	 * Instantiates a new fDH main view.
	 */
	FDHMainView(NewGameDialog NGD) {
		super();
		newGameDialog = NGD;
		this.setEnabled(false);
		this.init();
	}

	/**
	 * Adds the play mouse listener.
	 */
	public void addPlayMouseListener() {
		this.move = new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {

			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (FDHMainView.this.dicedNumber_.getText() != Messages
						.getString("FDHMainView.1")) { //$NON-NLS-1$
					if (FDHMainView.this.gamepanel_.getControl()
							.getDicedStatus()) {
						FDHMainView.this.dicedNumber_.setForeground(Color.RED);
					} else {
						FDHMainView.this.dicedNumber_
								.setForeground(Color.GREEN);
					}
				}
				FDHMainView.this.upDatePlayers();

			}

		};

		this.addMouseMotionListener(this.move);
		this.gamepanel_.addMouseMotionListener(this.move);
	}

	/**
	 * Display players.
	 */
	public void displayPlayers() {

		this.listOfPlayers = new JList(this.gamepanel_.getgamecontroller()
				.getPlayerNames());
		this.listOfPlayers.setSelectedIndex(this.gamepanel_.getgamecontroller()
				.getActivePlayerIndex());
		this.listOfPlayers.setSelectionBackground(this.gamepanel_
				.getgamecontroller().getPlayerColors()[this.gamepanel_
				.getgamecontroller().getActivePlayerIndex()]);
		this.listOfPlayers.setBackground(Color.BLACK);
		this.listOfPlayers.setForeground(Color.WHITE);
		this.listOfPlayers.setEnabled(false);
		this.listOfPlayers.setFont(new Font(
				Messages.getString("FDHMainView.2"), Font.PLAIN, 30)); //$NON-NLS-1$
		this.listOfPlayers.setBounds(760, 300, 200, 400);
		this.listOfPlayers.setVisible(true);
		this.getContentPane().add(this.listOfPlayers);

	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	FDHBoardView getBoard() {
		return this.gamepanel_;
	}
	
	// Initialize class buttons
	private void initButtons() {
		this.click.setBounds(760, 50, 200, 30);
		this.click.setForeground(Color.WHITE);
		this.click.setBackground(this.getContentPane().getBackground());
		this.initDiced();

		this.closeButton_ = new JButton(Messages.getString("FDHMainView.5")); //$NON-NLS-1$
		this.closeButton_.setBounds(760, 700, 200, 30);
		this.closeButton_.setForeground(Color.WHITE);
		this.closeButton_.setBackground(this.getContentPane().getBackground());
		this.endclick_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!FDHMainView.this.gamepanel_.getControl().getFDHGame()
						.isReplayMode()) {
					FDHMainView.this.gamepanel_
							.getControl()
							.getFDHGame()
							.getPars()
							.parseMove(
									FDHMainView.this.gamepanel_.getControl()
											.getFDHGame());
				}
				System.exit(0);

			}
		};

		this.closeButton_.addActionListener(this.endclick_);
		this.closeButton_.setVisible(true);
		this.getContentPane().add(this.closeButton_);
		
		// TUTORIAL BUTTON
		this.tutButton = new JButton(Messages.getString("FDHMainView.11")); //$NON-NLS-1$
		this.tutButton.setBounds(760, 10, 200, 30);
		this.tutButton.setForeground(Color.WHITE);
		this.tutButton.setBackground(this.getContentPane().getBackground());
		this.tutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FDHMainView.this.gamepanel_.getControl().setTutorialState();
				FDHMainView.this.gamepanel_.getControl().getFDHGame().change();
		    }
		});
		this.tutButton.setVisible(true);
		this.getContentPane().add(this.tutButton);
				
		// TEMP FINISH BUTTON
		/*
		this.tempFinishButton = new JButton("Finish Game"); //$NON-NLS-1$
		this.tempFinishButton.setBounds(760, 650, 200, 30);
		this.tempFinishButton.setForeground(Color.WHITE);
		this.tempFinishButton.setBackground(this.getContentPane().getBackground());
		this.tempFinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FDHMainView.this.gamepanel_.getControl().getFDHGame().setFinished(true);
				FDHMainView.this.gamepanel_.getControl().getFDHGame().change();
		    }
		});
		this.tempFinishButton.setVisible(true);
		this.getContentPane().add(this.tempFinishButton);
		*/
		
		this.getContentPane().add(this.click);
		this.gamepanel_.setDoubleBuffered(true);

		this.getContentPane().add(this.gamepanel_);
		this.getContentPane().add(this.dicedNumber_);
	}

	/**
	 * Inits the.
	 */
	private void init() {
		this.addComponentListener(FDHMainView.window);
		this.setSize(1024, 800);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.BLACK);
		
		this.setTitle("Coppit Game");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/de/uni_mannheim/swt/pm_7/fdh/gui/coppitIcon.png"));
		
		this.gamepanel_ = new FDHBoardView(newGameDialog, this);

		this.clicked_ = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FDHMainView.this.dicedNumber_.setForeground(Color.GREEN);
				FDHMainView.this.dicedNumber_.setText(String
						.valueOf(FDHMainView.this.gamepanel_.getControl()
								.rollDice()));

			}
		};

		this.click.addActionListener(this.clicked_);

		FDHMainView.window = new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// RootExample.newgame.setLocationRelativeTo(this);

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {

			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentShown(ComponentEvent arg0) {

			}
		};

		this.addComponentListener(FDHMainView.window);

		this.gamepanel_.setBounds(0, 0, 750, 750);
		this.initButtons();
		this.setVisible(true);
		this.mainRootPane_ = this.getRootPane();
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.repaint();
	}
	
	/**
	 * Inits the button.
	 *
	 * @param button the button
	 */
	public void initButton(JButton button) {
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setVisible(true);
		this.getContentPane().add(button);
	}

	/**
	 * Inits the diced.
	 */
	public void initDiced() {
		this.dicedNumber_.setBounds(760, 120, 200, 100);
		this.dicedNumber_.setForeground(Color.WHITE);
		this.dicedNumber_.setFont(new Font(
				Messages.getString("FDHMainView.3"), Font.PLAIN, 20)); //$NON-NLS-1$
		this.dicedNumber_.setText(Messages.getString("FDHMainView.4")); //$NON-NLS-1$
	}

	/**
	 * Inits the game.
	 *
	 * @param names the names
	 * @param color the color
	 * @param computer the computer
	 */
	void initGame(String[] names, Color[] color, boolean[] computer) {
		this.addPlayMouseListener();
		this.gameFacade_ = new FDHGameFacade(this.getBoard().getControl(),
				names, color, computer);
		this.displayPlayers();
	}

	/**
	 * Inits the replay mode.
	 *
	 * @param chosenFile the chosen file
	 */
	public void initReplayMode(File chosenFile) {
		this.gameFacade_ = new FDHGameFacade(this.getBoard().getControl(),
				chosenFile);
		this.remove(this.click);
		this.replayForward_ = new JButton();
		this.replayForward_.setBounds(760, 50, 100, 50);
		this.initButton(this.replayForward_);
		this.replayBackward_ = new JButton();
		this.replayBackward_.setBounds(860, 50, 100, 50);
		this.initButton(this.replayBackward_);
		this.replayForward_.setText(Messages.getString("FDHMainView.6")); //$NON-NLS-1$
		this.replayBackward_.setText(Messages.getString("FDHMainView.7")); //$NON-NLS-1$
		this.gamepanel_.removeMouseListener(this.gamepanel_);
		this.autoPlayReplay_ = new JButton(Messages.getString("FDHMainView.10")); //$NON-NLS-1$
		this.autoPlayReplay_.setBounds(760, 200, 200, 50);
		this.initButton(this.autoPlayReplay_);
		this.playedClicked_ = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Timer time = new Timer();
				java.util.TimerTask task = new ReplayMode(
						FDHMainView.this.replayForwardAction_);
				time.schedule(task, 0, 2);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};
		this.autoPlayReplay_.addMouseListener(this.playedClicked_);
		this.replayForwardAction_ = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				FDHMainView.this.gamepanel_.getControl().next();
				FDHMainView.this.displayPlayers();
				FDHMainView.this.progressBar_
						.setValue(FDHMainView.this.gamepanel_.getControl()
								.getSequence());
				FDHMainView.this.dicedNumber_.setText(String
						.valueOf(FDHMainView.this.gamepanel_.getControl()
								.getNumber()));

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		this.replayBackward_.addMouseListener(this.replayForwardAction_);

		this.replayBackwordAction_ = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				FDHMainView.this.gamepanel_.getControl().left();
				FDHMainView.this.progressBar_
						.setValue(FDHMainView.this.gamepanel_.getControl()
								.getSequence());

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		this.replayForward_.addMouseListener(this.replayBackwordAction_);

		this.dicedNumber_.setText(Messages.getString("FDHMainView.8")); //$NON-NLS-1$
		this.progressBar_ = new JProgressBar();
		this.progressBar_.setBounds(760, 110, 200, 50);
		this.progressBar_.setForeground(Color.WHITE);
		this.progressBar_.setBackground(Color.BLACK);
		this.progressBar_.setVisible(true);
		this.getContentPane().add(this.progressBar_);
		this.progressBar_.setMaximum(this.gamepanel_.getControl().moveSize());
		this.progressBar_.setMinimum(0);
		this.getContentPane().add(this.dicedNumber_);
		this.initDiced();
		this.displayPlayers();

	}

	/**
	 * Inits the reset mode.
	 *
	 * @param tempfile the tempfile
	 */
	public void initResetMode(File tempfile) {
		this.gameFacade_ = new FDHGameFacade(this.getBoard().getControl(),
				tempfile);
		this.gamepanel_.getControl().nextEnd();
		this.gamepanel_.getControl().setComputer();
		this.displayPlayers();
		this.addPlayMouseListener();
		this.upDatePlayers();

	}

	/**
	 * Up date players.
	 */
	public synchronized void upDatePlayers() {
		try {
			this.listOfPlayers.setSelectedIndex(this.gamepanel_
					.getgamecontroller().getNextPlayerIndex());
			this.listOfPlayers.setSelectionBackground(this.gamepanel_
					.getgamecontroller().getPlayerColors()[this.gamepanel_
					.getgamecontroller().getNextPlayerIndex()]);
		} catch (Exception e) {
			
		}
	}

}
