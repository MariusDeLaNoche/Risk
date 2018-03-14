package com.risk.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giraud
 * Objet définissant un joueur
 */

public class PlayerBean {
	private String name;
	private Integer initial;
	private List<RegionBean> regions;
	
	/**
	 * Constructeur
	 * @param name Nom du joueur
	 * @param initial Nombre de troupe du joueur
	 */
	public PlayerBean(String name, int initial) {
		this.name = name;
		this.initial = initial;
		this.regions = new ArrayList<>();
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
	 * @return the initial number of troops
	 */
	public int getInitial() {
		return initial;
	}

	/**
	 * @param initial the initial number of troops to set
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
	
	// ------
	// --- METHODES
	// ------
	
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
		regions.remove(region);
	}

	/**
	 * Retourne la liste des zones entierrement possédées par le joueur
	 * @param les zones a vérifier
	 * @return la liste des zones possédées
	 */
	public List<ZoneBean> getOwnedZones(List<ZoneBean> zones) {
		ArrayList<ZoneBean> ownedZones = new ArrayList<>();
		for(ZoneBean z : zones) {
			if (this.getRegions().containsAll(z.getRegions()))
				ownedZones.add(z);
		}
		return ownedZones;
	}
	
}
