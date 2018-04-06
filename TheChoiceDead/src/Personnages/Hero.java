package Personnages;

import Contenants.Contenant;
import Interfaces.PresentListe;
import Objets.*;
import Univers.Lieux;
import Utilitaire.Present;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Cette classe représente un héro</b>
 * <p>
 * Un héro est caractérisé par :
 * <ul>
 * <li>un nom</li>
 * <li>une santé</li>
 * <li>une résistance</li>
 * <li>une arme (ou non)</li>
 * <li>un lieu dans lequel il se trouve</li>
 * <li>des dégats par défauts (si il n'à pas d'arme)</li>
 * <li>possède un inventaire d'objet</li>
 * </ul>
 * </br>
 * Un héro va pourvoir éxécuter un grand nombre d'opération : </br>
 * <ul>
 * <li>se déplacer d'un lieu vers un autre</li>
 * <li>attaquer un monstre</li>
 * <li>utiliser des objets</li>
 * <li>stocker des objets dans son inventaire</li>
 * <li>ouvrir des contenants</li>
 * <li>...</li>
 * </ul>
 * </p>
 *
 */
public class Hero extends Personnage implements PresentListe {

	/**
	 * Nombre maximal d'arme dans l'inventaire
	 *
	 * @see Hero#typeObjet(Objet)
	 */
	private static final int MAX_ARME = 1;

	/**
	 * Nombre maximal de soin dans l'inventaire
	 *
	 * @see Hero#typeObjet(Objet)
	 */
	private static final int MAX_SOIN = 1;

	/**
	 * Nombre maximal d'armure dans l'inventaire
	 *
	 * @see Hero#typeObjet(Objet)
	 */
	private static final int MAX_ARMURE = 1;

	/**
	 * Nombre maximal d'indice dans l'inventaire
	 *
	 * @see Hero#typeObjet(Objet)
	 */
	private static final int MAX_INDICE = 6;

	/**
	 * Nombre maximal de munition dans l'inventaire
	 *
	 * @see Hero#typeObjet(Objet)
	 */
	private static final int MAX_MUNITION = 1;

	/**
	 * Nombre maximal d'objet au total dans l'inventaire
	 *
	 * @see Hero#inventaireEstPlein()
	 */
	private static final int MAX_NB_OBJETS = 10;

	/**
	 * Resistance maximale d'un héro
	 *
	 * @see Hero#amelioreResistance(Armure)
	 */
	private static final int RESISTANCE_MAX = 10;

	/**
	 * Sante maximale d'un héro
	 *
	 * @see Hero#restaureSante(Soin)
	 */
	private static final int SANTE_MAX = 100;

	/**
	 * Dégats si le héro n'a pas d'arme
	 *
	 * @see Hero#Hero(String, int, int, Lieux, Arme)
	 */
	private static final int DEGATS_DEFAULTS = 2;

	/**
	 * resistance d'un héro
	 *
	 * @see Hero#Hero(String, int, int, Lieux, Arme)
	 * @see Hero#getResistance()
	 * @see Hero#toString()
	 */
	private int resistance;

	/**
	 * Inventaire du héros
	 *
	 * @see Hero#Hero(String, int, int, Lieux, Arme)
	 * @see Hero#degatsInfliges()
	 * @see Hero#ajouterInventaire(Objet)
	 * @see Hero#supprimerInvertaire(Objet)
	 * @see Hero#changerObjet(Objet)
	 * @see Hero#inventaireEstPlein()
	 * @see Hero#nbElementInventaire()
	 * @see Hero#nbObjetO(Objet)
	 * @see Hero#armePerso()
	 * @see Hero#afficheInventaire()
	 */
	private List<Objet> inventaire = new ArrayList<>();

	/**
	 * Accès à la methode présent liste
	 * 
	 * @see Hero#Hero(String, int, int, Lieux, Arme)
	 * @see Hero#getP()
	 */
	private Present p;

