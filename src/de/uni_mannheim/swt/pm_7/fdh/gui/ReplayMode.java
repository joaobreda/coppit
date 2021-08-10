/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplayMode.
 */
public class ReplayMode extends TimerTask {

	/** The auto replay listener_. */
	private MouseListener autoReplayListener_;

	/** The e. */
	private MouseEvent e;

	/**
	 * Instantiates a new replay mode.
	 *
	 * @param list the list
	 */
	public ReplayMode(MouseListener list) {
		this.autoReplayListener_ = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		this.autoReplayListener_.mouseClicked(this.e);

	}

}
