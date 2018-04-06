package Utilitaire;

import Objets.Objet;

import java.util.List;

/**
 * <b>Classe qui permet l'accès aux méthodes recupObjet(récupère un objet en
 * fonction de son nom) et estPresent (savoir si l'objet est présent dans la
 * liste)</b>
 *
 */
public class Present {

	/**
	 * Vérifie si l'objet est présent dans la liste
	 *
	 * @param o
	 *            Objet que l'on teste
	 * @param l
	 *            Liste que l'on parcours
	 * @return un booléen
	 */
	public boolean estPresent(Object o, List<Object> l) {

		boolean isPresent = false;

		for (Object obj : l) {
			if (obj == o) {
				isPresent = true;
			}
		}
		return isPresent;
	}

	/**
	 * Permet de récupérer un Objet
	 *
	 * @param n
	 *            Nom de l'objet
	 * @param l
	 *            Liste de d'objet à parcourir
	 * @return une instance d'Objet
	 */
	public Objet recupObjet(String n, List<Objet> l) {

		Object res = null;

		for (Objet o : l) {
			if (o.getNom().equalsIgnoreCase(n)) {
				res = o;
			}
		}
		return (Objet) res;
	}
}
