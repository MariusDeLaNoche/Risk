package com.risk.dao;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Giraud
 *
 */
public class RegionsDAO {
	private List<RegionDAO> listRegion = new LinkedList<RegionDAO>();

	/**
	 * @return the listRegion
	 */
	@XmlElement(name = "region")
	public List<RegionDAO> getListRegion() {
		return listRegion;
	}

	/**
	 * @param listRegion the listRegion to set
	 */
	public void setListRegion(List<RegionDAO> listRegion) {
		this.listRegion = listRegion;
	}
	

}
