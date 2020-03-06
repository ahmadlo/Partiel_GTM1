package service;

import dao.PersonnelDao;
import metier.Personnel;

public interface IPersonnel {
	PersonnelDao personnelDao = new PersonnelDao();
	public default Personnel authentification(String login,String password ) {
		return personnelDao.connexionAppli(login, password);
		
	}

}
