package com.risk.front;

import com.risk.dao.MapDAO;
import com.risk.metier.XmlReader;

public class Main {

	public static void main(String[] args) {
		// Art magnifique++
		System.out.println("_-' RISK '-_");
		XmlReader xml = new XmlReader();
		MapDAO map = xml.unmarshalXML();
		System.out.println("");
	}

}
