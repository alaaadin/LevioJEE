package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Projet;

@Remote
public interface ProjetServiceRemote {
	public void removeProjet(int projetId);
	public void FindProjet(int projetId);
	public void UpdateProjet(Projet proj);
	public List<Projet> getAllProject();

}
