package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapDAO {
	private RegionsDAO regions;
	private ZonesDAO zones;
	private AdjacenciesDAO adjacencies;
	private ModesDAO modes;
	private Integer minimal;
	private Integer divisor;
	
	
	/**
	 * @return the regions
	 */
	@XmlElement(name = "regions")
	public RegionsDAO getRegions() {
		return regions;
	}
	
	/**
	 * @param regions the regions to set
	 */
	@XmlElement(name = "regions")
	public void setRegions(RegionsDAO regions) {
		this.regions = regions;
	}
	
	/**
	 * @return the zones
	 */
	@XmlElement(name = "zones")
	public ZonesDAO getZones() {
		return zones;
	}
	
	/**
	 * @param zones the zones to set
	 */
	@XmlElement(name = "zones")
	public void setZones(ZonesDAO zones) {
		this.zones = zones;
	}
	
	/**
	 * @return the adjacencies
	 */
	@XmlElement(name = "adjacencies")
	public AdjacenciesDAO getAdjacencies() {
		return adjacencies;
	}
	
	/**
	 * @param adjacencies the adjacencies to set
	 */
	@XmlElement(name = "adjacencies")
	public void setAdjacencies(AdjacenciesDAO adjacencies) {
		this.adjacencies = adjacencies;
	}
	
	/**
	 * @return the modes
	 */
	@XmlElement(name = "modes")
	public ModesDAO getModes() {
		return modes;
	}

	/**
	 * @param modes the modes to set
	 */
	@XmlElement(name = "modes")
	public void setModes(ModesDAO modes) {
		this.modes = modes;
	}
	
	/**
	 * @return the minimal
	 */
	@XmlValue
	public Integer getMinimal() {
		return minimal;
	}
	
	/**
	 * @param minimal the minimal to set
	 */
	@XmlValue
	public void setMinimal(Integer minimal) {
		this.minimal = minimal;
	}
	
	/**
	 * @return the divisor
	 */
	@XmlValue
	public Integer getDivisor() {
		return divisor;
	}
	
	/**
	 * @param divisor the divisor to set
	 */
	@XmlValue
	public void setDivisor(Integer divisor) {
		this.divisor = divisor;
	}
}
