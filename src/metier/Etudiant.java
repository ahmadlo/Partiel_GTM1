package metier;

import java.sql.Date;

/*
 * classe de base des etudiants qui hérite de PErsonne 
 */
public class Etudiant extends Personne  {


	// propriétés spécifiques 
	private Date date_naiss;



	/**
	 * 
	 */
	public Etudiant() {
	}
	
	/**
	 * @return the date_naiss
	 */
	public Date getDate_naiss() {
		return date_naiss;
	}

	/**
	 * @param date_naiss the date_naiss to set
	 */
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}

	@Override
	public String toString() {
		return "Etudiant [getDate_naiss()=" + getDate_naiss() + ", getIdentifiant()=" + getIdentifiant() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse() + ", getEmail()="
				+ getEmail() + ", getTelephone()=" + getTelephone() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	
}
