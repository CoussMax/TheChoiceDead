package Utilitaire;

import Contenants.Contenant;
import Objets.*;
import Personnages.Hero;
import Personnages.Kamikase;
import Personnages.Monstre;
import Sortie.*;
import Univers.Lieux;
import Univers.Monde;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>La classe initialisation s'occupe de construire tous les objets, les
 * personnages, les contenants, les sortie.</b>
 * <p>
 * C'est elle qui génére la map du jeu
 * </p>
 */
public class Initialisation {
	public Monde prison;
	public Lieux celluleJ, tourSO, celluleA, gymnase, celluleB, couloirOuest, celluleC, tourNO, celluleD,
			administration, celluleE, tourNE, celluleF, couloirEst, celluleG, parloir, celluleH, tourSE, celluleI,
			cuisine, chaufferie, self, hall, cour, dehors;
	public Sortie sortieCelluleJ, sortieTourSO, sortieCelluleA, sortieGymnase, sortieCelluleB, sortieCouloirOuest,
			sortieCelluleC, sortieTourNO, sortieCelluleD, sortieAdministration, sortieCelluleE, sortieTourNE,
			sortieCelluleF, sortieCouloirEst, sortieCelluleG, sortieParloir, sortieCelluleH, sortieTourSE,
			sortieCelluleI, sortieCuisine, sortieChaufferie, sortieSelf, sortieHall, sortieCour;
	public Verrouille sortieDehors;
	public Explose sortieDehorsPiege, sortieAdministrationPiege, sortieTourSOPiege, sortieChaufferiePiege,
			sortieGymnasePiege, sortieCelluleGPiege, sortieParloirPiege, sortieCelluleBPiege, sortieHallPiege;
	public Monstre zombieA, zombieB, zombieC, zombieD, zombieE, zombieF, zombieG, zombieH, zombieI, zombieJ, zombieK,
			zombieL, chienA, chienB, chienC, chienD, chienE, chienF, chienG, chienH;
	public Kamikase kamikaseA, kamikaseB, kamikaseC, kamikaseD, kamikaseE, kamikaseF, kamikaseG;
	public Arme revolvers, fusil, pistolet, mitraillette, sniper, fusilAPompe, arbalete;
	public Munition mun1, mun2, mun3, mun4, mun5, mun6, mun7, mun8;
	public Armure giletParBalles, antiEmeute, mastodonte;
	public Soin soin1, soin2, soin3, soin4, soin5, soin6, soin7, soin8;
	public Indice indParloir, indGym, indCellD, indTour, indCuisine, indCellG;
	public Piege mineA, mineB, mineC, obusA, obusB, claymoreA, claymoreB, bettyA, bettyB;
	public Contenant coffre1, coffre2, coffre3, coffre4, coffre5, coffre6, coffre7, coffre8, coffre9, coffre10,
			coffre11, coffre12, coffre13, coffre14, coffre15, coffre16, coffre17, coffre18, coffre19, coffre20,
			coffre21, coffre22, coffre23, coffre24, coffre25, coffre26, coffre27, coffre28, coffre29, coffre30,
			coffre31, coffre32, coffre33, coffre34, coffre35, coffre36, coffre37, coffre38, coffre39, coffre40;
	public Hero daril, rick, carol;
	public List<Hero> lesHeros;

