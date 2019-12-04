package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "timeshcom")
public class CommentTimesheet extends Commentaire implements Serializable {


	
	
	@ManyToOne
	private Timesheet timesheet;

	public CommentTimesheet() {
		super();
	}
	
	
	public CommentTimesheet(Timesheet timesheet) {
		super();
		this.timesheet = timesheet;
	}


	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	
	
	
}
