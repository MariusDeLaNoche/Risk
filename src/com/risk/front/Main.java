package com.risk.front;

import java.io.IOException;
import java.util.List;

import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
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
		MapDAO mapDAO = xml.unmarshalXML();
		BeanCreator beanCreator = new BeanCreator(mapDAO);
		
		// On transmet les règles de la partie
		MainHelper.setRule(beanCreator.getRule());

		// Demande du nombre de joueurs et récupération du mode de jeu correspondant
		List<ModeDAO> lesModes = mapDAO.getModes().getModes();
		ModeDAO modeDAO = MainHelper.askNbPlayers(lesModes);

		// Demande du nom des joueurs et création des beans des joueurs
		List<PlayerBean> players = beanCreator.setPlayers(MainHelper.askPlayersNames(modeDAO.getPlayers()), modeDAO.getInitial());
		
		// Assignation des régions aux joueurs
		List<RegionBean> freeRegions = MainHelper.assignRegion(players, beanCreator.getRegions());
		
		// Placement des troupes de chaque joueur
		MainHelper.deployTroops(players);

		// Effectuer les tours de jeu
		MainHelper.doGameRound(players, freeRegions, beanCreator.getListZones());
		
		System.out.println("");
	}

}