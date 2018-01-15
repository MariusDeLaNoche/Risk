package com.risk.beans;

import java.util.List;

/**
 * Bean d'une région
 * 
 * @author Alex
 *
 */
public class RegionBean {
	private String name;
	private String bonus;
	private List<RegionBean> adjacencies;

	/**
	 * Constructeur region
	 * 
	 * @param aName
	 * @param aBonus
	 */
	public RegionBean(String aName, String aBonus) {
		this.name = aName;
		this.bonus = aBonus;
	}

	// ------
	// --- METHODES
	// ------
	
	/**
	 * Ajoute une region dans la liste des adjacences de la region courante
	 * @param aRegion la region a ajouter
	 * @return boolean, true si ajout OK, false si la region existait déjà dans la liste
	 */
	public boolean addRegionAdjacency(RegionBean aRegion) {
		// Region deja dans la liste des adjacences?
		boolean isAlreadyAdjacent = this.adjacencies.stream().filter(o -> o.getName().equals(aRegion.getName())).findFirst().isPresent();
		if (!isAlreadyAdjacent)
			this.adjacencies.add(aRegion);
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
	public String getBonus() {
		return bonus;
	}

	/**
	 * @param bonus
	 *            the bonus to set
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
	 * @param adjacencies
	 *            the adjacencies to set
	 */
	public void setAdjacencies(List<RegionBean> adjacencies) {
		this.adjacencies = adjacencies;
	}
}
