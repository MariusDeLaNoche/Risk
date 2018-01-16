package com.risk.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Alex
 *
 */
public class EndsDAO {
	private List<EndDAO> endList;

	/**
	 * @return the endList
	 */
	@XmlElement(name = "end")
	public List<EndDAO> getEndList() {
		return endList;
	}

	/**
	 * @param endList the endList to set
	 */
	public void setEndList(List<EndDAO> endList) {
		this.endList = endList;
	}
}
