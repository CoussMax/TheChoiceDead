package Personnages;

import Univers.Lieux;

/**
 * <b>Cette classe représente un personnage.</b>
 * <p>
 * Un personnagge est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une santé</li>
 * <li>des dégats</li>
 * <li>se trouve dans un lieu</li>
 * </ul>
 * </p>
 *
 */
public abstract class Personnage {

	/**
	 * Le nom du personnage
	 *
	 * @see Personnage#Personnage(String, int, int, Lieux)
	 * @see Personnage#toString()
	 */
	private String nom;

	/**
	 * La sante du personnage
	 *
	 * @see Personnage#Personnage(String, int, int, Lieux)
	 * @see Personnage#estMort()
	 * @see Personnage#baisseSante(int)
	 * @see Personnage#getSante()
	 * @see Personnage#toString()
	 */
	private int sante;

	/**
	 * Les dégats infligés par le personnage
	 *
	 * @see Personnage#Personnage(String, int, int, Lieux)
	 * @see Personnage#getDegats()
	 * @see Personnage#toString()
	 */
	private int degats;

	/**
	 * Lieu courant du personnage
	 *
	 * @see Personnage#Personnage(String, int, int, Lieux)
	 * @see Personnage#getLieuCourant()
	 * @see Personnage#changeLieu(Lieux)
	 * @see Lieux
	 */
	private Lieux lieuCourant;

	/**
	 * Constructeur d'un personnage
	 *
	 * @param nom
	 *            Nom du personnage
	 * @param sante
	 *            Sante du personnage
	 * @param degats
	 *            Degats du personnage
	 * @param l
	 *            Lieux dans lequel se trouve le personnage
	 */
	public Personnage(String nom, int sante, int degats, Lieux l) {
		this.nom = nom;
		this.sante = sante;
		this.degats = degats;
		this.lieuCourant = l;
	}

	/**
	 * Réduit la sante d'un personnage
	 *
	 * @see Hero#attaquer(Monstre)
	 * @see Monstre#attaquer(Hero)
	 * @param degats
	 *            Dégats infligés au personnage
	 */
	public void baisseSante(int degats) {

		if (!(this.estMort())) {
			this.sante = this.sante - degats;
			if (this.sante < 0) {
				this.sante = 0;
			}
		}
	}

	/**
	 * Vérifie si le personnage est mort
	 *
	 * @see Hero#attaquer(Monstre)
	 * @see Monstre#attaquer(Hero)
	 *
	 * @return un booléen pour savoir si le personnage est mort
	 */
	public boolean estMort() {

		boolean mort = false;

		if (this.sante == 0) {
			mort = true;
		}
		return mort;
	}

	/**
	 * Change le lieu courant du personnage
	 *
	 * @param lieu
	 *            Lieu dans lequel se déplace le personnage
	 */
	public void changeLieu(Lieux lieu) {
		this.lieuCourant = lieu;
	}

	/**
	 * Retourne la sante du personnage
	 *
	 * @return un entier symbolisant la sante du personnage
	 */
	public int getSante() {
		return sante;
	}

	/**
	 * Retourne les dégats du personnage
	 *
	 * @return un entier symbolisant les dégats du personnage
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Retourne le Lieu courant du personnage
	 *
	 * @return une instance de Lieux représentant le lieu courant du personnage
	 */
	public Lieux getLieuCourant() {
		return lieuCourant;
	}

	/**
	 * Retourne le nom du personnage
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie la sante du personnage
	 *
	 * @param sante
	 *            Nouvelle sante du Personnage
	 */
	public void setSante(int sante) {

		if (sante > 0) {
			this.sante = sante;
		}
	}

	/**
	 * Retourne la description du personnage
	 *
	 * @return un String symbolisant la description du personnage
	 */
	public String toString() {
		return "nom = " + this.nom + ", sante = " + this.sante + ", degats = " + this.degats;
	}

}
