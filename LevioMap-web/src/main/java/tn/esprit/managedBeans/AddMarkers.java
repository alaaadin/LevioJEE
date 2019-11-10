package tn.esprit.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import Services.ClientService;
import Entities.*;

import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class AddMarkers implements Serializable {
    
	  private MapModel advancedModel;
	  @EJB
	  private ClientService clientservice;
	    private Marker marker;
	  private List<Client> listclient;
	    @PostConstruct
	    public void init() {
	        advancedModel = new DefaultMapModel();
	        if(!clientservice.findAllClients().isEmpty())
	        { listclient=clientservice.findAllClients();
	        StringBuilder ruta = new StringBuilder();
	        ruta.append(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
	        ruta.append("/resources/img/");
	        for (Client client : listclient) {
				 
	        //Shared coordinates
	        LatLng coord1 = new LatLng(client.getLatitude(), client.getLongitude());

	        //Icons and Data
	        advancedModel.addOverlay(new Marker(coord1, client.getNomC(), client.getNomC()+"jpg", ruta.toString()+client.getLogo()));
 
	    	}}
	    }
	  
	    public MapModel getAdvancedModel() {
	        return advancedModel;
	    }
	 
	    public void onMarkerSelect(OverlaySelectEvent event) {
	        marker = (Marker) event.getOverlay();
	       
	    }
	      
	    public Marker getMarker() {
	        return marker;
	    }
}