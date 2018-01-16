package com.risk.dao;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class AdjacencyDAO {
	private StartDAO start;
	private EndsDAO ends;
	
	/**
	 * @return the start
	 */
	@XmlElement(name = "start")
	public StartDAO getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(StartDAO start) {
		this.start = start;
	}
	/**
	 * @return the ends
	 */
	@XmlElement(name = "ends")
	public EndsDAO getEnds() {
		return ends;
	}
	/**
	 * @param ends the ends to set
	 */
	public void setEnds(EndsDAO ends) {
		this.ends = ends;
	}
	
	
}
