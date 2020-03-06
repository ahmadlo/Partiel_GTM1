package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author braham
 * Classe de base de l'Ecole
 */
public class Ecole {

	
	private String nom;
	private String adresse;
	private String email;
	private String telephone;
	private String directeur;
	
	
	
	/**
	 * 
	 */
	public Ecole() {
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @return the directeur
	 */
	public String getDirecteur() {
		return directeur;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @param directeur the directeur to set
	 */
	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}
	
	
		
}
