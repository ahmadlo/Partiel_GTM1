/**
 * 
 */
package metier;

/**
 * @author braham
 * Classe de base des cours 
 */
public class Cours  {

	private int id;
	private String theme;
	private int nb_heures;
	/**
	 * 
	 */
	public Cours() {
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * @return the nb_heures
	 */
	public int getNb_heures() {
		return nb_heures;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/**
	 * @param nb_heures the nb_heures to set
	 */
	public void setNb_heures(int nb_heures) {
		this.nb_heures = nb_heures;
	}
	
	
	
}
