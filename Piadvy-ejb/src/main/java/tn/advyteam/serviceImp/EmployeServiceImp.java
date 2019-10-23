package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.service.GestionEmployeLocal;
import tn.advyteam.service.GestionEmployeRemote;


@Stateless
@LocalBean
public class EmployeServiceImp implements GestionEmployeLocal, GestionEmployeRemote{
	
	@PersistenceContext
	EntityManager em;
	
	Employee employee ;
	Developpeur developpeur;
	List<Employee> listemp ;


	
    public void addemploye (Developpeur developpeur) 
    {
    	em.persist(developpeur);
    }
    
    public void addemploye (Employee developpeur) 
    {
    	em.persist(developpeur);
    }
    
    public List<Employee> emps()
    {
    	TypedQuery<Employee> query = em.createQuery("Select e From Employee e",Employee.class);
    	try {listemp = query.getResultList();} 
		catch (Exception e){System.out.println("Errer:" + e ) ;}
    	return listemp ;
    }
    
    public Employee find (int id ) 
    {
		return em.find(Employee.class,id);   	
    }
    
    public void  delete (int id )
   
    {
            Employee e = find(id);
            e.setIsActif(false);
    	  	em.merge(e); 
     }
    
    

    public void addContrat (Contrat contrat) 
    {
    	em.persist(contrat);
    }
    
    

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getListemp() {
		return listemp;
	}

	public void setListemp(List<Employee> listemp) {
		this.listemp = listemp;
	}
    

	public void ajoutercontratemploye(Developpeur developpeur, Contrat contrat) 
	{
		developpeur.setContrat(contrat);
		em.persist(developpeur);
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	
	
}
