package com.risk.beans;

/**
 * @author Giraud
 * Objet définissant les règles de la partie
 */

public class RuleBean {
	private Integer players;
	private Integer initial;
	private Integer minimal;
	private Integer divisor;
	
	/**
	 * Constructeur
	 * @param players Nombre de joueurs
	 * @param initial Nombre de troupe par joueur
	 * @param minimal Nombre minimal de renforts par tour
	 * @param divisor Diviseur du bonus de renfort
	 */
	public RuleBean(int players, int initial, int minimal, int divisor) {
		this.players = players;
		this.initial = initial;
		this.minimal = minimal;
		this.divisor = divisor;
	}

	/**
	 * @return the players
	 */
	public int getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(int players) {
		this.players = players;
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
	 * @return the minimal
	 */
	public int getMinimal() {
		return minimal;
	}

	/**
	 * @param minimal the minimal to set
	 */
	public void setMinimal(int minimal) {
		this.minimal = minimal;
	}

	/**
	 * @return the divisor
	 */
	public int getDivisor() {
		return divisor;
	}

	/**
	 * @param divisor the divisor to set
	 */
	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}
}
