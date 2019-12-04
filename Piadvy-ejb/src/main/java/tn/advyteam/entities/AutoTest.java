package tn.advyteam.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class AutoTest implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTest;
	@Column
    public String TestName ;
	@Column
	private TypeTest TypeTest ;
	@Column
	private String StatusTest ;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date DateTest ;
	@Column
    private int score ;
    
    @OneToOne
    private Note note;
    @OneToMany(mappedBy="test")
    private  List<QuestionTest> question ;
    @OneToOne
    private AttestationTest attes;
    @ManyToOne
    private Employee emp;
    
    
    
	public AutoTest() {
		super();
	}




	



	public AutoTest(int idTest, String testName, tn.advyteam.entities.TypeTest typeTest, String statusTest,
			Date dateTest, int score, Note note, List<QuestionTest> question, AttestationTest attes, Employee emp) {
		super();
		this.idTest = idTest;
		TestName = testName;
		TypeTest = typeTest;
		StatusTest = statusTest;
		DateTest = dateTest;
		this.score = score;
		this.note = note;
		this.question = question;
		this.attes = attes;
		this.emp = emp;
	}








	public int getIdTest() {
		return idTest;
	}




	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}




	public String getTestName() {
		return TestName;
	}




	public void setTestName(String testName) {
		TestName = testName;
	}




	public TypeTest getTypeTest() {
		return TypeTest;
	}




	public void setTypeTest(TypeTest typeTest) {
		TypeTest = typeTest;
	}




	public String getStatusTest() {
		return StatusTest;
	}




	public void setStatusTest(String statusTest) {
		StatusTest = statusTest;
	}




	public Date getDateTest() {
		return DateTest;
	}




	public void setDateTest(Date dateTest) {
		DateTest = dateTest;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	public Note getNote() {
		return note;
	}




	public void setNote(Note note) {
		this.note = note;
	}









	public List<QuestionTest> getQuestion() {
		return question;
	}








	public void setQuestion(List<QuestionTest> question) {
		this.question = question;
	}








	public Employee getEmp() {
		return emp;
	}








	public void setEmp(Employee emp) {
		this.emp = emp;
	}








	public AttestationTest getAttes() {
		return attes;
	}




	public void setAttes(AttestationTest attes) {
		this.attes = attes;
	}



    
	
    
}
