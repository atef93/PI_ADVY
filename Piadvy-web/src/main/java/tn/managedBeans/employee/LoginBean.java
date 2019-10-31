package tn.managedBeans.employee;

import java.io.Serializable;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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

import tn.advyteam.entities.Developpeur;
import tn.advyteam.entities.Employee;
import tn.advyteam.serviceImp.EmployeServiceImp;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	@EJB
	EmployeServiceImp employeServiceImp ;
	private Employee employe ;
	private String login ;
	private  Boolean loggeIn;
	private String password;
	private Boolean isActif;
	private String email;
	private Boolean isrh;
	

	
	
	
	
	public EmployeServiceImp getEmployeServiceImp() {
		return employeServiceImp;
	}



	public void setEmployeServiceImp(EmployeServiceImp employeServiceImp) {
		this.employeServiceImp = employeServiceImp;
	}



	public Employee getEmploye() {
		return employe;
	}



	public void setEmploye(Employee employe) {
		this.employe = employe;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Boolean getIsActif() {
		return isActif;
	}



	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String doLogin()
	{
		String navigateto = "null"; 
		employe=employeServiceImp.getEmployebyEmailAndPassword(login,employeServiceImp.MD5(password));
		if (employe != null  && employe.getIsActif()== true && employe.getFerstlogin()==true )
		{ isrh =	employe instanceof Developpeur;
			navigateto= "/views/employeeviews/Profile?faces-redirect=true"; loggeIn = true ;}
		else if(employe != null  && employe.getIsActif() == true && employe.getFerstlogin() == false)
		{
			 isrh =	employe instanceof Developpeur;
			
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
					InternetAddress.parse(employe.getEmail()));
				message.setSubject("Le Code  de  confirmation  pour  le  changement du votre  mod de passe ");
				System.out.println("saddsdsada"+employe.getEmail());
				System.out.println("adasdadadsdsdasdsaddddd"+Codeconection);
				message.setText("Voici votre  Email  : " + employe.getEmail() +" Voici votre  password  : " + Codeconection);
				Transport.send(message);
				System.out.println("Done");
			} catch (MessagingException e) {
				System.out.println("ERE");
			}
		  
			navigateto= "/views/employeeviews/Changepass?faces-redirect=true"; loggeIn = true 

			
			;}
		else {FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials or  you are not actif"));}
		return navigateto;					
	}

	
	
	public Boolean getIsrh() {
		return isrh;
	}



	public void setIsrh(Boolean isrh) {
		this.isrh = isrh;
	}
	
	
	public int passran()
	{
			Random r = new Random();
	        int n = r.nextInt(10000);
	        System.out.println(n); 
		
		return  n;
	}

	private int Codeconection ;
	
	@PostConstruct
	public void init() 
	{
		Codeconection = passran();
	
		
	}



	public int getCodeconection() {
		return Codeconection;
	}



	public void setCodeconection(int codeconection) {
		Codeconection = codeconection;
	}
	
	
	
}
