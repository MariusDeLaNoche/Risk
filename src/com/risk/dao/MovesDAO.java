package com.risk.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class MovesDAO {
	private List<MoveDAO> movesList;

	/**
	 * @return the movesList
	 */
	@XmlElement(name = "move")
	public List<MoveDAO> getMoves() {
		return movesList;
	}

	/**
	 * @param movesList the moves to set
	 */
	public void setMoves(List<MoveDAO> moves) {
		this.movesList = moves;
	}

}
