package com.risk.dao;

import javax.xml.bind.annotation.XmlValue;

/**
 * 
 * @author Giraud
 *
 */
public class RegionDAO {
	private String name;
	private int bonus; // A discuter

	/**
	 * @return the name
	 */
	@XmlValue
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlValue
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bonus
	 */
	@XmlValue
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	@XmlValue
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	

}
