package com.risk.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
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
	 * @throws IOException 
	 */
	public static ModeDAO askNbPlayers(List<ModeDAO> lesModes) throws IOException {
		String demandeNbJoueurs = "Nouvelle partie : choisir un nombre de joueurs >= 2 : ";	
		nbJoueurs = MainHelper.getInputNumber(demandeNbJoueurs);

		while (!lesModes.stream().filter(o -> o.getPlayers().intValue() == nbJoueurs).findFirst().isPresent()) {
			System.out.println("Aucun mode de jeu ne correspond à ce nombre de joueurs. Veuillez saisir un nouveau nombre : ");
			nbJoueurs = MainHelper.getInputNumber(demandeNbJoueurs);
		}
		return lesModes.stream().filter(o -> o.getPlayers().intValue() == nbJoueurs).findFirst().get();
	}
	
	/**
	 * Demande autant de noms de joueurs que spécifié en paramètre, et retourne la liste des noms
	 * @param nbPlayers le nombre de joueurs
	 * @return la liste des noms choisis par l'utilisateur
	 * @throws IOException 
	 */
	public static List<String> askPlayersNames(int nbPlayers) throws IOException {
		List<String> listeNoms = new ArrayList<String>();
		for (int i = 0; i < nbPlayers; i++) {
			String unNom = getInputString("Veuillez entrer le nom du joueur " + (i + 1) + " : ");
			while(stringAlreadyExists(listeNoms, unNom)) {
				System.out.println("Ce nom existe déjà! Veuillez en choisir un autre :");
				unNom = getInputString("Veuillez entrer le nom du joueur " + (i + 1) + " : ");
			}
			listeNoms.add(unNom);
		}
		return listeNoms;
	}
	
	/**
	 * Permet de récuperer un entier saisi par l'utilisateur, avec une phrase personalisable
	 * @param text la phrase a afficher
	 * @return l'entier entré par l'utilisateur
	 * @throws IOException 
	 */
	public static int getInputNumber(String text) throws IOException {
		System.out.println(text);
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		while(!StringUtils.isNumeric(input)) {
			System.out.println("Saisie invalide. Veuillez saisir un nombre!");
			System.out.println("Nouvel essai : ");
			input = new BufferedReader(new InputStreamReader(System.in)).readLine();

		}
		return Integer.parseInt(input);
	}
	
	/**
	 * Permet de récuperer une chaine de caracteres saisie par l'utilisateur, avec une phrase personalisable
	 * @param text la phrase a afficher
	 * @return la chaine entrée par l'utilisateur
	 * @throws IOException 
	 */
	public static String getInputString(String text) throws IOException {
		System.out.println(text);
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		while(input.length() == 0) {
			System.out.println("Saisie invalide. Veuillez saisir une chaine de caractères!");
			System.out.println("Nouvel essai : ");
			input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		}
		return input;
	}
	
	/**
	 * Vérifie si une chaine de caracteres se trouve dans une liste
	 * @param lesStrings la liste a verifier
	 * @param stringCompare la chine de caractre
	 * @return true si existe deja, false sinon
	 */
	public static boolean stringAlreadyExists(List<String> lesStrings, String stringCompare) {
		return lesStrings.stream().anyMatch(o -> o.equals(stringCompare));
	}
	
	/**
	 * Assigne les régions aux joueurs
	 * @param players Liste des joueurs présents dans la partie
	 * @param regions Liste des regions
	 * @return La liste des régions non possédées
	 * @throws IOException 
	 */
	public static List<RegionBean> assignRegion(List<PlayerBean> players, List<RegionBean> regions) throws IOException {
		// Copie de la liste des regions afin de réaliser des manipulations
		List<RegionBean> copyRegions = new ArrayList<>();
		copyRegions.addAll(regions);
		
		int nbPlayers = players.size();
		
		System.out.println("\n--- Attribution des régions ---");
		// Tant que le nombre de régions non possédé est supérieur ou égal au nombre de joueurs
		while(copyRegions.size() >= nbPlayers) {
			
			// Pour chaque joueur
			for(PlayerBean player : players) {
				// Pour chaque région
				for(int i = 0; i < copyRegions.size(); i++) {
					// Affiche i avec le nom de la région
					System.out.println(i + ": " + copyRegions.get(i).getName());
				}
				
				// Demande un numéro au joueur
				int num;
				do {
					num = getInputNumber(player.getName() + ", sélectionnez une région: ");
				} while(num < 0 || num >= copyRegions.size());
		
				// On ajoute une troupe à la région
				RegionBean region = copyRegions.get(num);
				region.setTroopsOnGround(region.getTroopsOnGround() + 1);
				// Ajoute la région, correspondant au numéro, au joueur
				player.addRegion(region);
				player.setInitial(player.getInitial() - 1);
				
				// On supprime la région de la liste
				copyRegions.remove(num);
				
				System.out.println("\n-------------------------------\n");
			}
		}
		
		// On ajoute une troupe pour chaque régions non possédée
		for(RegionBean region : copyRegions) {
			region.setTroopsOnGround(region.getTroopsOnGround() + 1);
		}
		
		return copyRegions;
	}
	
	public static void deployTroops(List<PlayerBean> players) {
		
	}
}
