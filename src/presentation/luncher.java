package presentation;

import java.util.Scanner;

import javax.management.openmbean.OpenMBeanOperationInfo;

import metier.Ecole;
import metier.Etudiant;
import metier.Personnel;
import service.Dao;

public class luncher {
static Personnel userConnect = null;
	private static void afficher() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour ins�rer une �cole tapez 1");
		System.out.println("Pour ins�rer un �tudiant tapez 2");
		System.out.println("Pour lister les �coles tapez 3");
		System.out.println("Pour lister les �tudiants tapez 4");
		System.out.println("Pour supprimer une �cole tapez 5");
		System.out.println("Pour supprimer un �tudiant tapez 6");
		System.out.println("Pour modifier le nom d'une �cole tapez 7");
		System.out.println("Pour modifier le nom d'un �tudiant tapez 8");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");

	}

	private static Integer saisieOperation() {
		// saisir une num�ro qui correspond � une op�ration
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	// regroupement des m�thodes qui se r�p�tent
	private static void methodeARepetition() {
		// appel de la m�thode afficher
		afficher();
		// r�cup�ration du chiffre saisie
		int saisie = saisieOperation();
		// op�ration � ex�cuter
		operation(saisie);
	}

	/*
	 * mot de passe base de donn�e
	 */
	private static void saisirMotDePasse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Avez vous un mot de passe pour mysql O / N : ");
		String reponse = sc.next().toUpperCase();
		if (reponse.equals("O")) {
			System.out.println();
			System.out.print("Veuillez saisir le mot de passe de votre base mysql : ");
			System.out.println();
			Dao.password = sc.next();
		}
	}

	// m�thode main
	public static void main(String[] args) {
		// mot de passe mysql
		saisirMotDePasse();
		// connexion à l'application  
		testerConnexion();
		// op�ration � faire
		methodeARepetition();

	}

	private static void testerConnexion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Vous devez vous connectez avant d'accéder à l'application : ");
		System.out.println();
		System.out.print("Veuillez saisir votre login : ");
		System.out.println();
		String login  = sc.next();
		System.out.println();
		System.out.print("Veuillez saisir votre password : ");
		System.out.println();
		String password   = sc.next();
		
		
		userConnect= Dao.connexionAppli(login,password );
		System.out.println("bienvenue  : " + userConnect.getNom());
		
	}

	/*
	 * demander si l'utilisateur veut poursuivre les op�rations
	 */
	private static void continuerOperation() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Voulez-vous continuer? O / N : ");
		System.out.println();
		String reponse = sc.next().toUpperCase();
		//
		switch (reponse) {

		case "O":
			// recommencer
			methodeARepetition();
			break;
		case "N":
			// finir le programme
			System.out.println("Au revoir !!!");
			break;
		default:
			// reposer la question
			System.out.println("Mauvaise reponse");
			continuerOperation();
			break;
		}
	}

	/*
	 * op�ration � ex�cuter
	 */
	private static void operation(int chiffre) {
		Scanner scan = new Scanner(System.in);
		switch (chiffre) {
		case 1:
			// enr�gistrer une �cole
			System.out.println();
			System.out.print("entrer le nom de l'�cole : ");
			String nomEcol = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'�cole : ");
			String adresse = scan.next();
			Ecole ecole = new Ecole();
			Dao.creerEcole(ecole);
			continuerOperation();
			break;

		case 2:
			System.out.println();
			// enr�gistrer un �tudiant
			System.out.print("entrer le nom de l'etudiant : ");
			String nom = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'etudiant : ");
			String prenom = scan.next();
			System.out.println();
			System.out.print("entrer le nom de l'�cole : ");
			String nomEcole = scan.next();
			Etudiant etudiant = new Etudiant();
			Dao.creerEtudiant(etudiant, nomEcole);
			continuerOperation();
			break;

		case 3:
			// lister les �coles
			System.out.println();
			System.out.println("La liste des �coles");
			Dao.lireEcole();
			continuerOperation();
			break;
		case 4:
			// lister les �tudiants
			System.out.println();
			System.out.println("La liste des �tudiants");
			Dao.lireEtudiant();
			continuerOperation();
			break;
		case 5:
			// supprimer une �cole
			System.out.println();
			System.out.print("entrer le nom de l'�cole � supprimer: ");
			String nomEcoleSupprimer = scan.next();
			Dao.deleteEcole(nomEcoleSupprimer);
			continuerOperation();
			break;

		case 6:
			// supprimer un �tudiant
			System.out.println();
			System.out.print("entrer le nom de l'�tudiant � supprimer: ");
			String nomEtudiantSupprimer = scan.next();
			Dao.deleteEtudiant(nomEtudiantSupprimer);
			continuerOperation();
			break;

		case 7:
			// modifer une �cole
			System.out.println();
			System.out.print("entrer le nom de l'�cole � modifier: ");
			String ancienNomEcole = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'�cole : ");
			String nouveauNomEcole = scan.next();
			Dao.updateEcole(ancienNomEcole, nouveauNomEcole);
			continuerOperation();
			break;
		case 8:
			// modifier un �tudiant
			System.out.println();
			System.out.print("entrer le nom de l'etudiant � modifier: ");
			String ancienNom = scan.next();
			System.out.println();
			System.out.print("entrer le nouveau nom de l'etudiant : ");
			String nouveauNom = scan.next();
			Dao.updateEtudiant(ancienNom, nouveauNom);
			continuerOperation();
			break;

		default:
			// si aucune op�ration ne correspond
			System.out.println();
			System.out.println("Vous avez saisi un mauvais chiffre. Veuillez reprendre Merci.");
			methodeARepetition();
			break;
		}

	}

}
