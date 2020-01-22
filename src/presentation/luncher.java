package presentation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import javax.management.openmbean.OpenMBeanOperationInfo;

import metier.Ecole;
import metier.Etudiant;
import metier.Personnel;
import service.Dao;

public class luncher {
static Personnel userConnect = null;

// fonction qui affiche le menu 
	private static void afficher() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour ins�rer un �tudiant tapez 1");
		System.out.println("Pour modifier le nom d'un �tudiant tapez 2");
		System.out.println("Pour lister les �infos d'un étudaint  tapez 3");
		System.out.println("Pour lister les �tudiants tapez 4");
		System.out.println("Pour supprimer un �tudiant tapez 5");
		System.out.println("Pour Associer un cours à un étudiant tapez 6");
		
		
		
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
		if(userConnect != null) {
			// op�ration � faire
			methodeARepetition();
		}
		
		
		

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
			System.out.println();
			// enr�gistrer un �tudiant
			CreerEtudiant();
			
			continuerOperation();
			break;

		case 2:
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

		case 3:
			// lister infos etudiants 
			System.out.println();
			System.out.print("entrer le nom de l'etudiant � afficher: ");
			String nom = scan.next();
			System.out.println();
			Etudiant etu = Dao.lireEtudiant(nom);
			System.out.println(etu.toString());
			continuerOperation();
			break;
		case 4:
			// lister les �tudiants
			if(userConnect.getFonction().matches("directeur")) {
				System.out.println();
				System.out.println("La liste des �tudiants");
				ArrayList<Etudiant> list = Dao.lireEtudiants();
				for (Etudiant etudiant : list) {
					System.out.println("infos Etudiant : " + etudiant.getNom());
					System.out.println();
					System.out.println(etudiant.toString());
				}
			}
			else {
				System.out.println("vous n'etes pas autorisé à accéder à cette fonctionnalité ");
			}
		
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

		

		default:
			// si aucune op�ration ne correspond
			System.out.println();
			System.out.println("Vous avez saisi un mauvais chiffre. Veuillez reprendre Merci.");
			methodeARepetition();
			break;
		}

	}
//focntion de saisie des infos de l'etudaint 
	private static void CreerEtudiant() {
		Etudiant etudiant = new Etudiant();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("entrer le nom de l'etudiant : ");
		etudiant.setNom(scan.next());
		System.out.println();
		
		System.out.print("entrer le prenom de l'etudiant : ");
		etudiant.setPrenom(scan.next());
		System.out.println();
		
		System.out.print("entrer l'email de l'etudiant : ");
		etudiant.setEmail(scan.next());
		System.out.println();
		
		System.out.print("entrer l'adresse de l'etudiant : ");
		etudiant.setAdresse(scan.next());
		System.out.println();
		
		System.out.print("entrer le telephone de l'etudiant : ");
		etudiant.setTelephone(scan.next());
		System.out.println();
		
		System.out.print("entrer la date de naissance  de l'etudiant : ");
		etudiant.setDate_naiss( Date.valueOf(scan.next()));
		System.out.println();
		Dao.creerEtudiant(etudiant);
		
		
	}

}