	/**
	 * Initialisation de tous les objet (création des objets)
	 */
	public void initialisation() {
		// ********************* Création du Monde
		prison = new Monde("Prison");

		// ********************* Création des Lieux
		celluleJ = new Lieux("CelluleJ", prison);
		tourSO = new Lieux("TourSO", prison);
		celluleA = new Lieux("CelluleA", prison);
		gymnase = new Lieux("Gymnase", prison);
		celluleB = new Lieux("CelluleB", prison);
		couloirOuest = new Lieux("CouloirOuest", prison);
		celluleC = new Lieux("CelluleC", prison);
		tourNO = new Lieux("TourNo", prison);
		celluleD = new Lieux("CelluleD", prison);
		administration = new Lieux("Administration", prison);
		celluleE = new Lieux("CelluleE", prison);
		tourNE = new Lieux("TourNE", prison);
		celluleF = new Lieux("CelluleF", prison);
		couloirEst = new Lieux("CouloirEst", prison);
		celluleG = new Lieux("CelluleG", prison);
		parloir = new Lieux("Parloir", prison);
		celluleH = new Lieux("CelluleH", prison);
		tourSE = new Lieux("TourSE", prison);
		celluleI = new Lieux("CelluleI", prison);
		cuisine = new Lieux("Cuisine", prison);
		chaufferie = new Lieux("Chaufferie", prison);
		self = new Lieux("Self", prison);
		hall = new Lieux("Hall", prison);
		cour = new Lieux("Cour", prison);
		dehors = new Lieux("Dehors", prison);

		// ********************* Création des Sortie
		// ********* Sorties classiques
		sortieCelluleJ = new Sortie("sortieCelluleJ", celluleJ);
		sortieTourSO = new Sortie("sortieTourSO", tourSO);
		sortieCelluleA = new Sortie("sortieCelluleA", celluleA);
		sortieGymnase = new Sortie("sortieGymnase", gymnase);
		sortieCelluleB = new Sortie("sortieCelluleB", celluleB);
		sortieCouloirOuest = new Sortie("sortieCouloirOuest", couloirOuest);
		sortieCelluleC = new Sortie("sortieCelluleC", celluleC);
		sortieTourNO = new Sortie("sortieTourNo", tourNO);
		sortieCelluleD = new Sortie("sortieCelluleD", celluleD);
		sortieAdministration = new Sortie("sortieAdministration", administration);
		sortieCelluleE = new Sortie("sortieCelluleE", celluleE);
		sortieTourNE = new Sortie("sortieTourNE", tourNE);
		sortieCelluleF = new Sortie("sortieCelluleF", celluleF);
		sortieCouloirEst = new Sortie("sortieCouloirEst", couloirEst);
		sortieCelluleG = new Sortie("sortieCelluleG", celluleG);
		sortieParloir = new Sortie("sortieParloir", parloir);
		sortieCelluleH = new Sortie("sortieCelluleH", celluleH);
		sortieTourSE = new Sortie("sortieTourSE", tourSE);
		sortieCelluleI = new Sortie("sortieCelluleI", celluleI);
		sortieCuisine = new Sortie("sortieCuisine", cuisine);
		sortieChaufferie = new Sortie("sortieChaufferie", chaufferie);
		sortieSelf = new Sortie("sortieSelf", self);
		sortieHall = new Sortie("sortieHall", hall);
		sortieCour = new Sortie("sortieCour", cour);

		// ********* Sortie piégées
		sortieDehorsPiege = new Explose("sortieDehors2", dehors);
		sortieAdministrationPiege = new Explose("sortieAdministration2", administration);
		sortieChaufferiePiege = new Explose("sortieChaufferie2", chaufferie);
		sortieTourSOPiege = new Explose("sortieTourNO2", tourSO);
		sortieCelluleGPiege = new Explose("sortieCelluleG2", celluleG);
		sortieGymnasePiege = new Explose("sortieGymnase2", gymnase);
		sortieParloirPiege = new Explose("sortieParloir2", parloir);
		sortieCelluleBPiege = new Explose("sortieCelluleB2", celluleB);
		sortieHallPiege = new Explose("sortieHall2", hall);

		// ********* Sortie vérouillée
		sortieDehors = new Verrouille("sortieDehors", dehors);

		// ********************* Création des Montres
		// ********* Zombie
		zombieA = new Monstre("ZombieA", 40, 10, null);
		zombieB = new Monstre("ZombieB", 40, 10, null);
		zombieC = new Monstre("ZombieC", 40, 10, null);
		zombieD = new Monstre("ZombieD", 40, 10, null);
		zombieE = new Monstre("ZombieE", 40, 10, null);
		zombieF = new Monstre("ZombieF", 40, 10, null);
		zombieG = new Monstre("ZombieG", 40, 10, null);
		zombieH = new Monstre("ZombieH", 40, 10, null);
		zombieI = new Monstre("ZombieI", 40, 10, null);
		zombieJ = new Monstre("ZombieJ", 40, 10, null);
		zombieK = new Monstre("ZombieK", 40, 10, null);
		zombieL = new Monstre("ZombieL", 40, 10, null);
		// ********* Chien
		chienA = new Monstre("ChienA", 25, 20, null);
		chienB = new Monstre("ChienB", 25, 20, null);
		chienC = new Monstre("ChienC", 25, 20, null);
		chienD = new Monstre("ChienD", 25, 20, null);
		chienE = new Monstre("ChienE", 25, 20, null);
		chienF = new Monstre("ChienF", 25, 20, null);
		chienG = new Monstre("ChienG", 25, 20, null);
		chienH = new Monstre("ChienH", 25, 20, null);
		// ********* Kamikase
		kamikaseA = new Kamikase("KamikaseA", 15, 15, 10, null);
		kamikaseB = new Kamikase("KamikaseB", 15, 15, 10, null);
		kamikaseC = new Kamikase("KamikaseC", 15, 15, 10, null);
		kamikaseD = new Kamikase("KamikaseD", 15, 15, 10, null);
		kamikaseE = new Kamikase("KamikaseE", 15, 15, 10, null);
		kamikaseF = new Kamikase("KamikaseF", 15, 15, 10, null);
		kamikaseG = new Kamikase("KamikaseG", 15, 15, 10, null);

		// ********************* Création des Objets
		// ********* Armes
		fusil = new Arme("Fusil", 65, 6, 6);
		pistolet = new Arme("Pistolet", 25, 10, 10);
		mitraillette = new Arme("Mitraillette", 30, 20, 20);
		sniper = new Arme("Sniper", 50, 7, 7);
		fusilAPompe = new Arme("FusilAPompe", 40, 10, 10);
		arbalete = new Arme("Arbalete", 20, 6, 6);
		revolvers = new Arme("Revolvers", 15, 20, 20);
		// ********* Armure
		giletParBalles = new Armure("GiletParBalles", 2);
		antiEmeute = new Armure("AntiEmeute", 3);
		mastodonte = new Armure("Mastodonte", 10);
		// ********* Munitions
		mun1 = new Munition("munition1", 10);
		mun2 = new Munition("munition2", 10);
		mun3 = new Munition("munition3", 10);
		mun4 = new Munition("munition4", 5);
		mun5 = new Munition("munition5", 3);
		mun6 = new Munition("munition6", 2);
		mun7 = new Munition("munition7", 3);
		mun8 = new Munition("munition8", 6);
		// ********* Soins
		soin1 = new Soin("soin1", 15);
		soin2 = new Soin("soin2", 20);
		soin3 = new Soin("soin3", 5);
		soin4 = new Soin("soin4", 15);
		soin5 = new Soin("soin5", 50);
		soin6 = new Soin("soin6", 10);
		soin7 = new Soin("soin7", 10);
		soin8 = new Soin("soin8", 35);
		// ********* Piège
		mineA = new Piege("MineA", 5);
		mineB = new Piege("MineB", 5);
		mineC = new Piege("MineC", 5);
		obusA = new Piege("ObusA", 10);
		obusB = new Piege("ObusB", 10);
		claymoreA = new Piege("ClaymoreA", 20);
		claymoreB = new Piege("ClaymoreB", 20);
		bettyA = new Piege("BettyA", 15);
		bettyB = new Piege("BettyB", 15);
		// ********* Inidice
		indParloir = new Indice("IndParloir", sortieDehors.lettre(sortieDehors.getCodeSecret(), 0));
		indGym = new Indice("IndGymnase", sortieDehors.lettre(sortieDehors.getCodeSecret(), 1));
		indCellD = new Indice("IndCellule D", sortieDehors.lettre(sortieDehors.getCodeSecret(), 2));
		indTour = new Indice("IndTour", sortieDehors.lettre(sortieDehors.getCodeSecret(), 3));
		indCuisine = new Indice("IndCuisine", sortieDehors.lettre(sortieDehors.getCodeSecret(), 4));
		indCellG = new Indice("IndCellG", sortieDehors.lettre(sortieDehors.getCodeSecret(), 5));

		// ********************** Création des Contenants
		coffre1 = new Contenant("coffre1");
		coffre2 = new Contenant("coffre2");
		coffre3 = new Contenant("coffre3");
		coffre4 = new Contenant("coffre4");
		coffre5 = new Contenant("coffre5");
		coffre6 = new Contenant("coffre6");
		coffre7 = new Contenant("coffre7");
		coffre8 = new Contenant("coffre8");
		coffre9 = new Contenant("coffre9");
		coffre10 = new Contenant("coffre10");
		coffre11 = new Contenant("coffre11");
		coffre12 = new Contenant("coffre12");
		coffre13 = new Contenant("coffre13");
		coffre14 = new Contenant("coffre14");
		coffre15 = new Contenant("coffre15");
		coffre16 = new Contenant("coffre16");
		coffre17 = new Contenant("coffre1è");
		coffre18 = new Contenant("coffre18");
		coffre19 = new Contenant("coffre19");
		coffre20 = new Contenant("coffre20");
		coffre21 = new Contenant("coffre21");
		coffre22 = new Contenant("coffre22");
		coffre23 = new Contenant("coffre23");
		coffre24 = new Contenant("coffre24");
		coffre25 = new Contenant("coffre25");
		coffre26 = new Contenant("coffre26");
		coffre27 = new Contenant("coffre27");
		coffre28 = new Contenant("coffre28");
		coffre29 = new Contenant("coffre29");
		coffre30 = new Contenant("coffre30");
		coffre31 = new Contenant("coffre31");
		coffre32 = new Contenant("coffre32");
		coffre33 = new Contenant("coffre33");
		coffre34 = new Contenant("coffre34");
		coffre35 = new Contenant("coffre35");
		coffre36 = new Contenant("coffre36");
		coffre37 = new Contenant("coffre37");
		coffre38 = new Contenant("coffre38");
		coffre39 = new Contenant("coffre39");
		coffre40 = new Contenant("coffre40");

		// ********************* Création du Héro
		daril = new Hero("Daril", 80, 5, hall, revolvers);
		rick = new Hero("Rick", 100, 1, hall, revolvers);
		carol = new Hero("Carol", 90, 2, hall, revolvers);

		lesHeros = new ArrayList<>();
		lesHeros.add(rick);
		lesHeros.add(daril);
		lesHeros.add(carol);

		// ********************* Ajout des Lieux au Monde
		prison.ajoutLieu(celluleJ);
		prison.ajoutLieu(tourSO);
		prison.ajoutLieu(celluleA);
		prison.ajoutLieu(gymnase);
		prison.ajoutLieu(celluleB);
		prison.ajoutLieu(couloirOuest);
		prison.ajoutLieu(celluleC);
		prison.ajoutLieu(tourNO);
		prison.ajoutLieu(celluleD);
		prison.ajoutLieu(administration);
		prison.ajoutLieu(celluleE);
		prison.ajoutLieu(tourNE);
		prison.ajoutLieu(celluleF);
		prison.ajoutLieu(couloirEst);
		prison.ajoutLieu(celluleG);
		prison.ajoutLieu(parloir);
		prison.ajoutLieu(celluleH);
		prison.ajoutLieu(tourSE);
		prison.ajoutLieu(celluleI);
		prison.ajoutLieu(cuisine);
		prison.ajoutLieu(chaufferie);
		prison.ajoutLieu(self);
		prison.ajoutLieu(hall);
		prison.ajoutLieu(cour);
		prison.ajoutLieu(dehors);

		// ********************* Ajout des Sortie aux Lieux
		// ******** Lieu CelluleJ
		celluleJ.ajoutSortie(sortieTourSO);
		// ******** Lieu TourSo
		tourSO.ajoutSortie(sortieCelluleA);
		tourSO.ajoutSortie(sortieCelluleJ);
		// ******** Lieu CelluleA
		celluleA.ajoutSortie(sortieTourSO);
		celluleA.ajoutSortie(sortieCelluleB);
		// ******** Lieu Gymnase
		gymnase.ajoutSortie(sortieCouloirOuest);
		gymnase.ajoutSortie(sortieCelluleBPiege);
		// ******** Lieu CelluleB
		celluleB.ajoutSortie(sortieCelluleA);
		celluleB.ajoutSortie(sortieCelluleC);
		// ******** Lieu couloirOuest
		couloirOuest.ajoutSortie(sortieGymnase);
		couloirOuest.ajoutSortie(sortieAdministration);
		couloirOuest.ajoutSortie(sortieCouloirEst);
		couloirOuest.ajoutSortie(sortieTourSOPiege);
		// ******** Lieu CelluleC
		celluleC.ajoutSortie(sortieCelluleB);
		celluleC.ajoutSortie(sortieTourNO);
		// ******** Lieu TourNO
		tourNO.ajoutSortie(sortieCelluleC);
		tourNO.ajoutSortie(sortieCelluleD);
		// ******** Lieu CelluleD
		celluleD.ajoutSortie(sortieTourNO);
		// ******** Lieu Administration
		administration.ajoutSortie(sortieCouloirEst);
		administration.ajoutSortie(sortieCouloirOuest);
		// ******** Lieu CelluleE
		celluleE.ajoutSortie(sortieTourNE);
		celluleE.ajoutSortie(sortieHallPiege);
		// ******** Lieu TourNE
		tourNE.ajoutSortie(sortieCelluleE);
		tourNE.ajoutSortie(sortieCelluleF);
		tourNE.ajoutSortie(sortieParloirPiege);
		// ******** Lieu CelluleF
		celluleF.ajoutSortie(sortieTourNE);
		celluleF.ajoutSortie(sortieCelluleG);
		// ******** Lieu CouloirEst
		couloirEst.ajoutSortie(sortieAdministration);
		couloirEst.ajoutSortie(sortieParloir);
		couloirEst.ajoutSortie(sortieCouloirOuest);
		// ******** Lieu CelluleG
		celluleG.ajoutSortie(sortieCelluleF);
		celluleG.ajoutSortie(sortieCelluleH);
		celluleG.ajoutSortie(sortieChaufferiePiege);
		// ******** Lieu Parloir
		parloir.ajoutSortie(sortieCouloirEst);
		parloir.ajoutSortie(sortieGymnasePiege);
		// ******** Lieu CelluleH
		celluleH.ajoutSortie(sortieCelluleG);
		celluleH.ajoutSortie(sortieTourSE);
		// ******** Lieu TourSE
		tourSE.ajoutSortie(sortieCelluleH);
		tourSE.ajoutSortie(sortieCelluleI);
		// ******** Lieu CelluleI
		celluleI.ajoutSortie(sortieTourSE);
		celluleI.ajoutSortie(sortieCelluleGPiege);
		// ******** Lieu Cuisine
		cuisine.ajoutSortie(sortieSelf);
		cuisine.ajoutSortie(sortieAdministrationPiege);
		// ******** Lieu Chaufferie
		chaufferie.ajoutSortie(sortieSelf);
		// ******** Lieu Self
		self.ajoutSortie(sortieCuisine);
		self.ajoutSortie(sortieChaufferie);
		self.ajoutSortie(sortieHall);
		// ******** Lieu Hall
		hall.ajoutSortie(sortieSelf);
		hall.ajoutSortie(sortieCour);
		hall.ajoutSortie(sortieDehorsPiege);
		// ******** Lieu Cour
		cour.ajoutSortie(sortieHall);
		cour.ajoutSortie(sortieDehors);

		// ********************* Ajout des Personnages aux Lieux
		// ******** Lieu CelluleJ
		celluleJ.ajoutPersonnage(chienE);
		celluleJ.ajoutPersonnage(chienF);
		// ******** Lieu TourSo
		tourSO.ajoutPersonnage(kamikaseD);
		// ******** Lieu CelluleA
		celluleA.ajoutPersonnage(zombieG);
		// ******** Lieu Gymnase
		gymnase.ajoutPersonnage(zombieF);
		// ******** Lieu CelluleB
		celluleB.ajoutPersonnage(zombieH);
		// ******** Lieu couloirOuest
		couloirOuest.ajoutPersonnage(zombieE);
		// ******** Lieu CelluleC
		celluleC.ajoutPersonnage(zombieI);
		// ******** Lieu TourNO
		tourNO.ajoutPersonnage(kamikaseE);
		// ******** Lieu CelluleD
		// ******** Lieu Administration
		administration.ajoutPersonnage(zombieC);
		administration.ajoutPersonnage(zombieD);
		administration.ajoutPersonnage(kamikaseB);
		administration.ajoutPersonnage(kamikaseC);
		// ******** Lieu CelluleE
		// ******** Lieu TourNE
		tourNE.ajoutPersonnage(kamikaseF);
		// ******** Lieu CelluleF
		celluleF.ajoutPersonnage(zombieJ);
		// ******** Lieu CouloirEst
		couloirEst.ajoutPersonnage(chienD);
		// ******** Lieu CelluleG
		celluleG.ajoutPersonnage(zombieK);
		// ******** Lieu Parloir
		// ******** Lieu CelluleH
		celluleH.ajoutPersonnage(zombieL);
		// ******** Lieu TourSE
		tourSE.ajoutPersonnage(kamikaseG);
		tourSE.ajoutPersonnage(chienG);
		// ******** Lieu CelluleI
		celluleI.ajoutPersonnage(chienC);
		// ******** Lieu Cuisine
		cuisine.ajoutPersonnage(chienA);
		// ******** Lieu Chaufferie
		chaufferie.ajoutPersonnage(zombieB);
		// ******** Lieu Cour
		cour.ajoutPersonnage(zombieA);
		cour.ajoutPersonnage(kamikaseA);
		cour.ajoutPersonnage(chienB);

		// ********************* Ajout des Contenants aux Lieux
		// ******** Lieu CelluleJ
		celluleJ.ajoutContenant(coffre19);
		celluleJ.ajoutContenant(coffre20);
		// ******** Lieu TourSo
		tourSO.ajoutContenant(coffre21);
		// ******** Lieu CelluleA
		celluleA.ajoutContenant(coffre1);
		celluleA.ajoutContenant(coffre2);
		// ******** Lieu Gymnase
		gymnase.ajoutContenant(coffre31);
		// ******** Lieu CelluleB
		celluleB.ajoutContenant(coffre3);
		celluleB.ajoutContenant(coffre4);
		// ******** Lieu couloirOuest
		couloirOuest.ajoutContenant(coffre32);
		// ******** Lieu CelluleC
		celluleC.ajoutContenant(coffre5);
		celluleC.ajoutContenant(coffre6);
		// ******** Lieu TourNO
		tourNO.ajoutContenant(coffre22);
		// ******** Lieu CelluleD
		celluleD.ajoutContenant(coffre7);
		celluleD.ajoutContenant(coffre8);
		// ******** Lieu Administration
		administration.ajoutContenant(coffre37);
		administration.ajoutContenant(coffre38);
		administration.ajoutContenant(coffre39);
		administration.ajoutContenant(coffre40);
		// ******** Lieu CelluleE
		celluleE.ajoutContenant(coffre9);
		celluleE.ajoutContenant(coffre10);
		// ******** Lieu TourNE
		tourNE.ajoutContenant(coffre23);
		// ******** Lieu CelluleF
		celluleF.ajoutContenant(coffre11);
		celluleF.ajoutContenant(coffre12);
		// ******** Lieu CouloirEst
		couloirEst.ajoutContenant(coffre33);
		// ******** Lieu CelluleG
		celluleG.ajoutContenant(coffre13);
		celluleG.ajoutContenant(coffre14);
		// ******** Lieu Parloir
		parloir.ajoutContenant(coffre34);
		// ******** Lieu CelluleH
		celluleH.ajoutContenant(coffre15);
		celluleH.ajoutContenant(coffre16);
		// ******** Lieu TourSE
		tourSE.ajoutContenant(coffre24);
		// ******** Lieu CelluleI
		celluleI.ajoutContenant(coffre17);
		celluleI.ajoutContenant(coffre18);
		// ******** Lieu Cuisine
		cuisine.ajoutContenant(coffre35);
		// ******** Lieu Chaufferie
		chaufferie.ajoutContenant(coffre36);
		// ******** Lieu Self
		// ******** Lieu Hall
		// ******** Lieu Cour
		cour.ajoutContenant(coffre25);
		cour.ajoutContenant(coffre26);
		cour.ajoutContenant(coffre27);
		cour.ajoutContenant(coffre28);
		cour.ajoutContenant(coffre29);
		cour.ajoutContenant(coffre30);

		// ********************* Ajout des Objets aux Contenants
		coffre1.ajoutObjet(claymoreB);
		coffre2.ajoutObjet(bettyA);
		coffre3.ajoutObjet(mun8);
		coffre4.ajoutObjet(mun6);
		coffre5.ajoutObjet(soin8);
		coffre6.ajoutObjet(mineC);
		coffre7.ajoutObjet(indCellD);
		coffre8.ajoutObjet(mineB);
		coffre9.ajoutObjet(soin5);
		coffre10.ajoutObjet(mun4);
		coffre11.ajoutObjet(obusA);
		coffre12.ajoutObjet(mun5);
		coffre13.ajoutObjet(obusB);
		coffre14.ajoutObjet(indCellG);
		coffre15.ajoutObjet(arbalete);
		coffre16.ajoutObjet(mun7);
		coffre17.ajoutObjet(soin6);
		coffre18.ajoutObjet(soin7);
		coffre19.ajoutObjet(bettyB);
		coffre20.ajoutObjet(pistolet);
		coffre21.ajoutObjet(antiEmeute);
		coffre22.ajoutObjet(sniper);
		coffre23.ajoutObjet(claymoreA);
		coffre24.ajoutObjet(indTour);
		coffre25.ajoutObjet(mitraillette);
		coffre26.ajoutObjet(mun2);
		coffre27.ajoutObjet(mun3);
		coffre28.ajoutObjet(soin2);
		coffre29.ajoutObjet(soin3);
		coffre30.ajoutObjet(mineA);
		coffre31.ajoutObjet(indGym);
		coffre32.ajoutObjet(soin4);
		coffre33.ajoutObjet(giletParBalles);
		coffre34.ajoutObjet(indParloir);
		coffre35.ajoutObjet(indCuisine);
		coffre36.ajoutObjet(fusilAPompe);
		coffre37.ajoutObjet(fusil);
		coffre38.ajoutObjet(soin1);
		coffre39.ajoutObjet(mun1);
		coffre40.ajoutObjet(mastodonte);
	}
}
