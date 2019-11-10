package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity implementation class for Entity: Mandat
 *
 */

@Entity
public class Mandat implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMandat;
	
	
	private float frais;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date dateFin;
	
	private boolean archive;
	
	

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Ressource ressource;
	
	@Override
	public String toString() {
		return "Mandat [idMandat=" + idMandat + ", frais=" + frais + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", archive=" + archive + ", ressource=" + ressource + ", projet=" + projet + "]";
	}

	@ManyToOne
	private Projet projet;
	
	
	
	
	
	public Mandat(int idMandat, float frais, Date dateDebut, Date dateFin, boolean archive, Ressource ressource,
			Projet projet) {
		super();
		this.idMandat = idMandat;
		this.frais = frais;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.archive = archive;
		this.ressource = ressource;
		this.projet = projet;
	}
	
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}


	
	
	public Mandat(int MandatIdTobeUpdated, Date dateDebut, Date dateFin, float frais) {
		super();
		this.idMandat = MandatIdTobeUpdated;
		this.frais = frais;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.projet = projet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ressource getRessource() {
		return ressource;
	}
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Mandat() {
		super();
	}   
	public int getIdMandat() {
		return this.idMandat;
	}

	public void setIdMandat(int idMandat) {
		this.idMandat = idMandat;
	}   
	public float getFrais() {
		return this.frais;
	}

	public void setFrais(float frais) {
		this.frais = frais;
	}   
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
   
}
