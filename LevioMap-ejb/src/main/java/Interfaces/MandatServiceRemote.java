package Interfaces;

import javax.ejb.Remote;

import Entities.Mandat;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
@Remote
public interface MandatServiceRemote {
    public List<Mandat> getAll();
    public List<Mandat> getMandatsNotif();
    public List<Mandat> SearchMandateByDate(Date date);
    public List<Mandat> getMandateByResource(int resourceId);

    public void AssignResource(int projetId,int resourceId,String dateDebut,String dateFin)throws ParseException;
    public void CalculFraisMandat(int mandateID,float taux,float NbrH);

    public List<Mandat> AfficherHistorique();
    public List<Mandat> ArchivedMandate();
    public void  ArchiveMandat(int idMandat);
    public void TrackResource();
    public String SendMail(String username,String password,String from,String to,String subject,String msg);
    public void  ModifierMandat(Mandat m);
    public void removeMandat(int mandattId);
    public void UpdateMandat(Mandat m);

}

