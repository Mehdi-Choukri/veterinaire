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
@Table (name = "question")

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "question")
	private String question;
	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur user;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "categorie")
	private String  categorie;
	
	public Question( String question,Utilisateur user, Date date, String categorie) {
	 
		 
		this.question = question;
		this.user = user;
		this.date = date;
		this.categorie = categorie;
	}
	public Question()
	{
		
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public 	Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", user=" + user + ", date=" + date + ", categorie="
				+ categorie + "]";
	}
	
	

}
