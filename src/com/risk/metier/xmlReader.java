package com.risk.metier;

import java.io.File;

/**
 * Classe permettant la lecutre d'un fichier XML à l'aide de l'API JABX
 * 
 * @author Alex
 *
 */
public class xmlReader {

	/**
	 * Instancie un objet File correspondant au fichier xml dont le chemin est
	 * spécifié dans risk.properties
	 * 
	 * @return File, une instance du fichier XML ou null chemin fichier invalide
	 */
	public File getXMLFile() {
		File xmlFile = null;
		try {
			xmlFile = new File(propertiesReader.getMapPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlFile;
	}
}
