package com.risk.front;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.risk.dao.ModeDAO;

/**
 * 
 * @author Alex
 *
 */
public class MainHelper {

	static int nbJoueurs;
	
	/**
	 * Retourne le mode de jeu correspondant au nombre de joueurs demandé par l'utilisateur
	 * @return le mode de jeu choisit
	 */
	public static ModeDAO askNbPlayers(List<ModeDAO> lesModes) {
		String demandeNbJoueurs = "Nouvelle partie : choisir un nombre de joueurs >= 2 : ";	
		nbJoueurs = MainHelper.getInputNumber(demandeNbJoueurs);

		while (lesModes.stream().noneMatch(o -> o.getPlayers() != nbJoueurs)) {
			System.out.println("Aucun mode de jeu ne correspond à ce nombre de joueurs. Veuillez saisir un nouveau nombre : ");
			nbJoueurs = MainHelper.getInputNumber(demandeNbJoueurs);
		}
		
		return lesModes.stream().filter(o -> o.getPlayers() == nbJoueurs).findFirst().get();
	}
	
	/**
	 * Demande autant de noms de joueurs que spécifié en paramètre, et retourne la liste des noms
	 * @param nbPlayers le nombre de joueurs
	 * @return la liste des noms choisis par l'utilisateur
	 */
	public static List<String> askPlayersNames(int nbPlayers) {
		List<String> listeNoms = new ArrayList<String>();
		for (int i = 0; i < nbPlayers; i++) {
			listeNoms.add(getInputString("Veuillez entrer le nom du joueur " + (i + 1) + " : "));
		}
		return listeNoms;
	}
	
	/**
	 * Permet de récuperer un entier saisi par l'utilisateur, avec une phrase personalisable
	 * @param text la phrase a afficher
	 * @return l'entier entré par l'utilisateur
	 */
	public static int getInputNumber(String text) {
		System.out.println(text);
		String input = System.console().readLine();
		
		while(StringUtils.isNumeric(input)) {
			System.out.println("Saisie invalide. Veuillez saisir un nombre!");
			System.out.println("Nouvel essai : ");
			input = System.console().readLine();
		}
		
		return Integer.parseInt(input);
	}
	
	/**
	 * Permet de récuperer une chaine de caracteres saisie par l'utilisateur, avec une phrase personalisable
	 * @param text la phrase a afficher
	 * @return la chaine entrée par l'utilisateur
	 */
	public static String getInputString(String text) {
		System.out.println(text);
		String input = System.console().readLine();
		
		while(input.length() == 0) {
			System.out.println("Saisie invalide. Veuillez saisir une chaine de caractères!");
			System.out.println("Nouvel essai : ");
			input = System.console().readLine();
		}
		
		return input;
	}
}
