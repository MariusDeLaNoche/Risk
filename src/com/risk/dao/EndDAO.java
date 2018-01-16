package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class EndDAO {
	private RegionDAO region;
	private MovesDAO moves;
	
	/**
	 * @return the region
	 */
	@XmlElement(name = "region")
	public RegionDAO getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(RegionDAO region) {
		this.region = region;
	}
	/**
	 * @return the moves
	 */
	@XmlElement(name = "moves")
	public MovesDAO getMoves() {
		return moves;
	}
	/**
	 * @param moves the moves to set
	 */
	public void setMoves(MovesDAO moves) {
		this.moves = moves;
	}
}
