package com.risk.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giraud
 * Objet définissant une zone
 */

public class ZoneBean {
	private String name;
	private Integer bonus;
	private List<RegionBean> regions;
	
	/**
	 * Constructeur
	 * @param name Nom de la zone
	 * @param bonus Bonus lié à la zone
	 * @param regions la liste de regions
	 */
	public ZoneBean(String name, int bonus, List<RegionBean> regions) {
		this.name = name;
		this.bonus = bonus;
		this.regions = regions;
	}
	
	/**
	 * Constructeur
	 * @param name Nom de la zone
	 * @param bonus Bonus lié à la zone
	 */
	public ZoneBean(String name, int bonus) {
		this.name = name;
		this.bonus = bonus;
		this.regions = new ArrayList<RegionBean>();
	}
	
	// ------
	// --- METHODES
	// ------
	
	/**
	 * Ajoute une région dans la liste des régions de la zone
	 * @param region
	 * @return boolean, true si ajout OK, false si la région existait déjà dans la liste
	 */
	public boolean addRegion(RegionBean r) {
		// Region courante deja dans la liste des regions de cette zone?
		boolean isAlreadyPresent = this.regions.stream().filter(o -> o.equals(r)).findFirst().isPresent();
		if (!isAlreadyPresent)
			this.regions.add(r);
		return !isAlreadyPresent;
	}

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
	public List<RegionBean> getRegions() {
		return regions;
	}
}
