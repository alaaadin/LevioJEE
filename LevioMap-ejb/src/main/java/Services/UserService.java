package Services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Utilisateur;
import Interfaces.UserServiceLocal;
import Interfaces.UserServiceRemote;


@Stateless
public class UserService implements UserServiceLocal, UserServiceRemote {
    
	
	public UserService() {
		
	}
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addUser(Utilisateur user) {
		entityManager.persist(user);
		
	}
	@Override
	public Utilisateur findUserById(Integer idUser) {
		return entityManager.find(Utilisateur.class, idUser);
	}
	@Override
	public void updateUser(Utilisateur user) {
		entityManager.merge(user);
		
	}
	@Override
	public Utilisateur login(String login, String password) {
		Utilisateur user = null;
		String jpql = "SELECT u FROM User u WHERE u.login = :param1 AND u.password = :param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (Utilisateur) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return user;
	}
	


}

