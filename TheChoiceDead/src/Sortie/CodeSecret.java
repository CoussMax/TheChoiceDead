package Sortie;

import java.util.Random;

/**
 * <b>Enumération dans laquelle se trouve les différents code secret à 6
 * lettre</b> c<
 */
public enum CodeSecret {

	ORANGE("orange"), SIFFLE("siffle"), ABOUTI("abouti"), BANANE("banane"), MARCHE("marche"), REGLES("regles"), SECRET(
			"secret"), COLLER("coller");

	/**
	 * Variable qui va contenir le constructeur aléatoirement choisi
	 *
	 * @see CodeSecret#randomCodeSecret(Object[])
	 */
	private static Random codeSecretAleatoire = new Random();

	/**
	 * Le code secret
	 *
	 * @see CodeSecret#CodeSecret(String)
	 * @see CodeSecret#getNom()
	 */
	private String nom;

	/**
	 * Constructeur de CodeSecret
	 *
	 * @param nom
	 *            Mot correspondant au code secret
	 */
	CodeSecret(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet de choisier aléatoirement un constructeur de l'enum
	 *
	 * @param elements
	 *            Tous les code secret présent dans la class CodeSecret
	 * @param <T>
	 *            Liste d'éléments inconnus
	 * @return un constructeur de l'énumération
	 */
	public <T> T randomCodeSecret(T[] elements) {
		return elements[codeSecretAleatoire.nextInt(elements.length)];
	}

	/**
	 * Retourne le code secret
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}

}
