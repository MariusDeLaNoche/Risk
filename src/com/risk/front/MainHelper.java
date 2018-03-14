package com.risk.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;

import com.risk.beans.AdjacencyBean;
import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
import com.risk.beans.RuleBean;
import com.risk.beans.ZoneBean;
import com.risk.dao.ModeDAO;

/**
 * 
 * @author Alex
 *
 */
public class MainHelper {
	private static RuleBean ruleGame;
	static int nbJoueurs;
	
	/**
	 * @param rule Les règles définies pour la partie
	 */
	public static void setRule(RuleBean rule) {
		ruleGame = rule;
	}
	
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
	 * Permet de récupérer une région choisie par l'utilisateur
	 * @param regions La liste des régions sélectionnable par l'utilisateur
	 * @return La région choisie par l'utilisateur
	 * @throws IOException
	 */
	private static RegionBean getInputRegion(List<RegionBean> regions) throws IOException {
		// Choix d'une région possédée
		for(int i = 0; i < regions.size(); i++) {
			// Affiche i avec le nom de la région
			System.out.println(i + ": " + regions.get(i).getName() + 
					" (actuellement " + regions.get(i).getTroopsOnGround() + " troupe(s))");
		}
		int num;
		do {
			num = getInputNumber("Choisir une région: ");
		} while(num < 0 || num >= regions.size());

		// On retourne la région choisie
		return regions.get(num);
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
	
	/**
	 * Permet d'effectuer le placement initial des troupes d'un joueur
	 * @param players avec un liste de region possédées initialisée
	 * @throws IOException 
	 */
	public static void deployTroops(List<PlayerBean> players) throws IOException {
		System.out.println("\n--- Chaque joueur va maintenant placer ses troupes ---");
		
		for (PlayerBean p : players) {
			// on recupère le nombre de troupes que le joueur doit placer, et les régions qu'il possède
			int remainingTroops = p.getInitial();
			List<RegionBean> regions = p.getRegions();
			
			// tant qu'il y a des troupes non attribuées
			while (remainingTroops > 0) {
				System.out.println(p.getName() + ", il vous reste " + remainingTroops + " troupe(s) à placer.");
				
				// on affiche la liste des régions avec le nombre de troupes déjà placées
				for(int i = 0 ; i < regions.size(); i++) {
					System.out.println(i + ". " + regions.get(i).getZone().getName() + " " + regions.get(i).getName() + 
							" (actuellement " + regions.get(i).getTroopsOnGround() + " troupes)");
				}
				// on récupère le choix du joueur
				Integer numRegion = -1;
				while (numRegion < 0 || numRegion >= regions.size()) {
					numRegion = getInputNumber(
						p.getName() + ", veuillez saisir le numéro de la région à peupler : ");
					if (numRegion < 0 || numRegion >= regions.size()) {
						System.out.println("Ce numéro de région n'existe pas.");
					}
				}
				// on récupère le nombre de troupes
				Integer nbTroops = -1;
				while (nbTroops < 0 || nbTroops > remainingTroops) {
					nbTroops = getInputNumber(
							p.getName() + ", veuillez entrer le nombre de troupes à placer dans " + 
							regions.get(numRegion).getName() + " : ");
					if (nbTroops < 0 || nbTroops > remainingTroops) {
						System.out.println("Le nombre de troupes saisi est invalide.");
					}
				}
				// placement des troupes selon les infos saisies
				regions.get(numRegion).setTroopsOnGround(
						regions.get(numRegion).getTroopsOnGround() + nbTroops);
				// on prend en compte le nombre de troupes placées
				remainingTroops = remainingTroops - nbTroops;
				
				System.out.println("\n-------------------------------\n");
			}
		}
	}
	
	/**
	 * Tours de jeu
	 * @param players La liste des joueurs
	 * @param regions La liste des régions non possédées
	 * @param zones La liste des zones du jeu
	 * @throws IOException 
	 */
	public static void doGameRound(List<PlayerBean> players, List<RegionBean> freeRegions, List<ZoneBean> zones) throws IOException {
		System.out.println("Début de la partie\n");
		
		List<PlayerBean> playersInGame = new ArrayList<>();
		playersInGame.addAll(players);
		
		while(playersInGame.size() > 1) {
			for(PlayerBean player : playersInGame) {
				System.out.println("Joueur " + player.getName());
				// Déploiement
				deployment(player, zones);
				// Guerre
				PlayerBean looser = war(player, playersInGame, freeRegions); 
				// Renforcement
				reinforcement(player); 
				// Si un joueur vient de perde sa dernière région sur cette manche on le retire des joueurs en jeu
				if (looser != null)
					playersInGame.remove(looser); 
				// Si il y a moins de deux joueurs en jeu, on termine
				if(playersInGame.size() < 2)
					break;
				System.out.println("-------------------------------\n");
			}
			
			// Affiche du joueur gagnant
			System.out.println("Partie terminée! " + playersInGame.get(0).getName() + " remporte la victoire!");
		}
	}
	
	/**
	 * Déploiement
	 * @param player Joueur sur lequel agir
	 * @param zones La liste des zones du jeu
	 * @throws IOException 
	 */
	private static void deployment(PlayerBean player, List<ZoneBean> zones) throws IOException {
		System.out.println("Déploiement");
		int nbMinRenfort = ruleGame.getMinimal();
		
		/*
		 * Somme des bonus de renfort des régions possédées et des bonus de renfort des zones
		 * dont toutes les régions sont possédées divisée par ruleGame.getDivisor()
		 * et arrondie à l'entier inférieur
		 */
		int nbRenfortCalculee = 0; 
		// Ajout du bonus de chaque région possédée
		for(RegionBean r : player.getRegions())
			nbRenfortCalculee += r.getBonus();
		// Ajout du bonus de chaque zone entierrement possédée
		for(ZoneBean z : player.getOwnedZones(zones))
			nbRenfortCalculee += z.getBonus();	
		// Application du divisor (resultat arrondi à l'entier inferieur car stocké dans un int)
		nbRenfortCalculee = (nbRenfortCalculee / ruleGame.getDivisor());
		
		// On prend la valeur la plus grande
		int renfort = (nbRenfortCalculee > nbMinRenfort)? nbRenfortCalculee : nbMinRenfort;
		
		while(renfort > 0) {
			System.out.println("Il vous reste " + renfort + " renforts à déployer\n");
			
			// Choix d'une région possédée
			RegionBean region = getInputRegion(player.getRegions());
			
			// Choix du nombre de troupe à déployer D
			int nbDeployer;
			do {
				nbDeployer = getInputNumber("Nombre de troupes à déployer: ");
			} while(nbDeployer < 1 || nbDeployer > renfort);
						
			// On applique
			region.setTroopsOnGround(region.getTroopsOnGround() + nbDeployer);
			renfort -= nbDeployer;
		}
	}
	
	/**
	 * Attaque d'une région
	 * @param player Joueur sur lequel agir
	 * @param players Liste des joueurs de la partie
	 * @param freeRegions Liste des regions occupées par aucun joueur
	 * @throws IOException
	 */
	private static PlayerBean war(PlayerBean player, List<PlayerBean> players, List<RegionBean> freeRegions) throws IOException {
		PlayerBean playerLoose = null;
		
		System.out.println("Attaque");
		while(true) {
			int rep = getInputNumber("\nSouhaitez-vous attaquer une région ? (0: non, 1: oui)");
			if(rep == 0)
				break;
			else if(rep != 1)
				continue;
			else {
				// L'utilisateur souhaite attaquer une région
				System.out.println("Choisir la région de départ");
				RegionBean regionStart = getInputRegion(player.getRegions());
				
				int troopsStart = regionStart.getTroopsOnGround(); // Le nombre de troupe sur la région de départ
				if(troopsStart < 2) {
					System.out.println("La région doit contenir au moins 2 troupes");
					continue;
				}
				
				// Récupération des régions adjacente qui ne sont pas possédées
				ArrayList<RegionBean> regionsAdjaNotOwned = new ArrayList<>();
				for(AdjacencyBean adjacency : regionStart.getAdjacencies()) {
					if(!player.getRegions().contains(adjacency.getRegion()));
						regionsAdjaNotOwned.add(adjacency.getRegion());
				}
				
				// Selection d'une région par l'utilisateur
				RegionBean regionEnd = getInputRegion(regionsAdjaNotOwned);
				
				int troopsEnd = regionEnd.getTroopsOnGround(); // Le nombre de troupe sur la région d'arrivé
				
				// Choix du nombre de troupe à déployer
				int troopsToDeploy = 0;
				int troopsMax = Math.min(troopsStart - 1, 3);
				do {
					troopsToDeploy = getInputNumber("Nombre de troupe à déployer (entre 1 et " + troopsMax + "): ");
				} while(troopsToDeploy < 1 || troopsToDeploy > troopsMax); // entre 1 et min(troopsStart-1, 3)
					
				// Validation par l'utilisateur
				int validationUser = -1;
				do {
					validationUser = getInputNumber("Valider ? (0: non, 1: oui)");
				} while(validationUser != 0 && validationUser != 1);
				
				if(validationUser == 0)
					continue;
				
				// On retire ces troupes de la région de départ
				regionStart.setTroopsOnGround(troopsStart - troopsToDeploy);
				
				
				// Calcul résultat de l'attaquant et du défenseur
				int resAttaquant = calculResultat(troopsToDeploy);
				System.out.println("Resultat attaquant: " + resAttaquant);
				int resDefenseur = calculResultat(troopsEnd);
				System.out.println("Resultat défenseur: " + resDefenseur);
				
				// Cas d'une attaque réussie
				if(resAttaquant > resDefenseur) {
					System.out.println("L'attaque a réussi");
					// Le nombre de troupes dans la région conquise devient le nombre de troupes déployées
					regionEnd.setTroopsOnGround(troopsToDeploy);
					// Si la région est libre, on la retire de la liste des régions libres
					if(freeRegions.contains(regionEnd)) {
						freeRegions.remove(regionEnd);
					}
					// Sinon elle appartient à un joueur, donc on lui retire la region
					else {
						PlayerBean playerWarLooser = null;
						// On retrouve le joueur possedant la region
						for(PlayerBean p : players) {
							if(p.getRegions().contains(regionEnd)) {
								playerWarLooser = p;
								// On lui retire la region
								p.removeRegion(regionEnd);
							}
						}
						// On regarde si le joueur perdant possède encore une région
						if (playerWarLooser.getRegions().size() == 0) {
							playerLoose = playerWarLooser;
						}
					}
					// Ajouter la région à l'attaquant
					player.addRegion(regionEnd);
				} else {
					System.out.println("L'attaque a échoué");
				}
				
				System.out.println("Troupe(s) restante(s) sur " + regionStart.getName() + ": " + regionStart.getTroopsOnGround());
				System.out.println("Troupe(s) restante(s) sur " + regionEnd.getName() + ": " + regionEnd.getTroopsOnGround());
				break;
			}
		}
		
		return playerLoose;
	}
	
	/**
	 * Calcul le résultat d'une bataille selon le nombre de troupe renseignées
	 * @param troopNumber Le nombre de troupe à prendre en compte
	 * @return
	 */
	private static int calculResultat(int troopNumber) {
		int res = 0;
		for(int i = 0; i < troopNumber; i++) {
			// Génération d'un nombre aléatoire entre 1 et 6 (le +1 est voulu :3)
			res += ThreadLocalRandom.current().nextInt(1, 6 + 1);
		}
		
		return res; 
	}
	
	/**
	 * Renforcement
	 * @param player Joueur sur lequel agir
	 * @throws IOException
	 */
	private static void reinforcement(PlayerBean player) throws IOException {
		System.out.println("Renforcement");
		
		while(true) {
			int rep = getInputNumber("\nSouhaitez-vous renforcer une région ? (0: non, 1: oui)");
			if(rep == 0)
				break;
			else if(rep != 1)
				continue;
			else {
				// L'utilisateur souhaite renforcer une région
				RegionBean regionEnd = getInputRegion(player.getRegions());
				ArrayList<RegionBean> regionsAdjaOwned = new ArrayList<>();
				for(AdjacencyBean adjacency : regionEnd.getAdjacencies()) {
					RegionBean regionOwned = player.getRegions()
							.stream()
							.filter(r -> r.getName().equals(adjacency.getRegion().getName()))
							.findFirst()
							.orElse(null);
					
					if(regionOwned != null && regionOwned.getTroopsOnGround() > 1)
						regionsAdjaOwned.add(regionOwned);
				}
				if(regionsAdjaOwned.size() == 0) {
					System.out.println("La région sélectionnée ne peut être renforcée car aucune région possédée avec suffisament de troupe n'y est adjacente");
					continue;
				}
				RegionBean regionStart = getInputRegion(regionsAdjaOwned);
				
				int troopsStart = regionStart.getTroopsOnGround(); // Le nombre de troupe sur la région de départ
				int troopsEnd = regionEnd.getTroopsOnGround(); // Le nombre de troupe sur la région d'arrivé
				
				System.out.println("\nVous avez " + troopsStart + " dans la région " + regionStart.getName());
				System.out.println("Vous avez " + troopsEnd + " dans la région " + regionEnd.getName()+"\n");
				
				int number = -1;
				do {
					number = getInputNumber("Indiquer le nombre de troupe entre 1 et " 
				+ (troopsStart - 1) +
				" à déployer de " 
				+ regionStart.getName() +
				" à " 
				+ regionEnd.getName() + " (0 pour revenir en arrière): ");
				} while(number != 0 && (number < 1 || number >= troopsStart));
				
				if(number == 0) // Cas ou l'utilisateur souhaite revenir en arrière
					continue;
				
				// On effectue le déplacement
				regionStart.setTroopsOnGround(troopsStart - number);
				regionEnd.setTroopsOnGround(troopsEnd + number);
				break;
			}
		}
	}
}
