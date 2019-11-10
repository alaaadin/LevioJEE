package Services;

import java.util.List; 

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Client;




/**
 * Session Bean implementation class ArchiveService
 */
@Stateless
@LocalBean
public class ClientService   {
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ClientService() {
        // TODO Auto-generated constructor stub
    }

	
	public Client addClient(Client client) {
		em.persist(client);
	 
		return client;
	}

	
	public Client saveClient(Client client) {
			em.merge(client);
			return client;
	}
	
	
	public Client updateClient(Client client) {
		return em.merge(client);
	}
	
	
	public List<Client> findAllClients() {
		
		List<Client> archives = em.createQuery("select a from Client a", Client.class)
				.getResultList();
		
		return archives;
	}


	public Client findClientById(int id) {
		return em.find(Client.class, id);
	}
	
	
	public Client findClientByName(String name) {
		return em.find(Client.class, name);
	}
	
	
	public Boolean removeClientByName(String name) {
		if (!name.equals("")) {
			em.remove(em.merge(findClientByName(name)));
			return true ;
		}
		return false;
	}
	
	public Boolean removeClient(Client client) {
		if (client != null) {
			em.remove(em.merge(client));
			return true ;
		}
		return false;
	}
}