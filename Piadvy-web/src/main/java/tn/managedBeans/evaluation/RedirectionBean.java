package tn.managedBeans.evaluation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.advyteam.entities.EvaluationFile;

/**
 * Session Bean implementation class RedirectionBean
 */
@ManagedBean
@ApplicationScoped
public class RedirectionBean {

	public static EvaluationFile F;
    /**
     * Default constructor. 
     */
  
	public  EvaluationFile getF() {
		return F;
	}
	public  void setF(EvaluationFile f) {
		F = f;
	}

}
