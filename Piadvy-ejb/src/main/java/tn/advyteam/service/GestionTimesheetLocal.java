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
	public void affectTimesheetToDevloper(Timesheet timesheet, Developpeur developpeur);
	public List<Timesheet> getAllTimesheetsByDeveloperJPQL(int id);
	public List<Timesheet> getAllTimesheetsByProject(int id);
}
