package Interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Projet;

@Local
public interface ProjetServiceLocal {
	
	public void removeProjet(int projetId);
	public void FindProjet(int projetId);
	public void UpdateProjet(Projet proj);
	public List<Projet> getAllProject();

}
