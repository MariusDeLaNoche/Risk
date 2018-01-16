package com.risk.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class ModesDAO {
	private List<ModeDAO> modes;

	/**
	 * @return the modes
	 */
	@XmlElement(name = "mode")
	public List<ModeDAO> getModes() {
		return modes;
	}

	/**
	 * @param modes the modes to set
	 */
	public void setModes(List<ModeDAO> modes) {
		this.modes = modes;
	}
}
