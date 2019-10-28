package tn.advyteam.serviceImp;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.bind.DatatypeConverter;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Publication;
import tn.advyteam.service.GestionEmployeLocal;
import tn.advyteam.service.GestionEmployeRemote;

@Stateless
@LocalBean
public class EmployeServiceImp implements GestionEmployeLocal, GestionEmployeRemote{
	
	@PersistenceContext
	EntityManager em;
	
	private String password;
	Employee employee ;
	Developpeur developpeur;
	List<Employee> listemp ;
	Publication publication ;


	
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
	
    
	public static String MD5(String password) 
	{
		  try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(password.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return password;
	}
		
	

	public void ajoutercontratemploye(Developpeur developpeur, Contrat contrat)  
	{
		developpeur.setContrat(contrat);
		developpeur.setPassword(EmployeServiceImp.MD5(developpeur.getPassword()));
		em.persist(developpeur);
	}

	
	public Developpeur getDeveloppeur()
	{
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) 
	{
		this.developpeur = developpeur;
	}

	public Employee getEmployebyEmailAndPassword(String email , String password )
	{
		
		TypedQuery<Employee> query = em.createQuery("Select e From Employee e where e.email=:m and e.password=:pwd",Employee.class);
		query.setParameter("m", email);
		query.setParameter("pwd", password);

		Employee employe = null ; 
			
		try {employe = query.getSingleResult();
					} 
		
		catch (Exception e){System.out.println("Errer:" + e ) ;}
		
		return employe;
	}

 
	
	
	
	
}
