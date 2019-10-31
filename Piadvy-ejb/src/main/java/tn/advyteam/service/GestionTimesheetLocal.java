package tn.advyteam.service;

import java.util.List;

import javax.ejb.Local;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Projet;
import tn.advyteam.entities.Timesheet;

@Local
public interface GestionTimesheetLocal {
	/**
	 * 
	 * Crud of projet
	 */
	public int addProject(Projet projet);
	public Projet getProjectById(int id);
	public void deleteProjectById(int id);
	public void updateProject(Projet projet, int id);
	public List<Projet> getAllProjectsByManager(int id);
	
	/**
	 * Crud of timesheet
	 */
	
	public void addTimesheet(Timesheet timesheet);
	public void addTimesheet(int idProjet, int idDeveloper, Timesheet timesheet);
	public void affectTimesheetToDevloper(Timesheet timesheet, Developpeur developpeur);
	public List<Timesheet> getAllTimesheetsByDeveloperJPQL(int id);
	public List<Timesheet> getAllTimesheetsByProject(int id);
	public Timesheet getTimesheet(int idP, int idD);	
	public void updateHeureMinuteTimesheet();
	public void startTracking(Timesheet timesheet);
	public void stopTracking(Timesheet timesheet);
	public Timesheet getTimeshetByid(int id);
	public List<Developpeur> getAllDeveloppeur();
	public void updateTimesheetState(Timesheet timesheet);
	public Timesheet getTimesheetById(int id);
	public List<Timesheet> getTimesheetDP(int idP, int idD);
	public List<Projet> getAllProjetByEmploye(int id);
	
	public void startTracking();
	public void stopTracking();
	public void deleteTimesheetById(int id);

	
	
	
}
