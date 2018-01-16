package com.risk.dao;

import javax.xml.bind.annotation.XmlValue;

/**
 * 
 * @author Alex
 *
 */
public class MoveDAO {
	private String name;

	/**
	 * @return the name
	 */
	@XmlValue
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlValue
	public void setName(String name) {
		this.name = name;
	}
	
}
