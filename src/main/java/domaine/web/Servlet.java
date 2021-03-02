package domaine.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domaine.dao.ClientDao;
import domaine.dao.QuestionDao;
import domaine.dao.RDVDao;
import domaine.dao.ReponseDao;
import domaine.dao.UtilisateurDao;
import domaine.model.Client;
import domaine.model.Question;
import domaine.model.RDV;
import domaine.model.Reponse;
import domaine.model.Utilisateur;
import domaine.security.AES;
import domaine.security.Token;
import domaine.service.MailConfirmation;
import domaine.service.MailSender;
import domaine.service.SUtilisateur;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur userLogged;
 
    
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String path = request.getServletPath();
		 
		 if(path.equals("/Index.org"))
		 { 
			 request.getRequestDispatcher("index.jsp").forward(request, response);
			 

		 }
		 else if(path.equals("/*.org"))
		 {
			 
			 request.getRequestDispatcher("index.jsp").forward(request, response);

			 
		 }
		 else if(path.equals("/saveUtilisateur.org") && request.getMethod().equals("POST"))
		 {
			 String nom = request.getParameter("nom");
			 String prenom = request.getParameter("prenom");
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 String cpassword =request.getParameter("cpassword");
			 
			 //service utilisateur email checker
			 SUtilisateur SU = new SUtilisateur();
			 if(password.equals(cpassword))
			 {
				 System.out.println("password match");
				 if(!SU.checkEmailUtilisateur(email))
				 {
					 System.out.println("email is ok to use");
					 Token T = new Token();
					 AES cryp = new AES();
					 String salt = T.generate();
					 String hashedPassword = AES.encrypt(password, salt);
					 Utilisateur u1 = new Utilisateur(nom, prenom, email, hashedPassword, salt, 0);
					 
					 UtilisateurDao UD = new UtilisateurDao();
					 UD.saveUtilisateur(u1);
					  /*
					 ClientDao CD = new ClientDao();
					 
						final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSX";
						final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
						Date aujourdhui = new Date();
						java.util.Date utilDate =null;
						try {
							utilDate = sdf.parse("2021-02-23 05:39:49.916+03");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  
						Client c = new Client(1, utilDate);
						
						CD.saveClient(c);
						 */
					 	String title = "Succes";
					 	String msgGeneral = "Création faite avec succée ";
						String msgLink = "Cliquer sur ce lien pour retourner a la page Login";
						String targetLink = "Login.jsp";
						String alertType = "alert alert-success";
						messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
						request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
					  
				 }
				 else
				 {
					 	String title = "Erreur Utilisateur";
						String msgGeneral = "Email existe déja";
						String msgLink = "Cliquer sur ce lien pour retourner a la page d'inscription ";
						String targetLink = "Register.jsp";
						String alertType = "alert alert-danger";
						messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
						request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				 }
				
			 }
			 else
			 {
				 System.out.println("password not match");
			 }
			 
		 }
		 else if(path.equals("/Register.org"))
		 {
			 
			 request.getRequestDispatcher("Register.jsp").forward(request, response);

			 
		 }
		 else if(path.equals("/Login.org"))
		 {
			 
			 request.getRequestDispatcher("Login.jsp").forward(request, response);

			 
		 }
		 else if(path.equals("/loginUtilisateur.org"))
		 {
			 
			 SUtilisateur SU = new SUtilisateur();
			 String email = request.getParameter("email");
			 String password = request.getParameter("password");
			 Utilisateur user = SU.login(email, password);
			 setUserLogged(user);
			 if(getUserLogged() != null)
			 {
				 //test sur tous les niv de droit pour voir la page adequate 
					 userLogged.setId(userLogged.getId());
					 userLogged.setNivDroit(userLogged.getNivDroit());
					request.setAttribute("Utilisateur", userLogged);
					request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			 }
			 else
				{
				 	String title = "Erreur Utilisateur";
					String msgGeneral = "Email ou mot de passe incorrect";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-danger";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				}
		 

			 
		 }
		 else if( path.equals("/Reservation.org"))
		 {
			 if(userLogged != null && userLogged.getNivDroit()==0)
			 {
				  request.setAttribute("Utilisateur", userLogged);
				  request.getRequestDispatcher("Reservation.jsp").forward(request, response);
			 }
			 else if(userLogged != null && userLogged.getNivDroit()==1)
			 {
				   RDVDao rdv = new RDVDao();
				   List<RDV> listRdv = rdv.getAllRDVS();
				   request.setAttribute("RDV", listRdv);
 
				  request.getRequestDispatcher("ReservationSec.jsp").forward(request, response);
			 }
			 else
			 {
				 	String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
			 }
			
		 }
		 else if(path.equals("/ReservationRDV.org"))
		 {
			 if(userLogged != null && userLogged.getNivDroit()==0)
			 {
				 String email = request.getParameter("email");
				 String dateRDV = request.getParameter("date");
				  String newDate = dateRDV.substring(0, 10);
						   
				    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				    Date currentdate = new Date();
				    try {
						currentdate= sdf.parse(newDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
			 
				 
				 
			 
				 long idClient = userLogged.getId();
				 
				 RDV rdv = new RDV(idClient,currentdate,false,false);
				 RDVDao rdvDao = new RDVDao();
				 rdvDao.saveRDV(rdv);
				 Boolean test = MailSender.sendMail("Brief.Veterinaire@gmail.com","thisbriefisgood108",email,rdv.getId(),userLogged.getNom()+ " "+userLogged.getPrenom(),currentdate.toString());
				 if(test)
				 {
					 System.out.println("mail sent in servlet");
				 }

			 
				 
				 
				 
			 }
			 else
			 {
				 	String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
			 }
		 }
		 else if (path.equals("/ConfirmRDV.org"))
		 {
			 int  idRdv = Integer.parseInt(request.getParameter("idRDV"));
			 System.out.println(idRdv);
			 RDV rdvToUpdate = new RDV();
			 RDVDao rdvDao = new RDVDao();
			 
			 rdvToUpdate = rdvDao.getRDVById(idRdv);
			 rdvToUpdate.setValidation(true);
			 rdvDao.updateRDV(rdvToUpdate);
			 
			 
			 request.getRequestDispatcher("ConfirmRDV.jsp").forward(request, response);
			 
		 }
		 else if (path.equals("/accepterRDV.org"))
		 {
			 // l'update du rdv
			 int  idRdv = Integer.parseInt(request.getParameter("idRDV"));
			 RDV rdvToUpdate = new RDV();
			 RDVDao rdvDao = new RDVDao();
			 rdvToUpdate = rdvDao.getRDVById(idRdv);
			 rdvToUpdate.setEtat(true);
			 rdvDao.updateRDV(rdvToUpdate);
			 // l'envoi du message de l'acceptation dans la boite email 
			 long idUser = rdvToUpdate.getIdClient();
			 UtilisateurDao ud = new UtilisateurDao();
			 Utilisateur userToSendMail = new Utilisateur();
			 userToSendMail = ud.getUtilisateurById(idUser);
			MailConfirmation mc = new MailConfirmation();
			//l'appel de la fonctoin d'envoie 
			Boolean mailSent = mc.sendMail("Brief.Veterinaire@gmail.com","thisbriefisgood108",userToSendMail.getMail(),rdvToUpdate.getId(),userToSendMail.getNom()+ " "+userToSendMail.getPrenom(),rdvToUpdate.getDateRDV().toString());
			
			if(mailSent)
			{
				System.out.println("mail sent for the confirmation");
			}
			response.sendRedirect("Reservation.org");
			 
			 
		 }
		 else if(path.equals("/annulerRDV.org"))
		 {
			 int  idRdv = Integer.parseInt(request.getParameter("idRDV"));
			 RDV rdvToUpdate = new RDV();
			 RDVDao rdvDao = new RDVDao();
			 rdvToUpdate = rdvDao.getRDVById(idRdv);
			 rdvToUpdate.setEtat(false);
			 rdvDao.updateRDV(rdvToUpdate);
			 response.sendRedirect("Reservation.org");
		 }
		 //l'annulation via email 
		 else if(path.equals("/annulerRDVParClient.org"))
		 {
			 int  idRdv = Integer.parseInt(request.getParameter("idRDV"));
			 RDV rdvToUpdate = new RDV();
			 RDVDao rdvDao = new RDVDao();
			 rdvToUpdate = rdvDao.getRDVById(idRdv);
			 rdvToUpdate.setValidation(false);
			 rdvDao.updateRDV(rdvToUpdate);
			 
			 	String title = "Succes";
			 	String msgGeneral = "Rendez-vous annuler avec succés";
				String msgLink = "Cliquer sur ce lien pour retourner a la page Home";
				String targetLink = "index.jsp";
				String alertType = "alert alert-success";
				messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
				request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
			 
		 }
		 else if (path.equals("/Forum.org"))
		 {
			 if(userLogged != null )
			 {
				  request.setAttribute("Utilisateur", userLogged);
				  QuestionDao qd = new QuestionDao();
				  List<Question> listQuestions = qd.getAllQuestion();
				  request.setAttribute("listQuestions", listQuestions);
				   
					  
					
				 
				  
				  request.getRequestDispatcher("Forum.jsp").forward(request, response);
			 }
			 else
			 {
					String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				 
			 }
			
		 }
		 else if(path.equals("/Reponse.org"))
		 {
			 if(userLogged != null )
			 {
				 int  idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
				  request.setAttribute("UtilisateurVisiteur", userLogged);
				  QuestionDao qd = new QuestionDao();
				  UtilisateurDao ud = new UtilisateurDao();
				   Question  question = qd.getQuestionById(idQuestion);
				   
				   Utilisateur poseurQuestion = question.getUser();
				   request.setAttribute("Question", question);
				   request.setAttribute("UtilisateurposeurQuestion", poseurQuestion);
				   ReponseDao rd = new ReponseDao();
				   List<Reponse> listReponse = rd.getAllReponseByIdQuestion(idQuestion);
				   List listUtilisateur = new ArrayList();
				   
				   for (Reponse reponse : listReponse) {
					   Utilisateur usertoFind = new Utilisateur();
					   usertoFind = reponse.getUser();
					   listUtilisateur.add(usertoFind);
					    
					
				}
				   
				   request.setAttribute("listUtilisateur", listUtilisateur);
						   
				  request.setAttribute("listReponse", listReponse);
				   
				 
				 
				  
				  request.getRequestDispatcher("Reponse.jsp").forward(request, response);
			 }
			 else
			 {
					String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				 
			 }
			 
		 }
		 else if(path.equals("/PoserReponse.org"))
		 {
			 if(userLogged != null )
			 {
				 int  idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
				 Date date = new Date();
				 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 QuestionDao qd = new QuestionDao();
				  Question q = new Question ();
				   q = qd.getQuestionById(idQuestion);
				 
				 String reponse = request.getParameter("reponseUtilisateur");
				 Reponse r = new Reponse(reponse,userLogged,date,q);
				 ReponseDao rd = new ReponseDao();
				 rd.saveReponse(r);
				 
				 request.getRequestDispatcher("Reponse.org?idQuestion="+idQuestion).forward(request, response);
			 }
			 else
			 {
					String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				 
			 }
			 
		 }
		 else if(path.equals("/Logout.org"))
		 {
			 userLogged = null;
			 request.getRequestDispatcher("index.jsp").forward(request, response);
			 
		 }
		 else if(path.equals("/PoserQuestion.org"))
		 {
			 if(userLogged != null )
			 {
				 QuestionDao qd = new QuestionDao();
				 String question = request.getParameter("questionUtilisateur");
				 String categorie = request.getParameter("categorie");
				 Date date = new Date();
				 Question ques = new Question(question, userLogged, date, categorie);
				 
				  
				 
				 
				 
				qd.saveQuestion(ques);
				request.getRequestDispatcher("Forum.org").forward(request, response);
			 }
			 else
			 {
					String title = "Erreur Utilisateur";
					String msgGeneral = "Vous devrier vous connecter entant que client pour acceder a ce service";
					String msgLink = "Cliquer sur ce lien pour retourner a la page de login";
					String targetLink = "Login.jsp";
					String alertType = "alert alert-warning";
					messageAfterAction(request,title,msgGeneral ,targetLink,msgLink,alertType);
					request.getRequestDispatcher("MsgProvider.jsp").forward(request, response);
				 
			 }
		 }
		 
		 /*
		 else
		 {
			 response.sendError(response.SC_NOT_FOUND);
		 }
		 */
		 
	}
	public void messageAfterAction(HttpServletRequest requestm,String title,String msgGeneral ,String targetLink,String msgLink, String alertType)
	{
		requestm.setAttribute("title", title);
		requestm.setAttribute("msgGeneral", msgGeneral);
		requestm.setAttribute("targetLink", targetLink);
		requestm.setAttribute("msgLink", msgLink);
		requestm.setAttribute("alertType", alertType);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}
	public Utilisateur getUserLogged() {
		return userLogged;
	}
	public void setUserLogged(Utilisateur userLogged) {
		this.userLogged = userLogged;
	}
	 

}
