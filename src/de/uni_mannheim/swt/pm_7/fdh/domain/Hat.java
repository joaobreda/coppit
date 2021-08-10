/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * The Class Hat.
 */
public class Hat extends Observable {

	/** The outline of hat_. */
	private Shape outlineOfHat_;

	/** The had color. */
	private Color hadColor;

	/** The had id. */
	private int hadID;

	/** The position of hat_. */
	private Point positionOfHat_;

	/** The field of hat_. */
	private Field fieldOfHat_;

	/** The catched hats_. */
	private Stack<Hat> catchedHats_;

	/** The hat status_. */
	private boolean hatStatus_;

	/** The source point_. */
	private Point sourcePoint_;

	/**
	 * Instantiates a new hat.
	 */
	public Hat() {

	}

	/**
	 * Instantiates a new hat.
	 *
	 * @param color the color
	 * @param nr the nr
	 * @param p the p
	 * @param f the f
	 */
	public Hat(Color color, int nr, Point p, Field f) {

		this.outlineOfHat_ = new Polygon();
		this.catchedHats_ = new Stack<Hat>();
		this.outlineOfHat_ = new Polygon();
		this.catchedHats_ = new Stack<Hat>();
		this.fieldOfHat_ = f;
		this.hadColor = color;
		this.hadID = nr;
		this.positionOfHat_ = p;
		this.init();
	}

	/**
	 * Catch hat.
	 *
	 * @param h the h
	 */
	public void catchHat(Hat h) {
		// rekAdd(h);

		if (!(h.catchedHats_.isEmpty())) {
			// h.catched.peek().setInactive();
			// this.catched.push(h.catched.pop());
			for (Hat j : h.getAllCatched()) {
				this.getField().removeHat(j);
			}

			this.catchedHats_.addAll(h.getAllCatched());
			h.catchedHats_.clear();
		}

		this.catchedHats_.push(h);
		this.getField().removeHat(h);
		h.setInactive();

		int i = 1;
		for (Hat t : this.catchedHats_) {
			t.translate(this.positionOfHat_);
			this.translatecatchedHat(t, i);
			i++;
		}
	}

	/**
	 * Contains.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean contains(Point p) {
		if (this.outlineOfHat_.contains(p)) {
			return true;
		}

		if (!this.catchedHats_.empty()) {
			for (Hat t : this.catchedHats_) {
				if (t != null) {
					if (t.getFigure().contains(p)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Gets the all catched.
	 *
	 * @return the all catched
	 */
	public ArrayList<Hat> getAllCatched() {
		ArrayList<Hat> temp = new ArrayList<Hat>();

		for (Hat t : this.catchedHats_) {
			temp.add(t);
		}

		return temp;

	}

	/**
	 * Gets the catched num.
	 *
	 * @return the catched num
	 */
	public int getCatchedNum() {
		return this.catchedHats_.size();
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public Field getField() {
		return this.fieldOfHat_;
	}

	/**
	 * Gets the figure.
	 *
	 * @return the figure
	 */
	public Shape getFigure() {
		return this.outlineOfHat_;
	}

	/**
	 * Gets the had color.
	 *
	 * @return the had color
	 */
	public Color getHadColor() {
		return this.hadColor;
	}

	/**
	 * Gets the had id.
	 *
	 * @return the had id
	 */
	public int getHadID() {
		return this.hadID;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Point2D getPosition() {
		return this.positionOfHat_;
	}

	/**
	 * Gets the source point.
	 *
	 * @return the source point
	 */
	public Point getSourcePoint() {
		return this.sourcePoint_;
	}

	/**
	 * Checks for catched.
	 *
	 * @return true, if successful
	 */
	public boolean hasCatched() {
		return !this.catchedHats_.isEmpty();
	}

	/**
	 * Inits the.
	 */
	private void init() {

		((Polygon) this.outlineOfHat_).addPoint(0, 30);
		((Polygon) this.outlineOfHat_).addPoint(10, 0);
		((Polygon) this.outlineOfHat_).addPoint(20, 30);
		AffineTransform at = AffineTransform.getTranslateInstance(
				this.positionOfHat_.getX() - 10,
				this.positionOfHat_.getY() - 15);
		Shape temp = this.outlineOfHat_;
		this.outlineOfHat_ = null;
		this.outlineOfHat_ = new Path2D.Double(temp, at);

	}

	/**
	 * Checks if is inactive.
	 *
	 * @return true, if is inactive
	 */
	public boolean isInactive() {
		return this.hatStatus_;
	}

	/**
	 * Removes the catched.
	 *
	 * @param x the x
	 */
	public void removeCatched(Hat x) {
		this.catchedHats_.remove(x);

	}

	/**
	 * Sets the catched.
	 *
	 * @param catched the new catched
	 */
	public void setCatched(Stack<Hat> catched) {
		this.catchedHats_ = catched;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(Field field) {
		this.fieldOfHat_ = field;
	}

	/**
	 * Sets the figure.
	 *
	 * @param figure the new figure
	 */
	public void setFigure(Polygon figure) {
		this.outlineOfHat_ = figure;
	}

	/**
	 * Sets the inactive.
	 */
	public void setInactive() {
		this.hatStatus_ = true;

	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Point position) {
		this.positionOfHat_ = position;
	}

	/**
	 * Sets the source pos.
	 *
	 * @param point the new source pos
	 */
	public void setSourcePos(Point point) {
		this.sourcePoint_ = point;

	}

	/**
	 * Translate.
	 *
	 * @param pointp the pointp
	 */
	public void translate(Point pointp) {

		Shape temp = this.outlineOfHat_;
		double deltaX = (pointp.x - this.positionOfHat_.x);
		double deltaY = (pointp.y - this.positionOfHat_.y);
		this.positionOfHat_ = pointp.getLocation();

		AffineTransform at = AffineTransform.getTranslateInstance(deltaX,
				deltaY);

		this.outlineOfHat_ = null;
		this.outlineOfHat_ = new Path2D.Double(temp, at);

		if (this.hasCatched()) {
			for (Hat t : this.catchedHats_) {
				if (t != null) {
					Point z = new Point();
					z.setLocation(pointp.getX(), pointp.getY()
							+ (this.catchedHats_.indexOf(t) + 1) * 10);
					t.translate(z.getLocation());
				}
			}
		}

	}

	/**
	 * Translatecatched hat.
	 *
	 * @param h the h
	 * @param nr the nr
	 */
	public void translatecatchedHat(Hat h, int nr) {
		Point p = new Point();
		p.setLocation(this.getPosition().getX(),
				(this.getPosition().getY() + nr * 10));
		h.translate(p.getLocation());
	}

}
