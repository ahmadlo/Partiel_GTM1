package metier;
/*
 * classe de base des etudiants qui hérite de PErsonne 
 */
public class Etudiant extends Personne  {


	// propriétés spécifiques 
	private String date_naiss;



	/**
	 * 
	 */
	public Etudiant() {
	}
	
	/**
	 * @return the date_naiss
	 */
	public String getDate_naiss() {
		return date_naiss;
	}

	/**
	 * @param date_naiss the date_naiss to set
	 */
	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}
	
	
	
	
	
	
}
