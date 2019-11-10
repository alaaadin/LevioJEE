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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ressource implements Serializable {

	@Override
	public String toString() {
		return this.nom + " " +this.prenom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date dateFin;
	private String origine;
	private String statut;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Competence> Competences;
	
	
	

	public List<Competence> getCompetences() {
		return Competences;
	}

	public void setCompetences(List<Competence> competences) {
		Competences = competences;
	}

	
	public Ressource(Integer ressourceIdTobeUpdated, String nom, String prenom, String cv, String photo, String profil, String seniorite, String note,
			String historique, String secteur, Date dateDebut, Date dateFin, String origine, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cv = cv;
		this.photo = photo;
		this.profil = profil;
		this.seniorite = seniorite;
		this.note = note;
		this.historique = historique;
		this.secteur = secteur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.origine = origine;
		this.statut = statut;
		this.idRessource=ressourceIdTobeUpdated;
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

	public Ressource() {
		super();
	}

	public Ressource(String nom, String prenom, String cv, String photo, String profil, String seniorite, String note,
			String historique, String secteur, Date dateDebut, Date dateFin, String origine, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cv = cv;
		this.photo = photo;
		this.profil = profil;
		this.seniorite = seniorite;
		this.note = note;
		this.historique = historique;
		this.secteur = secteur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.origine = origine;
		this.statut = statut;
	}
	
	

}