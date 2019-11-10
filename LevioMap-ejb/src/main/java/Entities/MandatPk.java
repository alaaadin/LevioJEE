package Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MandatPk
 *
 */
@Embeddable

public class MandatPk implements Serializable {

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClient;
		result = prime * result + idRessource;
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
		MandatPk other = (MandatPk) obj;
		if (idClient != other.idClient)
			return false;
		if (idRessource != other.idRessource)
			return false;
		return true;
	}

	private int idClient;
	private int idRessource;
	private static final long serialVersionUID = 1L;

	public MandatPk() {
		super();
	}   
	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}   
	public int getIdRessource() {
		return this.idRessource;
	}

	public void setIdRessource(int idRessource) {
		this.idRessource = idRessource;
	}
   
}
