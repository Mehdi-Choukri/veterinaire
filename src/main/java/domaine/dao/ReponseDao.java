package domaine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import domaine.model.Question;
import domaine.model.Reponse;
import domaine.util.HibernateUtil;

public class ReponseDao implements IReponseDao{

	@Override
	public void saveReponse(Reponse reponse) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(reponse);
			transaction.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			if(transaction != null)
			{
				transaction.rollback();
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void updateReponse(Reponse reponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reponse getReponseById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reponse> getAllReponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReponse(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reponse> getAllReponseByIdQuestion(int idQuestion) {
		
		 Transaction transaction = null;
		 List<Reponse> reponses = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			String hql = "from Reponse where question_id =:idQuestion";
			Query query = session.createQuery(hql,Reponse.class);
			query.setParameter("idQuestion",idQuestion);
			reponses = query.list();
			
			transaction.commit();
		}
		catch(Exception e)
		{
			 
			if(transaction != null)
			{
				transaction.rollback();
				e.printStackTrace();
			}
			
		}
		return reponses;
	}

}
