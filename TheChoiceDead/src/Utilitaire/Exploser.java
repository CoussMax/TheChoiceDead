package Utilitaire;

import Personnages.Hero;

/**
 * <b>Classe qui permet l'accès à la méthode exploser</b>
 *
 */
public class Exploser {

	/**
	 * Explosion qui inflige des dégats à un héro
	 *
	 * @param h
	 *            Héro sur lesquels les dégats son infligés
	 * @param degats
	 *            dégats causés par l'explosion
	 */
	public void exploser(Hero h, int degats) {
		try {
			if (!(h.estMort())) {
				h.baisseSante(degats - h.getResistance());
			} else {
				System.out.println("Le héro est déjà mort...");
			}

		} catch (NullPointerException e) {
			System.out.println("Le hero est NULL...");
		}
	}
}
