
package Univers;

import Interfaces.PresentListe;
import Utilitaire.Present;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Cette classe représente un monde</b>
 * <p>
 * Un monde est caractérisé par:
 * <ul>
 * <li>un nom</li>
 * <li>une liste de lieux</li>
 * </ul>
 * </br>
 * Le monde symbolise la map dans lequel le joueur se trouve.
 * </p>
 */
public class Monde implements PresentListe {

	/**
	 * Le nom du monde
	 *
	 * @see Monde#Monde(String)
	 * @see Monde#getNom()
	 */
	private String nom;

	/**
	 * Liste des lieux présent dans le monde
	 *
	 * @see Monde#ajoutLieu(Lieux)
	 * @see Monde#getLieux()
	 */
	private List<Lieux> lesLieux = new ArrayList<>();

	/**
	 * Accès à la méthode présent dans la liste
	 *
	 */
	private Present p;

	/**
	 * Constructeur de Monde
	 *
	 * @param nom
	 *            Nom du monde
	 */
	public Monde(String nom) {
		this.nom = nom;
		this.p = new Present();
	}

	/**
	 * Ajoute un lieu au monde
	 *
	 * @param l
	 *            Lieu à ajouter au monde
	 */
	public void ajoutLieu(Lieux l) {
		try {
			if (!(estPresent(l, (List) this.lesLieux))) {
				this.lesLieux.add(l);
			} else {
				System.out.println("Ce lieu existe déjà dans le monde...");
			}
		} catch (NullPointerException e) {
			System.out.println("Le lieu est NULL...");
		}
	}

	/**
	 * Savoir si le lieu est déjà présent dans le monde
	 *
	 * @param o
	 *            Objet que l'on veut ajouter au monde
	 * @param l
	 *            Liste dans laquelle doit être placé l'objet o
	 * @return un booléen
	 */
	public boolean estPresent(Object o, List<Object> l) {

		return p.estPresent(o, l);
	}

	/**
	 * Retourne la liste de lieux du monde
	 *
	 * @return une liste de Lieux
	 */
	public List<Lieux> getLieux() {
		return lesLieux;
	}

	/**
	 * Retourne le nom du monde
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}
}
