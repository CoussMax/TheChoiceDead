package Univers;

import Contenants.Contenant;
import Interfaces.PresentListe;
import Personnages.Personnage;
import Sortie.Sortie;
import Utilitaire.Present;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Cette classe représente un lieu</b>
 * <p>
 * Un lieu est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>un monde dans lequel il se trouve</li>
 * <li>une liste de contenants</li>
 * <li>une liste de personnages</li>
 * <li>une liste de sorties</li>
 * </ul>
 * </br>
 * Un lieux représente une partie de la map dans laquelle se trouve le joueur.
 * </p>
 */
public class Lieux implements PresentListe {

	/**
	 * Le nom du lieu
	 *
	 * @see Lieux#Lieux(String, Monde)
	 * @see Lieux#getNom()
	 */
	private String nom;

	/**
	 * Monde dans lequel se trouve le lieu
	 *
	 * @see Lieux#Lieux(String, Monde)
	 * @see Lieux#getMonde()
	 */
	private Monde monde;

	/**
	 * Liste des sorties du lieu
	 *
	 * @see Lieux#ajoutSortie(Sortie)
	 */
	private List<Sortie> lesSortie = new ArrayList<>();

	/**
	 * Liste des personnages présents dans le lieu
	 *
	 * @see Lieux#ajoutPersonnage(Personnage)
	 * @see Lieux#supprimerPersonnage(Personnage)
	 */
	private List<Personnage> lesPersonnages = new ArrayList<>();

	/**
	 * Liste des contenants présents dans le lieu
	 *
	 * @see Lieux#ajoutContenant(Contenant)
	 */
	private List<Contenant> lesContenants = new ArrayList<>();

	/**
	 * Accès à la méthodes présent liste
	 *
	 */
	private Present p;

	/**
	 * Constructeur de Lieux
	 *
	 * @param nom
	 *            Nom du personnage
	 * @param monde
	 *            Monde dans lequel se trouve le lieu
	 */
	public Lieux(String nom, Monde monde) {
		this.nom = nom;
		this.monde = monde;
		this.p = new Present();
	}

	/**
	 * Ajout de sorties au lieu
	 *
	 * @param s
	 *            Sortie à ajouter au lieu
	 */
	public void ajoutSortie(Sortie s) {
		try {
			if (!(estPresent(s, (List) this.lesSortie))) {
				this.lesSortie.add(s);
			}
		} catch (NullPointerException e) {
			System.out.println("La sortie est NULL...");
		}
	}

	/**
	 * Ajout de personnages dans le lieu
	 *
	 * @param p
	 *            Personnage à ajouter au lieu
	 */
	public void ajoutPersonnage(Personnage p) {
		try {
			if (!(estPresent(p, (List) this.lesPersonnages))) {
				this.lesPersonnages.add(p);
			}
		} catch (NullPointerException e) {
			System.out.println("Le personnage est NULL...");
		}
	}

	/**
	 * Ajout de contenants au lieu
	 *
	 * @param c
	 *            Contenant à ajouter au lieu
	 */
	public void ajoutContenant(Contenant c) {
		try {
			if (!(estPresent(c, (List) this.lesContenants))) {
				this.lesContenants.add(c);
			}
		} catch (NullPointerException e) {
			System.out.println("Le contenant est NULL...");
		}
	}

	/**
	 * Supprime un personnage du lieu (si il est mort)
	 *
	 * @param p
	 *            Personnage à supprimer du lieu
	 */
	public void supprimerPersonnage(Personnage p) {
		try {
			if (p.estMort()) {
				this.lesPersonnages.remove(p);
			} else {
				System.out.println("Le personnage n'est pas mort...");
			}
		} catch (NullPointerException e) {
			System.out.println("Le personnage est NULL...");
		}
	}

	/**
	 * Supprime une sortie du lieu (après explosion)
	 *
	 * @param s
	 *            Sortie à supprimer du lieu
	 */
	public void supprimerSortie(Sortie s) {
		try {
			this.lesSortie.remove(s);
		} catch (NullPointerException e) {
			System.out.println("La sortie est NULL...");
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
	@Override
	public boolean estPresent(Object o, List<Object> l) {
		return p.estPresent(o, l);
	}

	/**
	 * Retourne le monde attacher au lieu
	 *
	 * @return une instance de Monde
	 */
	public Monde getMonde() {
		return monde;
	}

	/**
	 * Retourne le nom du lieu
	 *
	 * @return un String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne les contenants présent dans le Lieu
	 *
	 * @return une liste de contenants
	 */
	public List<Contenant> getLesContenants() {
		return lesContenants;
	}

	/**
	 * Retourne le liste des personnages présents dans le lieu
	 *
	 * @return une Liste de Personnage
	 */
	public List<Personnage> getLesPersonnages() {
		return lesPersonnages;
	}

	/**
	 * Retourne la liste des sorties présents dans le lieu
	 *
	 * @return une Liste de Sortie
	 */
	public List<Sortie> getLesSortie() {
		return lesSortie;
	}

	/**
	 * Affiche les caractéristiques d'un lieu
	 *
	 * @return un String
	 */
	public String toString() {

		String sorties = " sorties: ";
		String pers = " monstres: ";
		String contenants = " coffres: ";
		String res = "";

		for (Sortie s : this.lesSortie) {
			sorties = sorties + " " + s.getLieu().getNom();
		}

		for (Personnage p : this.lesPersonnages) {
			pers = pers + " " + p.getNom();
		}

		for (Contenant c : this.lesContenants) {
			contenants = contenants + " " + c.getNom();
		}

		res = "| " + sorties + " | " + contenants + " | " + pers + " |";

		return res;
	}
}
