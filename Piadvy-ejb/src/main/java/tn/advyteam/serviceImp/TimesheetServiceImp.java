package tn.advyteam.serviceImp;

import java.sql.Time;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Manager;
import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;
import tn.advyteam.service.GestionTimesheetLocal;
import tn.advyteam.service.GestionTimesheetRemote;


@Stateful
public class TimesheetServiceImp implements GestionTimesheetLocal, GestionTimesheetRemote{

	
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
	public void addTimesheet(Timesheet timesheet) {
		em.persist(timesheet);
		
	}

	@Override
	public void affectTimesheetToDevloper(Timesheet timesheet, Developpeur developpeur) {
		timesheet.setDeveloppeur(developpeur);
		em.merge(timesheet);
	}

	@Override
	public List<Timesheet> getAllTimesheetsByDeveloperJPQL(int id) {
		
		Developpeur developpeur=em.find(Developpeur.class, id);
		List<Timesheet> timesheets=developpeur.getTimesheets();
		return timesheets;
	}

	@Override
	public List<Timesheet> getAllTimesheetsByProject(int id) {
		Projet projet=em.find(Projet.class, id);
		List<Timesheet> timesheets=projet.getTimesheets();
		return timesheets;
	}

}
