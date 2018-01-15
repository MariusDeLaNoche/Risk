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
	private List<AdjacencyBean> adjacencies;

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
				.filter(o -> o.getRegion().getName().equals(anAdjacency.getRegion().getName())).findFirst().isPresent();
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
}
