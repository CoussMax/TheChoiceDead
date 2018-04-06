
import Personnages.Hero;
import Utilitaire.Commande;
import Utilitaire.GestionCommande;
import Utilitaire.Initialisation;
import Utilitaire.Scenario;

import java.util.Scanner;

/**
 * <b>Lanceur de l'application</b>.
 * 
 */
public class Main {

	public static void main(String[] args) {

		/**
		 * Permet de savoir si oui ou non l'utilisateur veut recommencer une partie.
		 */
		boolean recommencer = true;
		/**
		 * Permet de savoir si l'utilisateur a gagné la partie.
		 */
		boolean gagne = false;

		while (recommencer) {

			// ********************* Objet scanner
			Scanner sc = new Scanner(System.in);
			String str = "";
			String[] splitted = null;

			GestionCommande gestionCommande = new GestionCommande();
			Scenario scenario = new Scenario();

			Initialisation init = new Initialisation();
			init.initialisation();

			// ********************* Lancement du jeu
			scenario.depart();
			Hero heroPrincipal = scenario.choixPersonnage(init);

			do {
				scenario.descPersonnage(heroPrincipal);
				scenario.descLieux(heroPrincipal.getLieuCourant());
				System.out.println("Que voulez-vous faire ?");
				str = sc.nextLine();
				splitted = str.split("\\s+");

				if (splitted.length < 2) {
					gestionCommande.commandeSimple(str, heroPrincipal);
				} else {
					gestionCommande.commandeDouble(splitted[0], splitted[1], heroPrincipal);
				}
				if (heroPrincipal.getLieuCourant().getNom().equals("Dehors")) {
					System.out.println("Bravo !! Vous avez gagné !!!!");
					str = Commande.QUITTER.getName();
					gagne = true;
				}
				if (heroPrincipal.estMort()) {
					System.out.println("Vous avez perdu, " + heroPrincipal.getNom() + " est mort...");
				}
			} while (!str.equalsIgnoreCase(Commande.QUITTER.getName()) && !(heroPrincipal.estMort()));

			if (gagne == false) {
				recommencer = false;
			} else {
				recommencer = scenario.recommencer();
			}

		}
	}
}
