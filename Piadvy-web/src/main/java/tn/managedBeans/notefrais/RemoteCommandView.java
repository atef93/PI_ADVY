package tn.managedBeans.notefrais;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Session Bean implementation class RemoteCommandView
 */
@ManagedBean
public class RemoteCommandView {
	 public String getexecute() {
	     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Using RemoteCommand."));
	    return ""; }
    /**
     * Default constructor. 
     */
    public RemoteCommandView() {
        // TODO Auto-generated constructor stub
    }
   

}
