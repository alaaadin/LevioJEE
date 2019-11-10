package tn.esprit.managedBeans;



	import java.io.Serializable;
	import java.util.List;
	import java.util.Locale;

	import javax.ejb.EJB;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.SessionScoped;

    import Entities.Mandat;
    import Interfaces.MandatServiceRemote;
    import Services.MandatService;
	


	@ManagedBean
	@SessionScoped
	public class MandatFilter  implements Serializable {
		
		
		     
		    private List<Mandat> mandats;
		    private List<Mandat> filteredMandates;
		     
		     
		  
		    private MandatService mandatService;
		    @EJB
		    private MandatServiceRemote mandatServiceReemote;
		 
		  
		     
		    public boolean filterById(Object value, Object filter, Locale locale) {
		        String filterText = (filter == null) ? null : filter.toString().trim();
		        if(filterText == null||filterText.equals("")) {
		            return true;
		        }
		         
		        if(value == null) {
		            return false;
		        }
		         
		        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
		    }



			public List<Mandat> getMandats() {
				return mandats;
			}



			public void setMandats(List<Mandat> mandats) {
				this.mandats = mandats;
			}



			public List<Mandat> getFilteredMandates() {
				return filteredMandates;
			}



			public void setFilteredMandates(List<Mandat> filteredMandates) {
				this.filteredMandates = filteredMandates;
			}



			public MandatService getMandatService() {
				return mandatService;
			}



			public void setMandatService(MandatService mandatService) {
				this.mandatService = mandatService;
			}



			public MandatServiceRemote getMandatServiceReemote() {
				return mandatServiceReemote;
			}



			public void setMandatServiceReemote(MandatServiceRemote mandatServiceReemote) {
				this.mandatServiceReemote = mandatServiceReemote;
			}
		     
		  
		  
		
		

	}
	

