package Objets;

import Contenants.Contenant;
import Personnages.Hero;
import Univers.Lieux;

/**
 * <b>Cette classe représente un Objet</b>
 * <p>
 * Un objet est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * </ul>
 * </br>
 * </p>
 *
 */
public abstract class Objet {

	/**
	 * Nom de l'objet
	 *
	 * @see Objet#Objet(String)
	 * @see Objet#toString()
	 */
	private String nom;

	/**
	 * Contenant de l'objet
	 *
	 * @see Objet#getContenant()
	 * @see Objet#setContenant(Contenant)
	 */
	private Contenant contenant = null;

	/**
	 * Hero associer à l'objet
	 *
	 * @see Objet#getHero()
	 * @see Objet#setHero(Hero)
	 */
	private Hero hero = null;

	/**
	 * Constructeur d'un objet
	 *
	 * @param nom
	 *            Nom de l'objet
	 */
	public Objet(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne le contenant de l'objet
	 *
	 * @return une instance de Contenant
	 */
	public Contenant getContenant() {
		return contenant;
	}

	/**
	 * Modifie le contenant de l'objet
	 *
	 * @param contenant
	 *            Nouveau contenant associé à l'objet
	 */
	public void setContenant(Contenant contenant) {
		this.contenant = contenant;
	}

	/**
	 * Retourne le héro rattacher à l'objet
	 *
	 * @return une instance de Hero
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * Modifie le héro rattacher à l'objet
	 *
	 * @see Hero#supprimerInvertaire(Objet)
	 * @see Hero#ajouterInventaire(Objet)
	 * @see Hero#Hero(String, int, int, Lieux, Arme)
	 * @param hero
	 *            Nouveau personnage associé à l'objet
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * Retourne le nom de l'objet
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Description d'un objet
	 *
	 * @return la description de l'objet sous forme d'un String
	 */
	public String toString() {
		return "nom = " + this.nom;
	}
}
