package metier;

import java.sql.Date;

/**
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

	/**
	 * Permet d'afficher l'état de l'objet 
	 */
	@Override
	public String toString() {
		return getNom() + " - " + getPrenom() + " - "   + getAdresse() + " - "  + getDate_naiss()  ;
	}
	
	
	
	
	
	
	
}
