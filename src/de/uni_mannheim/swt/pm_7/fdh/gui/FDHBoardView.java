/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.uni_mannheim.swt.pm_7.fdh.domain.Field;
import de.uni_mannheim.swt.pm_7.fdh.domain.Hat;
import de.uni_mannheim.swt.pm_7.fdh.eventthandler.FDHBoardController;

// TODO: Auto-generated Javadoc
/**
 * The Class FDHBoardView.
 */
@SuppressWarnings("deprecation")
public class FDHBoardView extends JPanel implements MouseMotionListener,
		MouseListener, Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9167189682418329408L;

	/** The stroke. */
	private BasicStroke stroke;

	/** The controller of board_. */
	private FDHBoardController controllerOfBoard_;
	
	private JButton restartGame;
	
	private JButton menuGame;
	
	private JButton exitGame;

	/**
	 * Instantiates a new fDH board view.
	 */
	public FDHBoardView(final NewGameDialog NGD, final FDHMainView FMV) {
		this.setSize(1280, 800);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.controllerOfBoard_ = new FDHBoardController();
		this.controllerOfBoard_.addObserver(this);

		this.setLayout(null);
		restartGame = new JButton(Messages.getString("FDHBoardView.12"));
		restartGame.setBounds(200, 400, 100, 30);
		restartGame.setForeground(Color.WHITE);
		restartGame.setBackground(new Color(100, 100, 100, 200));
		restartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMV.dispatchEvent(new WindowEvent(FMV, WindowEvent.WINDOW_CLOSING));
				NGD.startNewGame();
		    }
		});
		restartGame.setVisible(false);
		this.add(restartGame);
		menuGame = new JButton(Messages.getString("FDHBoardView.13"));
		menuGame.setBounds(350, 400, 100, 30);
		menuGame.setForeground(Color.WHITE);
		menuGame.setBackground(new Color(100, 100, 100, 200));
		menuGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMV.dispatchEvent(new WindowEvent(FMV, WindowEvent.WINDOW_CLOSING));
				NGD.dispatchEvent(new WindowEvent(NGD, WindowEvent.WINDOW_CLOSING));
				try {
					new NewGameDialog();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		menuGame.setVisible(false);
		this.add(menuGame);
		exitGame = new JButton(Messages.getString("FDHBoardView.14"));
		exitGame.setBounds(500, 400, 100, 30);
		exitGame.setForeground(Color.WHITE);
		exitGame.setBackground(new Color(100, 100, 100, 200));
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!getControl().getFDHGame()
						.isReplayMode()) {
							getControl()
							.getFDHGame()
							.getPars()
							.parseMove(
									getControl().getFDHGame());
				}
				System.exit(0);
		    }
		});
		exitGame.setVisible(false);
		this.add(exitGame);
	}

	/**
	 * Gets the control.
	 *
	 * @return the control
	 */
	public FDHBoardController getControl() {
		return this.controllerOfBoard_;
	}

	/**
	 * Gets the gamecontroller.
	 *
	 * @return the gamecontroller
	 */
	FDHBoardController getgamecontroller() {
		return this.controllerOfBoard_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if (this.controllerOfBoard_.isStarted()) {
			this.controllerOfBoard_.onMouseClick(e.getPoint());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent
	 * )
	 */
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		if (this.controllerOfBoard_.isStarted()) {
			this.controllerOfBoard_.onMouseMove(arg0.getPoint());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		this.controllerOfBoard_.onMouseClick(e.getPoint());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponents(g2);

		this.setStroke(new BasicStroke(50));

		try {
			// Paint Backgroung

			g2.setPaint(this.controllerOfBoard_.getBackcolor());
			g2.fillRect(0, 0, 1280, 750);
			g2.setPaint(Color.WHITE);

			// Paint Fields
			for (Field s : this.controllerOfBoard_.getFields()) {
				g2.setPaint(s.getColor());
				g2.fill(s.getField());
				g2.setPaint(Color.WHITE);

				// int i = 0;
				// for (Point m : s.getPositions())
				// {
				// if (m != null)
				// {
				// g2.drawString(String.valueOf(i), m.x, m.y);
				// i++;
				// }

				// }

			}
			for (Field f : this.controllerOfBoard_.getHouses()) {
				g2.setPaint(f.getColor());
				g2.fill(f.getField());
			}
			// Mouseover Highligt
			if (this.controllerOfBoard_.getHighlited() != null) {
				g2.setColor(new Color(100, 100, 100, 50));
				g2.fill(this.controllerOfBoard_.getHighlited().getField());
			}
			g2.setPaint(Color.GREEN);
			// Reachable Highligt
			if (this.controllerOfBoard_.getReachable() != null) {
				for (Field s : this.controllerOfBoard_.getReachable()) {
					g2.setColor(new Color(255, 255, 255, 200));
					g2.fill(s.getField());
				}
			}
			// Figures

			g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER));

			for (Hat h : this.controllerOfBoard_.getHats()) {
				if (h.hasCatched()) {
					for (int i = h.getAllCatched().size() - 1; i >= 0; i--) {
						g2.setPaint(Color.BLACK);
						g2.draw(((Hat) h.getAllCatched().toArray()[i])
								.getFigure());
						g2.setPaint(((Hat) h.getAllCatched().toArray()[i])
								.getHadColor());
						g2.fill(((Hat) h.getAllCatched().toArray()[i])
								.getFigure());
					}
				}
				g2.setPaint(Color.BLACK);
				g2.draw(h.getFigure());
				g2.setPaint(h.getHadColor());
				g2.fill(h.getFigure());
			}

			if (!this.controllerOfBoard_.getPlayersScoredHats().isEmpty()) {
				for (int i = this.controllerOfBoard_.getPlayersScoredHats()
						.size() - 1; i >= 0; i--) {
					g2.setPaint(Color.BLACK);
					g2.draw(((Hat) this.controllerOfBoard_
							.getPlayersScoredHats().toArray()[i]).getFigure());
					g2.setPaint(((Hat) this.controllerOfBoard_
							.getPlayersScoredHats().toArray()[i]).getHadColor());
					g2.fill(((Hat) this.controllerOfBoard_
							.getPlayersScoredHats().toArray()[i]).getFigure());
				}
			}

			if (this.controllerOfBoard_.isStarted()) {
				if (this.controllerOfBoard_.getWinner() != null) {
					menuGame.setVisible(true);
					restartGame.setVisible(true);
					exitGame.setVisible(true);
					g2.setPaint(new Color(100, 100, 100, 200));
					g2.fillRect(150, 250, 500, 200);
					g2.setPaint(Color.WHITE);
					Font font = new Font("Arial", Font.PLAIN, 30); //$NON-NLS-1$
					g2.setFont(font);
					g2.drawString(this.controllerOfBoard_.getWinner().getName()
							+ Messages.getString("FDHBoardView.2"), 330, //$NON-NLS-1$
							340);
					g2.drawString(Messages.getString("FDHBoardView.3") //$NON-NLS-1$
							+ this.controllerOfBoard_.getWinner()
									.getScoreHads().size(), 330, 380);
				}
				if (this.controllerOfBoard_.getOptionsMenu()) {
					menuGame.setVisible(true);
					restartGame.setVisible(true);
					exitGame.setVisible(true);
					g2.setPaint(new Color(100, 100, 100, 200));
					g2.fillRect(150, 250, 500, 200);
					g2.setPaint(Color.WHITE);
					Font font = new Font("Arial", Font.BOLD, 40); //$NON-NLS-1$
					g2.setFont(font);
					g2.drawString(Messages.getString("FDHMainView.5"), 330, 340);
				}
				if(this.controllerOfBoard_.getTutorialState()) {
					g2.setPaint(new Color(100, 100, 100, 250));
					g2.fillRect(20, 20, 740, 720);
					g2.setPaint(Color.WHITE);
					Font font = new Font("Arial", Font.PLAIN, 40); //$NON-NLS-1$
					g2.setFont(font);
					g2.drawString(Messages.getString("FDHMainView.11"), 330, 80);
					Font font2 = new Font("Arial", Font.PLAIN, 22); //$NON-NLS-1$
					g2.setFont(font2);
					g2.drawString(Messages.getString("FDHBoardView.4"), 40, 140);
					g2.drawString(Messages.getString("FDHBoardView.5"), 40, 180);
					g2.drawString(Messages.getString("FDHBoardView.6"), 40, 220);
					g2.drawString(Messages.getString("FDHBoardView.7"), 40, 260);
					g2.drawString(Messages.getString("FDHBoardView.8"), 40, 300);
					g2.drawString(Messages.getString("FDHBoardView.9"), 40, 340);
					g2.drawString(Messages.getString("FDHBoardView.10"), 40, 380);
					g2.drawString(Messages.getString("FDHBoardView.11"), 40, 460);
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		try {
			this.repaint();
			this.getParent().validate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public BasicStroke getStroke() {
		return stroke;
	}

	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

}
