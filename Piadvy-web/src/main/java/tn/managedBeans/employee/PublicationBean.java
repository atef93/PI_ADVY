package tn.managedBeans.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Publication;
import tn.advyteam.serviceImp.PublicationEmpService;

@ManagedBean(name="publicationBean")
@SessionScoped
public class PublicationBean implements Serializable 
{
	@ManagedProperty(value= "#{loginBean}" )
	LoginBean lb;
	
	Publication pub = new Publication();
	List<Publication> listPublications;
	
	private Employee employee;
	
	public Publication getPub() {
		return pub;
	}


	public void setPub(Publication pub) {
		this.pub = pub;
	}

	@EJB
	PublicationEmpService publicationEmpService ;
	
	 
	public void init()
	{
		lpub().size();
	}
	


	public LoginBean getLb() {
		return lb;
	}



	public void setLb(LoginBean lb) {
		this.lb = lb;
	}


	private String description;


	public void  ajouterpubEmployee() 
	{
		pub.setDescription(description);
		 
		pub.setDateCreation(new Date());
		pub.setEmployee(lb.getEmploye());
		publicationEmpService.addpub( pub);
		System.out.println("cbon nemchi");
		pub=new Publication();
		this.description="";
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
		public List<Publication> lpub()
		{
			
			listPublications = publicationEmpService.listpub();
	System.out.println(listPublications.size());
	return listPublications;
		
		}


		public List<Publication> getListPublications() {
			return listPublications;
		}


		public void setListPublications(List<Publication> listPublications) {
			this.listPublications = listPublications;
		}

		
		
}
