package Sortie;

import Univers.Lieux;

/**
 * <b>Cette classe représente une sortie vérouillé par un code secret</b>
 * <p>
 * Une sortie vérouillé est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>un lieu dans lequel elle se trouve</li>
 * <li>un code secret</li>
 * </ul>
 * </br>
 * Le joueur va pouvoir ouvrir cette porte lorsque qu'il entrera le bon code
 * secret.
 * </p>
 */
public class Verrouille extends Sortie {

	/**
	 * Code de triche, permet de dévérouiller la porte de sortie
	 *
	 * @see Verrouille#deverouiller(String)
	 */
	private static String CHEAT_CODE = "cheatCode";

	/**
	 * Le code pour pouvoir ouvrir la porte
	 *
	 * @see Verrouille#Verrouille(String, Lieux)
	 * @see Verrouille#getCodeSecret()
	 */
	private String codeSecret;

	/**
	 * Sortie vérouillée ou non
	 *
	 * @see Verrouille#Verrouille(String, Lieux)
	 */
	private boolean verrou;

	/**
	 * Constructeur de Verouille
	 *
	 * @param nom
	 *            Nom de la sortie
	 * @param lieu
	 *            Lieu vers lequel va la sortie
	 */
	public Verrouille(String nom, Lieux lieu) {
		super(nom, lieu);

		CodeSecret code = CodeSecret.SECRET;
		CodeSecret[] allCode = CodeSecret.values();
		this.codeSecret = code.randomCodeSecret(allCode).getNom();
		this.verrou = true;
	}

	/**
	 * Dévérouiller la porte à l'aide du code secret
	 *
	 * @param code
	 *            Code secret saisi par l'utilisateur
	 */
	public void deverouiller(String code) {

		try {
			if (this.verrou != false) {
				if (this.codeSecret.equalsIgnoreCase(code) || code.equals(CHEAT_CODE)) {
					this.verrou = false;
					System.out.println("La sortie est désormais dévérouillée...");
				} else {
					System.out.println("Vous avez saisi(e) un mauvais code...");
				}
			} else {
				System.out.println("La sortie est déjà dévérouillée...");
			}
		} catch (NullPointerException e) {
			System.out.println("Le code est NULL...");
		}
	}

	/**
	 * Retourne une lettre du code secret
	 *
	 * @param code
	 *            Code sur lequel on récupèle une lettre
	 * @param indice
	 *            Position pour récupérer la lettre
	 * @return un char
	 */
	public char lettre(String code, int indice) {

		return code.charAt(indice);
	}

	/**
	 * Retourne si la sortie est vérouillé ou non
	 *
	 * @return un booléen
	 */
	public boolean isVerrou() {
		return verrou;
	}

	/**
	 * Retourne le code secret de la sortie
	 *
	 * @return un String
	 */
	public String getCodeSecret() {
		return codeSecret;
	}

}
