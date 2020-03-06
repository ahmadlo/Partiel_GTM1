package dao;

import java.sql.ResultSet;
import java.sql.Statement;

import metier.Personnel;

/**
 * @author braham
 * Classe de gestion des appels de la BDD pour le Personnel
 */
public class PersonnelDao {

	private static Statement st = null;
	private static ResultSet rs = null;
	private static String sql = "";
	private static Bdd B = new Bdd();
	//methode de conenxion du personnel 
			/**
			 * methode de connexion des personnels 
			 * @param login
			 * @param password
			 * @return 
			 */
			public static Personnel connexionAppli(String login,String password) {
				
				Personnel user = null;
				// connexion  à la base de données 
				try {
					B.connection();;
					if(B.getCn()!=null) {
						
						// etape 3 creation du statement
						st = B.getCn().createStatement();
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
			
}
