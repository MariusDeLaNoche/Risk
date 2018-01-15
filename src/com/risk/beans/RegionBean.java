package com.risk.beans;

import java.util.List;

public class RegionBean {
	private String name;
	private String bonus;
	private List<RegionBean> adjacencies;
	
	/**
	 * Constructeur region
	 * @param aName
	 * @param aBonus
	 */
	public RegionBean (String aName, String aBonus) {
		this.name = aName;
		this.bonus = aBonus;
	}
	
	// ------
	// --- METHODES
	// ------
	public boolean addRegionAdjacency(RegionBean aRegion) {
		boolean ok = false;
		//if()
		return ok;
	}
	
	// ------
	// --- ACCESSEURS
	// ------

	/**
	 * @return the name
	 */
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
	public String getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the adjacencies
	 */
	public List<RegionBean> getAdjacencies() {
		return adjacencies;
	}

	/**
	 * @param adjacencies the adjacencies to set
	 */
	public void setAdjacencies(List<RegionBean> adjacencies) {
		this.adjacencies = adjacencies;
	}
}
