package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Giraud
 *
 */
public class RegionDAO {
	private String name;
	private Integer bonus;

	/**
	 * @return the name
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bonus
	 */
	@XmlElement
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	

}
