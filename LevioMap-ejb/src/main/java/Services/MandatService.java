package Services;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;


import Entities.Mandat;
import Entities.Projet;
import Entities.Ressource;
import Interfaces.MandatServiceRemote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
@Stateless
@LocalBean
public class MandatService implements MandatServiceRemote {
    @PersistenceContext(unitName="LevioMap-ejb")
    EntityManager em;

    
    
    @Override
    public List<Mandat> getAll() {
        TypedQuery<Mandat> query = em.createQuery("SELECT m FROM Mandat m where archive=false", Mandat.class);
        List<Mandat> results = query.getResultList();
        return results;
    }
    //where Archived=false

    @Override
    public List<Mandat> SearchMandateByDate(Date date) {

        TypedQuery<Mandat> query = em.createQuery("SELECT m FROM Mandat m where m.dateDebut<=:date and m.dateFin>=:date and archive=false", Mandat.class);
        query.setParameter("date", date,TemporalType.DATE);
        List<Mandat> results = query.getResultList();
        return results;
    }

    @Override
    public List<Mandat> getMandateByResource(int resourceId) {

        TypedQuery<Mandat> query = em.createQuery("SELECT m FROM Mandat m where m.ressource.id=:resId and archive=false", Mandat.class);
        query.setParameter("resId", resourceId);
        List<Mandat> results = query.getResultList();
        return results;
    }
    
    
    

   
    
   
    @Override
    public void CalculFraisMandat(int idMandat,float taux,float NbrH) {
    	Mandat mandateEntity = em.find(Mandat.class, idMandat);
    	float montant=taux*NbrH; 
    	mandateEntity.setFrais(montant);
    }

    @Override
    public List<Mandat> AfficherHistorique() {
        TypedQuery<Mandat> query = em.createQuery("SELECT m FROM Mandat m where m.dateFin<=CURRENT_DATE and archive=false", Mandat.class);
        List<Mandat> results = query.getResultList();
        return results;
    }

    @Override
    public void ArchiveMandat(int idMandat) {
    	Mandat mandateEntity = em.find(Mandat.class,idMandat);
    	mandateEntity.setArchive(true);
    	};

    @Override
    public void TrackResource() {

    }
    @Override
    public List<Mandat> ArchivedMandate(){
        TypedQuery<Mandat> query = em.createQuery("SELECT m FROM Mandate m where archive=true", Mandat.class);
        List<Mandat> results = query.getResultList();
        return results;
    
    }
    @Override
    public String SendMail(String username,String password,String from,String to,String subject,String msg)
    {
     // user=	notifmaplevio@gmail.com
    // pass=NinjaC0ders	

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);

			Transport.send(message);

			return "Done";

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
    	
    }
    
    
    @Override
	public void removeMandat(int mandattId) {
		Mandat m = em.find(Mandat.class, mandattId);
		em.remove(m);
	}


	

	@Override
	public void ModifierMandat(Mandat m) {
		// TODO Auto-generated method stub
		Mandat mand = em.find(Mandat.class, m.getIdMandat());
    	if(m.getDateDebut()!=null)
    	mand.setDateDebut(m.getDateDebut());
    	if(m.getDateFin()!=null)
    	mand.setDateFin(m.getDateFin());
    	if(m.getFrais()>0)
    	mand.setFrais(m.getFrais());

    	em.merge(mand);
		
	}

	@Override
	public void AssignResource(int projetId, int resourceId, String dateDebut, String dateFin) throws ParseException {
		// TODO Auto-generated method stub
		
		Projet projetEntity = em.find(Projet.class, projetId);
    	Ressource resourceEntity = em.find(Ressource.class, resourceId);
    	
    	Mandat mand=new Mandat();
    	
    	String pattern = "yyyy-MM-dd";
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
 
    	mand.setDateDebut(simpleDateFormat.parse(dateDebut));
    	mand.setDateFin(simpleDateFormat.parse(dateFin));
    	mand.setProjet(projetEntity);
    	mand.setRessource(resourceEntity);
    	em.persist(mand);
    	SendMail("notifmaplevio@gmail.com","NinjaC0ders","notifmaplevio@gmail.com","alaeddine.sayahi@esprit.tn","Assign Notification","vous avez une nouvelle assignation ");
		
	}

	@Override
	public void UpdateMandat(Mandat m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Mandat> getMandatsNotif() {
		// TODO Auto-generated method stub
		 TypedQuery<Mandat> query = em.createQuery("SELECT p FROM mandat p WHERE datediff(p.dateFin, p.CURRENT_DATE)<=10", Mandat.class);
	        List<Mandat> results = query.getResultList();
	        return results;
	}
}
