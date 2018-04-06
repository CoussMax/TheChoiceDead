package Utilitaire;

import Personnages.Hero;
import Univers.Lieux;

import java.util.Scanner;

/**
 * <b>La classe scénario permet de gérer le scénario du jeu</b>
 * <p>
 * Elle contient les différentes fonctions d'affichage et fonction classiques
 * (par exemple : la fonction recommencer)
 * </p>
 */
public class Scenario {

	/**
	 * L'utilisateur choisi son héros avec lequel il veut jouer
	 *
	 * @param init
	 *            Initialisation des différents objets présent dans le jeu
	 *            (personnages...)
	 *
	 * @return une instance d'objet Hero
	 */
	public Hero choixPersonnage(Initialisation init) {

		Scanner sc = new Scanner(System.in);
		String str = "";
		String choix = null;
		Hero heroPrincipal = null;

		do {
			System.out.println("Voici les 3 Heros : \n" + "Rick : " + init.rick.toString() + "\n" + "Daril : "
					+ init.daril.toString() + "\n" + "Carol : " + init.carol.toString() + "\n"
					+ "Veuillez choisir un Hero :");

			str = sc.nextLine();
			for (Hero lesHeros : init.lesHeros) {
				if (lesHeros.getNom().equalsIgnoreCase(str)) {
					choix = str;
					heroPrincipal = lesHeros;
				}
			}
		} while (choix == null);

		return heroPrincipal;
	}

	/**
	 * Affiche des informations sur le personnages
	 *
	 * @param h
	 *            Héro correspondant aux informations affichées
	 */
	public void descPersonnage(Hero h) {

		String symbole = "-";
		String affiche = "| héro: " + h.getNom() + " | santé: " + h.getSante() + " | arme: " + h.armePerso().getNom()
				+ " | munitions: " + h.armePerso().getCapacite() + " | résistance: " + h.getResistance() + " |";
		int taille = affiche.length();

		System.out.println(genereSymboles(taille, symbole));
		System.out.println(affiche);
		System.out.println(genereSymboles(taille, symbole));
	}

	/**
	 * Affichage des informations sur le lieu
	 *
	 * @param l
	 *            Lieu que l'on décrit
	 */
	public void descLieux(Lieux l) {

		String symbole = "-";
		String affiche = "| Vous êtes dans le lieu " + l.getNom() + " ! |";
		String desc = l.toString();
		int taille = desc.length();

		System.out.println(genereSymboles(affiche.length(), symbole));
		System.out.println(affiche);
		System.out.println(genereSymboles(taille, symbole));
		System.out.println(l);
		System.out.println(genereSymboles(taille, symbole));
	}

	/**
	 * Génère des symboles pour l'affichage des blocks
	 *
	 * @param nb
	 *            nombre de symboles à générer
	 * @param symb
	 *            Symbole que l'on veut renvoyer
	 * @return un String
	 */
	public String genereSymboles(int nb, String symb) {
		String symbole = "";

		for (int i = 0; i < nb; i++) {
			symbole = symbole + symb;
		}
		return symbole;
	}

	/**
	 * Affichage au lancement du jeu (l'utilisateur doit saisir 's' pour commencer)
	 *
	 */
	public void depart() {

		boolean ok = false;
		String str = "";
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println(
					"___________.__             ________                     .___ _________ .__           .__              \n"
							+ "\\__    ___/|  |__   ____   \\______ \\   ____ _____     __| _/ \\_   ___ \\|  |__   ____ |__| ____  ____  \n"
							+ "  |    |   |  |  \\_/ __ \\   |    |  \\_/ __ \\\\__  \\   / __ |  /    \\  \\/|  |  \\ /  _ \\|  |/ ___\\/ __ \\ \n"
							+ "  |    |   |   Y  \\  ___/   |    `   \\  ___/ / __ \\_/ /_/ |  \\     \\___|   Y  (  <_> )  \\  \\__\\  ___/ \n"
							+ "  |____|   |___|  /\\___  > /_______  /\\___  >____  /\\____ |   \\______  /___|  /\\____/|__|\\___  >___  >\n"
							+ "                \\/     \\/          \\/     \\/     \\/      \\/          \\/     \\/               \\/    \\/ ");

			System.out.println("");
			System.out.println(
					"Vous vous retrouvez enfermé dans une prison remplie de zombie, vous allez devoir parcourir les différentes\n "
							+ "pièces de la prison pour trouver les 6 indices qui vous permettront de former un mot. Avec ce mot, vous allez pouvoir déverrouiller\n"
							+ "la porte de sortie et donc vous échapper. A savoir que la porte qui permet de de s'échapper se trouve dans la cour.\n"
							+ "Dans cette aventure, vous allez pouvoir trouver des armes, des munitions ainsi que des soins afin de survivre, mais attention, la prison regorge "
							+ "de pièges en tous genre...");
			System.out.println("");
			System.out.println("");
			System.out.println("                                               Press s to start...\n");
			str = sc.nextLine();

			if (str.equalsIgnoreCase("s")) {
				ok = true;
			}

		} while (ok != true);
	}

	/**
	 * Permet au joueur de recommencer ou non une partie
	 *
	 * @return un booleen
	 */
	public boolean recommencer() {

		boolean fin = true;
		String strReco = "";
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Voulez-vous rejouer (y=oui, n=non) ? ");
			strReco = sc.nextLine();

			if (strReco.equalsIgnoreCase("y")) {
				fin = true;

			} else if (strReco.equalsIgnoreCase("n")) {
				fin = false;

			} else {
				System.out.println("Veuillez saisir y ou n...");
			}

		} while (!(strReco.equalsIgnoreCase("y")) && !(strReco.equalsIgnoreCase("n")));

		return fin;
	}

}
