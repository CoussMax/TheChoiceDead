package Interfaces;

import Personnages.Hero;

/**
 * <b>Explosable est l'interface représentant tous se qui est explosable
 * (portes, pièges, monstres...</b>
 */
public interface Explosable {

	/**
	 * Permet de faire exploser un objet, une sortie, un monstre...
	 *
	 * @param h
	 *            Héro qui subit les dégats
	 * @param degats
	 *            dégats subits par le héro
	 */
	public void exploser(Hero h, int degats);
}
