package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity

public class Competence implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int idCompetence;
	private Date DateMiseAJour;
	private String Competences;
	
	@ManyToMany(mappedBy="Competences")
	private List<Ressource> Ressources;

	
	public List<Ressource> getRessources() {
		return Ressources;
	}
	public void setRessources(List<Ressource> ressources) {
		Ressources = ressources;
	}
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	public Date getDateMiseAJour() {
		return DateMiseAJour;
	}
	public void setDateMiseAJour(Date dateMiseAJour) {
		DateMiseAJour = dateMiseAJour;
	}
	public String getCompetences() {
		return Competences;
	}
	public void setCompetences(String competences) {
		Competences = competences;
	}
	public Competence() {
		super();
	}



}
