package Personnages;

import Interfaces.Explosable;
import Univers.Lieux;
import Utilitaire.Exploser;

/**
 * <b>Cette classe représente un kamikase (un type de monstre)</b>
 * <p>
 * Un kamikase est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une santé</li>
 * <li>des dégats</li>
 * <li>des dégats lorsqu'il explose</li>
 * <li>un lieu courant</li>
 * </ul>
 * </br>
 * Un kamikase a une capacité particulière. Lors de sa mort, le kamikase va
 * exploser et donc infligé des dégats au joueur.
 * </p>
 */
public class Kamikase extends Monstre implements Explosable {

	/**
	 * dégats infligé lors de l'explosion du kamikase
	 *
	 * @see Kamikase#Kamikase(String, int, int, int, Lieux)
	 * @see Kamikase#toString()
	 */
	private int degatsExplose;

	/**
	 * Accès au méthodes d'explosion
	 *
	 */
	private Exploser e;

	/**
	 * Constructeur du kamikase
	 *
	 * @param sante
	 *            Sante du kamikase
	 * @param degats
	 *            Dégats du kamikase
	 * @param degatsExplose
	 *            Dégats lors de l'explosion du kamikase
	 * @param l
	 *            Lieu dans lequel se trouve le kamikase
	 */
	public Kamikase(String nom, int sante, int degats, int degatsExplose, Lieux l) {
		super(nom, sante, degats, l);
		this.degatsExplose = degatsExplose;
		this.e = new Exploser();
	}

	/**
	 * Dégats infligés au héro lorsque le kamikase explose
	 *
	 * @param h
	 *            Héro qui subit les dégats
	 * @param degats
	 *            dégats infligés au héro
	 */
	public void exploser(Hero h, int degats) {
		e.exploser(h, degats);
	}

	/**
	 * Retourne les dégats causé par l'explosion du kamikase
	 *
	 * @return un entier
	 */
	public int getDegatsExplose() {
		return degatsExplose;
	}

	/**
	 * Description du kamikase
	 *
	 * @return un String représentant la description du kamikase
	 */
	public String toString() {
		return super.toString() + ", degatsExplose = " + this.degatsExplose + " ]";
	}

}
