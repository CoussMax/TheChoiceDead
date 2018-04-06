package Objets;

/**
 * <b>Cette classe représente une armure</b>
 * <p>
 * Une armure est caractérisée par :
 * <ul>
 * <li>un nom</li>
 * <li>une resistance</li>
 * </ul>
 * </br>
 * Le joueur va pouvoir augmenter sa resistance en s'équipant d'une
 * armure.</br>
 * Il pourra bien évidemment l'échanger avec une autre armure plus efficace.
 * </p>
 */
public class Armure extends Objet {

	/**
	 * Resistance de l'armure
	 *
	 * @see Armure#Armure(String, int)
	 * @see Armure#getResistance()
	 * @see Armure#toString()
	 */
	private int resistance;

	/**
	 * Constructeur de l'armure
	 *
	 * @param nom
	 *            Nom de l'armure
	 * @param resistance
	 *            Resistance de l'armure
	 */
	public Armure(String nom, int resistance) {
		super(nom);
		this.resistance = resistance;
	}

	/**
	 * Retourne la resistance de l'armure
	 *
	 * @return un entier (resistance de l'armure)
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * Description de l'armure
	 *
	 * @return un String (description de l'armure)
	 */
	public String toString() {
		return "Caractéristiques de l'armure : ( " + super.toString() + ", resistance = " + this.resistance + " )";
	}
}
