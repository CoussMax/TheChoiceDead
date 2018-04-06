package Utilitaire;

import Contenants.Contenant;
import Objets.Indice;
import Objets.Objet;
import Personnages.Hero;
import Personnages.Kamikase;
import Personnages.Monstre;
import Personnages.Personnage;
import Sortie.Explose;
import Sortie.Sortie;
import Sortie.Verrouille;
import Univers.Lieux;

import java.util.Scanner;

/**
 * <b>La classe gestion commande represente la définition de chaque
 * commande</b>
 * <p>
 * Les commandes que peut saisir l'utilisateur sont définies dans cette classe
 * </p>
 */
public class GestionCommande {

	public static Commande commandeName(String name) {
		for (Commande commande : Commande.values()) {
			if (commande.getName().equalsIgnoreCase(name))
				return commande;
		}
		return null;
	}

	/**
	 * Gestion des commandes sans arguments
	 *
	 * @param commande
	 *            Commande saisie
	 * @param h
	 *            Héro principal
	 */
	public void commandeSimple(String commande, Hero h) {
		Commande c = commandeName(commande);
		if (c == null) {
			System.out.println("null");
		} else {
			switch (c) {
			case AIDE:
				Aide();
				break;
			case INVENTAIRE:
				Inventaire(h);
				break;
			case QUITTER:
				System.out.println("Merci d'avoir joué !");
				break;
			case OBJECTIF:
				Objectif(h);
				break;
			default:
				System.out.println("Erreur dans la commande");
				break;
			}
		}

	}

	/**
	 * Gestion des commandes avec un argument
	 *
	 * @param commande
	 *            Commande saisie
	 * @param arg2
	 *            argument de la commande
	 * @param h
	 *            Héro principal
	 */
	public void commandeDouble(String commande, String arg2, Hero h) {
		Commande c = commandeName(commande);
		if (c == null) {
			System.out.println("null");
		} else {
			switch (c) {
			case ALLER:
				Aller(arg2, h);
				break;
			case UTILISER:
				Utiliser(arg2, h);
				break;
			case PRENDRE:
				Prendre(arg2, h, h.getLieuCourant());
				break;
			case OUVRIR:
				Ouvrir(arg2, h, h.getLieuCourant());
				break;
			case ATTAQUER:
				Attaquer(arg2, h, h.getLieuCourant());
				break;
			default:
				System.out.println("Erreur de la commande double");
			}
		}
	}

	/**
	 * Affichage de l'aide (commandes disponbles)
	 *
	 */
	public void Aide() {
		Scenario scenario = new Scenario();
		String titre = " *  Liste des commandes";
		String inv = " *  inventaire : Afficher votre inventaire \n";
		String aller = " *  aller : Aller dans un autre lieu (exemple : aller bureau) \n";
		String objectif = " *  objectif : Afficher l'objectif de la partie \n";
		String ouvrir = " *  ouvrir : Ouvrir un contenant (exemple : ouvrir coffre) \n";
		String prendre = " *  prendre : Ajouter un objet à l'inventaire (exemple : prendre fusil) \n";
		String utiliser = " *  utiliser : Utiliser un objet de l'inventaire (exemple : utiliser soin) \n";
		String attaque = " *  attaquer : Attaquer un monstre (exemple : attaquer zombie) \n";
		String quitter = " *  quitter : Quitter la partie";

		System.out.println(scenario.genereSymboles((utiliser.length()) / 2, " *"));
		System.out.println(titre);
		System.out.println(scenario.genereSymboles((utiliser.length()) / 2, " *"));
		System.out.println(inv + aller + objectif + ouvrir + utiliser + prendre + utiliser + attaque + quitter);
		System.out.println(scenario.genereSymboles((utiliser.length()) / 2, " *"));
	}

	/**
	 * Affichage de l'objectif de la partie
	 *
	 * @param h
	 *            Héro principal
	 */
	public void Objectif(Hero h) {
		Indice indice = new Indice("null", 'n');
		if (h.nbObjetO(indice) < 6) {
			System.out.println("L'objectif est de trouver les 6 indices.");
		} else {
			System.out.println(
					"Maintenant, l'objectif est d'aller vers la sortie finale et d'ordonner les indices pour faire un mot.");
		}

	}