	/**
	 * Constructeur du héro
	 *
	 * @param nom
	 *            Nom du héro
	 * @param sante
	 *            Santé du héro
	 * @param resistance
	 *            Resistance du héro
	 * @param l
	 *            Lieu dans lequel se trouve le héro
	 * @param a
	 *            Arme du héro
	 */
	public Hero(String nom, int sante, int resistance, Lieux l, Arme a) {
		super(nom, sante, DEGATS_DEFAULTS, l);
		this.resistance = resistance;
		if (a != null) {
			this.inventaire.add(a);
			a.setHero(this);
		}
		this.p = new Present();

	}

	/**
	 * Attaquer un monstre
	 *
	 * @param m
	 *            Monstre attaqué par le héro
	 */
	public void attaquer(Monstre m) {

		try {
			if (!(this.estMort())) {
				if (!(m.estMort())) {
					m.baisseSante(degatsInfliges());
				} else {
					System.out.println("Le monstre est déjà mort...");
				}
			} else {
				System.out.println("Vous ne pouvez pas attaquer, vous êtes mort...");
			}
		} catch (NullPointerException e) {
			System.out.println("Le monstre passé en paramètre est NULL...");
		}
	}

	/**
	 * Nombre de dégats infligés par le héro
	 *
	 * @return les dégats infligés sous forme d'un entier
	 */
	private int degatsInfliges() {

		Objet arme = null;
		int degats;

		for (Objet o : this.inventaire) {
			if (nomClasseObjet(o).equals(Arme.class.getName())) {
				arme = o;
			}
		}

		if (arme != null) {
			degats = ((Arme) arme).getDegats();
			((Arme) arme).tirer();
		} else {
			degats = super.getDegats();
		}

		return degats;
	}

	/**
	 * Augmente la résistance du héro
	 *
	 * @param a
	 *            Armure utilisé par le héro
	 */
	public void amelioreResistance(Armure a) {

		try {
			int total = this.resistance + a.getResistance();

			if (total > RESISTANCE_MAX) {
				total = RESISTANCE_MAX;
			}

			this.resistance = total;

		} catch (NullPointerException e) {
			System.out.println("L'armure passée en paramètre est NULL...");
		}
	}

	/**
	 * Augmente la sante du héro
	 *
	 * @param s
	 *            Soin utilisé par le héro
	 */
	public void restaureSante(Soin s) {

		try {
			int total = getSante() + s.getSante();

			if (total > SANTE_MAX) {
				total = SANTE_MAX;
			}
			setSante(total);

		} catch (NullPointerException e) {
			System.out.println("Le soin passé en paramètre est NULL...");
		}
	}

