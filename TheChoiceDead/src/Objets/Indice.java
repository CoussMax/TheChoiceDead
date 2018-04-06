package Objets;

/**
 * <b>Cette classe représente un Indice</b>
 * <p>
 * Un indice est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une lettre</li>
 * </ul>
 * </br>
 * Le joueur va devoir stocker ces indices dans son inventaire (indices ramasser
 * dans des contenants) et reconstituer un mot (à l'aide des indices) pour
 * pouvoir ouvrir la porte, sortir du lieu et gagné la partie.
 * </p>
 *
 */
public class Indice extends Objet {

	/**
	 * Lettre de l'indice
	 *
	 * @see Indice#Indice(String, char)
	 * @see Indice#getLettre()
	 * @see Indice#toString()
	 */
	private char lettre;

	/**
	 * Constructeur de Indice
	 *
	 * @param nom
	 *            Nom de l'indice
	 * @param lettre
	 *            Lettre contenu dans l'indice
	 */
	public Indice(String nom, char lettre) {
		super(nom);
		this.lettre = lettre;
	}

	/**
	 * Retourne la l'indice (composé d'une lettre)
	 *
	 * @return un char (lettre)
	 */
	public char getLettre() {
		return lettre;
	}

	/**
	 * Description de l'indice
	 *
	 * @return un String (description de l'indice)
	 */
	public String toString() {
		return "Caractéristiques de l'indice ( " + super.toString() + ", lettre = " + this.lettre + " )";
	}
}
