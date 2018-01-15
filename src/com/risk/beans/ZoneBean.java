package com.risk.beans;

import java.util.List;

/**
 * @author Giraud
 * Objet définissant une zone
 */

public class ZoneBean {
	private String name;
	private int bonus;
	private List<RegionBean> regions;
	
	/**
	 * Constructeur
	 * @param name Nom de la zone
	 * @param bonus Bonus lié à la zone
	 * @param regions Régions présentes dans la zone
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

	/**
	 * Ajoute une région à la zone
	 * @param region Region à ajouter
	 */
	public Boolean addRegion(RegionBean region) {
		// On test la présence de la région
		boolean isAlready = this.regions.stream().filter(o -> o.getName().equals(region.getName())).findFirst().isPresent();
		if (!isAlready)
			regions.add(region);
		return !isAlready;	
	}
	
	
	/**
	 * Supprime une région à la zone
	 * @param region Région à supprimer
	 */
	public void removeRegion(RegionBean region) {
		RegionBean r = this.regions.stream().filter(o -> o.getName().equals(region.getName())).findFirst().orElse(null);
		if(r != null)
			regions.remove(r);
	}
}
