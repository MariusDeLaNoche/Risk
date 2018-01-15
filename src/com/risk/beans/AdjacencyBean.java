package com.risk.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean représentant une adjacence
 * Une region contient plusieurs adjacences. La region contenant des adjacences est condidérée comme le point de départ de toutes ses adjacences.
 * Du coup, la region contenue dans ce bean (AdjacencyBean) symbolise la région d'arrivée d'une adjacency.
 * @author Alex
 *
 */
public class AdjacencyBean {
	private RegionBean region;
	private List<String> moves;
	
	/**
	 * Constructeur complet d'une adjacence
	 * @param aRegion la region d'arrivée
	 * @param someMoves les mouvement disponible pour ce rendre à cette region
	 */
	public AdjacencyBean (RegionBean aRegion, List<String> someMoves) {
		this.region = aRegion;
		this.moves = someMoves;
	}
	
	/**
	 * Constructeur d'une adjacence sans mouvements
	 * @param aRegion la region d'arrivée
	 */
	public AdjacencyBean (RegionBean aRegion) {
		this.region = aRegion;
		this.moves = new ArrayList<String>();
	}

	// ------
	// --- METHODES
	// ------
	
	/**
	 * Ajoute un mouvement dans la liste des mouvements de l'adjacence courante
	 * @param aMove le mouvement a ajouter
	 * @return boolean, true si ajout OK, false si le move existait déjà dans la liste
	 */
	public boolean addMove(String aMove) {
		// Mouvement courant deja dans la liste des mouvements?
		boolean isAlreadyPresent = this.moves.stream().filter(o -> o.equals(aMove)).findFirst().isPresent();
		if (!isAlreadyPresent)
			this.moves.add(aMove);
		return !isAlreadyPresent;
	}
	
	// ------
	// --- ACCESSEURS
	// ------
	
	/**
	 * @return the region
	 */
	public RegionBean getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(RegionBean region) {
		this.region = region;
	}

	/**
	 * @return the moves
	 */
	public List<String> getMoves() {
		return moves;
	}

	/**
	 * @param moves the moves to set
	 */
	public void setMoves(List<String> moves) {
		this.moves = moves;
	}
}
