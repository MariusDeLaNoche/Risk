package com.risk.front;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.risk.dao.MapDAO;
import com.risk.dao.ModeDAO;
import com.risk.dao.RegionDAO;
import com.risk.metier.XmlReader;
import com.risk.front.MainHelper;

/**
 * 
 * @author Alex
 *
 */
public class Main {

	static int nbJoueurs;
	
	public static void main(String[] args) {
		// Art magnifique++
		System.out.println("_-' RISK '-_\n");
		System.out.println("Bienvenue!");
		
		XmlReader xml = new XmlReader();
		MapDAO map = xml.unmarshalXML();
		List<RegionDAO> lesRegions = map.getRegions().getListRegion();
		List<ModeDAO> lesModes = map.getModes().getModes();
		
		
		String demandeNbJoueurs = "Nouvelle partie : choisir un nombre de joueurs = ";		
		do { nbJoueurs = MainHelper.getInputNumber(demandeNbJoueurs); }
		while (lesModes.stream().noneMatch(o -> o.getPlayers() != nbJoueurs));
		
		
		
		
		
		
		
		
		System.out.println("");
	}

}