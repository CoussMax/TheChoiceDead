package Utilitaire;

/**
 * <b>Enumération contenant les différents codes secrets pour la sortie
 * verrouillée</b>
 */
public enum Commande {
	AIDE("Aide"), INVENTAIRE("Inventaire"), ALLER("Aller"), OBJECTIF("Objectif"), PRENDRE("Prendre"), UTILISER(
			"Utiliser"), OUVRIR(
					"Ouvrir"), ATTAQUER("Attaquer"), QUITTER("Quitter"), SAUVEGARDER("Sauvegarder"), CHARGER("Charger");

	/**
	 * Nom d'une commande
	 *
	 */
	private String name = "";

	/**
	 * Constructeur de la commande
	 * 
	 * @param name
	 *            Nom de la commande
	 */
	Commande(String name) {
		this.name = name;
	}

	/**
	 * Retourne le nom de la commande
	 *
	 * @return un String
	 */
	public String getName() {
		return name;
	}

}
