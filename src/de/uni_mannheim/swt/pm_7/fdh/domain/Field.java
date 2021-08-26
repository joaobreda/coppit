/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Field.
 */
public class Field {

	/** The field color_. */
	private Paint fieldColor_;

	/** The down connections_. */
	private ArrayList<Field> downConnections_ = new ArrayList<Field>();

	/** The outline of field_. */
	private Shape outlineOfField_ = new GeneralPath();

	/** The is house_. */
	private boolean isHouse_;

	/** The is wait field_. */
	private boolean isWaitField_;

	/** The left connections_. */
	private ArrayList<Field> leftConnections_ = new ArrayList<Field>();

	/** The right connections_. */
	private ArrayList<Field> rightConnections_ = new ArrayList<Field>();

	/** The up connections_. */
	private ArrayList<Field> upConnections_ = new ArrayList<Field>();

	/** The hads on field_. */
	private ArrayList<Hat> hadsOnField_ = new ArrayList<Hat>();

	/** The temp variable_. */
	private ArrayList<Point> tempVariable_ = new ArrayList<Point>();

	/** The temtemp variable2_. */
	private ArrayList<Point> temtempVariable2_ = new ArrayList<Point>();

	/** The calctulating points_. */
	public Point[] calctulatingPoints_ = new Point[2];

	/** The dicalctulating points2_. */
	public Point[] dicalctulatingPoints2_ = new Point[2];

	/**
	 * Instantiates a new field.
	 *
	 * @param field the field
	 */
	public Field(Shape field) {
		super();
		this.outlineOfField_ = field;
		this.fieldColor_ = new Color(255, 210, 0, 255);
		this.initPoisitoninField();

	}

