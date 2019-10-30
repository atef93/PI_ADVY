package tn.advyteam.serviceImp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.advyteam.entities.Commentairepub;
 

/**
 * Session Bean implementation class CommentaireEmpService
 */
@Stateless
@LocalBean
public class CommentaireEmpService {


	@PersistenceContext
	EntityManager em;
	
	
    public CommentaireEmpService() {
        // TODO Auto-generated constructor stub

    }
    
    public void addcom(Commentairepub c)
    {
    	
    	this.em.persist(c);
    }

}
