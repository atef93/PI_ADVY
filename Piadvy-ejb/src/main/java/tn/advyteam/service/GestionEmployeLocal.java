package tn.advyteam.service;

import java.util.List;

import javax.ejb.Local;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Manager;

@Local
public interface GestionEmployeLocal {
	
	public int addManager(Manager manager);
	public Manager getManagerById(int id);
	public void deleteManagerById(int id);
	public List<Manager> getAllManager();
	public void updateManager(Manager manager, int id);
	
	public int addDeveloper(Developpeur developpeur);
	public Developpeur getDeveloperById(int id);
	public void deleteDeveloperById(int id);
	public List<Developpeur> getAllDevelopers();
	public void updateDeveloper(Developpeur developpeur, int id);
	
}
