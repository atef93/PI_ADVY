package tn.managedBeans.timesheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
     
	private List<String> names = new ArrayList<String>();
     
    @PostConstruct
    public void init() {
    	names.add("todo");
    	names.add("doing");
    	names.add("termnié");
    }
    
    public DropdownView() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

    
    
    
}