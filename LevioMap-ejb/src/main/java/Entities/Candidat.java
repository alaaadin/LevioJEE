package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Candidat implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private int id ;
private String etat;
@OneToOne(mappedBy="candidat")
private parrain parrain ;

public parrain getParrain() {
	return parrain;
}
public void setParrain(parrain parrain) {
	this.parrain = parrain;
}
public Demande getDemande() {
	return demande;
}
public void setDemande(Demande demande) {
	this.demande = demande;
}
@OneToOne
private Demande demande;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEtat() {
	return etat;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((etat == null) ? 0 : etat.hashCode());
	result = prime * result + id;
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
	Candidat other = (Candidat) obj;
	if (etat == null) {
		if (other.etat != null)
			return false;
	} else if (!etat.equals(other.etat))
		return false;
	if (id != other.id)
		return false;
	return true;
}
public void setEtat(String etat) {
	this.etat = etat;
}
}
