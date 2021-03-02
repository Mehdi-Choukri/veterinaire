package domaine.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "reponse")

public class Reponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	
	private long id;
	@Column(name = "reponse")
	private String reponse;

	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur user;

	@ManyToOne(cascade=CascadeType.ALL)
	private Question question;
	@Column(name = "date")
	private Date date;
	
	public Reponse( String reponse,Utilisateur user, Date date, Question question) {
 
		this.reponse = reponse;
		this.user = user;
		this.date = date;
		this.question = question;
	}
	public Reponse()
	{
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
