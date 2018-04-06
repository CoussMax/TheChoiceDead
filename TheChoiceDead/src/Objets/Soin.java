package Objets;

/**
 * <b>Cette classe représente un Soin</b>
 * <p>
 * Un soin est caratérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une sante</li>
 * </ul>
 * </br>
 * Les soins permettent au joueur d'augmenter sa sante.
 * </p>
 *
 */
public class Soin extends Objet {

	/**
	 * Nombre de point de vie de l'objet Soin
	 *
	 * @see Soin#Soin(String, int)
	 * @see Soin#getSante()
	 * @see Soin#toString()
	 */
	private int sante;

	/**
	 * Constructeur de Soin
	 *
	 * @param nom
	 *            Nom du soin
	 * @param sante
	 *            Sante délivré par le soin
	 */
	public Soin(String nom, int sante) {
		super(nom);
		this.sante = sante;
	}

	/**
	 * Retourne les points de vies de l'objet Soin
	 *
	 * @return un entier (points de vie)
	 */
	public int getSante() {
		return sante;
	}

	/**
	 * Description de Soin
	 *
	 * @return un String (description de l'objet)
	 */
	public String toString() {
		return "Caractéristiques du soin ( " + super.toString() + ", sante = " + this.sante + " )";
	}
}
