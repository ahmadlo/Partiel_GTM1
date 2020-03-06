package service;

import java.util.ArrayList;

import metier.Etudiant;

public interface IEtudiant {
	
	/**Permet de créer un étudiant 
	 * @param etudiant
	 * @return String 
	 */
	public String creerEtudiant(Etudiant etudiant);
	
	/** permet de lire les infso d'un étudiant
	 * @param nom
	 * @return les infos d'un étudiant
	 */
	public abstract Etudiant  lireEtudiant(String nom) ;
	
	/**
	 * permet de mettre à jour les infos d'un étudiant 
	 * @param ancienNom
	 * @param nouveauNom
	 * @return String
	 */
	public abstract String updateEtudiant(String ancienNom, String nouveauNom) ;
	
	/**
	 * permet de récupérer la liste des étudiants 
	 * @return liste d'étudiants
	 */
	public abstract ArrayList<Etudiant>  lireEtudiants();
	
	/**
	 * Permet de supprimer un étudiant 
	 * @param nom
	 * @return String
	 */
	public abstract String deleteEtudiant(String nom);
	
	/**
	 * Permet d'associer un étudiant à un cours 
	 * @param matEtud
	 * @param idcours
	 */
	public abstract void associerCoursEtudiant(String matEtud, int idcours);
	
}
