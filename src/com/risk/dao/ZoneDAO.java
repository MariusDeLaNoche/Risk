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
	private int bonus;
	private RegionsDAO regions;
	
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
	@XmlElement(name = "regions")
	public void setRegions(RegionsDAO regions) {
		this.regions = regions;
	}
}
