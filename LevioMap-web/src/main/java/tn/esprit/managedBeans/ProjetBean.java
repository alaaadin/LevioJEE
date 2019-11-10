package tn.esprit.managedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Projet;
import Entities.TypeProjet;
import Services.ProjetService;

@ManagedBean
@SessionScoped
public class ProjetBean {
	
	private int idProjet;
	private String NomProjet;
	private int NbrRessource;
	private float Rentabilite;
	private float Benefice;
	private Date DateDebut;
	private Date DateFin;
	private TypeProjet Typeprojet;
	
	@EJB
	ProjetService projetService;
	
	List<Projet>projets;
	
	public List<Projet> getProjets() {
		projets = projetService.getAllProject();
		return projets;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomProjet() {
		return NomProjet;
	}

	public void setNomProjet(String nomProjet) {
		NomProjet = nomProjet;
	}

	public int getNbrRessource() {
		return NbrRessource;
	}

	public void setNbrRessource(int nbrRessource) {
		NbrRessource = nbrRessource;
	}

	public float getRentabilite() {
		return Rentabilite;
	}

	public void setRentabilite(float rentabilite) {
		Rentabilite = rentabilite;
	}

	public float getBenefice() {
		return Benefice;
	}

	public void setBenefice(float benefice) {
		Benefice = benefice;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public TypeProjet getTypeprojet() {
		return Typeprojet;
	}

	public void setTypeprojet(TypeProjet typeprojet) {
		Typeprojet = typeprojet;
	}

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}
	
	
	
	
	
	

}
