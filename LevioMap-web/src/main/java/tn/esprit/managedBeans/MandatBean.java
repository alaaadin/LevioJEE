package tn.esprit.managedBeans;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entities.Mandat;
import Entities.Projet;
import Entities.Ressource;
import Interfaces.MandatServiceRemote;
import Services.MandatService;
import Services.ProjetService;
import Services.RessourceService;

@ManagedBean
@ViewScoped
public class MandatBean {
	
	private int idMandat;
	private float frais;
	private Date dateDebut;
	private Date dateFin;
	private boolean archive;
	private int MandatIdTobeUpdated;
	
	@EJB
	MandatService mandatService;
	
	@EJB
	ProjetService projetService;
	
	@EJB
	RessourceService ressourceService;
	
	
	private List<Mandat>mandats;
/*	
	private String projet;
	private List<String>projets=Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
	private String ressource;
	private List<String>ressources=Arrays.asList("Buenos Aires", "Córdoba", "La Plata");*/
	
    private List<Ressource> ressources = new ArrayList<>();
    private Ressource selectRessource = new Ressource();
	
	
	private List<Projet> projets = new ArrayList<>();
    private Projet selectedProjet=new Projet();

	  @PostConstruct
	  public void postInit() {
	      
			
	      List<Projet> prjts = projetService.getAllProject();
	      for (Projet projet : prjts) {
	    	  
	    	  projets.add(projet);
	    	  
	      }
	      
	      List<Ressource> listRess = ressourceService.getAllRessource();
	      for (Ressource ressource : listRess) {
	    	  
	    	  ressources.add(ressource);
	    	  
	      }
	  }
	  
	 
	      
	  public void delete(int MandatId){
			
		  mandatService.removeMandat(MandatId);;
		}
		
	    
	    public void modifier(Mandat m){
			this.setIdMandat(m.getIdMandat());
			this.setDateDebut(m.getDateDebut());
			this.setDateFin(m.getDateFin());
			this.setFrais(m.getFrais());
			
			
			
		}
		
		public void metreAjourProjet(){
			
			mandatService.UpdateMandat(new Mandat(MandatIdTobeUpdated, dateDebut, dateFin, frais));
		}


	public RessourceService getRessourceService() {
		return ressourceService;
	}


	public int getMandatIdTobeUpdated() {
		return MandatIdTobeUpdated;
	}



	public void setMandatIdTobeUpdated(int mandatIdTobeUpdated) {
		MandatIdTobeUpdated = mandatIdTobeUpdated;
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



	public Ressource getSelectRessource() {
		return selectRessource;
	}



	public void setSelectRessource(Ressource selectRessource) {
		this.selectRessource = selectRessource;
	}



	public List<Mandat> getMandats() {
		mandats = mandatService.getAll();
		return mandats;
	}

	

	public ProjetService getProjetService() {
		return projetService;
	}



	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}



	public List<Projet> getProjets() {
		return projets;
	}



	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}



	public Projet getSelectedProjet() {
		return selectedProjet;
	}



	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}


	public MandatService getMandatService() {
		return mandatService;
	}


	public void setMandatService(MandatService mandatService) {
		this.mandatService = mandatService;
	}
	
	


	public String ajoutMandat(int idProjet,int idRessource,String dateDebut,String dateFin) throws IOException, ParseException{
		
			if(dateDebut!=null && dateFin!=null) {
			this.mandatService.AssignResource(idProjet, idRessource, dateDebut, dateFin);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/LevioMap-web/pages/mandats/listMandat.jsf?faces-redirect=true");}
			return "/pages/mandats/listMandat.jsf?faces-redirect=true";
			
		}
	
	
	
/*
	public String getRessource() {
		return ressource;
	}



	public void setRessource(String ressource) {
		this.ressource = ressource;
	}



	public List<String> getRessources() {
		return ressources;
	}



	public void setRessources(List<String> ressources) {
		this.ressources = ressources;
	}*/



	public int getIdMandat() {
		return idMandat;
	}

	public void setIdMandat(int idMandat) {
		this.idMandat = idMandat;
	}

	public float getFrais() {
		return frais;
	}

	public void setFrais(float frais) {
		this.frais = frais;
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

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	

	public void setMandats(List<Mandat> mandats) {
		this.mandats = mandats;
	}
	
	
	public void calculFrais(){
		
		mandatService.CalculFraisMandat(idMandat, 0, 0);
	}
	

}
