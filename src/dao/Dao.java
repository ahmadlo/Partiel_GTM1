package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import metier.Cours;
import metier.Ecole;
import metier.Etudiant;
import metier.Personnel;

/**
 * @author braham
 *
 */

public  class Dao {

	public static String password = "";
	static Connection cn = null;
	static Statement st = null;
	private static ResultSet rs;

	//methode de conenxion à la base de données 
	/**
	 * @throws SQLException
	 */
	public static void  connexion() throws SQLException {
		// information de la base de donnee

		String url = "jdbc:mysql://localhost/partiel_gtm";
		String login = "root";



		try {
			// etape1 chargement du driver
			if(cn ==null ||cn.isClosed() ) {
				Class.forName("com.mysql.jdbc.Driver");

				// etape2 recupertion de la connnexion

				cn = DriverManager.getConnection(url, login, password);
			}
			//System.out.println("connexion reussie " + cn.toString());



		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			System.out.println("fsd");
			//cn.close();
			//st.close();
		}
	}

	//methode de conenxion du personnel 
	/**
	 * @param login
	 * @param password
	 * @return
	 */
	public static Personnel connexionAppli(String login,String password) {

		Personnel user = null;
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from personnel where  login = '" + login + "' and password = '" + password + "'";

				// etape 4 executer la requette

				rs = st.executeQuery(sql);

				// etape5 parcours du resultSet

				while (rs.next()) {
					user = new Personnel();

					user.setIdentifiant(rs.getString("identifiant"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setAdresse(rs.getString("adresse"));
					user.setTelephone(rs.getString("telephone"));
					user.setFonction(rs.getString("fonction"));


				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		// retourner le personnel connecté 
		return user;



	}

	// methode d'insertion d'etudiant 
	/**
	 * @param etudiant
	 */

	public static void creerEtudiant(Etudiant etudiant) {

		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {
				final String identifiant = UUID.randomUUID().toString().replace("-", "");


				// etape 3 creation du statement
				st = cn.createStatement();

				String sql = "INSERT INTO `etudiant` (`identifiant`,`nom`,`prenom`,`email`,`adresse`,`telephone`,`date_naiss`) "
						+ "VALUES ('" + identifiant+ "','" + etudiant.getNom() + "','" + etudiant.getPrenom() 
						+ "','" + etudiant.getEmail() + "','" + etudiant.getAdresse() + "','" + etudiant.getTelephone() + "'"
						+ ",'" + etudiant.getDate_naiss() + "' )";

				//		// etape 4 executer la requette

				st.executeUpdate(sql);
				System.out.println("Enr�gistrement effectu� avec succ�s !!!! ");

			}



		} catch (Exception e) {
			e.printStackTrace();
		}



	}


	//update de �tudiant
	/**
	 * @param ancienNom
	 * @param nouveauNom
	 */
	public static void updateEtudiant(String ancienNom, String nouveauNom) {

		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {
				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "update etudiant set nom = '" + nouveauNom + "' where nom = '" + ancienNom + "'";

				// etape 4 executer la requette

				int rs = st.executeUpdate(sql);
				System.out.println("modification du nom de l'�tudiant �ffectu�e avec succ�s");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	//lire les infos d'un étudiant 
	/**
	 * @param nom
	 * @return
	 */
	public static Etudiant  lireEtudiant(String nom) {

		Etudiant user = null;
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from etudiant where  nom = '" + nom + "'";

				// etape 4 executer la requette

				rs = st.executeQuery(sql);

				// etape5 parcours du resultSet

				while (rs.next()) {
					user = new Etudiant();

					user.setIdentifiant(rs.getString("identifiant"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setAdresse(rs.getString("adresse"));
					user.setTelephone(rs.getString("telephone"));
					user.setDate_naiss(rs.getDate("date_naiss"));


				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		// retourner le personnel connecté 
		return user;

	}


	//liste des étudiants 
	/**
	 * @return
	 */
	public static ArrayList<Etudiant>  lireEtudiants() {
		ArrayList<Etudiant> list = null;
		Etudiant user = null;
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from etudiant ";

				// etape 4 executer la requette

				rs = st.executeQuery(sql);

				// etape5 parcours du resultSet
				list = new ArrayList<Etudiant>();
				while (rs.next()) {
					user = new Etudiant();

					user.setIdentifiant(rs.getString("identifiant"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setAdresse(rs.getString("adresse"));
					user.setTelephone(rs.getString("telephone"));
					user.setDate_naiss(rs.getDate("date_naiss"));
					list.add(user);


				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		// retourner le personnel connecté 
		return list;

	}

	//supprimer  des étudiants 
	/**
	 * @param nom
	 */
	public static void deleteEtudiant(String nom) {
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {


				// etape 3 creation du statement
				st = cn.createStatement();

				String sql = "delete from `etudiant` where `nom` = '" + nom + "'";
				//			// etape 4 executer la requette

				st.executeUpdate(sql);
				System.out.println("suppression effectu� avec succ�s !!!! ");

			}



		} catch (Exception e) {
			e.printStackTrace();
		}



	}


	/**
	 * 
	 */
	public static void lireEtudiant() {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from etudiant";

			// etape 4 executer la requette
			System.out.println("Liste des etudiants ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				System.out.println(rs.getInt("idEcole"));
				System.out.println(" ");
				System.out.print(rs.getString("nom"));
				System.out.print(" ");
				System.out.println(rs.getString("prenom"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * @param ecole
	 */
	public static void creerEcole(Ecole ecole) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";



		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			//			String sql = "INSERT INTO `ecole` (`nomEcole`,`adresseEcole`) VALUES ('" + ecole.getNom() + "','"
			//					+ ecole.getAdresse() + "')";
			//
			//			// etape 4 executer la requette
			//			st.executeUpdate(sql);
			System.out.println("Enr�gistrement effectu� avec succ�s !!!! ");

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	public static void lireEcole() {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from ecole";

			// etape 4 executer la requette
			System.out.println("Liste des ecoles ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				System.out.print(rs.getString("nomEcole"));
				System.out.print(" ");
				System.out.println(rs.getString("adresseEcole"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}



	//update �cole
	/**
	 * @param ancienNom
	 * @param nouveauNom
	 */
	public static void updateEcole(String ancienNom, String nouveauNom) {
		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		Connection cn = null;
		Statement st = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "update ecole set nomEcole = '" + nouveauNom + "' where nomEcole = '" + ancienNom + "'";

			// etape 4 executer la requette

			int rs = st.executeUpdate(sql);
			System.out.println("modification du nom de l'�cole �ffectu�e avec succ�s");

		} catch (SQLException e) {
			System.out.println("Le nom n'existe pas");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} /*
		 * finally {
		 * 
		 * // etape 5 liberer les ressources try { cn.close(); st.close(); } catch
		 * (SQLException e) {
		 * 
		 * e.printStackTrace(); }

		 } */
	}

	/**
	 * @param nom
	 */
	public static void deleteEcole(String nom) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null, rs2 = null;

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sqlVerification = "SELECT distinct `idEcole` FROM `etudiant` WHERE `idEcole` = (SELECT `idEcole` FROM `ecole` WHERE `nomEcole` = '"
					+ nom + "')";
			rs2 = st.executeQuery(sqlVerification);
			if (rs2.next()) {
				System.out.println("Suppression impossible. L'�cole est reli�e � des �tudiants");
			} else {

				String sql = "delete from `ecole` where `nomEcole` = '" + nom + "'";
				// etape 4 executer la requette
				st.executeUpdate(sql);

				// etape5 parcours du resultSet
				System.out.println("Suppression �ffectu�e avec succ�s");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} /*
		 * finally {
		 * 
		 * // etape 5 liberer les ressources try { cn.close(); st.close(); } catch
		 * (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
	}


	// associer etudiant et cours 

	/**
	 * @param matEtud
	 * @param idcours
	 */
	public static void associerCoursEtudiant(String matEtud, int idcours) {

		// information de la base de donnee

		String url = "jdbc:mysql://localhost/etudiantecole";
		String login = "root";



		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `etudiant_cours` (`idetudiant`,`idcours`) VALUES ('" + matEtud + "','"
					+ idcours + "')";
			//
			//			// etape 4 executer la requette
			//			st.executeUpdate(sql);
			System.out.println("Enr�gistrement effectu� avec succ�s !!!! ");

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}} /*
		 * finally {
		 * 
		 * // etape 5 liberer les ressources try { //st.close(); //cn.close();
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } } }
		 */

	//lire les infos d'un cours 
	/**
	 * @param nom
	 * @return
	 */
	public static Cours  lireCours(String nom) {

		Cours cours = null;
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from cours where  theme = '" + nom + "'";

				// etape 4 executer la requette

				rs = st.executeQuery(sql);

				// etape5 parcours du resultSet

				while (rs.next()) {
					cours = new Cours();

					cours.setId(rs.getInt("id"));
					cours.setTheme(rs.getString("theme"));
					cours.setNb_heures(rs.getInt("nb_heures"));


				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		// retourner le cours connecté 
		return cours;

	}


	//liste des cours 
	/**
	 * @return
	 */
	public static ArrayList<Cours>  listeCours() {
		ArrayList<Cours> list = null;
		Cours cours = null;
		// connexion  à la base de données 
		try {
			connexion();
			if(cn!=null) {

				// etape 3 creation du statement
				st = cn.createStatement();
				String sql = "select * from cours ";

				// etape 4 executer la requette

				rs = st.executeQuery(sql);

				// etape5 parcours du resultSet
				list = new ArrayList<Cours>();
				while (rs.next()) {
					cours = new Cours();

					cours.setId(rs.getInt("id"));
					cours.setTheme(rs.getString("theme"));
					cours.setNb_heures(rs.getInt("nb_heures"));

					list.add(cours);


				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		// retourner la liste des cours 
		return list;

	}

}
