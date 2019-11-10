package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

 @Entity
public class Projet implements Serializable{
	
	 @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProjet;
	private String NomProjet;
	private int NbrRessource;
	private float Rentabilite;
	private float Benefice;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date DateDebut;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date DateFin;
	
	@Enumerated(EnumType.STRING)
	private TypeProjet Typeprojet;
	
	
	@ManyToOne
	private Organigramme organigramme;
	 @JsonIgnore
	 @OneToMany(mappedBy="projet")
	 private List<Mandat> mandats;
	
	
	


	public List<Mandat> getMandats() {
		return mandats;
	}



	public void setMandats(List<Mandat> mandats) {
		this.mandats = mandats;
	}



	public Projet() {
		super();
	}
	
	@Override
	public String toString() {
		return this.NomProjet;
	}


	public Projet(String nomProjet, int nbrRessource, float rentabilite, float benefice) {
		super();
		NomProjet = nomProjet;
		NbrRessource = nbrRessource;
		Rentabilite = rentabilite;
		Benefice = benefice;
	}



	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
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

	public String getNomProjet() {
		return NomProjet;
	}

	public void setNomProjet(String nomProjet) {
		NomProjet = nomProjet;
	}

	public Organigramme getOrganigramme() {
		return organigramme;
	}

	public void setOrganigramme(Organigramme organigramme) {
		this.organigramme = organigramme;
	}

	

	
 
	
	

}
