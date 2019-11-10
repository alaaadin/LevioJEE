package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organigramme implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int IdOrg;
	private int idClient;
	private String NomHauteDir;
	private String Pvp;
	private String Vp;
	private String NomDir;
	
	@OneToMany(mappedBy="organigramme")
	private List<Projet> projets;
	
	
	public Organigramme() {
		super();
	}

	

	public Organigramme( String nomHauteDir, String pvp, String nomDir) {
		super();
		
		NomHauteDir = nomHauteDir;
		Pvp = pvp;
		NomDir = nomDir;
	}



	public int getIdOrg() {
		return IdOrg;
	}


	public void setIdOrg(int idOrg) {
		IdOrg = idOrg;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getNomHauteDir() {
		return NomHauteDir;
	}


	public void setNomHauteDir(String nomHauteDir) {
		NomHauteDir = nomHauteDir;
	}


	public String getPvp() {
		return Pvp;
	}


	public void setPvp(String pvp) {
		Pvp = pvp;
	}


	public String getVp() {
		return Vp;
	}


	public void setVp(String vp) {
		Vp = vp;
	}


	public String getNomDir() {
		return NomDir;
	}


	public void setNomDir(String nomDir) {
		NomDir = nomDir;
	}


	



	

}
