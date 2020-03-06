package service;

import java.util.ArrayList;

import dao.EtudiantDao;
import metier.Etudiant;

public class EtudiantService implements IEtudiant {
	
	EtudiantDao ed = new EtudiantDao();

	@Override
	public String creerEtudiant(Etudiant etudiant) {
		
		if (ed.createEtudiant(etudiant) != 0) {
			return "Etudiant insere";
		}
		return "Etudiant non inser�";
	}

	@Override
	public Etudiant lireEtudiant(String nom) {
		// TODO Auto-generated method stub
		Etudiant etudiant = ed.getEtudiant(nom);
		
		return etudiant;
	}

	@Override
	public String updateEtudiant(String ancienNom, String nouveauNom) {
		if (ed.updateEtudiant(ancienNom, nouveauNom) != 0) {
			return "Etudiant modifié";
		}
		return "Etudiant non modifié";
	}

	@Override
	public ArrayList<Etudiant> lireEtudiants() {
		
		return ed.getEtudiants();
	}

	@Override
	public String deleteEtudiant(String nom) {
		if (ed.deleteEtudiant( nom) != 0) {
			return "Etudiant modifié";
		}
		return "Etudiant non modifié";
	}

	@Override
	public void associerCoursEtudiant(String matEtud, int idcours) {
		ed.associerCoursEtudiant(matEtud, idcours);
		
	}

}
