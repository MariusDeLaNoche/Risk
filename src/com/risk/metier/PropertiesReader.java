package com.risk.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Cette classe s'occupe de fournir des données contenues dans le fichier de
 * configuration risk.properties
 * 
 * @author Alex
 *
 */
public class PropertiesReader {
	
	private static final String PROPERTIES_PATH = "risk.properties";
	
	/**
	 * Récupère le chemin du fichier XML contenant la carte du jeu
	 * @return le chemin du fichier
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getMapPath() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(PROPERTIES_PATH));
		return props.getProperty("mapPath"); 
	}
}
