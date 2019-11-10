package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Projet;
import Entities.Ressource;
import Interfaces.RessourceServiceLocal;
import Interfaces.RessourceServiceRemote;

/**
 * Session Bean implementation class RessourceService
 */
@Stateless
@LocalBean
public class RessourceService implements RessourceServiceRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RessourceService() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Ressource> getAllRessource() {
		TypedQuery<Ressource> query = em.createQuery("Select r from Ressource r", Ressource.class);
		List<Ressource> listRes = query.getResultList();
		return listRes;
		
	}

}
