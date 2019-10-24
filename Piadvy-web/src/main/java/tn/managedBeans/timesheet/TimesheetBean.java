package tn.managedBeans.timesheet;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class TimesheetBean {

	
	public void index() throws IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("footer.xhtml");
	}
}
