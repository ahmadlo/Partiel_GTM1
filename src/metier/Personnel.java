/**
 * Classe de gestion du Personnel de l'école
 */
package metier;

/**
 * @author braham
 *
 */
public class Personnel  extends Personne{

	private String fonction;
	
	private String login ;
	
	private String password;

	
	
	/**
	 * 
	 */
	public Personnel() {
	}

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
