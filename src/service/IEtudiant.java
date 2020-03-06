package service;

import java.util.ArrayList;

import metier.Etudiant;

public interface IEtudiant {
	
	public String creerEtudiant(Etudiant etudiant);
	
	public abstract Etudiant  lireEtudiant(String nom) ;
	
	public abstract String updateEtudiant(String ancienNom, String nouveauNom) ;
	
	public abstract ArrayList<Etudiant>  lireEtudiants();
	
	public abstract String deleteEtudiant(String nom);
	public abstract void associerCoursEtudiant(String matEtud, int idcours);
	
}