	/**
	 * Describe current segment.
	 *
	 * @param pi the pi
	 * @return the point[]
	 */
	public Point[] describeCurrentSegment(PathIterator pi) {
		double[] coordinates = new double[6];
		Point _1 = new Point();
		Point _2 = new Point();
		_1.setLocation(0, 0);
		_2.setLocation(0, 0);
		int type = pi.currentSegment(coordinates);
		switch (type) {
		case PathIterator.SEG_MOVETO:
			_1.setLocation(coordinates[0], coordinates[1]);
			break;
		case PathIterator.SEG_LINETO:
			_1.setLocation(coordinates[0], coordinates[1]);
			_2.setLocation(coordinates[2], coordinates[3]);
			break;
		case PathIterator.SEG_QUADTO:
			_1.setLocation(coordinates[0], coordinates[1]);
			_2.setLocation(coordinates[2], coordinates[3]);
		case PathIterator.SEG_CUBICTO:
			_1.setLocation(coordinates[0], coordinates[1]);
			_2.setLocation(coordinates[4], coordinates[5]);
			break;
		case PathIterator.SEG_CLOSE:
			_1.setLocation(coordinates[0], coordinates[1]);
			break;
		default:
			break;

		}
		Point[] temp = new Point[2];
		temp[0] = _1;
		temp[1] = _2;
		return temp;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Paint getColor() {
		return this.fieldColor_;
	}

	/**
	 * Gets the down.
	 *
	 * @return the down
	 */
	public ArrayList<Field> getDown() {
		return this.downConnections_;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public Shape getField() {
		return this.outlineOfField_;
	}

	/**
	 * Gets the hads.
	 *
	 * @return the hads
	 */
	public ArrayList<Hat> getHads() {
		return this.hadsOnField_;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public ArrayList<Field> getLeft() {
		return this.leftConnections_;
	}

	/**
	 * Gets the positions.
	 *
	 * @return the positions
	 */
	public ArrayList<Point> getPositions() {
		return this.tempVariable_;
	}

	/**
	 * Gets the pos to had.
	 *
	 * @return the pos to had
	 */
	@SuppressWarnings("finally")
	public Point getPosToHad() {
		try {
			if (!this.hadsOnField_.isEmpty()) {
				return this.tempVariable_.get((this.hadsOnField_.size()) %5);
			}
			else return  this.tempVariable_.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return this.tempVariable_.get(0);
		}
	}

	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public ArrayList<Field> getRight() {
		return this.rightConnections_;
	}

	/**
	 * Gets the up.
	 *
	 * @return the up
	 */
	public ArrayList<Field> getUp() {
		return this.upConnections_;
	}

	/**
	 * Checks for down.
	 *
	 * @return true, if successful
	 */
	public boolean hasDown() {
		if (this.downConnections_.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks for left.
	 *
	 * @return true, if successful
	 */
	public boolean hasLeft() {
		if (this.leftConnections_.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks for right.
	 *
	 * @return true, if successful
	 */
	public boolean hasRight() {
		if (this.rightConnections_.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks for up.
	 *
	 * @return true, if successful
	 */
	public boolean hasUp() {
		if (this.upConnections_.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Inits the poisitonin field.
	 */
	public void initPoisitoninField() {

		Point[] locations = new Point[2];

		PathIterator it = this.outlineOfField_.getPathIterator(null);

		do {
			locations = this.describeCurrentSegment(it);
			this.tempVariable_.add(locations[0]);
			this.tempVariable_.add(locations[1]);
			it.next();
		}

		while (!it.isDone());
		this.tempVariable_.add(locations[0]);
		this.tempVariable_.add(locations[1]);

		this.tempVariable_.add(this.outlineOfField_.getBounds().getLocation());
		double z = 0;
		double q = 0;

		Point gff = new Point();

		for (Point x : this.tempVariable_) {
			for (int i = -50; i <= 50; i += 5) {
				for (int k = -50; k <= 50; k += 5) {
					gff.setLocation(x.getX(), x.getY());
					gff.translate(i, k);
					if (this.outlineOfField_.contains(gff)) {
						this.temtempVariable2_.add(gff.getLocation());
					}
				}
			}
		}
		this.tempVariable_.addAll(this.temtempVariable2_);

		for (Point x : this.tempVariable_) {
			z += x.getX();
			q += x.getY();
		}

		Point middel = new Point();
		middel.setLocation((z / this.tempVariable_.size()),
				(q / this.tempVariable_.size()));
		this.tempVariable_.clear();
		this.tempVariable_.add(middel);

		double bi;
		double cv;

		for (double i = -0.5; i <= 0.5; i += 1) {
			for (double k = -0.5; k <= 0.5; k += 1) {
				bi = 0;
				cv = 0;
				gff.setLocation(middel.getX(), middel.getY());
				while (this.outlineOfField_.contains(gff.getLocation())) {
					gff.setLocation(middel.getX() + bi, middel.getY() + cv);
					bi += i;
					cv += k;

				}
				gff.setLocation(middel.getX() + bi / 1.5, middel.getY() + cv
						/ 1.5);
				this.tempVariable_.add(gff.getLocation());
			}
		}

	}

	/**
	 * Checks if is house.
	 *
	 * @return true, if is house
	 */
	public boolean isHouse() {
		return this.isHouse_;
	}

	/**
	 * Checks if is wait field.
	 *
	 * @return true, if is wait field
	 */
	public boolean isWaitField() {
		return this.isWaitField_;
	}

	/**
	 * Removes the hat.
	 *
	 * @param t the t
	 */
	public void removeHat(Hat t) {
		this.hadsOnField_.remove(t);
		int i = 0;
		for (Hat k : this.hadsOnField_) {
			k.translate(this.getPositions().get(i));
			i++;
		}
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.fieldColor_ = color;
	}

	/**
	 * Sets the down.
	 *
	 * @param down the new down
	 */
	public void setDown(Field down) {
		this.downConnections_.add(down);
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(Shape field) {
		this.outlineOfField_ = field;
	}

	/**
	 * Sets the hads.
	 *
	 * @param h the new hads
	 */
	public void setHads(Hat h) {
		this.hadsOnField_.add(h);
	}

	/**
	 * Sets the house.
	 *
	 * @param isHouse the new house
	 */
	public void setHouse(boolean isHouse) {
		this.isHouse_ = isHouse;
	}

	/**
	 * Sets the left.
	 *
	 * @param left the new left
	 */
	public void setLeft(Field left) {
		this.leftConnections_.add(left);
	}

	/**
	 * Sets the right.
	 *
	 * @param right the new right
	 */
	public void setRight(Field right) {
		this.rightConnections_.add(right);
	}

	/**
	 * Sets the up.
	 *
	 * @param up the new up
	 */
	public void setUp(Field up) {
		this.upConnections_.add(up);
	}

	/**
	 * Sets the wait field.
	 *
	 * @param isWaitField the new wait field
	 */
	public void setWaitField(boolean isWaitField) {
		this.isWaitField_ = isWaitField;
		this.fieldColor_ = new Color(84, 92, 43, 255);
	}

}
