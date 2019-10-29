package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Manager;
import tn.advyteam.service.GestionEmployeLocal;

@Stateful
@LocalBean
public class EmployeServiceImp implements GestionEmployeLocal{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int addManager(Manager manager) {
		em.persist(manager);
		return manager.getId();
	}

	@Override
	public Manager getManagerById(int id) {
		Manager manager = em.find(Manager.class, id);
		return manager;
	}


	@Override
	public List<Manager> getAllManager() {
		List<Manager> managers = em.createQuery("select m from Manager m", Manager.class).getResultList();
		return managers;
	}

	@Override
	public void updateManager(Manager manager, int id) {
		
		Manager managerToUp = getManagerById(id);
		
		managerToUp.setNom(manager.getNom());
		managerToUp.setPrenom(manager.getPrenom());
		
	}

	@Override
	public void deleteManagerById(int id) {
		Manager manager = em.find(Manager.class, id);
		em.remove(manager);
		
	}

	
	/**
	 * Developpeur
	 */
	
	@Override
	public int addDeveloper(Developpeur developpeur) {
		em.persist(developpeur);
		return developpeur.getId();
	}

	@Override
	public Developpeur getDeveloperById(int id) {
		Developpeur developpeur = em.find(Developpeur.class, id);
		return developpeur;
	}

	@Override
	public void deleteDeveloperById(int id) {
		em.remove(getDeveloperById(id));
	}

	@Override
	public List<Developpeur> getAllDevelopers() {
		List<Developpeur> developpeurs = em.createQuery("select d from Developpeur d", Developpeur.class).getResultList();
		return developpeurs;
	}

	@Override
	public void updateDeveloper(Developpeur developpeur, int id) {
		
		Developpeur developpeur2 = em.find(Developpeur.class, id);
		
		developpeur2.setNom(developpeur.getNom());
		developpeur2.setPrenom(developpeur.getPrenom());
		em.merge(developpeur2);
		
	}



}
