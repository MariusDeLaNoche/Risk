package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class AdjacenciesDAO {
	private AdjacencyDAO adjacency;

	/**
	 * @return the adjacency
	 */
	@XmlElement(name = "adjacency")
	public AdjacencyDAO getAdjacency() {
		return adjacency;
	}

	/**
	 * @param adjacency the adjacency to set
	 */
	public void setAdjacency(AdjacencyDAO adjacency) {
		this.adjacency = adjacency;
	}
}
