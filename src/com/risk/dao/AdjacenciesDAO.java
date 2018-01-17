package com.risk.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class AdjacenciesDAO {
	private List<AdjacencyDAO> listAdjacency;

	/**
	 * @return the adjacency
	 */
	@XmlElement(name = "adjacency")
	public List<AdjacencyDAO> getListAdjacency() {
		return listAdjacency;
	}

	/**
	 * @param adjacency the adjacency to set
	 */
	public void setListAdjacency(List<AdjacencyDAO> listAdjacency) {
		this.listAdjacency = listAdjacency;
	}
}
