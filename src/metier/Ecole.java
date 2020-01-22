package metier;

import java.util.ArrayList;
import java.util.List;

public class Ecole {

	
	private String nom;
	private String email;
	private String adresse;
	private String telephone;
	private String directeur;
	
	
	
	public Ecole(String nomEcole, String adresseEcole) {
		super();
		this.nom = nomEcole;
		this.adresse = adresseEcole;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomEcole) {
		this.nom = nomEcole;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresseEcole) {
		this.adresse = adresseEcole;
	}

	
		
}
