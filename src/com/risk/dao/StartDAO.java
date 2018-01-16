package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class StartDAO {
	private RegionDAO region;

	/**
	 * @return the region
	 */
	@XmlElement(name = "region")
	public RegionDAO getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	@XmlElement(name = "region")
	public void setRegion(RegionDAO region) {
		this.region = region;
	}
	
}
