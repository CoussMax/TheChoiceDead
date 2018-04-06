package Sortie;

import Univers.Lieux;

/**
 * <b>Cette classe représente une Sortie</b>
 * <p>
 * Une sortie est caractérisée par :
 * <ul>
 * <li>un nom</li>
 * <li>un lieu vers lequel elle mène</li>
 * </ul>
 * Une sortie va permettre (comme son nom l'indique) au joueur de sortir d'un
 * lieu pour se rendre dans un nouveau lieu (passé d'un lieu à un autre).
 * </p>
 */
public class Sortie {

	/**
	 * Nom de la sortie
	 *
	 * @see Sortie#Sortie(String, Lieux)
	 * @see Sortie#getNom()
	 */
	private String nom;

	/**
	 * Lieu vers lequel va la sortie
	 *
	 * @see Sortie#Sortie(String, Lieux)
	 * @see Sortie#getLieu()
	 */
	private Lieux lieu;

	/**
	 * Constructeur de Sortie
	 *
	 * @param nom
	 *            Nom de la sortie
	 * @param lieu
	 *            Nom du lieu vers lequel va la sortie
	 */
	public Sortie(String nom, Lieux lieu) {
		this.nom = nom;
		this.lieu = lieu;
	}

	/**
	 * Retourne le lieu vers lequel va la sortie
	 *
	 * @return une instance de Lieux
	 */
	public Lieux getLieu() {
		return lieu;
	}

	/**
	 * Retourne le nom de la sortie
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}
}
