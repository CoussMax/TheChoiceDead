package Sortie;

import Interfaces.Explosable;
import Personnages.Hero;
import Univers.Lieux;
import Utilitaire.Exploser;

/**
 * <b>Cette classe représente une sortie piégée</b>
 * <p>
 * Une sortie piégée est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>des dégats</li>
 * <li>un lieu dans lequel elle se trouve</li>
 * </ul>
 * </br>
 * Lorsque le joueur veut utiliser cette sortie, la sortie explose et inflige
 * des dégats au joueur.
 * </p>
 */
public class Explose extends Sortie implements Explosable {

	/**
	 * Dégats par défaut de l'explosion
	 *
	 * @see Explose#Explose(String, Lieux)
	 */
	private static final int DEGATS = 10;

	/**
	 * Dégats de l'explosion
	 *
	 * @see Explose#Explose(String, Lieux)
	 */
	private int degats;

	/**
	 * Accès au méthodes d'explosion
	 *
	 */
	private Exploser e;

	/**
	 * Constructeur de Explose
	 *
	 * @param nom
	 *            Nom de la sortie
	 * @param lieu
	 *            Nom du lieu dans lequel la sortie est
	 */
	public Explose(String nom, Lieux lieu) {
		super(nom, lieu);
		this.degats = DEGATS;
		this.e = new Exploser();
	}

	/**
	 * Inflige des dégats au héro lorsque ce type de sortie est utilisé
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
	 * Retourne les dégats causés par la sortie
	 *
	 * @return un entierg
	 */
	public int getDegats() {
		return degats;
	}
}
