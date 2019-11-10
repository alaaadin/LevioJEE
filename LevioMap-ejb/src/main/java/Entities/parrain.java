package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class parrain  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private int idPar;
	public int getIdPar() {
		return idPar;
	}

	public void setIdPar(int idPar) {
		this.idPar = idPar;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	@OneToOne

private Candidat candidat ;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idPar;
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
	parrain other = (parrain) obj;
	if (idPar != other.idPar)
		return false;
	return true;
}
}
