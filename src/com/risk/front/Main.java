package com.risk.front;

import java.awt.GraphicsEnvironment;
import java.io.Console;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException {		
		// Magnifique ASCII art
		System.out.println("_-' RISK '-_\n");
		System.out.println("Bienvenue!");
		
		// Instanciation des classes DAO avec JAXB
		XmlReader xml = new XmlReader();
		MapDAO map = xml.unmarshalXML();
		BeanCreator beanCreator = new BeanCreator(map);

		// Demande du nombre de joueurs et récupération du mode de jeu correspondant
		List<ModeDAO> lesModes = map.getModes().getModes();
		ModeDAO modeJeu = MainHelper.askNbPlayers(lesModes);

		// Demande du nom des joueurs et création des beans des joueurs
		beanCreator.setPlayers(MainHelper.askPlayersNames(modeJeu.getPlayers()), modeJeu.getInitial());

		System.out.println("");
	}

}