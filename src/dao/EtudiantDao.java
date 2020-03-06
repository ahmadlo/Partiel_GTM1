package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import metier.Cours;
import metier.Etudiant;

/**
 * @author braham
 * Classe de gestion des appels de la BDD pour l'Etudiant 
 */
public class EtudiantDao {
	private static Statement st = null;
	private static ResultSet rs = null;
	private static String sql = "";
	private static Bdd B = new Bdd();
	
	// methode d'insertion d'etudiant 
	public  int createEtudiant(Etudiant etudiant) {

		// connexion  à la base de données 
		try {
			B.connection();
			if(B.getCn() != null) {
				String identifiant = UUID.randomUUID().toString().replace("-", "");
				System.out.println(identifiant);


				// etape 3 creation du statement
				st = B.getCn().createStatement();

				String sql = "INSERT INTO `etudiant` (`identifiant`,`nom`,`prenom`,`email`,`adresse`,`telephone`,`date_naiss`) "
						+ "VALUES ('" + identifiant+ "','" + etudiant.getNom() + "','" + etudiant.getPrenom() 
						+ "','" + etudiant.getEmail() + "','" + etudiant.getAdresse() + "','" + etudiant.getTelephone() + "'"
						+ ",'" + etudiant.getDate_naiss() + "' )";

				//			// etape 4 executer la requette

				st.executeUpdate(sql);
				System.out.println("Enr�gistrement effectu� avec succ�s !!!! ");
				return 1;

			}
			return 0;



		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;



	}

	//update de �tudiant
	public int  updateEtudiant(String ancienNom, String nouveauNom) {

		// connexion  à la base de données 
		try {
			B.connection();
			if(B.getCn()!=null) {
				// etape 3 creation du statement
				st = B.getCn().createStatement();
				String sql = "update etudiant set nom = '" + nouveauNom + "' where nom = '" + ancienNom + "'";

				// etape 4 executer la requette

				int rs = st.executeUpdate(sql);
				return rs;
				//System.out.println("modification du nom de l'�tudiant �ffectu�e avec succ�s");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
return 0;


	}

	//lire les infos d'un étudiant 
	public  Etudiant  getEtudiant(String nom) {

		Etudiant user = null;
		// connexion  à la base de données 
		try {
			B.connection(); 
			if(B.getCn()!=null) {

				// etape 3 creation du statement
				st = B.getCn().createStatement();
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
	public  ArrayList<Etudiant>  getEtudiants() {
		ArrayList<Etudiant> list = null;
		Etudiant user = null;
		// connexion  à la base de données 
		try {
			B.connection();
			if(B.getCn()!=null) {

				// etape 3 creation du statement
				st = B.getCn().createStatement();
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
	public  int deleteEtudiant(String nom) {
		// connexion  à la base de données 
		try {
			B.connection();
			if(B.getCn()!=null) {
				final String identifiant = UUID.randomUUID().toString().replace("-", "");


				// etape 3 creation du statement
				st = B.getCn().createStatement();

				String sql = "delete from `etudiant` where `nom` = '" + nom + "'";
				//					// etape 4 executer la requette

				st.executeUpdate(sql);
				return 1;
				//System.out.println("suppression effectu� avec succ�s !!!! ");

			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;



	}


	// associer etudiant et cours 
	
		public static void associerCoursEtudiant(String matEtud, int idcours) {

			

			try {
				

				// etape2 recupertion de la connnexion
				B.connection();
				if(B.getCn()!=null) {


					// etape 3 creation du statement
					st = B.getCn().createStatement();
					String sql = "INSERT INTO `etudiant_cours` (`idetudiant`,`idcours`) VALUES ('" + matEtud + "','"
							+ idcours + "')";
		//
//					// etape 4 executer la requette
//					st.executeUpdate(sql);
					System.out.println("Enr�gistrement effectu� avec succ�s !!!! ");

					
				}

				
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
		public static Cours  lireCours(String nom) {
					
					Cours cours = null;
					// connexion  à la base de données 
					try {
						B.connection();
						if(B.getCn()!=null) {
							
							// etape 3 creation du statement
							st = B.getCn().createStatement();
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

		
	

}
