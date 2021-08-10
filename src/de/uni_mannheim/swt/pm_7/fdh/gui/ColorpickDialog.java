/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

// TODO: Auto-generated Javadoc
/**
 * The Class ColorpickDialog.
 */
public class ColorpickDialog extends JComponent implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3104509983720376577L;

	/** The color to choose_. */
	Color colorToChoose_;

	/**
	 * Instantiates a new colorpick dialog.
	 */
	ColorpickDialog() {

		this.setVisible(false);
		int a = 240;
		int b = 30;

		this.setSize(a, b);
		this.setForeground(Color.BLACK);
		this.setBackground(Color.black);

		JButton blue = new JButton();
		blue.setForeground(this.getForeground());
		blue.setBackground(Color.BLUE);
		blue.setBounds(0, 0, b, b);
		blue.addActionListener(this);
		blue.setBorder(null);
		this.add(blue);

		JButton red = new JButton();
		red.setForeground(this.getForeground());
		red.setBackground(Color.RED);
		red.setBounds(b, 0, b, b);
		red.addActionListener(this);
		red.setBorder(null);
		this.add(red);

		JButton yellow = new JButton();
		yellow.setForeground(this.getForeground());
		yellow.setBackground(Color.YELLOW);
		yellow.setBounds(2 * b, 0, b, b);
		yellow.addActionListener(this);
		yellow.setBorder(null);
		this.add(yellow);

		JButton green = new JButton();
		green.setForeground(this.getForeground());
		green.setBackground(Color.GREEN);
		green.setBounds(3 * b, 0, b, b);
		green.addActionListener(this);
		green.setBorder(null);
		this.add(green);

		JButton cyan = new JButton();
		cyan.setForeground(this.getForeground());
		cyan.setBackground(Color.CYAN);
		cyan.setBounds(4 * b, 0, b, b);
		cyan.addActionListener(this);
		cyan.setBorder(null);
		this.add(cyan);

		JButton pink = new JButton();
		pink.setForeground(this.getForeground());
		pink.setBackground(Color.PINK);
		pink.setBounds(5 * b, 0, b, b);
		pink.addActionListener(this);
		pink.setBorder(null);
		this.add(pink);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.colorToChoose_ = ((JButton) arg0.getSource()).getBackground();

		((JButton) arg0.getSource()).setText("x");
		((JButton) arg0.getSource()).repaint();

		for (Object f : this.getComponents()) {
			if (!f.equals(arg0.getSource())) {
				((JButton) f).setText(null);
			}
		}

		System.out.print(this.colorToChoose_.toString());
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return this.colorToChoose_;
	}

	/**
	 * Sets the unselected.
	 */
	public void setUnselected() {
		for (Object f : this.getComponents()) {
			((JButton) f).setText(null);
		}
		this.colorToChoose_ = null;
	}

}