	/**
	 * Aller dans un lieu
	 *
	 * @param Lieu
	 *            Lieu dans lequel on veut aller
	 * @param h
	 *            Héro principal
	 */
	public void Aller(String Lieu, Hero h) {

		Object tmpL = null;
		Object tmpS = null;

		for (Sortie s : h.getLieuCourant().getLesSortie()) {
			for (Lieux l : h.getLieuCourant().getMonde().getLieux()) {
				if (l.getNom().equalsIgnoreCase(Lieu) && s.getLieu().equals(l))
					tmpL = l;
			}
		}

		for (Sortie so : h.getLieuCourant().getLesSortie()) {
			if (so.getLieu() == (Lieux) tmpL) {
				tmpS = so;
			}
		}
		try {
			if (tmpS.getClass().getName().equals(Explose.class.getName())) {
				((Explose) tmpS).exploser(h, ((Explose) tmpS).getDegats());
				h.getLieuCourant().supprimerSortie((Explose) tmpS);
				System.out.println("La sortie était piégé, vous subissez des dégats...");
				System.out.println("Cette sortie est désormais détruite...");
			} else if (tmpS.getClass().getName().equals(Verrouille.class.getName())) {
				System.out.println("Veuillez entrer le code secret : ");

				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();

				((Verrouille) tmpS).deverouiller(str);
				if (!(((Verrouille) tmpS).isVerrou())) {
					h.changeLieu((Lieux) tmpL);
				}
			} else {
				h.changeLieu((Lieux) tmpL);
			}

		} catch (NullPointerException e) {
			System.out.println("Erreur de commande...");
		}
	}

	/**
	 * Afficher l'inventaire
	 *
	 * @param h
	 *            Héro principal
	 */
	public void Inventaire(Hero h) {
		h.afficheInventaire();
	}

	/**
	 * Utiliser un objet de l'inventaire
	 *
	 * @param objet
	 *            Objet que l'on veut utiliser
	 * @param h
	 *            Héro principal
	 */
	public void Utiliser(String objet, Hero h) {
		Objet o = h.getP().recupObjet(objet, h.getInventaire());
		h.utiliserObjetInventaire(o);
	}

	/**
	 * Ajouter un objet à l'inventaire
	 *
	 * @param objet
	 *            Objet que l'on ajouter à l'inventaire
	 * @param h
	 *            Héro principal
	 * @param l
	 *            Lieu courant
	 */
	public void Prendre(String objet, Hero h, Lieux l) {
		Object tmp = null;

		try {
			for (Contenant c : l.getLesContenants()) {
				if (c.getObjet() != null) {
					if (c.getObjet().getNom().equalsIgnoreCase(objet)) {
						tmp = c.getObjet();
					}
				}
			}

			if ((h.nbObjetO(((Objet) tmp)) > 0 && ((Objet) tmp).getClass() != Indice.class)) {
				h.changerObjet(((Objet) tmp));
			} else {
				h.ajouterInventaire(((Objet) tmp));
			}
		} catch (NullPointerException e) {
			System.out.println("Erreur de commande...");
		}
	}

	/**
	 * Ouvrir un contenant
	 *
	 * @param coffre
	 *            Coffre que l'on va ouvrir
	 * @param h
	 *            Héro principal
	 * @param l
	 *            Lieu courant
	 */
	public void Ouvrir(String coffre, Hero h, Lieux l) {
		Object tmp = null;
		for (Contenant c : l.getLesContenants()) {
			if (c.getNom().equalsIgnoreCase(coffre)) {
				tmp = c;
			}
		}
		h.ouvrir((Contenant) tmp);
	}

	/**
	 * Attaquer un Personnage
	 *
	 * @param monstre
	 *            Monstre que l'on attaque
	 * @param h
	 *            Héro principal
	 * @param l
	 *            Lieu courant
	 */
	public void Attaquer(String monstre, Hero h, Lieux l) {

		Object tmp = null;

		for (Personnage p : l.getLesPersonnages()) {
			if (p.getNom().equalsIgnoreCase(monstre)) {
				tmp = p;
			}
		}
		try {
			h.attaquer((Monstre) tmp);
			((Monstre) tmp).attaquer(h);
			if ((((Monstre) tmp).getSante()) == 0) {
				l.supprimerPersonnage(((Monstre) tmp));
			}

			if ((((Monstre) tmp).getClass().getName()).equals(Kamikase.class.getName())) {
				if (((Monstre) tmp).getSante() == 0) {
					((Kamikase) tmp).exploser(h, ((Kamikase) tmp).getDegatsExplose());
					System.out.println("Le kamikase à explosé...");
					l.supprimerPersonnage(((Monstre) tmp));
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Erreur de commande...");
		}
	}
}
