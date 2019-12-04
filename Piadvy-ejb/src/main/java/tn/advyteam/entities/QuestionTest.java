package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuestionTest implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idQuestion;
	@Column
	private String question1 ;
	@Column
	private String Rep1 ;
	@Column
	private String Rep2 ;
	@Column
	private String Rep3 ;
	@Column
	private String Rep4 ;
	@Column
	private String ReponseCorrect ;
    @ManyToOne
	private AutoTest test ;
    
    
    
	public QuestionTest() {
		super();
	}



	public QuestionTest(int idQuestion, String question1, String rep1, String rep2, String rep3, String rep4,
			String reponseCorrect, AutoTest testId) {
		super();
		this.idQuestion = idQuestion;
		this.question1 = question1;
		Rep1 = rep1;
		Rep2 = rep2;
		Rep3 = rep3;
		Rep4 = rep4;
		ReponseCorrect = reponseCorrect;
		test = testId;
	}



	public int getIdQuestion() {
		return idQuestion;
	}



	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}



	public String getQuestion1() {
		return question1;
	}



	public void setQuestion1(String question1) {
		this.question1 = question1;
	}



	public String getRep1() {
		return Rep1;
	}



	public void setRep1(String rep1) {
		Rep1 = rep1;
	}



	public String getRep2() {
		return Rep2;
	}



	public void setRep2(String rep2) {
		Rep2 = rep2;
	}



	public String getRep3() {
		return Rep3;
	}



	public void setRep3(String rep3) {
		Rep3 = rep3;
	}



	public String getRep4() {
		return Rep4;
	}



	public void setRep4(String rep4) {
		Rep4 = rep4;
	}



	public String getReponseCorrect() {
		return ReponseCorrect;
	}



	public void setReponseCorrect(String reponseCorrect) {
		ReponseCorrect = reponseCorrect;
	}



	public AutoTest getTest() {
		return test;
	}



	public void setTest(AutoTest test) {
		this.test = test;
	}



	

	

}
