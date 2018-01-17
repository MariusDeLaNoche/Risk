package com.risk.front;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Alex
 *
 */
public class MainHelper {
	
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
			System.out.println("Nouvel essai = ");
			input = System.console().readLine();
		}
		
		return Integer.parseInt(input);
	}
}
