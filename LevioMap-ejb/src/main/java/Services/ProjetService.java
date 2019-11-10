package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;




import Entities.Projet;
import Interfaces.ProjetServiceLocal;
import Interfaces.ProjetServiceRemote;

/**
 * Session Bean implementation class ProjetService
 */
@Stateless
@LocalBean
public class ProjetService implements ProjetServiceRemote {

    /**
     * Default constructor. 
     */
    public ProjetService() { }
    
    @PersistenceContext
  	EntityManager em;
    
	public int addProjet(Projet p) {
		em.persist(p);
		return p.getIdProjet();
		
	}

	@Override
	public void removeProjet(int projetId) {
		Projet p = em.find(Projet.class, projetId);
		em.remove(p);
	}

	public void FindProjet(int projetId) {
		em.find(Projet.class, projetId);
		
	}

	@Override
	public void UpdateProjet(Projet proj) {
		em.merge(proj);
		
	}
	
	public List<Projet> getAllProject() {
		TypedQuery<Projet> query = em.createQuery("Select e from Projet e", Projet.class);
		List<Projet> rs = query.getResultList();
		return rs;
		
	}
}
