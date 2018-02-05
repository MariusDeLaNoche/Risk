package com.risk.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean d'une région
 * 
 * @author Alex
 *
 */
public class RegionBean {
	private String name;
	private Integer bonus;
	private List<AdjacencyBean> adjacencies;
	private ZoneBean zone;
	private Integer troopsOnGround;

	/**
	 * Constructeur region
	 * 
	 * @param aName
	 * @param aBonus
	 */
	public RegionBean(String aName, Integer aBonus) {
		this.name = aName;
		this.bonus = aBonus;
		this.adjacencies = new ArrayList<>();
	}
	
	/**
	 * Constructeur region
	 * 
	 * @param aName
	 * @param aBonus
	 * @param zone
	 */
	public RegionBean(String aName, Integer aBonus, ZoneBean zone) {
		this.name = aName;
		this.bonus = aBonus;
		this.zone = zone;
		this.adjacencies = new ArrayList<>();
	}

	// ------
	// --- METHODES
	// ------

	/**
	 * Ajoute une adjacency dans la liste des adjacencies de cette région
	 * 
	 * @param anAdjacency
	 *            l'adjacency a ajouter
	 * @return boolean, true si ajout OK, false si l'adjacency existait déjà dans la
	 *         liste des adjacences de cette région
	 */
	public boolean addRegionAdjacency(AdjacencyBean anAdjacency) {
		// Region deja dans la liste des adjacences?
		boolean isAlreadyAdjacent = this.adjacencies.stream()
				.filter(o -> o.getRegion().getName().equals(anAdjacency.getRegion().getName()))
				.findFirst()
				.isPresent();
		if (!isAlreadyAdjacent)
			this.adjacencies.add(anAdjacency);
		return !isAlreadyAdjacent;
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bonus
	 */
	public Integer getBonus() {
		return bonus;
	}

	/**
	 * @param bonus
	 *            the bonus to set
	 */
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the adjacencies
	 */
	public List<AdjacencyBean> getAdjacencies() {
		return adjacencies;
	}

	/**
	 * @param adjacencies
	 *            the adjacencies to set
	 */
	public void setAdjacencies(List<AdjacencyBean> adjacencies) {
		this.adjacencies = adjacencies;
	}

	/**
	 * @return the zone
	 */
	public ZoneBean getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(ZoneBean zone) {
		this.zone = zone;
	}

	/**
	 * @return the number of troops on ground
	 */
	public Integer getTroopsOnGround() {
		return troopsOnGround;
	}

	/**
	 * @param the number of troops on ground to set
	 */
	public void setTroopsOnGround(Integer troopsOnGround) {
		this.troopsOnGround = troopsOnGround;
	}
}