	/**
	 * Utiliser un objet
	 *
	 * @param o
	 *            Objet utiliser par le héro
	 */
	public void utiliser(Objet o) {

		try {
			Object type[] = typeObjet(o);

			if (nomClasseObjet(o) == type[0]) {
				if (type[2].equals("armure")) {
					amelioreResistance((Armure) o);
					o.getContenant().supprimerObjet(o);
				} else if (type[2].equals("soin")) {
					restaureSante((Soin) o);
					o.getContenant().supprimerObjet(o);
				} else if (type[2].equals("munition")) {
					armePerso().recharger((Munition) o);
					o.getContenant().supprimerObjet(o);
				} else {
					System.out.println("Vous utiliser déjà cet objet...");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}
	}

	/**
	 * Utiliser un objet de l'inventaire
	 *
	 * @param o
	 *            Objet de l'inventaire que veut utiliser le héro
	 */
	public void utiliserObjetInventaire(Objet o) {

		try {
			Object type[] = typeObjet(o);

			if (nomClasseObjet(o) == type[0]) {
				if (type[2].equals("armure")) {
					amelioreResistance((Armure) o);
					supprimerInvertaire(o);
				} else if (type[2].equals("soin")) {
					restaureSante((Soin) o);
					supprimerInvertaire(o);
				} else if (type[2].equals("munition")) {
					armePerso().recharger((Munition) o);
					supprimerInvertaire(o);
				} else {
					System.out.println("Vous ne pouvez pas utilisez ce type d'objet ou vous l'utiliser déjà...");
				}

			}
		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}
	}

	/**
	 * Ajouter un objet à l'inventaire
	 *
	 * @see Hero#changerObjet(Objet)
	 * @param o
	 *            Objet à ajouter dans l'inventaire du héro
	 */
	public void ajouterInventaire(Objet o) {

		try {
			Object type[] = typeObjet(o);

			if (!(inventaireEstPlein())) {
				if (!(estPresent(o, (List) this.inventaire))) {
					if (nomClasseObjet(o).equals(type[0])) {
						if (nbObjetO(o) < (int) type[1]) {
							this.inventaire.add(o);
							o.getContenant().supprimerObjet(o);
							o.setHero(this);
						} else {
							System.out.println("Vous avez atteint le nombre maximal pour cette objet...");
						}
					} else {
						System.out.println("Ce type d'objet n'existe pas...");
					}
				} else {
					System.out.println("Cet objet à déjà été ajouté à la liste...");
				}
			} else {
				System.out.println("L'inventaire est plein");
			}
		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}
	}

	/**
	 * Supprime un objet de l'inventaire
	 *
	 * @see Hero#changerObjet(Objet)
	 * @param o
	 *            Objet à supprimer dans l'inventaire du héro
	 */
	public void supprimerInvertaire(Objet o) {
		try {
			if (nbElementInventaire() > 0) {
				this.inventaire.remove(o);
				o.setHero(null);
			} else {
				System.out.println("L'inventaire est déjà vide...");
			}
		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}
	}

	/**
	 * Change un objet de l'inventaire
	 *
	 * @param o
	 *            Objet à changer dans l'inventaire du héro
	 */
	public void changerObjet(Objet o) {

		try {
			Object type[] = typeObjet(o);
			Object tmp = null;

			for (Object obj : this.inventaire) {
				if (obj.getClass().getName().equals(type[0])) {
					tmp = obj;
				}
			}
			this.supprimerInvertaire((Objet) tmp);
			this.ajouterInventaire(o);

		} catch (NullPointerException e) {
			System.out.println("L'objet passé en paramètre est NULL...");
		}
	}

	/**
	 * Retourne si oui ou non l'inventaire est plein
	 *
	 * @return si l'inventaire est plein sous la forme d'un booléen
	 */
	public boolean inventaireEstPlein() {
		boolean plein = false;

		if (this.nbElementInventaire() == MAX_NB_OBJETS) {
			plein = true;
		}

		return plein;
	}

	/**
	 * Retourne le nombre d'élément dans l'inventaire
	 *
	 * @return un entier représentant le nombre d'objet dans l'inventaire
	 */
	public int nbElementInventaire() {

		return this.inventaire.size();
	}

	/**
	 * Retourne le nombre d'ojet o (nombre d'arme par exemple)
	 *
	 * @param o
	 *            Nombre d'objet présent dans l'inventaire du même type que
	 *            l'objet passé en paramètre
	 * @return le nombre d'objet o sous forme d'entier
	 */
	public int nbObjetO(Objet o) {

		int compteur = nbElementInventaire();
		int nbObjetO = 0;

		for (int i = 0; i < compteur; i++) {
			if (nomClasseObjet(o).equals(nomClasseObjet(this.inventaire.get(i)))) {
				nbObjetO++;
			}
		}
		return nbObjetO;
	}

	/**
	 * Retourne un tableau contenant les informations correspondants au classes
	 *
	 *
	 * @see Hero#utiliser(Objet)
	 * @see Hero#changerObjet(Objet)
	 * @see Hero#utiliserObjetInventaire(Objet)
	 * @see Hero#ajouterInventaire(Objet)
	 * @param o
	 *
	 * @return un tableau d'object (une constante, le nom de la classe ainsi qu'une
	 *         chaine de caractère)
	 */
	private Object[] typeObjet(Objet o) {

		Object typeObj[] = new Object[3];

		if (nomClasseObjet(o).equals(Arme.class.getName())) {
			typeObj[0] = nomClasseObjet(o);
			typeObj[1] = MAX_ARME;
			typeObj[2] = "arme";
		} else if (nomClasseObjet(o).equals(Soin.class.getName())) {
			typeObj[0] = nomClasseObjet(o);
			typeObj[1] = MAX_SOIN;
			typeObj[2] = "soin";
		} else if (nomClasseObjet(o).equals(Armure.class.getName())) {
			typeObj[0] = nomClasseObjet(o);
			typeObj[1] = MAX_ARMURE;
			typeObj[2] = "armure";
		} else if (nomClasseObjet(o).equals(Munition.class.getName())) {
			typeObj[0] = nomClasseObjet(o);
			typeObj[1] = MAX_MUNITION;
			typeObj[2] = "munition";
		} else {
			typeObj[0] = nomClasseObjet(o);
			typeObj[1] = MAX_INDICE;
			typeObj[2] = "indice";
		}

		return typeObj;
	}

	/**
	 * Affichage de l'inventaire
	 *
	 */
	public void afficheInventaire() {

		System.out.println(this.inventaire.toString());
	}

	/**
	 * Retourne le nom de la classe d'un objet
	 *
	 * @see Hero#typeObjet(Objet)
	 * @see Hero#ouvrir(Contenant)
	 * @see Hero#degatsInfliges()
	 * @see Hero#armePerso()
	 * @see Hero#utiliser(Objet)
	 * @see Hero#utiliserObjetInventaire(Objet)
	 * @see Hero#nbObjetO(Objet)
	 * @see Hero#ajouterInventaire(Objet)
	 * @param o
	 *            Objet sur lequel on veut obtenir son type
	 * @return le nom de la classe de l'objet en paramètre sous forme de String
	 */
	private static String nomClasseObjet(Objet o) {

		return o.getClass().getName();
	}

	/**
	 * Ouvre un contenant
	 *
	 * @param c
	 *            Contenant ouvert par le prsonnage
	 */
	public void ouvrir(Contenant c) {

		try {
			if (c.getObjet() != null) {
				if (nomClasseObjet(c.getObjet()).equals(Piege.class.getName())) {
					((Piege) c.getObjet()).exploser(this, ((Piege) c.getObjet()).getDegats());
					c.supprimerObjet(c.getObjet());
					System.out.println("Le coffre était piégé...");
				} else {
					System.out.println(c);
				}
			} else {
				System.out.println(c);
			}
		} catch (NullPointerException e) {
			System.out.println("Le contenant est NULL...");
		}
	}

	/**
	 * Retourne l'arme détenu par le héro
	 *
	 * @return une instance d'Arme (arme du héro)
	 */
	public Arme armePerso() {
		Arme a = null;

		for (Objet o : this.inventaire) {
			if (nomClasseObjet(o).equals(Arme.class.getName())) {
				a = (Arme) o;
			}
		}
		return a;
	}

	/**
	 * Savoir si l'objet est déjà présent dans le monde
	 *
	 * @param o
	 *            Objet que l'on veut ajouter au monde
	 * @param l
	 *            Liste dans laquelle doit être placé l'objet o
	 * @return un booléen
	 */
	public boolean estPresent(Object o, List<Object> l) {
		return p.estPresent(o, l);
	}

	/**
	 * Retourne la résistance du héro
	 *
	 * @return un entier symbolisant la resistance du héro
	 */
	public int getResistance() {
		return resistance;
	}

	/**
	 * Retourne l'inventaire du héro
	 *
	 * @return une liste d'objets
	 */
	public List<Objet> getInventaire() {
		return inventaire;
	}

	/**
	 * Retourne une Instance de Present
	 *
	 * @return une instance d'objet
	 */
	public Present getP() {
		return p;
	}

	/**
	 * Description du héro
	 *
	 * @return la description du héro sous la forme d'un String
	 */
	public String toString() {
		return "Caractéristiques du Héro [" + super.toString() + ", resistance = " + resistance + "\n" + "Son arme = "
				+ armePerso().toString() + " ]\n";
	}
}
