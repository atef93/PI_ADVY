package tn.managedBeans.employee;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.advyteam.entities.Etatcivil;
@ManagedBean(name ="data")
@ApplicationScoped
public class Data {
	

	
	public Etatcivil[] getEtatcivils()
	{
		return Etatcivil.values();
	}
	
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
