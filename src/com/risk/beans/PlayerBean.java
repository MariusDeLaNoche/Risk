package com.risk.beans;

import java.util.List;

/**
 * @author Giraud
 * Objet définissant un joueur
 */

public class PlayerBean {
	private String name;
	private int initial;
	private List<RegionBean> regions;
	
	/**
	 * Constructeur
	 * @param name Nom du joueur
	 * @param initial Nombre de troupe du joueur
	 */
	public PlayerBean(String name, int initial) {
		this.name = name;
		this.initial = initial;
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
	 * @return the initial
	 */
	public int getInitial() {
		return initial;
	}

	/**
	 * @param initial the initial to set
	 */
	public void setInitial(int initial) {
		this.initial = initial;
	}
	
	/**
	 * Retourne la liste des régions
	 * @return Régions
	 */
	public List<RegionBean> getRegions() {
		return this.regions;
	}
	
	/**
	 * Ajoute une région au joueur
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
	 * Supprime une région au joueur
	 * @param region Région à supprimer
	 */
	public void removeRegion(RegionBean region) {
		RegionBean r = this.regions.stream().filter(o -> o.getName().equals(region.getName())).findFirst().orElse(null);
		if(r != null)
			regions.remove(r);
	}
	
}
