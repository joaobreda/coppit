/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.awt.Color;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8332640072994206578L;

	/** The back board color_. */
	private Paint backBoardColor_;

	/** The background of board_. */
	private Rectangle2D backgroundOfBoard_;

	/** The list of fields_. */
	private transient ArrayList<Field> listOfFields_ = new ArrayList<Field>();

	/** The list of houses_. */
	private transient ArrayList<Field> listOfHouses_ = new ArrayList<Field>();

	/**
	 * Instantiates a new board.
	 */
	public Board() {

		this.backgroundOfBoard_ = new Rectangle2D.Double(0.0, 0.0, 750.0, 750.0);

		this.backBoardColor_ = new RadialGradientPaint(new Point2D.Double(
				400.6993103027344, 401.3985900878906), 401.1993f,
				new Point2D.Double(400.6993103027344, 401.3985900878906),
				new float[] { 0.0f, 1.0f }, new Color[] {
						new Color(79, 0, 128, 255), new Color(0, 0, 0, 255) },
				MultipleGradientPaint.CycleMethod.NO_CYCLE,
				MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(
						0.9375f, 0.0f, 0.0f, 0.9358658790588379f,
						1.2674832344055176f, 50.91816711425781f));

		this.Initiatefields();
		this.connectFields();

	}

	/**
	 * Connect fields.
	 */
	public void connectFields() {

		for (Field s : this.listOfFields_) {
			if (this.listOfFields_.indexOf(s) < 51) {
				s.setUp(this.listOfFields_.get(this.listOfFields_.indexOf(s) + 1));
				if (this.listOfFields_.indexOf(s) != 0) {
					s.setDown(this.listOfFields_.get(this.listOfFields_
							.indexOf(s) - 1));
				}
			}

			if ((this.listOfFields_.indexOf(s) < 57)
					&& (this.listOfFields_.indexOf(s) > 52)) {
				s.setRight(this.listOfFields_.get(this.listOfFields_.indexOf(s) + 1));
				s.setLeft(this.listOfFields_.get(this.listOfFields_.indexOf(s) - 1));
			}
			if ((this.listOfFields_.indexOf(s) < 70)
					&& (this.listOfFields_.indexOf(s) > 65)) {
				s.setRight(this.listOfFields_.get(this.listOfFields_.indexOf(s) - 1));
				s.setLeft(this.listOfFields_.get(this.listOfFields_.indexOf(s) + 1));
			}
			if ((this.listOfFields_.indexOf(s) < 76)
					&& (this.listOfFields_.indexOf(s) > 71)) {
				s.setRight(this.listOfFields_.get(this.listOfFields_.indexOf(s) - 1));
				s.setLeft(this.listOfFields_.get(this.listOfFields_.indexOf(s) + 1));
			}
			if ((this.listOfFields_.indexOf(s) < 64)
					&& (this.listOfFields_.indexOf(s) > 59)) {
				s.setRight(this.listOfFields_.get(this.listOfFields_.indexOf(s) - 1));
				s.setLeft(this.listOfFields_.get(this.listOfFields_.indexOf(s) + 1));
			}

		}

		this.listOfFields_.get(51).setLeft(this.listOfFields_.get(50));
		this.listOfFields_.get(52).setLeft(this.listOfFields_.get(5));
		this.listOfFields_.get(52).setRight(this.listOfFields_.get(53));

		this.listOfFields_.get(64).setLeft(this.listOfFields_.get(18));
		this.listOfFields_.get(64).setRight(this.listOfFields_.get(63));

		this.listOfFields_.get(76).setLeft(this.listOfFields_.get(31));
		this.listOfFields_.get(76).setRight(this.listOfFields_.get(75));

		this.listOfFields_.get(70).setLeft(this.listOfFields_.get(44));
		this.listOfFields_.get(70).setRight(this.listOfFields_.get(69));

		this.listOfFields_.get(57).setRight(this.listOfFields_.get(58));
		this.listOfFields_.get(59).setRight(this.listOfFields_.get(58));
		this.listOfFields_.get(65).setRight(this.listOfFields_.get(58));
		this.listOfFields_.get(71).setRight(this.listOfFields_.get(58));

		this.listOfFields_.get(57).setRight(this.listOfFields_.get(56));
		this.listOfFields_.get(59).setRight(this.listOfFields_.get(60));
		this.listOfFields_.get(65).setRight(this.listOfFields_.get(66));
		this.listOfFields_.get(71).setRight(this.listOfFields_.get(72));

		this.listOfFields_.get(0).setDown(this.listOfFields_.get(51));
		this.listOfFields_.get(51).setUp(this.listOfFields_.get(0));

		this.listOfFields_.get(18).setRight(this.listOfFields_.get(64));
		this.listOfFields_.get(5).setRight(this.listOfFields_.get(52));
		this.listOfFields_.get(44).setRight(this.listOfFields_.get(70));
		this.listOfFields_.get(31).setRight(this.listOfFields_.get(76));

		this.listOfFields_.get(58).setLeft(this.listOfFields_.get(57));
		this.listOfFields_.get(58).setLeft(this.listOfFields_.get(59));
		this.listOfFields_.get(58).setLeft(this.listOfFields_.get(65));
		this.listOfFields_.get(58).setLeft(this.listOfFields_.get(71));

		this.listOfFields_.get(5).setLeft(this.listOfHouses_.get(0));
		this.listOfFields_.get(18).setLeft(this.listOfHouses_.get(1));
		this.listOfFields_.get(31).setLeft(this.listOfHouses_.get(2));
		this.listOfFields_.get(44).setLeft(this.listOfHouses_.get(3));

		this.listOfHouses_.get(0).setRight(this.listOfFields_.get(5));
		this.listOfHouses_.get(1).setRight(this.listOfFields_.get(18));
		this.listOfHouses_.get(2).setRight(this.listOfFields_.get(31));
		this.listOfHouses_.get(3).setRight(this.listOfFields_.get(44));

		this.listOfHouses_.get(0).setColor(Color.GRAY);
		this.listOfHouses_.get(1).setColor(Color.GRAY);
		this.listOfHouses_.get(2).setColor(Color.GRAY);
		this.listOfHouses_.get(3).setColor(Color.GRAY);

		this.listOfHouses_.get(0).setHouse(true);
		this.listOfHouses_.get(1).setHouse(true);
		this.listOfHouses_.get(2).setHouse(true);
		this.listOfHouses_.get(3).setHouse(true);

		this.listOfFields_.get(15).setWaitField(true);
		this.listOfFields_.get(21).setWaitField(true);
		this.listOfFields_.get(28).setWaitField(true);
		this.listOfFields_.get(34).setWaitField(true);
		this.listOfFields_.get(42).setWaitField(true);
		this.listOfFields_.get(47).setWaitField(true);
		this.listOfFields_.get(2).setWaitField(true);
		this.listOfFields_.get(8).setWaitField(true);
		this.listOfFields_.get(62).setWaitField(true);
		this.listOfFields_.get(74).setWaitField(true);
		this.listOfFields_.get(68).setWaitField(true);
		this.listOfFields_.get(54).setWaitField(true);

	}

	/**
	 * Gets the backcolor.
	 *
	 * @return the backcolor
	 */
	public Paint getBackcolor() {
		return this.backBoardColor_;
	}

	/**
	 * Gets the background.
	 *
	 * @return the background
	 */
	public Rectangle2D getBackground() {
		return this.backgroundOfBoard_;
	}

	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public ArrayList<Field> getFields() {
		return this.listOfFields_;
	}

	/**
	 * Gets the fieldto point.
	 *
	 * @param p the p
	 * @return the fieldto point
	 */
	public Field getFieldtoPoint(Point p) {
		for (Field f : this.listOfFields_) {
			if (f.getField().contains(p)) {
				return f;
			}
		}

		for (Field f : this.listOfHouses_) {
			if (f.getField().contains(p)) {
				return f;
			}
		}

		return null;

	}

	/**
	 * Gets the house.
	 *
	 * @return the house
	 */
	public ArrayList<Field> getHouse() {
		return this.listOfHouses_;
	}

	/**
	 * Gets the houseof color.
	 *
	 * @param c the c
	 * @return the houseof color
	 */
	public Field getHouseofColor(Color c) {
		for (Field f : this.listOfHouses_) {
			if (f.getColor() == c) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Gets the reachable fields.
	 *
	 * @param number the number
	 * @param field the field
	 * @return the reachable fields
	 */
	public ArrayList<Field> getReachableFields(int number, Field field) {

		ArrayList<Field> a = new ArrayList<Field>();
		ArrayList<Field> b = new ArrayList<Field>();
		ArrayList<Field> c = new ArrayList<Field>();
		a.add(field);

		for (int i = number; i > 0; i--) {

			for (Field s : a) {

				if (s.hasUp()) {
					for (Field f : s.getUp()) {
						if (i == 1) {
							c.add(f);
						} else {
							b.add(f);
						}
					}
				}

				if (s.hasLeft()) {
					for (Field f : s.getLeft()) {
						if (i == 1) {
							c.add(f);
						} else {
							b.add(f);
						}
					}
				}

				if (s.hasRight()) {
					for (Field f : s.getRight()) {
						if (i == 1) {
							c.add(f);
						} else {
							b.add(f);
						}
					}
				}

				if (s.hasDown()) {
					for (Field f : s.getDown()) {
						if (i == 1) {
							c.add(f);
						} else {
							b.add(f);
						}
					}
				}

			}

			a.addAll(b);
			a.retainAll(b);

		}
		c.removeAll(b);
		if (number == 2) {
			while (c.contains(field)) {
				c.remove(field);
			}
		}

		return c;

	}

	/**
	 * Gets the score position.
	 *
	 * @param c the c
	 * @return the score position
	 */
	public Point getScorePosition(Color c) {
		Point temp = this.getHouseofColor(c).getPositions().get(0);
		temp.setLocation(temp.getX(), temp.getY());
		return temp;
	}

	/**
	 * Gets the start poisitions.
	 *
	 * @param teamcolor the teamcolor
	 * @return the start poisitions
	 */
	public ArrayList<Point> getStartPoisitions(Color teamcolor) {
		ArrayList<Point> temp = new ArrayList<Point>();

		for (int i = 0; i < 6; i++) {

			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX() - 30), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() - 31)));
			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX()), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() - 31)));
			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX() + 30), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() - 31)));
			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX() + -30), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() + 16)));
			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX()), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() + 16)));
			temp.add(new Point(((int) this.getHouseofColor(teamcolor)
					.getField().getBounds2D().getCenterX() + 30), ((int) this
					.getHouseofColor(teamcolor).getField().getBounds2D()
					.getCenterY() + 16)));
		}

		return temp;
	}

	/**
	 * Initiatefields.
	 */
	public void Initiatefields() {
		Shape shape = null;

		// _0_0_0
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(42.043564, 332.09705);
		((GeneralPath) shape).curveTo(22.51409, 329.65622, 6.4110866,
				327.53482, 6.2591114, 327.38287);
		((GeneralPath) shape).curveTo(5.6194687, 326.74323, 12.758383,
				286.35825, 13.66612, 285.4813);
		((GeneralPath) shape).curveTo(13.763869, 285.3869, 64.80891, 297.88187,
				87.435875, 303.53882);
		((GeneralPath) shape).lineTo(89.14663, 303.96652);
		((GeneralPath) shape).lineTo(87.567474, 311.13492);
		((GeneralPath) shape).curveTo(86.69896, 315.0775, 85.365875, 322.34915,
				84.60507, 327.29407);
		((GeneralPath) shape).lineTo(83.22179, 336.28485);
		((GeneralPath) shape).lineTo(80.386734, 336.40988);
		((GeneralPath) shape).curveTo(78.82745, 336.47858, 61.573025,
				334.53787, 42.043564, 332.09705);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));

		// _0_0_1
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(50.61999, 292.43985);
		((GeneralPath) shape).curveTo(30.862623, 287.5291, 14.595013,
				283.40875, 14.469742, 283.2835);
		((GeneralPath) shape).curveTo(14.066464, 282.88022, 20.687878,
				260.54724, 23.83682, 251.6898);
		((GeneralPath) shape).curveTo(25.514908, 246.96965, 27.321022,
				243.1077, 27.850374, 243.1077);
		((GeneralPath) shape).curveTo(28.379745, 243.1077, 44.772247,
				249.15573, 64.278145, 256.54776);
		((GeneralPath) shape).lineTo(99.74341, 269.98782);
		((GeneralPath) shape).lineTo(96.73615, 278.61603);
		((GeneralPath) shape).curveTo(95.08218, 283.36154, 92.85467, 290.46252,
				91.786156, 294.396);
		((GeneralPath) shape).curveTo(90.137535, 300.46506, 89.59355,
				301.53418, 88.19295, 301.4581);
		((GeneralPath) shape).curveTo(87.28518, 301.4088, 70.37735, 297.3506,
				50.619987, 292.43985);
		((GeneralPath) shape).lineTo(50.619987, 292.43985);
		((GeneralPath) shape).closePath();
		this.listOfFields_.add(new Field(shape));

		// _0_0_2
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(64.06552, 254.33868);
		((GeneralPath) shape).curveTo(44.510574, 246.88983, 28.403751,
				240.71788, 28.272594, 240.62325);
		((GeneralPath) shape).curveTo(27.79983, 240.28212, 34.60246, 224.07083,
				39.8721, 212.98059);
		((GeneralPath) shape).curveTo(44.0101, 204.27193, 45.546192, 201.76424,
				46.51494, 202.13596);
		((GeneralPath) shape).curveTo(47.677216, 202.58195, 113.27964,
				236.93498, 113.7029, 237.31924);
		((GeneralPath) shape).curveTo(113.80637, 237.41324, 111.380646,
				242.98375, 108.312416, 249.69829);
		((GeneralPath) shape).curveTo(105.244194, 256.41284, 102.235176,
				263.28583, 101.62572, 264.97162);
		((GeneralPath) shape).curveTo(101.01625, 266.6574, 100.31562,
				268.00186, 100.06878, 267.95935);
		((GeneralPath) shape).curveTo(99.82193, 267.91684, 83.62045, 261.7875,
				64.06553, 254.33868);
		((GeneralPath) shape).closePath();
		this.listOfFields_.add(new Field(shape));

		// _0_0_3

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(80.82106, 217.63792);
		((GeneralPath) shape).curveTo(62.38997, 207.93732, 47.177116,
				199.88121, 47.01474, 199.73547);
		((GeneralPath) shape).curveTo(45.83948, 198.68056, 67.87007, 163.13353,
				69.3477, 163.70055);
		((GeneralPath) shape).curveTo(69.87145, 163.90152, 84.29404, 173.72328,
				101.39786, 185.52666);
		((GeneralPath) shape).lineTo(132.49574, 206.98735);
		((GeneralPath) shape).lineTo(126.17936, 216.87408);
		((GeneralPath) shape).curveTo(122.70534, 222.3118, 118.88819, 228.6918,
				117.69679, 231.05188);
		((GeneralPath) shape).curveTo(116.505394, 233.41196, 115.260956,
				235.32774, 114.93137, 235.30916);
		((GeneralPath) shape).curveTo(114.60181, 235.29056, 99.25215,
				227.33853, 80.821045, 217.63792);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_4

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(102.48066, 183.77614);
		((GeneralPath) shape).curveTo(85.62295, 172.11398, 71.506454,
				162.09335, 71.11068, 161.5081);
		((GeneralPath) shape).curveTo(70.293045, 160.299, 75.83746, 152.45883,
				88.4035, 137.05489);
		((GeneralPath) shape).curveTo(96.19991, 127.49774, 96.24863, 127.45653,
				97.92996, 128.99092);
		((GeneralPath) shape).curveTo(98.85946, 129.83916, 111.75751, 141.2569,
				126.5923, 154.36366);
		((GeneralPath) shape).curveTo(141.42708, 167.47043, 153.65604,
				178.4553, 153.76776, 178.7745);
		((GeneralPath) shape).curveTo(153.87947, 179.09369, 151.48874,
				182.3534, 148.45502, 186.01822);
		((GeneralPath) shape).curveTo(145.4213, 189.68306, 140.91623,
				195.46568, 138.44377, 198.86848);
		((GeneralPath) shape).curveTo(135.97131, 202.27133, 133.76447,
				205.03847, 133.5397, 205.01773);
		((GeneralPath) shape).curveTo(133.31494, 204.99702, 119.33837,
				195.43826, 102.48065, 183.7761);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_5

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(126.9888, 151.78935);
		((GeneralPath) shape).curveTo(111.26164, 137.8683, 98.393936,
				126.10579, 98.393936, 125.65038);
		((GeneralPath) shape).curveTo(98.393936, 125.195, 104.98733,
				118.229034, 113.045906, 110.170456);
		((GeneralPath) shape).lineTo(127.697876, 95.51846);
		((GeneralPath) shape).lineTo(131.28708, 99.43021);
		((GeneralPath) shape).curveTo(133.26115, 101.58167, 144.86046,
				114.61259, 157.06331, 128.38783);
		((GeneralPath) shape).lineTo(179.25034, 153.43369);
		((GeneralPath) shape).lineTo(167.41699, 165.267);
		((GeneralPath) shape).lineTo(155.58368, 177.10031);
		((GeneralPath) shape).lineTo(126.9888, 151.78934);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_6

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(162.39937, 131.28601);
		((GeneralPath) shape).curveTo(152.4237, 119.96262, 140.96815,
				106.99965, 136.9426, 102.47937);
		((GeneralPath) shape).lineTo(129.62341, 94.26071);
		((GeneralPath) shape).lineTo(137.09863, 88.01921);
		((GeneralPath) shape).curveTo(144.94925, 81.46424, 163.11139, 67.64672,
				163.42078, 67.99365);
		((GeneralPath) shape).curveTo(164.31816, 69.00003, 206.54471,
				130.51398, 206.76215, 131.13164);
		((GeneralPath) shape).curveTo(206.92038, 131.58116, 203.47519,
				134.58455, 199.10614, 137.80582);
		((GeneralPath) shape).curveTo(194.7371, 141.02707, 189.02615,
				145.53268, 186.41515, 147.81827);
		((GeneralPath) shape).curveTo(183.80414, 150.10388, 181.41342,
				151.95142, 181.10243, 151.92395);
		((GeneralPath) shape).curveTo(180.79143, 151.89645, 172.37506,
				142.6094, 162.39938, 131.28603);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_7

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(187.48439, 99.05554);
		((GeneralPath) shape).curveTo(175.57161, 81.80398, 165.7186, 67.39266,
				165.5888, 67.03035);
		((GeneralPath) shape).curveTo(165.17935, 65.88734, 198.9577, 44.901867,
				201.207, 44.901867);
		((GeneralPath) shape).curveTo(201.63153, 44.901867, 210.03224,
				60.25772, 219.87521, 79.02598);
		((GeneralPath) shape).lineTo(237.77155, 113.150055);
		((GeneralPath) shape).lineTo(230.40521, 117.26877);
		((GeneralPath) shape).curveTo(226.3537, 119.53405, 219.91249,
				123.42023, 216.09142, 125.90474);
		((GeneralPath) shape).lineTo(209.144, 130.42201);
		((GeneralPath) shape).lineTo(187.48439, 99.05554);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_8

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(221.81282, 78.29871);
		((GeneralPath) shape).curveTo(212.14772, 59.830826, 204.1226,
				44.409492, 203.97919, 44.02908);
		((GeneralPath) shape).curveTo(203.48186, 42.709812, 241.54066,
				25.103312, 242.57846, 26.172575);
		((GeneralPath) shape).curveTo(242.95206, 26.5575, 270.0361, 97.85951,
				270.0361, 98.458115);
		((GeneralPath) shape).curveTo(270.0361, 98.67175, 269.57565, 98.84656,
				269.0129, 98.84656);
		((GeneralPath) shape).curveTo(268.45013, 98.84656, 261.55447,
				101.78901, 253.68922, 105.38531);
		((GeneralPath) shape).curveTo(245.82393, 108.98162, 239.38805,
				111.9134, 239.38722, 111.90037);
		((GeneralPath) shape).curveTo(239.38638, 111.88747, 231.4779, 96.76658,
				221.8128, 78.29872);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_9

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(258.75793, 62.27042);
		((GeneralPath) shape).curveTo(251.49704, 43.052643, 245.45523,
				26.80809, 245.33171, 26.171413);
		((GeneralPath) shape).curveTo(245.18333, 25.40661, 247.18713,
				24.217314, 251.23721, 22.666342);
		((GeneralPath) shape).curveTo(258.21817, 19.993023, 284.86505,
				12.052465, 285.32196, 12.509366);
		((GeneralPath) shape).curveTo(286.10706, 13.29445, 303.63956,
				85.984055, 303.27377, 86.937355);
		((GeneralPath) shape).curveTo(303.0436, 87.53718, 300.8961, 88.48892,
				298.5015, 89.05229);
		((GeneralPath) shape).curveTo(296.10693, 89.615685, 289.26477,
				91.68206, 283.29663, 93.64424);
		((GeneralPath) shape).curveTo(277.32852, 95.60645, 272.33618, 97.21187,
				272.20255, 97.21187);
		((GeneralPath) shape).curveTo(272.0689, 97.21187, 266.01886, 81.488205,
				258.75797, 62.27042);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_10

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(305.26654, 83.60615);
		((GeneralPath) shape).curveTo(304.8038, 81.87375, 300.62454, 64.98632,
				295.97928, 46.07852);
		((GeneralPath) shape).lineTo(287.53333, 11.70073);
		((GeneralPath) shape).lineTo(297.78796, 9.485219);
		((GeneralPath) shape).curveTo(310.41324, 6.7575417, 328.84082,
				3.718235, 329.39484, 4.272239);
		((GeneralPath) shape).curveTo(329.82144, 4.698843, 338.65543,
				75.810555, 338.67932, 79.010414);
		((GeneralPath) shape).curveTo(338.68832, 80.25446, 338.1086, 80.949486,
				336.85394, 81.19773);
		((GeneralPath) shape).curveTo(335.37103, 81.49115, 319.03876, 84.44644,
				308.30127, 86.36423);
		((GeneralPath) shape).curveTo(306.33325, 86.715744, 306.02148,
				86.43243, 305.26657, 83.60615);
		((GeneralPath) shape).lineTo(305.26657, 83.60615);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_11

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(340.87268, 78.27145);
		((GeneralPath) shape).curveTo(339.51746, 70.558815, 332.03827,
				5.5156784, 332.39868, 4.576538);
		((GeneralPath) shape).curveTo(332.83118, 3.449502, 346.84674,
				2.0497952, 365.86963, 1.2338412);
		((GeneralPath) shape).lineTo(374.65607, 0.8569702);
		((GeneralPath) shape).lineTo(374.65607, 39.565228);
		((GeneralPath) shape).lineTo(374.65607, 78.27348);
		((GeneralPath) shape).lineTo(368.73032, 78.72752);
		((GeneralPath) shape).curveTo(365.47116, 78.97721, 358.75873, 79.40002,
				353.81378, 79.66708);
		((GeneralPath) shape).curveTo(348.86887, 79.93414, 344.0417, 80.341194,
				343.08673, 80.571625);
		((GeneralPath) shape).curveTo(341.6395, 80.92088, 341.2709, 80.538124,
				340.87265, 78.271454);
		((GeneralPath) shape).lineTo(340.87265, 78.271454);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_12

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(403.2631, 80.01197);
		((GeneralPath) shape).curveTo(400.3411, 79.68715, 394.7834, 79.37838,
				390.9127, 79.32583);
		((GeneralPath) shape).curveTo(387.04196, 79.27323, 382.16855, 78.99642,
				380.0829, 78.71054);
		((GeneralPath) shape).lineTo(376.29074, 78.19078);
		((GeneralPath) shape).lineTo(376.29074, 39.49718);
		((GeneralPath) shape).lineTo(376.29074, 0.8036003);
		((GeneralPath) shape).lineTo(385.48587, 1.2118013);
		((GeneralPath) shape).curveTo(390.54315, 1.4363123, 400.29565,
				2.0323443, 407.15802, 2.5363302);
		((GeneralPath) shape).lineTo(419.63504, 3.4526472);
		((GeneralPath) shape).lineTo(419.08005, 7.626059);
		((GeneralPath) shape).curveTo(418.77478, 9.921435, 416.65167,
				27.217474, 414.36203, 46.061695);
		((GeneralPath) shape).curveTo(412.07236, 64.90592, 409.8338, 80.38663,
				409.3874, 80.46326);
		((GeneralPath) shape).curveTo(408.941, 80.539955, 406.1851, 80.336815,
				403.26306, 80.01198);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_13

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(440.59094, 85.75194);
		((GeneralPath) shape).curveTo(439.31863, 85.37025, 432.51422, 84.07853,
				425.47006, 82.88142);
		((GeneralPath) shape).curveTo(418.42593, 81.6843, 412.5647, 80.612366,
				412.44507, 80.49933);
		((GeneralPath) shape).curveTo(412.32538, 80.386246, 414.2564, 63.68029,
				416.7361, 43.374897);
		((GeneralPath) shape).curveTo(419.21582, 23.069496, 421.24466,
				5.8688164, 421.24466, 5.151169);
		((GeneralPath) shape).curveTo(421.24466, 3.6460018, 424.00214,
				3.857596, 440.04355, 6.5936747);
		((GeneralPath) shape).curveTo(454.499, 9.059228, 463.90375, 11.420618,
				463.5421, 12.493784);
		((GeneralPath) shape).curveTo(463.3678, 13.010987, 459.20468, 29.89041,
				454.29074, 50.003624);
		((GeneralPath) shape).curveTo(447.38196, 78.281845, 445.07834,
				86.55867, 444.13028, 86.50948);
		((GeneralPath) shape).curveTo(443.456, 86.47448, 441.86328, 86.13361,
				440.59094, 85.751945);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_14

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(473.14597, 95.02443);
		((GeneralPath) shape).curveTo(469.99918, 93.92829, 463.02866, 91.7523,
				457.6559, 90.18894);
		((GeneralPath) shape).curveTo(452.28314, 88.625595, 447.7718, 87.23101,
				447.63068, 87.08988);
		((GeneralPath) shape).curveTo(447.35107, 86.81028, 465.40308,
				12.825287, 465.882, 12.287987);
		((GeneralPath) shape).curveTo(466.35184, 11.760835, 476.11066,
				14.517436, 492.0715, 19.685795);
		((GeneralPath) shape).lineTo(506.9103, 24.490822);
		((GeneralPath) shape).lineTo(501.3894, 38.9874);
		((GeneralPath) shape).curveTo(498.3529, 46.96052, 492.26144, 63.046906,
				487.85278, 74.734924);
		((GeneralPath) shape).curveTo(483.44415, 86.42294, 479.6189, 96.217964,
				479.35223, 96.50166);
		((GeneralPath) shape).curveTo(479.08557, 96.78535, 476.29276,
				96.120575, 473.146, 95.02444);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_15

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(508.29175, 109.69411);
		((GeneralPath) shape).curveTo(506.9431, 108.9553, 500.50757, 106.03155,
				493.9905, 103.196884);
		((GeneralPath) shape).curveTo(487.47348, 100.36222, 482.0443, 97.75185,
				481.9257, 97.39604);
		((GeneralPath) shape).curveTo(481.7315, 96.81343, 507.30066, 28.669945,
				508.57675, 26.369225);
		((GeneralPath) shape).curveTo(508.94995, 25.696394, 511.91913,
				26.57946, 518.50854, 29.323082);
		((GeneralPath) shape).curveTo(526.73846, 32.749733, 546.99756,
				42.059364, 547.6548, 42.71662);
		((GeneralPath) shape).curveTo(548.1086, 43.17039, 512.3746, 110.586624,
				511.5611, 110.81146);
		((GeneralPath) shape).curveTo(511.11154, 110.93575, 509.64035,
				110.432884, 508.29175, 109.6941);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_16

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(534.8554, 124.86313);
		((GeneralPath) shape).curveTo(530.5848, 122.17076, 524.0659, 118.27794,
				520.36896, 116.21241);
		((GeneralPath) shape).lineTo(513.6473, 112.4569);
		((GeneralPath) shape).lineTo(515.9696, 108.30809);
		((GeneralPath) shape).curveTo(517.2469, 106.02626, 525.3617, 90.64247,
				534.0025, 74.12191);
		((GeneralPath) shape).curveTo(542.6433, 57.60136, 549.8941, 44.084534,
				550.1154, 44.084534);
		((GeneralPath) shape).curveTo(551.16797, 44.084534, 584.1659,
				63.914783, 586.2273, 65.78615);
		((GeneralPath) shape).curveTo(586.3857, 65.92992, 576.6786, 80.32364,
				564.656, 97.77224);
		((GeneralPath) shape).curveTo(552.6334, 115.22082, 542.7571, 129.55576,
				542.7085, 129.62762);
		((GeneralPath) shape).curveTo(542.6599, 129.69952, 539.12604,
				127.55548, 534.8554, 124.86312);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_17

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(564.5113, 146.44589);
		((GeneralPath) shape).curveTo(561.36945, 143.8209, 555.6184, 139.31763,
				551.7312, 136.43858);
		((GeneralPath) shape).curveTo(547.844, 133.55954, 544.67633, 131.0038,
				544.6919, 130.75912);
		((GeneralPath) shape).curveTo(544.7523, 129.81349, 587.6374, 68.311295,
				588.4179, 68.05113);
		((GeneralPath) shape).curveTo(589.8908, 67.56015, 620.5256, 91.35575,
				621.22473, 93.53383);
		((GeneralPath) shape).curveTo(621.47644, 94.318, 572.2493, 150.49971,
				570.88684, 150.98325);
		((GeneralPath) shape).curveTo(570.5221, 151.1127, 567.6531, 149.07088,
				564.5112, 146.44589);
		((GeneralPath) shape).lineTo(564.5112, 146.44589);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_18

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(584.17896, 164.56429);
		((GeneralPath) shape).lineTo(572.6104, 152.82799);
		((GeneralPath) shape).lineTo(597.9484, 124.20259);
		((GeneralPath) shape).curveTo(611.88434, 108.45861, 623.585, 95.577194,
				623.9499, 95.577194);
		((GeneralPath) shape).curveTo(624.31476, 95.577194, 631.3007,
				102.27779, 639.4741, 110.46739);
		((GeneralPath) shape).curveTo(653.54333, 124.56449, 654.2529,
				125.424324, 652.7958, 126.60993);
		((GeneralPath) shape).curveTo(651.9493, 127.29873, 639.0091, 138.7125,
				624.03986, 151.9739);
		((GeneralPath) shape).curveTo(609.0706, 165.23529, 596.5811, 176.13393,
				596.2853, 176.19307);
		((GeneralPath) shape).curveTo(595.9895, 176.25217, 590.5416, 171.01926,
				584.17896, 164.5643);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_19

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(613.9306, 198.7314);
		((GeneralPath) shape).curveTo(611.79376, 195.71648, 607.3089,
				189.96277, 603.96423, 185.94537);
		((GeneralPath) shape).curveTo(600.61957, 181.928, 598.0564, 178.36047,
				598.2683, 178.0176);
		((GeneralPath) shape).curveTo(599.0442, 176.7622, 655.00543, 127.4549,
				655.60834, 127.495415);
		((GeneralPath) shape).curveTo(657.4758, 127.620964, 682.448, 160.02325,
				681.42303, 160.99088);
		((GeneralPath) shape).curveTo(679.9708, 162.3618, 618.8454, 204.28166,
				618.34705, 204.24847);
		((GeneralPath) shape).curveTo(618.0549, 204.22887, 616.06744, 201.7463,
				613.9306, 198.7314);
		((GeneralPath) shape).lineTo(613.9306, 198.7314);
		((GeneralPath) shape).closePath();
		this.listOfFields_.add(new Field(shape));// _0_0_20

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(634.56995, 230.65361);
		((GeneralPath) shape).curveTo(633.44684, 228.52405, 629.66003,
				222.21532, 626.15466, 216.63419);
		((GeneralPath) shape).curveTo(622.64935, 211.05309, 620.0747,
				206.22508, 620.4333, 205.90526);
		((GeneralPath) shape).curveTo(621.1463, 205.26926, 677.77057,
				166.20297, 681.285, 163.9224);
		((GeneralPath) shape).lineTo(683.45337, 162.51526);
		((GeneralPath) shape).lineTo(687.8949, 169.3004);
		((GeneralPath) shape).curveTo(692.9889, 177.08224, 698.3662, 185.96681,
				702.6751, 193.72067);
		((GeneralPath) shape).lineTo(705.66205, 199.09566);
		((GeneralPath) shape).lineTo(671.87244, 216.81062);
		((GeneralPath) shape).curveTo(653.28815, 226.55385, 637.7519,
				234.52557, 637.34735, 234.52557);
		((GeneralPath) shape).curveTo(636.9429, 234.52557, 635.693, 232.78319,
				634.56995, 230.65361);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_21

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(651.0299, 265.47183);
		((GeneralPath) shape).curveTo(648.96, 260.0332, 645.41364, 252.08987,
				641.8865, 244.99216);
		((GeneralPath) shape).lineTo(637.9489, 237.0685);
		((GeneralPath) shape).lineTo(671.6102, 219.38467);
		((GeneralPath) shape).curveTo(690.12396, 209.65858, 705.6188,
				201.63838, 706.04315, 201.56201);
		((GeneralPath) shape).curveTo(708.0097, 201.20818, 725.1108, 239.4259,
				723.4064, 240.36566);
		((GeneralPath) shape).curveTo(722.2139, 241.02315, 655.15436,
				266.46826, 653.1805, 267.0122);
		((GeneralPath) shape).curveTo(652.2356, 267.27255, 651.52026,
				266.76016, 651.0299, 265.4718);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_22

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(661.52576, 297.32635);
		((GeneralPath) shape).curveTo(660.9584, 294.92798, 658.7504, 287.69894,
				656.6194, 281.26184);
		((GeneralPath) shape).lineTo(652.7446, 269.558);
		((GeneralPath) shape).lineTo(654.8964, 268.7311);
		((GeneralPath) shape).curveTo(656.0799, 268.2763, 670.60706, 262.76285,
				687.179, 256.4789);
		((GeneralPath) shape).curveTo(703.751, 250.19498, 719.0749, 244.35786,
				721.23224, 243.50752);
		((GeneralPath) shape).lineTo(725.15466, 241.96146);
		((GeneralPath) shape).lineTo(728.3987, 251.1167);
		((GeneralPath) shape).curveTo(731.84924, 260.85483, 737.5566,
				280.15564, 737.5566, 282.0865);
		((GeneralPath) shape).curveTo(737.5566, 282.93286, 727.8475, 285.62903,
				701.38916, 292.13004);
		((GeneralPath) shape).curveTo(681.4971, 297.01767, 664.62225,
				301.16748, 663.8896, 301.35184);
		((GeneralPath) shape).curveTo(662.86694, 301.6092, 662.3178, 300.67398,
				661.52576, 297.3264);
		((GeneralPath) shape).lineTo(661.52576, 297.3264);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_23

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(668.19556, 329.54178);
		((GeneralPath) shape).curveTo(667.6363, 325.6083, 666.3153, 318.34418,
				665.2602, 313.39926);
		((GeneralPath) shape).curveTo(664.205, 308.4543, 663.5808, 304.1756,
				663.87305, 303.891);
		((GeneralPath) shape).curveTo(664.4516, 303.32758, 733.4662, 286.20163,
				736.6381, 285.8344);
		((GeneralPath) shape).curveTo(739.30475, 285.52567, 740.0439,
				288.60895, 746.10645, 325.33145);
		((GeneralPath) shape).lineTo(746.4571, 327.45554);
		((GeneralPath) shape).lineTo(733.6291, 329.2397);
		((GeneralPath) shape).curveTo(720.71564, 331.03574, 672.8582, 336.6822,
				670.48645, 336.68954);
		((GeneralPath) shape).curveTo(669.5066, 336.69354, 668.97766, 335.0423,
				668.19556, 329.54175);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_24

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(671.0752, 360.19217);
		((GeneralPath) shape).curveTo(670.7823, 353.3367, 670.3066, 345.80447,
				670.01807, 343.45386);
		((GeneralPath) shape).curveTo(669.61597, 340.17828, 669.7582,
				339.09918, 670.62695, 338.83383);
		((GeneralPath) shape).curveTo(671.25037, 338.64337, 684.0819,
				337.11417, 699.1415, 335.43555);
		((GeneralPath) shape).curveTo(714.201, 333.75693, 730.93616, 331.74048,
				736.3306, 330.95456);
		((GeneralPath) shape).curveTo(741.7251, 330.16867, 746.2364, 329.61157,
				746.3557, 329.71658);
		((GeneralPath) shape).curveTo(746.9814, 330.26733, 748.99493, 356.3036,
				748.9971, 363.87018);
		((GeneralPath) shape).lineTo(749.00006, 372.65662);
		((GeneralPath) shape).lineTo(710.3042, 372.65662);
		((GeneralPath) shape).lineTo(671.60834, 372.65662);
		((GeneralPath) shape).lineTo(671.07587, 360.19214);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_25

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(706.6186, 412.83054);
		((GeneralPath) shape).lineTo(669.5505, 408.2572);
		((GeneralPath) shape).lineTo(670.0278, 404.96478);
		((GeneralPath) shape).curveTo(670.2903, 403.15393, 670.7535, 395.51163,
				671.05707, 387.98184);
		((GeneralPath) shape).lineTo(671.6091, 374.29135);
		((GeneralPath) shape).lineTo(710.30426, 374.29135);
		((GeneralPath) shape).lineTo(748.9994, 374.29135);
		((GeneralPath) shape).lineTo(748.9904, 383.48645);
		((GeneralPath) shape).curveTo(748.98145, 392.28564, 747.8589,
				409.34778, 746.91833, 414.9542);
		((GeneralPath) shape).curveTo(746.60876, 416.7995, 746.0473, 417.579,
				745.0794, 417.5072);
		((GeneralPath) shape).curveTo(744.3131, 417.4504, 727.00543, 415.34586,
				706.618, 412.83054);
		((GeneralPath) shape).lineTo(706.618, 412.83054);
		((GeneralPath) shape).closePath();
		this.listOfFields_.add(new Field(shape));

		// _0_0_26

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(699.9424, 452.4619);
		((GeneralPath) shape).lineTo(663.55414, 443.35687);
		((GeneralPath) shape).lineTo(665.77637, 432.32275);
		((GeneralPath) shape).curveTo(666.9986, 426.25397, 668.2489, 418.8059,
				668.5548, 415.7715);
		((GeneralPath) shape).curveTo(668.8607, 412.73712, 669.2602, 410.25446,
				669.4425, 410.25446);
		((GeneralPath) shape).curveTo(669.6248, 410.25446, 686.434, 412.27737,
				706.7964, 414.74985);
		((GeneralPath) shape).curveTo(727.1587, 417.22232, 744.4371, 419.24524,
				745.19275, 419.24524);
		((GeneralPath) shape).curveTo(746.34155, 419.24524, 746.4861, 419.8146,
				746.0746, 422.71896);
		((GeneralPath) shape).curveTo(744.7492, 432.07297, 743.0416, 441.8678,
				741.0874, 451.326);
		((GeneralPath) shape).curveTo(739.39197, 459.53162, 738.6575,
				461.72797, 737.63245, 461.65704);
		((GeneralPath) shape).curveTo(736.91644, 461.60745, 719.956, 457.46973,
				699.94244, 452.46194);
		((GeneralPath) shape).lineTo(699.94244, 452.46194);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_27

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(689.742, 491.51273);
		((GeneralPath) shape).curveTo(670.4118, 484.1678, 654.2655, 478.03357,
				653.86127, 477.88116);
		((GeneralPath) shape).curveTo(653.45703, 477.72873, 654.2992, 474.0834,
				655.7327, 469.7804);
		((GeneralPath) shape).curveTo(657.16626, 465.47742, 659.38104,
				458.32352, 660.6545, 453.88284);
		((GeneralPath) shape).curveTo(662.5819, 447.16147, 663.22687,
				445.83752, 664.5044, 445.97986);
		((GeneralPath) shape).curveTo(666.0165, 446.14832, 735.4086, 463.10608,
				737.3068, 463.77097);
		((GeneralPath) shape).curveTo(738.0174, 464.01987, 737.7213, 466.18243,
				736.21906, 471.71643);
		((GeneralPath) shape).curveTo(733.4345, 481.97418, 726.1755, 504.11954,
				725.46185, 504.53384);
		((GeneralPath) shape).curveTo(725.14606, 504.71716, 709.07214,
				498.85767, 689.74194, 491.5127);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_28

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(672.5778, 528.23444);
		((GeneralPath) shape).curveTo(654.1467, 518.5366, 638.97144, 510.51794,
				638.855, 510.41504);
		((GeneralPath) shape).curveTo(638.7385, 510.3122, 640.7864, 505.6644,
				643.4059, 500.08673);
		((GeneralPath) shape).curveTo(646.0253, 494.50906, 649.033, 487.73865,
				650.08954, 485.0414);
		((GeneralPath) shape).curveTo(651.1461, 482.34418, 652.0923, 480.0244,
				652.19214, 479.88638);
		((GeneralPath) shape).curveTo(652.3938, 479.6077, 723.795, 506.56177,
				724.365, 507.13177);
		((GeneralPath) shape).curveTo(725.2821, 508.0489, 708.065, 545.9649,
				706.76086, 545.90015);
		((GeneralPath) shape).curveTo(706.39124, 545.88184, 691.0089,
				537.93225, 672.5778, 528.2345);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_29

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(651.5427, 562.815);
		((GeneralPath) shape).curveTo(634.579, 551.0577, 620.6944, 541.1589,
				620.688, 540.8176);
		((GeneralPath) shape).curveTo(620.682, 540.4764, 622.62274, 537.16614,
				625.00146, 533.46155);
		((GeneralPath) shape).curveTo(627.3802, 529.75696, 631.1083, 523.5996,
				633.286, 519.7785);
		((GeneralPath) shape).curveTo(635.4638, 515.9574, 637.3521, 512.7052,
				637.4823, 512.5514);
		((GeneralPath) shape).curveTo(637.9, 512.0577, 705.6802, 547.93274,
				705.6802, 548.6475);
		((GeneralPath) shape).curveTo(705.6802, 549.5809, 694.6777, 568.4473,
				689.00775, 577.23645);
		((GeneralPath) shape).curveTo(686.48425, 581.14813, 683.962, 584.3134,
				683.4028, 584.2703);
		((GeneralPath) shape).curveTo(682.8435, 584.2271, 668.5065, 574.5723,
				651.5427, 562.81506);
		((GeneralPath) shape).lineTo(651.5427, 562.81506);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_30

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(626.7133, 594.7128);
		((GeneralPath) shape).lineTo(598.013, 569.2278);
		((GeneralPath) shape).lineTo(600.2185, 566.77576);
		((GeneralPath) shape).curveTo(603.6064, 563.0092, 611.81537, 552.5975,
				615.5108, 547.37994);
		((GeneralPath) shape).lineTo(618.8281, 542.6963);
		((GeneralPath) shape).lineTo(650.19836, 564.3567);
		((GeneralPath) shape).curveTo(667.45197, 576.2699, 681.6813, 586.34753,
				681.819, 586.75146);
		((GeneralPath) shape).curveTo(682.35406, 588.3207, 657.5024, 620.44293,
				655.8988, 620.2548);
		((GeneralPath) shape).curveTo(655.6319, 620.2235, 642.4984, 608.7296,
				626.71326, 594.7128);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_31

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(620.9699, 648.7144);
		((GeneralPath) shape).curveTo(619.14594, 646.8039, 607.62006, 633.8908,
				595.3568, 620.0187);
		((GeneralPath) shape).lineTo(573.06, 594.7967);
		((GeneralPath) shape).lineTo(584.80444, 583.03125);
		((GeneralPath) shape).curveTo(591.2639, 576.56024, 596.7974, 571.35895,
				597.10126, 571.4728);
		((GeneralPath) shape).curveTo(598.8012, 572.10986, 653.7788, 621.62006,
				653.7788, 622.5139);
		((GeneralPath) shape).curveTo(653.7788, 623.52594, 625.73895, 652.1881,
				624.7489, 652.1881);
		((GeneralPath) shape).curveTo(624.4944, 652.1881, 622.7938, 650.62494,
				620.96985, 648.7144);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_32

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(566.6278, 648.3709);
		((GeneralPath) shape).lineTo(544.8642, 616.78864);
		((GeneralPath) shape).lineTo(551.50696, 611.8938);
		((GeneralPath) shape).curveTo(555.16046, 609.2016, 561.1091, 604.52203,
				564.726, 601.4947);
		((GeneralPath) shape).lineTo(571.3023, 595.9904);
		((GeneralPath) shape).lineTo(587.61163, 614.42725);
		((GeneralPath) shape).curveTo(596.5818, 624.56744, 608.13586, 637.6325,
				613.2874, 643.4606);
		((GeneralPath) shape).lineTo(622.6539, 654.0571);
		((GeneralPath) shape).lineTo(619.8262, 656.48395);
		((GeneralPath) shape).curveTo(609.5724, 665.28406, 590.26697, 679.991,
				589.00256, 679.9655);
		((GeneralPath) shape).curveTo(588.66644, 679.9575, 578.59784, 665.7412,
				566.6278, 648.3709);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_33

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(532.4034, 670.07587);
		((GeneralPath) shape).curveTo(522.7383, 651.612, 514.7434, 636.2639,
				514.637, 635.96893);
		((GeneralPath) shape).curveTo(514.5307, 635.67395, 517.2892, 633.8011,
				520.7671, 631.80695);
		((GeneralPath) shape).curveTo(524.24506, 629.81287, 530.4796,
				626.04285, 534.6217, 623.4292);
		((GeneralPath) shape).curveTo(538.7638, 620.8155, 542.46265, 618.67706,
				542.8414, 618.67706);
		((GeneralPath) shape).curveTo(543.65027, 618.67706, 586.348, 680.365,
				586.348, 681.5336);
		((GeneralPath) shape).curveTo(586.348, 682.9022, 552.7766, 703.7172,
				550.6557, 703.66364);
		((GeneralPath) shape).curveTo(550.282, 703.65466, 542.0685, 688.5397,
				532.4034, 670.07587);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_34

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(495.67383, 687.1296);
		((GeneralPath) shape).curveTo(488.3226, 667.687, 482.16266, 651.38367,
				481.9851, 650.89984);
		((GeneralPath) shape).curveTo(481.8075, 650.4161, 484.34363, 648.9793,
				487.6209, 647.7071);
		((GeneralPath) shape).curveTo(490.89816, 646.4349, 497.784, 643.4226,
				502.92267, 641.0132);
		((GeneralPath) shape).curveTo(509.96335, 637.7119, 512.4275, 636.8874,
				512.9219, 637.6672);
		((GeneralPath) shape).curveTo(514.4853, 640.133, 547.9329, 704.3081,
				547.9329, 704.84204);
		((GeneralPath) shape).curveTo(547.9329, 705.92944, 511.66702,
				722.47974, 509.28418, 722.47974);
		((GeneralPath) shape).curveTo(509.1497, 722.47974, 503.02502, 706.5722,
				495.67383, 687.12964);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_35

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(465.38925, 733.135);
		((GeneralPath) shape).curveTo(464.92764, 731.4207, 460.85892, 714.9891,
				456.3477, 696.62024);
		((GeneralPath) shape).curveTo(451.83646, 678.25134, 447.97696,
				662.65466, 447.77106, 661.9609);
		((GeneralPath) shape).curveTo(447.4861, 661.0007, 448.51947, 660.4482,
				452.0979, 659.6473);
		((GeneralPath) shape).curveTo(454.68356, 659.0686, 461.94836,
				656.87775, 468.2419, 654.7786);
		((GeneralPath) shape).lineTo(479.6847, 650.96216);
		((GeneralPath) shape).lineTo(493.31982, 686.88855);
		((GeneralPath) shape).curveTo(500.81915, 706.6481, 506.78506,
				723.08984, 506.57745, 723.4258);
		((GeneralPath) shape).curveTo(506.117, 724.17084, 484.16843, 731.3823,
				473.77396, 734.2038);
		((GeneralPath) shape).lineTo(466.22852, 736.25195);
		((GeneralPath) shape).lineTo(465.38922, 733.1351);
		((GeneralPath) shape).lineTo(465.38922, 733.1351);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_36

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(417.24597, 707.8911);
		((GeneralPath) shape).curveTo(414.84772, 687.81866, 412.7083,
				670.43866, 412.4917, 669.2689);
		((GeneralPath) shape).curveTo(412.10898, 667.202, 412.24405, 667.12683,
				417.28427, 666.6019);
		((GeneralPath) shape).curveTo(420.13678, 666.3048, 427.61993, 665.0136,
				433.91345, 663.73254);
		((GeneralPath) shape).curveTo(440.207, 662.4515, 445.40076, 661.44476,
				445.4551, 661.4955);
		((GeneralPath) shape).curveTo(445.68323, 661.7082, 463.7465, 735.3134,
				463.7465, 736.03033);
		((GeneralPath) shape).curveTo(463.7465, 737.233, 442.36652, 741.571,
				424.49054, 743.99536);
		((GeneralPath) shape).lineTo(421.60638, 744.38654);
		((GeneralPath) shape).lineTo(417.24594, 707.8911);
		((GeneralPath) shape).lineTo(417.24594, 707.8911);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_37

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(376.29074, 708.1762);
		((GeneralPath) shape).lineTo(376.29074, 669.35236);
		((GeneralPath) shape).lineTo(383.4425, 669.3434);
		((GeneralPath) shape).curveTo(387.376, 669.3384, 394.95847, 668.9521,
				400.29245, 668.4842);
		((GeneralPath) shape).curveTo(405.62643, 668.0163, 410.08353, 667.7442,
				410.1971, 667.87964);
		((GeneralPath) shape).curveTo(410.64557, 668.41425, 419.5952,
				744.01733, 419.2508, 744.36176);
		((GeneralPath) shape).curveTo(418.5529, 745.0597, 393.84296, 746.9485,
				385.0772, 746.97394);
		((GeneralPath) shape).lineTo(376.29077, 746.99945);
		((GeneralPath) shape).lineTo(376.29077, 708.17566);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_38

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(343.73215, 745.74426);
		((GeneralPath) shape).curveTo(337.28815, 745.16003, 331.91605,
				744.55994, 331.79413, 744.41064);
		((GeneralPath) shape).curveTo(331.37946, 743.903, 340.81744, 668.5901,
				341.36426, 668.0433);
		((GeneralPath) shape).curveTo(341.66348, 667.7441, 346.3, 667.9162,
				351.6676, 668.42584);
		((GeneralPath) shape).curveTo(357.03525, 668.9354, 364.4035, 669.35236,
				368.0415, 669.35236);
		((GeneralPath) shape).lineTo(374.65607, 669.35236);
		((GeneralPath) shape).lineTo(374.65607, 708.1762);
		((GeneralPath) shape).lineTo(374.65607, 747.0);
		((GeneralPath) shape).lineTo(365.05228, 746.9032);
		((GeneralPath) shape).curveTo(359.77017, 746.85, 350.17615, 746.3284,
				343.73215, 745.7442);
		((GeneralPath) shape).lineTo(343.73215, 745.7442);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_39

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(319.89404, 742.8209);
		((GeneralPath) shape).curveTo(310.23502, 741.356, 295.7468, 738.5656,
				290.19702, 737.10144);
		((GeneralPath) shape).curveTo(288.35373, 736.6151, 287.2122, 735.87463,
				287.42438, 735.303);
		((GeneralPath) shape).curveTo(287.62274, 734.7685, 291.74185,
				718.14777, 296.57794, 698.36804);
		((GeneralPath) shape).curveTo(301.41403, 678.5883, 305.6042, 662.16187,
				305.88934, 661.86475);
		((GeneralPath) shape).curveTo(306.17453, 661.5676, 310.6376, 662.1868,
				315.8073, 663.2408);
		((GeneralPath) shape).curveTo(320.97702, 664.29474, 328.24115,
				665.6085, 331.94983, 666.16034);
		((GeneralPath) shape).curveTo(336.4733, 666.8333, 338.69293, 667.5178,
				338.69293, 668.2397);
		((GeneralPath) shape).curveTo(338.69293, 669.6984, 329.73938, 743.2012,
				329.49066, 743.78424);
		((GeneralPath) shape).curveTo(329.3822, 744.03845, 325.06372, 743.605,
				319.894, 742.8209);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_40

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(274.5315, 733.05615);
		((GeneralPath) shape).curveTo(261.85068, 729.36273, 243.88495,
				723.1347, 244.24254, 722.5561);
		((GeneralPath) shape).curveTo(244.48766, 722.15955, 269.4687, 656.503,
				271.23492, 651.61334);
		((GeneralPath) shape).curveTo(271.4891, 650.9096, 273.63608, 651.32324,
				278.78223, 653.06744);
		((GeneralPath) shape).curveTo(282.73788, 654.4081, 289.83624, 656.6462,
				294.5564, 658.041);
		((GeneralPath) shape).curveTo(299.27658, 659.43585, 303.26758,
				660.6883, 303.42532, 660.8242);
		((GeneralPath) shape).curveTo(303.58304, 660.9602, 299.57388, 677.8307,
				294.51602, 698.3143);
		((GeneralPath) shape).curveTo(287.10648, 728.32196, 285.06592,
				735.5455, 284.01242, 735.49695);
		((GeneralPath) shape).curveTo(283.2933, 735.4639, 279.02686, 734.3654,
				274.5315, 733.05615);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_41

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(234.30937, 719.15515);
		((GeneralPath) shape).curveTo(230.16875, 717.4665, 221.40858,
				713.49005, 214.84232, 710.31854);
		((GeneralPath) shape).lineTo(202.90364, 704.55225);
		((GeneralPath) shape).lineTo(205.72896, 699.4168);
		((GeneralPath) shape).curveTo(208.42625, 694.514, 233.59662, 646.5215,
				237.22192, 639.3689);
		((GeneralPath) shape).lineTo(238.95526, 635.9491);
		((GeneralPath) shape).lineTo(249.79596, 641.0925);
		((GeneralPath) shape).curveTo(255.75833, 643.9214, 262.4197, 646.9033,
				264.599, 647.719);
		((GeneralPath) shape).curveTo(266.77832, 648.53467, 268.71564,
				649.60406, 268.90424, 650.0955);
		((GeneralPath) shape).curveTo(269.19525, 650.8539, 243.90314, 718.7548,
				242.37006, 721.33093);
		((GeneralPath) shape).curveTo(242.01509, 721.9274, 239.32947, 721.2025,
				234.30937, 719.1552);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_42

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(192.37192, 698.66187);
		((GeneralPath) shape).curveTo(177.28711, 690.00476, 164.56241,
				681.51807, 165.1573, 680.5112);
		((GeneralPath) shape).curveTo(166.0617, 678.9806, 207.2877, 619.1513,
				207.96895, 618.3808);
		((GeneralPath) shape).curveTo(208.31174, 617.9931, 213.31392, 620.61,
				219.0849, 624.19617);
		((GeneralPath) shape).curveTo(224.85587, 627.7823, 231.28381, 631.6772,
				233.36923, 632.8515);
		((GeneralPath) shape).lineTo(237.1609, 634.9865);
		((GeneralPath) shape).lineTo(219.31078, 669.0205);
		((GeneralPath) shape).curveTo(209.49321, 687.7392, 201.34293, 703.1722,
				201.19907, 703.31604);
		((GeneralPath) shape).curveTo(201.05519, 703.4599, 197.083, 701.36554,
				192.37192, 698.66187);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_43

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(153.25455, 673.0329);
		((GeneralPath) shape).curveTo(143.43344, 665.66284, 132.02231,
				656.3425, 130.34372, 654.31995);
		((GeneralPath) shape).curveTo(129.49072, 653.2921, 133.37407,
				648.54364, 154.8122, 624.4003);
		((GeneralPath) shape).curveTo(177.71309, 598.60974, 180.44011,
				595.8105, 181.73094, 596.7686);
		((GeneralPath) shape).curveTo(182.52094, 597.355, 186.80522, 600.78,
				191.25159, 604.3797);
		((GeneralPath) shape).curveTo(195.69795, 607.97943, 200.89119,
				612.02527, 202.79214, 613.3705);
		((GeneralPath) shape).curveTo(204.69308, 614.7157, 206.25626, 616.0682,
				206.26585, 616.376);
		((GeneralPath) shape).curveTo(206.28175, 616.88806, 164.38515,
				677.9666, 163.06404, 679.3572);
		((GeneralPath) shape).curveTo(162.74773, 679.6901, 158.33344, 676.8442,
				153.25455, 673.03284);
		((GeneralPath) shape).lineTo(153.25455, 673.03284);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_44

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(112.2931, 637.0495);
		((GeneralPath) shape).lineTo(97.20433, 621.94147);
		((GeneralPath) shape).lineTo(99.638145, 619.5691);
		((GeneralPath) shape).curveTo(100.97677, 618.2642, 113.96688,
				606.68353, 128.5051, 593.8342);
		((GeneralPath) shape).lineTo(154.93823, 570.4718);
		((GeneralPath) shape).lineTo(166.77167, 582.4222);
		((GeneralPath) shape).lineTo(178.6051, 594.3726);
		((GeneralPath) shape).lineTo(176.2345, 596.9211);
		((GeneralPath) shape).curveTo(174.93068, 598.32275, 163.81403,
				610.87146, 151.53085, 624.8072);
		((GeneralPath) shape).curveTo(139.24768, 638.7429, 128.78922, 650.5977,
				128.28983, 651.1512);
		((GeneralPath) shape).curveTo(127.59443, 651.92194, 123.84944,
				648.62067, 112.29308, 637.0495);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_45

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(88.3846, 611.158);
		((GeneralPath) shape).curveTo(75.98754, 596.03186, 69.494095, 586.7671,
				70.54753, 585.70825);
		((GeneralPath) shape).curveTo(71.067856, 585.18524, 85.362, 575.1786,
				102.312294, 563.4712);
		((GeneralPath) shape).lineTo(133.13106, 542.18506);
		((GeneralPath) shape).lineTo(136.35005, 546.71564);
		((GeneralPath) shape).curveTo(140.53719, 552.6088, 144.33284,
				557.43713, 149.60637, 563.5784);
		((GeneralPath) shape).lineTo(153.87935, 568.5546);
		((GeneralPath) shape).lineTo(125.31266, 593.8202);
		((GeneralPath) shape).curveTo(109.60099, 607.71625, 96.41722, 619.1963,
				96.01537, 619.3315);
		((GeneralPath) shape).curveTo(95.61354, 619.4666, 92.1797, 615.7886,
				88.384605, 611.1581);
		((GeneralPath) shape).lineTo(88.384605, 611.1581);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_46

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(62.73357, 576.135);
		((GeneralPath) shape).curveTo(55.187122, 564.6173, 45.971134,
				548.15704, 46.70448, 547.5061);
		((GeneralPath) shape).curveTo(47.037502, 547.2105, 59.447533, 540.6252,
				74.2823, 532.872);
		((GeneralPath) shape).curveTo(89.117096, 525.11884, 104.24105,
				517.16895, 107.89111, 515.20557);
		((GeneralPath) shape).lineTo(114.52757, 511.63574);
		((GeneralPath) shape).lineTo(119.26267, 519.99817);
		((GeneralPath) shape).curveTo(121.866974, 524.59753, 125.80829,
				531.0571, 128.02118, 534.35284);
		((GeneralPath) shape).curveTo(130.23402, 537.64856, 131.9212,
				540.43866, 131.77045, 540.5531);
		((GeneralPath) shape).curveTo(131.61969, 540.66754, 117.7037, 550.2538,
				100.84598, 561.85583);
		((GeneralPath) shape).curveTo(83.98828, 573.4579, 69.74956, 583.2987,
				69.20441, 583.72437);
		((GeneralPath) shape).curveTo(68.48888, 584.283, 66.68929, 582.17236,
				62.733578, 576.135);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_47

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(40.942776, 537.5557);
		((GeneralPath) shape).curveTo(33.15854, 521.8434, 27.070866, 506.72418,
				28.34528, 506.26883);
		((GeneralPath) shape).curveTo(28.88599, 506.07562, 44.94017, 500.01334,
				64.02118, 492.79706);
		((GeneralPath) shape).curveTo(83.10222, 485.5808, 99.10225, 479.82556,
				99.57681, 480.00766);
		((GeneralPath) shape).curveTo(100.051384, 480.1898, 101.6903, 483.4198,
				103.21886, 487.1855);
		((GeneralPath) shape).curveTo(104.74738, 490.95117, 107.727104,
				497.58215, 109.840416, 501.92102);
		((GeneralPath) shape).lineTo(113.68281, 509.80988);
		((GeneralPath) shape).lineTo(80.01642, 527.463);
		((GeneralPath) shape).curveTo(61.499886, 537.17224, 45.976135,
				545.11615, 45.519196, 545.11615);
		((GeneralPath) shape).curveTo(45.06225, 545.11615, 43.00285, 541.714,
				40.94277, 537.5557);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_48

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(26.248133, 503.70715);
		((GeneralPath) shape).curveTo(24.700068, 501.08575, 13.703384,
				464.42014, 14.2948675, 463.85208);
		((GeneralPath) shape).curveTo(14.836568, 463.33185, 88.710434,
				445.25238, 89.02187, 445.5638);
		((GeneralPath) shape).curveTo(89.18227, 445.72418, 91.17932, 452.04227,
				93.45979, 459.60394);
		((GeneralPath) shape).curveTo(95.74025, 467.16562, 98.00133, 474.09097,
				98.484406, 474.9936);
		((GeneralPath) shape).curveTo(98.967476, 475.89624, 99.05279,
				476.90103, 98.673996, 477.22644);
		((GeneralPath) shape).curveTo(97.99529, 477.80954, 30.83017, 503.29877,
				28.071404, 504.0202);
		((GeneralPath) shape).curveTo(27.29084, 504.22433, 26.470362, 504.0835,
				26.248133, 503.70712);
		((GeneralPath) shape).lineTo(26.248133, 503.70712);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_49

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(11.892821, 454.2082);
		((GeneralPath) shape).curveTo(8.428805, 438.83884, 5.445065, 419.24167,
				6.5704184, 419.2509);
		((GeneralPath) shape).curveTo(6.949758, 419.25488, 24.123768,
				417.20633, 44.734894, 414.70056);
		((GeneralPath) shape).curveTo(65.34601, 412.1948, 82.36313, 410.29807,
				82.55071, 410.48566);
		((GeneralPath) shape).curveTo(82.73829, 410.67325, 83.63097, 415.3578,
				84.53448, 420.89575);
		((GeneralPath) shape).curveTo(85.43797, 426.43375, 86.75678, 433.5131,
				87.46517, 436.62762);
		((GeneralPath) shape).curveTo(88.17356, 439.7422, 88.43966, 442.58038,
				88.05647, 442.93466);
		((GeneralPath) shape).curveTo(87.67331, 443.289, 71.360306, 447.4933,
				51.805363, 452.27756);
		((GeneralPath) shape).curveTo(32.25042, 457.06186, 15.654835,
				461.15936, 14.926289, 461.38318);
		((GeneralPath) shape).curveTo(13.846279, 461.71497, 13.286116,
				460.38998, 11.892829, 454.20816);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_50

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(5.768801, 417.02515);
		((GeneralPath) shape).curveTo(5.286956, 416.2455, 3.727045, 394.449,
				3.3100424, 382.66913);
		((GeneralPath) shape).lineTo(3.0134788, 374.29135);
		((GeneralPath) shape).lineTo(41.625496, 374.29135);
		((GeneralPath) shape).curveTo(76.0806, 374.29135, 80.29091, 374.43054,
				80.733604, 375.5842);
		((GeneralPath) shape).curveTo(81.00647, 376.2953, 81.25287, 380.61697,
				81.28116, 385.188);
		((GeneralPath) shape).curveTo(81.30951, 389.759, 81.63326, 396.62524,
				82.00075, 400.44635);
		((GeneralPath) shape).curveTo(82.368225, 404.26743, 82.36001,
				407.59015, 81.982544, 407.83017);
		((GeneralPath) shape).curveTo(81.60505, 408.07016, 65.005875, 410.2117,
				45.095505, 412.58908);
		((GeneralPath) shape).curveTo(25.18515, 414.96646, 8.28215, 417.08383,
				7.533283, 417.29434);
		((GeneralPath) shape).curveTo(6.784428, 417.50485, 5.990416, 417.38373,
				5.768836, 417.02518);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(3.9046159, 361.41818);
		((GeneralPath) shape).curveTo(4.20333, 355.23703, 4.856762, 345.858,
				5.356672, 340.5759);
		((GeneralPath) shape).lineTo(6.2656064, 330.9721);
		((GeneralPath) shape).lineTo(9.076128, 330.9721);
		((GeneralPath) shape).curveTo(12.574244, 330.9721, 41.804077,
				334.33115, 64.53281, 337.34506);
		((GeneralPath) shape).lineTo(81.638405, 339.6133);
		((GeneralPath) shape).lineTo(81.60697, 343.87482);
		((GeneralPath) shape).curveTo(81.58966, 346.21863, 81.49776, 353.65338,
				81.40265, 360.39645);
		((GeneralPath) shape).lineTo(81.22976, 372.65662);
		((GeneralPath) shape).lineTo(42.295628, 372.65662);
		((GeneralPath) shape).lineTo(3.361515, 372.65662);
		((GeneralPath) shape).lineTo(3.9046364, 361.41815);
		((GeneralPath) shape).closePath();
		this.listOfFields_.add(new Field(shape));// _0_0_54

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(166.36314, 230.96107);
		((GeneralPath) shape).curveTo(165.8939, 229.58745, 157.01453, 184.8674,
				156.6926, 182.25635);
		((GeneralPath) shape).curveTo(156.44221, 180.22572, 166.27783,
				169.05978, 175.9123, 160.43697);
		((GeneralPath) shape).lineTo(181.95699, 155.027);
		((GeneralPath) shape).lineTo(207.62169, 159.96967);
		((GeneralPath) shape).curveTo(221.7373, 162.68817, 233.36858,
				164.99455, 233.469, 165.09499);
		((GeneralPath) shape).curveTo(233.56935, 165.19536, 218.6028,
				180.32303, 200.2098, 198.71191);
		((GeneralPath) shape).curveTo(178.27216, 220.64467, 166.62871,
				231.73856, 166.36313, 230.96107);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_61

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(181.1949, 247.54662);
		((GeneralPath) shape).lineTo(168.3341, 234.66696);
		((GeneralPath) shape).lineTo(202.24812, 200.76033);
		((GeneralPath) shape).lineTo(236.16214, 166.85371);
		((GeneralPath) shape).lineTo(249.24556, 179.91795);
		((GeneralPath) shape).lineTo(262.32898, 192.98221);
		((GeneralPath) shape).lineTo(228.61429, 226.70424);
		((GeneralPath) shape).curveTo(210.07121, 245.25136, 194.70972,
				260.42627, 194.47763, 260.42627);
		((GeneralPath) shape).curveTo(194.24556, 260.42627, 188.26834,
				254.63043, 181.19492, 247.54662);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_60

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(209.19693, 276.3657);
		((GeneralPath) shape).lineTo(195.72249, 262.87265);
		((GeneralPath) shape).lineTo(230.04108, 228.54675);
		((GeneralPath) shape).lineTo(264.35968, 194.22083);
		((GeneralPath) shape).lineTo(277.84708, 207.70822);
		((GeneralPath) shape).lineTo(291.33444, 221.19562);
		((GeneralPath) shape).lineTo(257.0029, 255.52716);
		((GeneralPath) shape).lineTo(222.67136, 289.8587);
		((GeneralPath) shape).lineTo(209.19693, 276.3657);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_59

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(237.39108, 304.55984);
		((GeneralPath) shape).lineTo(224.32979, 291.47937);
		((GeneralPath) shape).lineTo(258.64526, 257.1566);
		((GeneralPath) shape).lineTo(292.96075, 222.8338);
		((GeneralPath) shape).lineTo(306.25177, 236.1065);
		((GeneralPath) shape).lineTo(319.5428, 249.37921);
		((GeneralPath) shape).lineTo(285.4195, 283.50974);
		((GeneralPath) shape).curveTo(266.65167, 302.28152, 251.10634,
				317.6403, 250.8743, 317.6403);
		((GeneralPath) shape).curveTo(250.64224, 317.6403, 244.57481, 311.7541,
				237.3911, 304.5598);
		((GeneralPath) shape).lineTo(237.3911, 304.5598);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_62

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(265.79016, 332.9592);
		((GeneralPath) shape).lineTo(252.5203, 319.67102);
		((GeneralPath) shape).lineTo(286.8432, 285.3554);
		((GeneralPath) shape).lineTo(321.16614, 251.03976);
		((GeneralPath) shape).lineTo(334.65796, 264.51303);
		((GeneralPath) shape).lineTo(348.1498, 277.98627);
		((GeneralPath) shape).lineTo(314.02652, 312.11682);
		((GeneralPath) shape).curveTo(295.2587, 330.8886, 279.7135, 346.24738,
				279.48163, 346.24738);
		((GeneralPath) shape).curveTo(279.24973, 346.24738, 273.08856,
				340.2677, 265.79016, 332.95923);
		((GeneralPath) shape).lineTo(265.79016, 332.95923);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_63

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(293.58383, 360.75293);
		((GeneralPath) shape).lineTo(281.12784, 348.2775);
		((GeneralPath) shape).lineTo(315.45346, 313.95917);
		((GeneralPath) shape).lineTo(349.77908, 279.64087);
		((GeneralPath) shape).lineTo(362.24115, 292.10294);
		((GeneralPath) shape).lineTo(374.7032, 304.565);
		((GeneralPath) shape).lineTo(340.3715, 338.8967);
		((GeneralPath) shape).lineTo(306.0398, 373.2284);
		((GeneralPath) shape).lineTo(293.58383, 360.75293);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_64

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(342.01523, 409.18402);
		((GeneralPath) shape).lineTo(307.6929, 374.85437);
		((GeneralPath) shape).lineTo(342.01523, 340.52472);
		((GeneralPath) shape).lineTo(376.3376, 306.19507);
		((GeneralPath) shape).lineTo(410.66724, 340.52472);
		((GeneralPath) shape).lineTo(444.9969, 374.85437);
		((GeneralPath) shape).lineTo(410.66724, 409.18402);
		((GeneralPath) shape).lineTo(376.3376, 443.51367);
		((GeneralPath) shape).lineTo(342.01523, 409.18402);
		((GeneralPath) shape).lineTo(342.01523, 409.18402);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_65

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(412.30557, 338.89127);
		((GeneralPath) shape).lineTo(377.98404, 304.5624);
		((GeneralPath) shape).lineTo(390.65286, 291.8936);
		((GeneralPath) shape).lineTo(403.3217, 279.22476);
		((GeneralPath) shape).lineTo(437.64322, 313.5536);
		((GeneralPath) shape).lineTo(471.96475, 347.88245);
		((GeneralPath) shape).lineTo(459.29593, 360.55127);
		((GeneralPath) shape).lineTo(446.6271, 373.2201);
		((GeneralPath) shape).lineTo(412.30557, 338.89127);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_66

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(438.65842, 312.1168);
		((GeneralPath) shape).lineTo(404.53513, 277.98627);
		((GeneralPath) shape).lineTo(418.02695, 264.51303);
		((GeneralPath) shape).lineTo(431.5188, 251.03976);
		((GeneralPath) shape).lineTo(465.84174, 285.3554);
		((GeneralPath) shape).lineTo(500.16467, 319.67102);
		((GeneralPath) shape).lineTo(486.89484, 332.9592);
		((GeneralPath) shape).curveTo(479.5964, 340.26767, 473.43524,
				346.24734, 473.20337, 346.24734);
		((GeneralPath) shape).curveTo(472.9715, 346.24734, 457.42627,
				330.88858, 438.65848, 312.1168);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_67

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(467.26544, 283.50977);
		((GeneralPath) shape).lineTo(433.14215, 249.37924);
		((GeneralPath) shape).lineTo(446.43317, 236.10654);
		((GeneralPath) shape).lineTo(459.72418, 222.83383);
		((GeneralPath) shape).lineTo(494.03967, 257.15662);
		((GeneralPath) shape).lineTo(528.35516, 291.4794);
		((GeneralPath) shape).lineTo(515.2939, 304.55988);
		((GeneralPath) shape).curveTo(508.11017, 311.75415, 502.04272,
				317.64032, 501.81067, 317.64032);
		((GeneralPath) shape).curveTo(501.57864, 317.64032, 486.0333,
				302.28156, 467.26547, 283.50977);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_68

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(495.67462, 255.52222);
		((GeneralPath) shape).lineTo(461.3529, 221.19318);
		((GeneralPath) shape).lineTo(474.83908, 207.70702);
		((GeneralPath) shape).lineTo(488.32526, 194.22084);
		((GeneralPath) shape).lineTo(522.647, 228.54988);
		((GeneralPath) shape).lineTo(556.9687, 262.8789);
		((GeneralPath) shape).lineTo(543.48254, 276.36508);
		((GeneralPath) shape).lineTo(529.9964, 289.85126);
		((GeneralPath) shape).lineTo(495.67465, 255.52223);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_69

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(524.2787, 226.91226);
		((GeneralPath) shape).lineTo(489.96, 192.58626);
		((GeneralPath) shape).lineTo(503.23938, 179.30685);
		((GeneralPath) shape).lineTo(516.5188, 166.02744);
		((GeneralPath) shape).lineTo(550.8503, 200.35895);
		((GeneralPath) shape).lineTo(585.18176, 234.69046);
		((GeneralPath) shape).lineTo(571.8895, 247.96436);
		((GeneralPath) shape).lineTo(558.59735, 261.23825);
		((GeneralPath) shape).lineTo(524.2786, 226.91226);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_70

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(552.17505, 198.4119);
		((GeneralPath) shape).lineTo(518.81226, 165.04169);
		((GeneralPath) shape).lineTo(544.7003, 159.98592);
		((GeneralPath) shape).lineTo(570.5884, 154.93016);
		((GeneralPath) shape).lineTo(576.9435, 160.65916);
		((GeneralPath) shape).curveTo(580.4388, 163.81012, 586.17926,
				169.56122, 589.70013, 173.43938);
		((GeneralPath) shape).lineTo(596.1017, 180.4906);
		((GeneralPath) shape).lineTo(591.3626, 205.54192);
		((GeneralPath) shape).curveTo(588.75616, 219.32013, 586.3793,
				230.86073, 586.0807, 231.18768);
		((GeneralPath) shape).curveTo(585.7821, 231.51463, 570.52454,
				216.76552, 552.175, 198.4119);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_71

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(316.35025, 434.78125);
		((GeneralPath) shape).lineTo(281.81555, 400.6007);
		((GeneralPath) shape).lineTo(293.94, 388.54797);
		((GeneralPath) shape).lineTo(306.06445, 376.49527);
		((GeneralPath) shape).lineTo(340.38257, 410.82068);
		((GeneralPath) shape).lineTo(374.70068, 445.1461);
		((GeneralPath) shape).lineTo(362.79285, 457.05392);
		((GeneralPath) shape).lineTo(350.88498, 468.9618);
		((GeneralPath) shape).lineTo(316.35028, 434.78122);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));

		// _0_0_72

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(288.06934, 463.12747);
		((GeneralPath) shape).lineTo(253.74759, 428.79843);
		((GeneralPath) shape).lineTo(267.23376, 415.3123);
		((GeneralPath) shape).lineTo(280.71994, 401.8261);
		((GeneralPath) shape).lineTo(315.04166, 436.15515);
		((GeneralPath) shape).lineTo(349.3634, 470.48416);
		((GeneralPath) shape).lineTo(335.87726, 483.97034);
		((GeneralPath) shape).lineTo(322.39108, 497.45648);
		((GeneralPath) shape).lineTo(288.06934, 463.12747);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_73

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(259.46857, 491.27835);
		((GeneralPath) shape).lineTo(225.14636, 457.3997);
		((GeneralPath) shape).lineTo(238.62631, 443.92685);
		((GeneralPath) shape).lineTo(252.10625, 430.45404);
		((GeneralPath) shape).lineTo(286.45856, 464.75748);
		((GeneralPath) shape).lineTo(320.81085, 499.06088);
		((GeneralPath) shape).lineTo(307.70044, 512.15326);
		((GeneralPath) shape).curveTo(300.48972, 519.354, 294.41022, 525.22565,
				294.1904, 525.2013);
		((GeneralPath) shape).curveTo(293.9706, 525.177, 278.34576, 509.9116,
				259.46854, 491.27835);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_74

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(231.05315, 519.72205);
		((GeneralPath) shape).lineTo(196.92986, 485.5915);
		((GeneralPath) shape).lineTo(210.4217, 472.11826);
		((GeneralPath) shape).lineTo(223.91354, 458.645);
		((GeneralPath) shape).lineTo(258.23645, 492.96063);
		((GeneralPath) shape).lineTo(292.5594, 527.27625);
		((GeneralPath) shape).lineTo(279.28952, 540.5644);
		((GeneralPath) shape).curveTo(271.99112, 547.8729, 265.82993,
				553.85254, 265.59805, 553.85254);
		((GeneralPath) shape).curveTo(265.36615, 553.85254, 249.82097,
				538.49384, 231.05315, 519.722);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));

		// _0_0_75

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(203.0627, 548.12823);
		((GeneralPath) shape).lineTo(168.74397, 513.80225);
		((GeneralPath) shape).lineTo(181.98544, 500.5608);
		((GeneralPath) shape).lineTo(195.22688, 487.31934);
		((GeneralPath) shape).lineTo(229.38795, 521.1966);
		((GeneralPath) shape).curveTo(248.17656, 539.8291, 263.64203,
				555.26196, 263.7557, 555.4919);
		((GeneralPath) shape).curveTo(263.86926, 555.7218, 257.98166, 561.8824,
				250.67186, 569.1821);
		((GeneralPath) shape).lineTo(237.38138, 582.4543);
		((GeneralPath) shape).lineTo(203.06268, 548.1283);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_76

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(168.3644, 581.65155);
		((GeneralPath) shape).curveTo(159.93318, 573.17017, 156.13315,
				568.7936, 156.40016, 567.872);
		((GeneralPath) shape).curveTo(156.61536, 567.1292, 159.07956, 554.9973,
				161.87611, 540.91223);
		((GeneralPath) shape).lineTo(166.96078, 515.30304);
		((GeneralPath) shape).lineTo(201.13712, 549.4721);
		((GeneralPath) shape).curveTo(219.9341, 568.26514, 235.04599,
				583.86884, 234.71907, 584.14703);
		((GeneralPath) shape).curveTo(234.39214, 584.42523, 223.09055,
				586.5879, 209.60434, 588.95294);
		((GeneralPath) shape).curveTo(196.1182, 591.318, 184.10211, 593.4393,
				182.90198, 593.6669);
		((GeneralPath) shape).curveTo(180.97198, 594.03284, 179.29245,
				592.6447, 168.36438, 581.6516);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_77

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(390.188, 457.3567);
		((GeneralPath) shape).lineTo(377.991, 445.13937);
		((GeneralPath) shape).lineTo(412.30588, 410.8172);
		((GeneralPath) shape).lineTo(446.62076, 376.495);
		((GeneralPath) shape).lineTo(459.09186, 388.94666);
		((GeneralPath) shape).lineTo(471.56296, 401.39825);
		((GeneralPath) shape).lineTo(459.50714, 413.52014);
		((GeneralPath) shape).curveTo(452.87643, 420.1872, 437.3114, 435.52673,
				424.91812, 447.60803);
		((GeneralPath) shape).lineTo(402.38492, 469.57404);
		((GeneralPath) shape).lineTo(390.18796, 457.3567);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));// _0_0_78

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(417.4044, 484.57346);
		((GeneralPath) shape).curveTo(410.3294, 477.4881, 404.54083, 471.4663,
				404.54083, 471.19168);
		((GeneralPath) shape).curveTo(404.54083, 470.91708, 420.01282,
				455.49902, 438.92303, 436.92938);
		((GeneralPath) shape).lineTo(473.30524, 403.16638);
		((GeneralPath) shape).lineTo(486.72455, 416.59573);
		((GeneralPath) shape).lineTo(500.1439, 430.0251);
		((GeneralPath) shape).lineTo(465.8424, 463.7405);
		((GeneralPath) shape).curveTo(446.9766, 482.28397, 431.2545, 497.45593,
				430.90445, 497.45593);
		((GeneralPath) shape).curveTo(430.55438, 497.45593, 424.47937,
				491.65884, 417.4044, 484.5735);
		((GeneralPath) shape).lineTo(417.4044, 484.5735);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_79

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(445.65686, 512.8319);
		((GeneralPath) shape).lineTo(432.42584, 499.6009);
		((GeneralPath) shape).lineTo(462.41553, 470.10306);
		((GeneralPath) shape).curveTo(478.90988, 453.87924, 494.5392, 438.613,
				497.14743, 436.1781);
		((GeneralPath) shape).lineTo(501.88962, 431.75092);
		((GeneralPath) shape).lineTo(515.12897, 445.04724);
		((GeneralPath) shape).lineTo(528.36835, 458.34354);
		((GeneralPath) shape).lineTo(494.03992, 492.17883);
		((GeneralPath) shape).curveTo(475.15927, 510.78827, 459.52615,
				526.02515, 459.29968, 526.0385);
		((GeneralPath) shape).curveTo(459.07318, 526.05194, 452.93393,
				520.10895, 445.65683, 512.8319);
		((GeneralPath) shape).lineTo(445.65683, 512.8319);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_80

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(474.1246, 541.2935);
		((GeneralPath) shape).lineTo(460.81836, 527.96893);
		((GeneralPath) shape).lineTo(495.4107, 493.94516);
		((GeneralPath) shape).lineTo(530.00305, 459.9214);
		((GeneralPath) shape).lineTo(543.4154, 473.3051);
		((GeneralPath) shape).lineTo(556.82776, 486.68887);
		((GeneralPath) shape).lineTo(528.29456, 514.7615);
		((GeneralPath) shape).curveTo(512.60126, 530.2014, 496.98697,
				545.48553, 493.5961, 548.7261);
		((GeneralPath) shape).lineTo(487.43085, 554.6181);
		((GeneralPath) shape).lineTo(474.12457, 541.29346);
		((GeneralPath) shape).lineTo(474.12457, 541.29346);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_81

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(502.56577, 569.7345);
		((GeneralPath) shape).lineTo(489.1497, 556.2999);
		((GeneralPath) shape).lineTo(498.13354, 547.4541);
		((GeneralPath) shape).curveTo(503.07465, 542.58887, 518.6246, 527.2488,
				532.6889, 513.3649);
		((GeneralPath) shape).lineTo(558.26044, 488.1216);
		((GeneralPath) shape).lineTo(571.759, 501.62012);
		((GeneralPath) shape).lineTo(585.2575, 515.11865);
		((GeneralPath) shape).lineTo(550.6197, 549.14386);
		((GeneralPath) shape).lineTo(515.9819, 583.16907);
		((GeneralPath) shape).lineTo(502.56577, 569.7345);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));
		// _0_0_82

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(544.5126, 589.4806);
		((GeneralPath) shape).curveTo(530.01587, 586.7429, 518.19257, 584.3191,
				518.23865, 584.0943);
		((GeneralPath) shape).curveTo(518.39417, 583.335, 584.75806, 518.6325,
				585.55347, 518.4646);
		((GeneralPath) shape).curveTo(586.2605, 518.31537, 594.90216, 564.8267,
				594.9586, 569.0853);
		((GeneralPath) shape).curveTo(594.9838, 570.98834, 583.5527, 583.56494,
				575.55084, 590.43787);
		((GeneralPath) shape).lineTo(570.8701, 594.4582);
		((GeneralPath) shape).lineTo(544.5125, 589.4806);
		((GeneralPath) shape).closePath();

		this.listOfFields_.add(new Field(shape));

		// Houses
		// _0_0_51 House 2
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(54.199986, 127.72137);
		((GeneralPath) shape).curveTo(39.52147, 124.88213, 27.241182,
				117.80156, 18.091675, 106.90201);
		((GeneralPath) shape).curveTo(-11.522419, 71.62364, 4.417793,
				19.264038, 48.709816, 6.329132);
		((GeneralPath) shape).curveTo(65.34082, 1.472255, 85.05411, 4.602709,
				99.56453, 14.404819);
		((GeneralPath) shape).curveTo(137.04135, 39.721203, 137.04135,
				93.08298, 99.56453, 118.399376);
		((GeneralPath) shape).curveTo(86.60101, 127.15652, 69.474335,
				130.67587, 54.19998, 127.72137);
		((GeneralPath) shape).closePath();
		this.listOfHouses_.add(new Field(shape));

		// _0_0_52 House 1
		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(677.9581, 128.37193);
		((GeneralPath) shape).curveTo(670.2699, 127.511734, 660.43036,
				124.358315, 653.9516, 120.67816);
		((GeneralPath) shape).curveTo(650.86633, 118.925644, 645.4015,
				114.48081, 640.87, 110.038155);
		((GeneralPath) shape).curveTo(634.2064, 103.5053, 632.5419, 101.313095,
				629.2952, 94.794075);
		((GeneralPath) shape).curveTo(623.7919, 83.743744, 622.6206, 78.75081,
				622.6206, 66.341774);
		((GeneralPath) shape).curveTo(622.6206, 53.99819, 623.808, 48.878494,
				629.1265, 38.290222);
		((GeneralPath) shape).curveTo(639.7596, 17.121641, 660.828, 4.20446,
				684.9295, 4.0770836);
		((GeneralPath) shape).curveTo(695.22107, 4.0227237, 702.2912,
				5.5606556, 711.4237, 9.84034);
		((GeneralPath) shape).curveTo(727.9234, 17.572456, 739.6821, 31.170109,
				745.3827, 49.1101);
		((GeneralPath) shape).curveTo(747.00385, 54.21201, 747.2927, 56.81821,
				747.2927, 66.34177);
		((GeneralPath) shape).curveTo(747.2927, 78.708885, 745.9728, 84.60092,
				741.01495, 94.36506);
		((GeneralPath) shape).curveTo(729.3136, 117.41002, 703.6564, 131.2471,
				677.9582, 128.37193);
		((GeneralPath) shape).closePath();

		this.listOfHouses_.add(new Field(shape));// _0_0_53

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(675.5909, 745.5222);
		((GeneralPath) shape).curveTo(674.25385, 745.30963, 670.60724,
				744.3866, 667.4874, 743.47095);
		((GeneralPath) shape).curveTo(637.281, 734.6058, 617.764, 703.1548,
				623.6758, 672.87);
		((GeneralPath) shape).curveTo(626.18896, 659.9955, 631.1961, 649.9947,
				639.6731, 640.91833);
		((GeneralPath) shape).curveTo(652.12714, 627.5838, 670.2936, 620.23,
				688.1211, 621.3065);
		((GeneralPath) shape).curveTo(704.6082, 622.3021, 716.71295, 627.793,
				728.7676, 639.74445);
		((GeneralPath) shape).curveTo(735.7275, 646.6447, 737.00635, 648.388,
				740.6755, 655.9772);
		((GeneralPath) shape).curveTo(745.39813, 665.7453, 747.3133, 673.7753,
				747.29254, 683.7215);
		((GeneralPath) shape).curveTo(747.2346, 711.4097, 729.5447, 734.97034,
				702.33234, 743.6024);
		((GeneralPath) shape).curveTo(696.7034, 745.38794, 681.57684,
				746.47394, 675.5909, 745.5222);
		((GeneralPath) shape).closePath();

		this.listOfHouses_.add(new Field(shape));

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(52.937702, 744.6004);
		((GeneralPath) shape).curveTo(33.870365, 740.6191, 17.633488,
				727.94226, 9.17553, 710.43335);
		((GeneralPath) shape).curveTo(4.683498, 701.13434, 2.9676025,
				693.50757, 3.0004623, 682.9866);
		((GeneralPath) shape).curveTo(3.1272285, 642.40063, 42.187046,
				612.7559, 81.542595, 623.3764);
		((GeneralPath) shape).curveTo(92.546715, 626.34595, 99.76669,
				630.61536, 108.92781, 639.57007);
		((GeneralPath) shape).curveTo(115.31814, 645.8164, 117.87711, 648.9981,
				120.52841, 653.9938);
		((GeneralPath) shape).curveTo(126.06224, 664.42065, 127.67977,
				671.16547, 127.67211, 683.78217);
		((GeneralPath) shape).curveTo(127.66411, 695.81793, 126.27308,
				701.7504, 121.09025, 711.8388);
		((GeneralPath) shape).curveTo(108.33779, 736.66156, 80.04735, 750.261,
				52.9377, 744.6004);
		((GeneralPath) shape).closePath();

		this.listOfHouses_.add(new Field(shape));// _0_0_55

		// _0_0_56

		// AffineTransform af = AffineTransform.getScaleInstance(50, 50);
		//
		// PerspectiveTransform pers = new PerspectiveTransform();
		// pers = PerspectiveTransform.getSquareToQuad(0.0, 0.0, 650.0, 0.0,
		// 750.0, 0.0, 750.0, 750.0);
		// double[][] d = null;
		// d = pers.getMatrix(d);
		// //af.setTransform(d[0][0], d[0][1], d[0][2], d[1][0], d[1][1],
		// d[1][2]);
		// af.setToRotation(3);
		// for (GameField s : this.fields)
		// fields.set(fields.indexOf(s), new
		// GameField(AffineTransform.createTransformedShape(s.getField())));
		//

	}

	/**
	 * Sets the backcolor.
	 *
	 * @param backcolor the new backcolor
	 */
	public void setBackcolor(Paint backcolor) {
		this.backBoardColor_ = backcolor;
	}

	/**
	 * Sets the background.
	 *
	 * @param background the new background
	 */
	public void setBackground(Rectangle2D background) {
		this.backgroundOfBoard_ = background;
	}

}