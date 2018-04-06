package Objets;

import Interfaces.Explosable;
import Personnages.Hero;
import Utilitaire.Exploser;

/**
 * <b>Cette classe représente un Piège</b>
 * <p>
 * Un piège est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>des dégats</li>
 * </ul>
 * </br>
 * Si un piège est découvert par le joueur, il lui inflige des dégats.
 * </p>
 *
 */
public class Piege extends Objet implements Explosable {

	/**
	 * Degats causé par le piège
	 *
	 * @see Piege#Piege(String, int)
	 * @see Piege#toString()
	 */
	private int degats;

	/**
	 * Accès à la fonction exploser
	 * 
	 * @see Piege#Piege(String, int)
	 * @see Piege#exploser(Hero, int)
	 */
	private Exploser e;

	/**
	 * Constructeur de Piege
	 *
	 * @param nom
	 *            Nom du piège
	 * @param degats
	 *            Dégats infligés par le piège
	 */
	public Piege(String nom, int degats) {
		super(nom);
		this.degats = degats;
		this.e = new Exploser();
	}

	/**
	 * Inflige des dégats au joueur lorsque que l'objet explose
	 *
	 * @param h
	 *            Héro sur qui les dégats sont appliqués
	 * @param degats
	 *            Dégats infligés par l'objet
	 */
	public void exploser(Hero h, int degats) {
		e.exploser(h, degats);
	}

	/**
	 * Retourne les dégats du piège
	 *
	 * @return un entier
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Description du piège
	 *
	 * @return un String (description de l'objet)
	 */
	public String toString() {
		return "Caractéristiques du piege ( " + super.toString() + ", degats = " + this.degats + " )";
	}
}
