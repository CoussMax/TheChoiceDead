package Personnages;

import Univers.Lieux;

/**
 * <b>Cette classe représente un monstre</b>
 * <p>
 * Un monstre est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une santé</li>
 * <li>des dégats</li>
 * <li>un lieu dans lequel il se trouve</li>
 * </ul>
 * </br>
 * Un monstre va pourvoir attaqué un héro.
 *
 * </p>
 */
public class Monstre extends Personnage {

	/**
	 * Constructeur du Monstre
	 *
	 * @param nom
	 *            Nom du monstre
	 * @param sante
	 *            Sante du monstre
	 * @param degats
	 *            Dégats du monstre
	 * @param l
	 *            Lieu dans lequel se trouve le monstre
	 */
	public Monstre(String nom, int sante, int degats, Lieux l) {
		super(nom, sante, degats, l);
	}

	/**
	 * Attaque un héro
	 *
	 * @param h
	 *            Héro attaquer par le monstre
	 */
	public void attaquer(Hero h) {

		try {
			int degatsInfliger = 0;

			if (!(this.estMort())) {
				if (!(h.estMort())) {
					degatsInfliger = super.getDegats() - h.getResistance();
					h.baisseSante(degatsInfliger);
					System.out.println("Le " + this.getNom() + " vous as attaqué...");
				} else {
					System.out.println("Le hero est déjà mort...");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Le héro passé en paramètre est NULL");
		}
	}

	/**
	 * Retourne la description du Monstre
	 *
	 * @return un String symbolisant la description du Monstre
	 */
	public String toString() {
		return "Caractéristiques du Monstre [" + super.toString() + " ]";
	}
}
