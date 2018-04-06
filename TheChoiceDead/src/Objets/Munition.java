package Objets;

/**
 * <b>Cette classe représente une Munition</b>
 * <p>
 * Une munition est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une capacité</li>
 * </ul>
 * </br>
 * Ces munitions vont permettre au joueur de recharger son arme.
 * </p>
 *
 */
public class Munition extends Objet {

	/**
	 * Capacité de la munition
	 *
	 * @see Munition#Munition(String, int)
	 * @see Munition#getCapacite()
	 * @see Munition#toString()
	 */
	private int capacite;

	/**
	 * Constructeurs de Munition
	 *
	 * @param nom
	 *            Nom de la munition
	 * @param capacite
	 *            Capacité de la munition
	 */
	public Munition(String nom, int capacite) {
		super(nom);
		this.capacite = capacite;
	}

	/**
	 * Retourne la capacite de la munition
	 *
	 * @return un entier (capacite de la munition)
	 */
	public int getCapacite() {
		return capacite;
	}

	/**
	 * Description de la munition
	 *
	 * @return un String (description de la munition)
	 */
	public String toString() {
		return "Caractéristiques de la munition ( " + super.toString() + ", capacite = " + this.capacite + " )";
	}
}
