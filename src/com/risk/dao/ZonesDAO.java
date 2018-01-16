package com.risk.dao;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Giraud
 *
 */
public class ZonesDAO {
	private List<ZoneDAO> listZone = new LinkedList<ZoneDAO>();

	/**
	 * @return the listZone
	 */
	@XmlElement(name = "zone")
	public List<ZoneDAO> getListZone() {
		return listZone;
	}

	/**
	 * @param listZone the listZone to set
	 */
	public void setListZone(List<ZoneDAO> listZone) {
		this.listZone = listZone;
	}
}
