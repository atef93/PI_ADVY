package tn.advyteam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNote;
    @Column
	private int mark;
    @OneToOne
    private  AutoTest test ;
    
    
    
	public Note() {
		super();
	}
	public Note(int idNote, int mark, AutoTest test) {
		super();
		this.idNote = idNote;
		this.mark = mark;
		this.test = test;
	}
	public int getIdNote() {
		return idNote;
	}
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public AutoTest getTest() {
		return test;
	}
	public void setTest(AutoTest test) {
		this.test = test;
	}
  
    
      
}
