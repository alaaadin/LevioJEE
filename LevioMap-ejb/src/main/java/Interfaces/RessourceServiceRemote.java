package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Ressource;

@Remote
public interface RessourceServiceRemote {

	 public List<Ressource> getAllRessource();
}
