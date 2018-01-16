package com.risk.dao;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Giraud
 *
 */
public class ZoneDAO {
	private String name;
	private Integer bonus;
	private RegionsDAO regions;
	
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
	/**
	 * @return the regions
	 */
	@XmlElement(name = "regions")
	public RegionsDAO getRegions() {
		return regions;
	}
	/**
	 * @param regions the regions to set
	 */
	public void setRegions(RegionsDAO regions) {
		this.regions = regions;
	}
}
