package tn.managedBeans.employee;

import java.io.IOException;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.model.UploadedFile;

import tn.advyteam.entities.Contrat;
import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.entities.Etatcivil;
import tn.advyteam.entities.Manager;
import tn.advyteam.entities.TypeContrat;
import tn.advyteam.serviceImp.EmployeServiceImp;


@ManagedBean
@SessionScoped
public class EmployeBean implements Serializable{
	
	@EJB
	EmployeServiceImp employeServiceImp ;
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String sexe;
	private Boolean isActif;
	private String password;
	private Date datenaissance;
	private Etatcivil etatcivil ;
	private List<Employee> listemploye ;
	private Employee employe ;
	private Developpeur developpeur;
	private String login ;
	private  Boolean loggeIn;
	private String  role ;
	private UploadedFile file;
	private String encodedString="";
	private String description;
	private int codedeconfirmaationmail ;

	//contrat
	private int reference;
	private Date datedebut;
	private Date datefin;
	private Float salaire;
	private TypeContrat typeContrat;
	
	
	
	
	  @ManagedProperty(value="#{loginBean}" )
	  LoginBean lb;
	 
	
	
/*
	public void AjouterEmploye() 
	{
		employeServiceImp.addemploye(new Developpeur(nom, prenom));
	
	}
	*/

	public Employee getEmploye() {
		return employe;
	}



	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	@PostConstruct
	public void init() 
	{
		getEmployes();
		
		
	}
	

	
	public String doLogin()
	{
		String navigateto = "null"; 
		employe=employeServiceImp.getEmployebyEmailAndPassword(login,employeServiceImp.MD5(password));
		if (employe != null  && employe.getIsActif()== true )
		{ navigateto= "/views/employeeviews/Profile?faces-redirect=true"; loggeIn = true ;}
		else {FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials or  you are not actif"));}
		return navigateto;					
	}
	
	public String doLogout() 
	{String navigateto = "null"; 
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		{ navigateto = "/views/employeeviews/Login?face-redirect=true";}
		return navigateto;
	}
	
	
	public String Ajutemp()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/AjouterEmployee?face-redirect=true";
		
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public EmployeServiceImp getEmployeServiceImp() {
		return employeServiceImp;
	}

	public void setEmployeServiceImp(EmployeServiceImp employeServiceImp) {
		this.employeServiceImp = employeServiceImp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public Etatcivil getEtatcivil() {
		return etatcivil;
	}

	public void setEtatcivil(Etatcivil etatcivil) {
		this.etatcivil = etatcivil;
	}


	public List<Employee> getEmployes()
	{
		listemploye = employeServiceImp.emps();
		System.out.println(listemploye.size());
		return listemploye; 
	}

	public List<Employee> getListemploye() {
		return listemploye;
	}

	public void setListemploye(List<Employee> listemploye) {
		this.listemploye = listemploye;
	}
	
	
	
	
	public void supprimer(int id)
	{
		employeServiceImp.delete(id);
		getEmployes();
		
	}
	
	public void AjouterContrat() 
	{
		employeServiceImp.addContrat(new Contrat(datedebut, datefin, salaire, typeContrat));
	
	}
	public String upload() {
		if (file != null) {


		}
		System.out.println(encodedString);
	 return	encodedString;
	
		} 

		

	

	public void AjouterContratemp() 
	{
		
		
		String	pass =  password ;
		String  eml = 	email ;
			
		
		byte[] fileContent = file.getContents();
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		System.out.println(encodedString);
		
		final String username = "porjet2019@gmail.com";
		final String password = "duwhjaxubkjxebih";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("porjet2019@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(eml));
			System.out.println(eml + "dsssssssssssssss");
			message.setSubject("Le password ");
			System.out.println("Voici votre  Login: "  + eml +" votre  password : "+ pass );
			message.setText("Voici votre  Email  : " + eml +" Voici votre  password  : " + pass);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			System.out.println("ERE");
		}
		

		
	employeServiceImp.ajoutercontratemploye(new Developpeur(nom, prenom, adresse, email, sexe, isActif, this.password, datenaissance, etatcivil, role, encodedString) ,new Contrat(datedebut, datefin, salaire, typeContrat));
	getEmployes();
	System.out.println(encodedString);
	}
	

	public void AjouterContratmana() 
	{
		
		
		String	pass =  password ;
		String  eml = 	email ;
			
		
		byte[] fileContent = file.getContents();
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		System.out.println(encodedString);
		
		final String username = "porjet2019@gmail.com";
		final String password = "duwhjaxubkjxebih";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("porjet2019@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(eml));
			System.out.println(eml + "dsssssssssssssss");
			message.setSubject("Le password ");
			System.out.println("Voici votre  Login: "  + eml +" votre  password : "+ pass );
			message.setText("Voici votre  Email  : " + eml +" Voici votre  password  : " + pass);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			System.out.println("ERE");
		}
		

		
	employeServiceImp.ajoutercontratmanager(new Manager(nom, prenom, adresse, email, sexe, isActif, this.password, datenaissance, etatcivil, role, encodedString),new Contrat(datedebut, datefin, salaire, typeContrat));
	getEmployes();
	System.out.println(encodedString);
	}
	

	
	public int getReference() {
		return reference;
	}



	public void setReference(int reference) {
		this.reference = reference;
	}



	public Date getDatedebut() {
		return datedebut;
	}



	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}



	public Date getDatefin() {
		return datefin;
	}



	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}



	public Float getSalaire() {
		return salaire;
	}



	public void setSalaire(Float salaire) {
		this.salaire = salaire;
	}



	public TypeContrat getTypeContrat() {
		return typeContrat;
	}



	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}



	public Developpeur getDeveloppeur() {
		return developpeur;
	}



	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public Boolean getLoggeIn() {
		return loggeIn;
	}



	public void setLoggeIn(Boolean loggeIn) {
		this.loggeIn = loggeIn;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public UploadedFile getFile() {
		return file;
	}



	public void setFile(UploadedFile file) {
		this.file = file;
	}



	public String getEncodedString() {
		return encodedString;
	}



	public void setEncodedString(String encodedString) {
		this.encodedString = encodedString;
	}
	

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LoginBean getLb() {
		return lb;
	}



	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
	
	
	  public void updatepassworddevloppeur() throws IOException 
	  {
		  if (lb.getCodeconection() == codedeconfirmaationmail) 
		  {
		  lb.getEmploye().setPassword(password);
		  lb.getEmploye().setFerstlogin(true);
		  employeServiceImp.updatepass(lb.getEmploye());
			  {FacesContext.getCurrentInstance().getExternalContext().redirect("Profile.xhtml");}
		  }else {{FacesContext.getCurrentInstance().getExternalContext().redirect("Changepass.xhtml");}}
		  }
	 

	public int getCodedeconfirmaationmail() {
		return codedeconfirmaationmail;
	}



	public void setCodedeconfirmaationmail(int codedeconfirmaationmail) {
		this.codedeconfirmaationmail = codedeconfirmaationmail;
	}
	 
	
	
			
}
