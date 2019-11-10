package Interfaces;

import javax.ejb.Local;

import Entities.Utilisateur;


@Local
public interface UserServiceLocal {
	void addUser(Utilisateur user);

	Utilisateur findUserById(Integer idUser);

	void updateUser(Utilisateur user);

	Utilisateur login(String login, String password);

}
