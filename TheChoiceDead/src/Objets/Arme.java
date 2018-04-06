package Objets;

import Personnages.Hero;

/**
 * <b>Cette classe représente une arme.</b>
 * <p>
 * Une arme est caractérisée par :
 * <ul>
 * <li>un nom</li>
 * <li>des dégats</li>
 * <li>une capacité</li>
 * <li>une capacité maximale</li>
 * </ul>
 * </br>
 * L'utilisateur va pouvoir se servir de cette arme pour tirer sur un ennemi et
 * donc infligé des dégats à son homologue.</br>
 * Cette pourra être recharger à l'aide de munition, stocker dans l'inventaire
 * du joueur ou même échangé avec une autre arme.
 * </p>
 */
public class Arme extends Objet {

	/**
	 * Dégats de l'arme
	 *
	 * @see Arme#Arme(String, int, int, int)
	 * @see Arme#getDegats()
	 * @see Arme#toString()
	 */
	private int degats;

	/**
	 * Capacite de l'arme
	 *
	 * @see Arme#Arme(String, int, int, int)
	 * @see Arme#tirer()
	 * @see Arme#recharger(Munition)
	 * @see Arme#toString()
	 */
	private int capacite;

	/**
	 * Capacite maximum de l'arme
	 *
	 * @see Arme#Arme(String, int, int, int)
	 * @see Arme#recharger(Munition)
	 * @see Arme#toString()
	 */
	private int capaciteMax;

	/**
	 * Constructeur de l'arme
	 *
	 * @param nom
	 *            Nom de l'arme
	 * @param degats
	 *            Dégats de l'arme
	 * @param capacite
	 *            Capacité de l'arme
	 * @param capaciteMax
	 *            Capacité maximal de l'arme
	 */
	public Arme(String nom, int degats, int capacite, int capaciteMax) {
		super(nom);
		this.degats = degats;
		this.capacite = capacite;
		this.capaciteMax = capaciteMax;
	}

	/**
	 * L'arme peut tirer (diminution de sa capacité)
	 *
	 * @see Hero#degatsInfliges()
	 */
	public void tirer() {

		if (this.capacite > 0) {
			this.capacite--;
		} else {
			System.out.println("Veuillez recharger l'arme...");
		}
	}

	/**
	 * Recharge l'arme
	 *
	 * @see Hero#utiliser(Objet)
	 * @see Hero#utiliserObjetInventaire(Objet)
	 *
	 * @param m
	 *            Munition avec laquel on recharge l'arme
	 */
	public void recharger(Munition m) {

		try {
			if (m.getCapacite() > 0) {
				int totale = this.capacite + m.getCapacite();

				if (totale > this.capaciteMax) {
					totale = this.capaciteMax;
				}

				this.capacite = totale;
			}
		} catch (NullPointerException e) {
			System.out.println("La munition passée en paramètre est NULL...");
		}
	}

	/**
	 * Retourne la capacité de l'arme
	 *
	 * @return un entier
	 */
	public int getCapacite() {
		return capacite;
	}

	/**
	 * Retourne les dégats de l'arme
	 *
	 * @return les dégats de l'arme sous forme d'un entier
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Description de l'armes
	 *
	 * @return un String
	 */
	public String toString() {
		return "Caratéristiques de l'arme ( " + super.toString() + ", degats = " + this.degats + ", capacite = "
				+ this.capacite + ", capaciteMax = " + this.capaciteMax + " )";
	}
}
