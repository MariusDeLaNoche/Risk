package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class ModeDAO {
	private Integer players;
	private Integer initial;
	
	/**
	 * @return the players
	 */
	@XmlElement(name = "players")
	public Integer getPlayers() {
		return players;
	}
	/**
	 * @param players the players to set
	 */
	public void setPlayers(Integer players) {
		this.players = players;
	}
	/**
	 * @return le nombre initial de troupes
	 */
	@XmlElement(name = "initial")
	public Integer getInitial() {
		return initial;
	}
	/**
	 * @param initial the initial to set
	 */
	public void setInitial(Integer initial) {
		this.initial = initial;
	}
}
