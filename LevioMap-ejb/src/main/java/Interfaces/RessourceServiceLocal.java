package Interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Ressource;

@Local
public interface RessourceServiceLocal {
	 public List<Ressource> getAllRessource();

}
