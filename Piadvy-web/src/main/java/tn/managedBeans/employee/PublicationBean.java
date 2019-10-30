package tn.managedBeans.employee;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import tn.advyteam.entities.Commentairepub;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Publication;
import tn.advyteam.serviceImp.CommentaireEmpService;
import tn.advyteam.serviceImp.PublicationEmpService;

@ManagedBean(name="publicationBean")
@SessionScoped
public class PublicationBean implements Serializable 
{
	@ManagedProperty(value= "#{loginBean}" )
	LoginBean lb;
	
	Publication pub = new Publication();
	List<Publication> listPublications;
	
	List<PublicationCombean>listpublicationcom ;
	
	private Employee employee;
	
	public Publication getPub() {
		return pub;
	}


	public void setPub(Publication pub) {
		this.pub = pub;
	}

	@EJB
	PublicationEmpService publicationEmpService ;
	@EJB
	CommentaireEmpService commentaireEmpService;
	 
	public CommentaireEmpService getCommentaireEmpService() {
		return commentaireEmpService;
	}


	public void setCommentaireEmpService(CommentaireEmpService commentaireEmpService) {
		this.commentaireEmpService = commentaireEmpService;
	}
	
	

	@PostConstruct
	public void init() throws IOException
	{
	if (lb.getEmploye()==null)
		{FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
		}
	 	 this.listpublicationcom=listPubCom();
	 	 
	 	 
	}
	
	


	public LoginBean getLb() {
		return lb;
	}



	public void setLb(LoginBean lb) {
		this.lb = lb;
	}


	private String description;
	private Boolean isactif ;


	public void  ajouterpubEmployee() 
	{
		pub.setDescription(description);
		pub.setIsActif(isactif);
		pub.setDateCreation(new Date());
		pub.setEmployee(lb.getEmploye());
		publicationEmpService.addpub( pub);
		System.out.println("cbon nemchi");
		pub=new Publication();
		this.description="";
		 this.listpublicationcom=listPubCom();
		 }



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
 


		public List<Publication> getListPublications() {
			return listPublications;
		}


		public void setListPublications(List<Publication> listPublications) {
			this.listPublications = listPublications;
		}


		public Boolean getIsactif() {
			return isactif;
		}


		public void setIsactif(Boolean isactif) {
			this.isactif = isactif;
		}


		public List<PublicationCombean> getListpublicationcom() {
			return listpublicationcom;
		}


	 

		public void setListpublicationcom(List<PublicationCombean> listpublicationcom) {
			this.listpublicationcom = listpublicationcom;
		}


		public List<PublicationCombean> listPubCom() {
			listPublications = publicationEmpService.listpub();
			List<PublicationCombean> list = new ArrayList<>();
			for (Publication pub : listPublications) {
				list.add(new PublicationCombean(pub, new Commentairepub(pub)));
			}
			return list;
		}
		
		public void addComm(Commentairepub com) {
			System.out.println(com.getDescription()+"nnnnnnnnnnnnnnnn");
			
			
			com.setEmployee(lb.getEmploye());
			com.setDateCreation(new Date());
			this.commentaireEmpService.addcom(com);
			this.listpublicationcom=listPubCom();

		}
		
}
