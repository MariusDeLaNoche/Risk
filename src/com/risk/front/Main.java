package com.risk.front;

import java.util.List;

import com.risk.dao.MapDAO;
import com.risk.dao.ModeDAO;
import com.risk.metier.BeanCreator;
import com.risk.metier.XmlReader;
import com.risk.front.MainHelper;

/**
 * 
 * @author Alex
 *
 */
public class Main {
	
	public static void main(String[] args) {
		// Art magnifique++
		System.out.println("_-' RISK '-_\n");
		System.out.println("Bienvenue!");

		XmlReader xml = new XmlReader();
		MapDAO map = xml.unmarshalXML();
		BeanCreator beanCreator = new BeanCreator(map);
		List<ModeDAO> lesModes = map.getModes().getModes();

		// Demande du nombre de joueurs et récupération du mode de jeu correspondant
		ModeDAO modeJeu = MainHelper.askNbPlayers(lesModes);
		
		// Création des beans des joueurs
		beanCreator.setPlayers(
				MainHelper.askPlayersNames(modeJeu.getPlayers()));
		
		
		
		
		
		System.out.println("");
	}

}