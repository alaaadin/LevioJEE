package tn.esprit.managedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Projet;
import Entities.Ressource;
import Services.RessourceService;

@ManagedBean
@SessionScoped
public class RessourceBean {
	
	private int idRessource;
	private String nom;
	private String prenom;
	private String cv;
	private String photo;
	private String profil;
	private String seniorite;
	private String note;
	private String historique;
	private String secteur;
	private Date dateDebut;
	private Date dateFin;
	private String origine;
	private String statut;
	
	
	
	@EJB
	RessourceService ressourceService;
	
	List<Ressource>ressources;
	
	public List<Ressource> getProjets() {
		ressources = ressourceService.getAllRessource();
		return ressources;
	}
	
	
	

	public RessourceBean() {
		super();
	}




	public int getIdRessource() {
		return idRessource;
	}

	public void setIdRessource(int idRessource) {
		this.idRessource = idRessource;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getSeniorite() {
		return seniorite;
	}

	public void setSeniorite(String seniorite) {
		this.seniorite = seniorite;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getHistorique() {
		return historique;
	}

	public void setHistorique(String historique) {
		this.historique = historique;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public RessourceService getRessourceService() {
		return ressourceService;
	}

	public void setRessourceService(RessourceService ressourceService) {
		this.ressourceService = ressourceService;
	}

	public List<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	

}
