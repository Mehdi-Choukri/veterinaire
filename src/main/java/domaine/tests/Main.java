package domaine.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import domaine.dao.QuestionDao;
import domaine.dao.ReponseDao;
import domaine.dao.UtilisateurDao;
import domaine.model.Question;
import domaine.model.Reponse;
import domaine.model.Utilisateur;
 

public class Main {

	public static void main(String[] args) throws ParseException {

	 QuestionDao qd = new QuestionDao();
	 ReponseDao rd = new ReponseDao();
	 
	 UtilisateurDao ud = new UtilisateurDao();
	 Utilisateur  u = new Utilisateur();
	 u = ud.getUtilisateurById(3);
	 
	 
	 String newDate = "2020-02-02";
	   
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    Date currentdate = new Date();
	    try {
			currentdate= sdf.parse(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   Question q = new Question ();
	   q = qd.getQuestionById(6);
	   
	   Reponse r = new Reponse("j'ai pas de solution desolé !",u,currentdate,q);
	   
	  List<Reponse> listReponse = rd.getAllReponseByIdQuestion(6);
	  
	  for (Reponse reponse : listReponse) {
		  System.out.println(reponse.getReponse());
		
	}
	   
	   
	  

}
}
