package tn.advyteam.serviceImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Publication;

/**
 * Session Bean implementation class PublicationEmpService
 */
@Stateless
@LocalBean
public class PublicationEmpService {

	@PersistenceContext
	EntityManager em;
	List<Publication>publist;

	
    /**
     * Default constructor. 
     */
    public PublicationEmpService() {
        // TODO Auto-generated constructor stub
    }
    public void  addpub(Publication publication) 
	{
		 
		em.persist(publication);
	
	}
    
    public List<Publication> listpub()
    {
    	TypedQuery<Publication> query = em.createQuery("Select p From Publication p",Publication.class);
    	publist = query.getResultList();
    	return publist;
    	
    }
    
}