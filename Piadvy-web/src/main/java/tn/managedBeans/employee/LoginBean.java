package tn.managedBeans.employee;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
		if (employe != null  && employe.getIsActif()== true )
		{ 
			System.out.println(this.employe);
		//	navigateto= "/views/employeeviews/Profile?faces-redirect=true"; loggeIn = true ;
			navigateto= "/views/employeeviews/NewFile?faces-redirect=true"; loggeIn = true ;
			
		}
		else {FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad credentials or  you are not actif"));}
		return navigateto;					
	}
	
	
}
