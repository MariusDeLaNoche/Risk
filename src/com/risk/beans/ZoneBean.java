package com.risk.beans;


/**
 * @author Giraud
 * Objet définissant une zone
 */

public class ZoneBean {
	private String name;
	private Integer bonus;
	
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
}
