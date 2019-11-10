package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Demande implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private int idDemande ;
public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public Date getDateDemande() {
		return DateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		DateDemande = dateDemande;
	}
	public String getEtatDemande() {
		return EtatDemande;
	}
	public void setEtatDemande(String etatDemande) {
		EtatDemande = etatDemande;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	public Candidat getCandidat() {
		return Candidat;
	}
	public void setCandidat(Candidat candidat) {
		Candidat = candidat;
	}
private Date DateDemande;
private String EtatDemande;
private String Specialite;

@OneToOne(mappedBy="demande")
private Candidat Candidat;


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((DateDemande == null) ? 0 : DateDemande.hashCode());
	result = prime * result + ((EtatDemande == null) ? 0 : EtatDemande.hashCode());
	result = prime * result + ((Specialite == null) ? 0 : Specialite.hashCode());
	result = prime * result + idDemande;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Demande other = (Demande) obj;
	if (DateDemande == null) {
		if (other.DateDemande != null)
			return false;
	} else if (!DateDemande.equals(other.DateDemande))
		return false;
	if (EtatDemande == null) {
		if (other.EtatDemande != null)
			return false;
	} else if (!EtatDemande.equals(other.EtatDemande))
		return false;
	if (Specialite == null) {
		if (other.Specialite != null)
			return false;
	} else if (!Specialite.equals(other.Specialite))
		return false;
	if (idDemande != other.idDemande)
		return false;
	return true;
}
}
