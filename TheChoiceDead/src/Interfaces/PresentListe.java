package Interfaces;

import java.util.List;

/**
 * <b>PresentListe est l'interface qui possède des fonctions communes aux
 * différentes classes du projet</b>
 */
public interface PresentListe {

	public boolean estPresent(Object o, List<Object> l);
}