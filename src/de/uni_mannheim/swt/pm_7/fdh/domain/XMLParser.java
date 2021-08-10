/*
 * Copyright (C) 2010  Denny Stohr - University of Mannheim
 */
package de.uni_mannheim.swt.pm_7.fdh.domain;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLParser.
 */
public class XMLParser {

	/** The encode played game_. */
	private XMLEncoder encodePlayedGame_;

	/** The decode played game_. */
	public XMLDecoder decodePlayedGame_;

	/** The filename of game_. */
	private String filenameOfGame_;

	/** The directory of saved games_. */
	private String directoryOfSavedGames_;

	/**
	 * Instantiates a new xML parser.
	 */
	public XMLParser() {

		this.setFilenameOfGame_(("FDH_" + new Date().getTime() + ".xml"));
		String property = "java.io.tmpdir";
		this.setDirectoryOfSavedGames_(System.getProperty(property));
		File file = new File(this.getDirectoryOfSavedGames_() + "/Fang_Den_Hut");
		file.mkdir();
		System.out.println(file.getAbsolutePath());
		this.setDirectoryOfSavedGames_(file.getAbsolutePath());

	}

	/**
	 * Decode moves.
	 *
	 * @param filepath the filepath
	 * @return the array list
	 */
	public ArrayList<PersistenceData> decodeMoves(File filepath) {
		try {
			this.decodePlayedGame_ = new XMLDecoder(new BufferedInputStream(
					new FileInputStream(filepath)));
			return ((ArrayList<PersistenceData>) this.decodePlayedGame_
					.readObject());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (this.decodePlayedGame_ != null) {
				this.decodePlayedGame_.close();
			}
		}
		return null;
	}

	/**
	 * Parses the move.
	 *
	 * @param presGame the pres game
	 */
	public void parseMove(FDHGame presGame) {

		try {

			this.setEncodePlayedGame_(new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(this.getDirectoryOfSavedGames_() + "/"
							+ this.getFilenameOfGame_()))));

			this.getEncodePlayedGame_().writeObject(presGame.getMove());
			this.getEncodePlayedGame_().flush();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		finally {
			if (this.getEncodePlayedGame_() != null) {
				this.getEncodePlayedGame_().close();
			}

		}
	}

	/**
	 * @param filenameOfGame_ the filenameOfGame_ to set
	 */
	public void setFilenameOfGame_(String filenameOfGame_) {
		this.filenameOfGame_ = filenameOfGame_;
	}

	/**
	 * @return the filenameOfGame_
	 */
	public String getFilenameOfGame_() {
		return filenameOfGame_;
	}

	/**
	 * @param encodePlayedGame_ the encodePlayedGame_ to set
	 */
	public void setEncodePlayedGame_(XMLEncoder encodePlayedGame_) {
		this.encodePlayedGame_ = encodePlayedGame_;
	}

	/**
	 * @return the encodePlayedGame_
	 */
	public XMLEncoder getEncodePlayedGame_() {
		return encodePlayedGame_;
	}

	/**
	 * @param directoryOfSavedGames_ the directoryOfSavedGames_ to set
	 */
	public void setDirectoryOfSavedGames_(String directoryOfSavedGames_) {
		this.directoryOfSavedGames_ = directoryOfSavedGames_;
	}

	/**
	 * @return the directoryOfSavedGames_
	 */
	public String getDirectoryOfSavedGames_() {
		return directoryOfSavedGames_;
	}

	/**
	 * @param encodePlayedGame_2
	 */
	public void setEncodePlayedGame_1(XMLEncoder encodePlayedGame_2) {
		this.encodePlayedGame_ = encodePlayedGame_2;
		
	}

	/**
	 * @return
	 */
	

	

}
