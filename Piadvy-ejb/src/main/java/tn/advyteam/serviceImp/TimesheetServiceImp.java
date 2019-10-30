package tn.advyteam.serviceImp;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Manager;
import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;
import tn.advyteam.entities.TimesheetPK;
import tn.advyteam.service.GestionTimesheetLocal;
import tn.advyteam.service.GestionTimesheetRemote;



@Stateful
@LocalBean
public class TimesheetServiceImp implements GestionTimesheetLocal, GestionTimesheetRemote{


	Instant debut = null;
	Instant fin = null; 
	
	
	
	@PersistenceContext
	EntityManager em;
	
	
	
	/**
	 * 
	 * 
	 * CRUD Project
	 * 
	 */
	
	@Override
	public int addProject(Projet projet) {
		em.persist(projet);
		return projet.getId();
	}

	@Override
	public Projet getProjectById(int id) {
		return em.find(Projet.class, id);
	}

	@Override
	public void deleteProjectById(int id) {
		em.remove(getProjectById(id));
	}

	@Override
	public void updateProject(Projet projet, int id) {

		Projet projetToupdate = getProjectById(id);
		projetToupdate.setTitre(projet.getTitre());
		projetToupdate.setDescription(projet.getDescription());
	}

	@Override
	public List<Projet> getAllProjectsByManager(int id) {

		
		Manager manager= em.find(Manager.class, id);
		List<Projet> projets = manager.getProjets();
		return projets;
		/*
		TypedQuery<Projet> query = em.createQuery(""
				+ "select p from Projet p join p.createdBy m join m.projets e where e.createdBy=:id", Projet.class);
		query.setParameter("id", id);
	
		return query.getResultList();
		*/
	}
	/**
	 * 
	 * CRUD Timesheet
	 * 
	 */

	@Override
	public void addTimesheet(int idProjet, int idDeveloper, Timesheet timesheet) {
		
		
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setIdDeveloppeur(idDeveloper);
		timesheetPK.setIdProjet(idProjet);
		timesheet.setTimesheetPk(timesheetPK);
		em.persist(timesheet);
		
	}

	@Override
	public void affectTimesheetToDevloper(Timesheet timesheet, Developpeur developpeur) {
		timesheet.setDeveloppeur(developpeur);
		em.merge(timesheet);
	}	

	@Override
	public List<Timesheet> getAllTimesheetsByDeveloperJPQL(int id) {
		
		TypedQuery<Timesheet> query=em.createQuery("select t from Timesheet t where t.timesheetPk.idDeveloppeur=:id", Timesheet.class);
		query.setParameter("id", id);
		return query.getResultList();
		
	}

	@Override
	public List<Timesheet> getAllTimesheetsByProject(int id) {
			TypedQuery<Timesheet> query=em.createQuery("select t from Timesheet t where t.timesheetPk.idProjet=:id", Timesheet.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public void addTimesheet(Timesheet timesheet) {
		
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheet.setTimesheetPk(timesheetPK);
		em.persist(timesheet);
		
	}

	@Override
	public void updateHeureMinuteTimesheet() {

		//startTracking();
		
		debut = Instant.now();
		
		Timesheet timesheet = getTimesheetById(11);

		System.out.println(timesheet);
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//stopTracking();
		fin = Instant.now();

		long hours = Duration.between(debut, fin).toHours();
		long minutes = Duration.between(debut, fin).toMinutes() - (hours * 60);
		
		if(timesheet.getMinutePasse()+minutes>=59) {
			hours+=1;
			long ecart = Math.abs((timesheet.getMinutePasse()+minutes)-60);
			timesheet.setHeurePasse(timesheet.getHeurePasse()+hours);
			timesheet.setMinutePasse(ecart);	
		}
		else {
			timesheet.setHeurePasse(timesheet.getHeurePasse()+hours);
			timesheet.setMinutePasse(timesheet.getMinutePasse()+minutes);	
		}
		
		debut = null;
		fin = null;
		System.out.println("klk");
		em.merge(timesheet);
	}

	@Override
	public Timesheet getTimesheet(int idP, int idD) {
		
		Query query = em.createQuery("select t from Timesheet t where t.timesheetPk.idProjet=:idP and t.timesheetPk.idDeveloppeur=:idD", Timesheet.class);
		
		query.setParameter("idP", idP);
		query.setParameter("idD", idD);
		return (Timesheet) query.getSingleResult();
	}

	
	

	@Override
	public void startTracking(Timesheet timesheet) {
		debut = Instant.now();
		timesheet.setDebut(debut);
	}

	@Override
	public void stopTracking(Timesheet timesheet){
		fin = Instant.now();
		timesheet.setFin(fin);
		
		long hours = Duration.between(debut, fin).toHours();
		long minutes = Duration.between(debut, fin).toMinutes() - (hours * 60);
		
		if(timesheet.getMinutePasse()+minutes>=59) {
			hours+=1;
			long ecart = Math.abs((timesheet.getMinutePasse()+minutes)-60);
			timesheet.setHeurePasse(timesheet.getHeurePasse()+hours);
			timesheet.setMinutePasse(ecart);	
		}
		else {
			timesheet.setHeurePasse(timesheet.getHeurePasse()+hours);
			timesheet.setMinutePasse(timesheet.getMinutePasse()+minutes);	
		}
		
		fin = null;
		debut=null;
		
		System.out.println("klk");
		em.merge(timesheet);
		
	}

	@Override
	public Timesheet getTimeshetByid(int id) {
		return em.find(Timesheet.class, id);
	}

	@Override
	public List<Developpeur> getAllDeveloppeur() {
		TypedQuery<Developpeur> query = em.createQuery("select d from Developpeur d", Developpeur.class);
		return query.getResultList();
	}

	@Override
	public void updateTimesheetState(Timesheet timesheet) {
		em.merge(timesheet);
		
	}

	@Override
	public Timesheet getTimesheetById(int id) {
		
		return em.find(Timesheet.class, id);
	}

	@Override
	public List<Timesheet> getTimesheetDP(int idP, int idD) {
		TypedQuery<Timesheet> query = em.createQuery("select t from Timesheet t where t.timesheetPk.idProjet=:idP and t.timesheetPk.idDeveloppeur=:idD", Timesheet.class);	
		query.setParameter("idP", idP);
		query.setParameter("idD", idD);
		return query.getResultList();
	}

	@Override
	public List<Projet> getAllProjetByEmploye(int id) {
		TypedQuery<Projet> query = em.
				createQuery("select DISTINCT p from Projet p join p.timesheets t join t.developpeur d where d.id=:id", Projet.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

	@Override
	public void startTracking() {
		this.debut = Instant.now();
		
	}

	@Override
	public void stopTracking() {
		// TODO Auto-generated method stub
		
	}



}
