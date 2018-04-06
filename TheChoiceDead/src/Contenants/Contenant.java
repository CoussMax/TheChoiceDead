package Contenants;

import Objets.Objet;

/**
 * <b>Contenant est la classe représentant par exemple un coffre, une armoire,
 * un tiroir, etc...</b>
 * <p>
 * Un contenant est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>possède un objet</li>
 * </ul>
 * </br>
 * Cette classe va être utilisé par le joueur car il va pouvojr ouvrir un
 * contenant.</br>
 * En ouvrant ce contenant le joueur pourra utiliser l'objet sur le champs ou le
 * stocker dans son inventaire.
 * </p>
 *
 */
public class Contenant {

	/**
	 * Le nom du contenant
	 *
	 * @see Contenant#Contenant(String)
	 * @see Contenant#getNom()
	 * @see Contenant#toString()
	 */
	private String nom;

	/**
	 * Objet contenu par le contenant
	 *
	 * @see Contenant#Contenant(String)
	 * @see Contenant#getObjet()
	 * @see Contenant#ajoutObjet(Objet)
	 * @see Contenant#supprimerObjet(Objet)
	 * @see Contenant#toString()
	 */
	private Objet objet = null;

	/**
	 * Constructeur du contenant
	 *
	 * @param nom
	 *            Nom du contenant
	 */
	public Contenant(String nom) {
		this.nom = nom;
	}

	/**
	 * Ajoute un objet au contenant
	 *
	 * @param o
	 *            Objet ajouter au contenant
	 */
	public void ajoutObjet(Objet o) {
		if (this.objet == null && o.getContenant() == null && o.getHero() == null) {
			this.objet = o;
			o.setContenant(this);
		} else if (this.objet == null && o.getContenant() != null) {
			System.out.println("L'objet à déjà un contenant...");
		} else if (this.objet == null && o.getContenant() == null && o.getHero() != null) {
			System.out.println("Un personnage possède déjà cet objet...");
		} else {
			System.out.println("Ce contenant contient déjà un objet...");
		}
	}

	/**
	 * Supprime un objet du contenant
	 *
	 * @see Personnages.Hero#ajouterInventaire(Objet)
	 * @see Personnages.Hero#utiliser(Objet)
	 * @param o
	 *            Objet à supprimer du contenant
	 */
	public void supprimerObjet(Objet o) {
		try {
			if (o == this.objet) {
				this.objet = null;
				o.setContenant(null);
			} else {
				System.out.println("l'objet n'est pas dans ce contenant...");
			}
		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}

	}

	/**
	 * Retourne le nom du contenant
	 *
	 * @return un String symbolisant le nom du contenant
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne l'objet contenu dans le contenant
	 *
	 * @see Personnages.Hero#ouvrir(Contenant)
	 * @return une instance d'objet représentant l'objet contenu par le contenant
	 */
	public Objet getObjet() {
		return objet;
	}

	/**
	 * Retourne la description du contenant
	 *
	 * @return un string symbolisant la description du contenant
	 */
	public String toString() {

		String res = "Voici le contenu du " + this.nom + ": [ " + this.objet + " ]";
		if (this.objet == null) {
			res = "Le " + this.nom + " ne contient aucun objet...";
		}
		return res;
	}
}
