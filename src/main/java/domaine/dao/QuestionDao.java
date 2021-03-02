package domaine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domaine.model.Question;
import domaine.util.HibernateUtil;

public class QuestionDao implements IQuestionDao{

	@Override
	public void saveQuestion(Question question) {
		 
		 Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession())
			{
				transaction = session.beginTransaction();
				session.save(question);
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
	public void updateQuestion(Question question) {

		 Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession())
			{
				transaction = session.beginTransaction();
				session.saveOrUpdate(question);
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
		
	}

	@Override
	public Question getQuestionById(long id) {
		 Transaction transaction = null;
		 Question question = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			question = session.get(Question.class, id);
			
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
		return question;
	}

	@Override
	public List<Question> getAllQuestion() {
		 Transaction transaction = null;
		 List<Question> questions = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			questions = session.createQuery("from Question",Question.class).list();
			
			transaction.commit();
		}
		catch(Exception e)
		{
			System.out.println(questions.size());
			if(transaction != null)
			{
				transaction.rollback();
				e.printStackTrace();
			}
			
		}
		return questions;
	}

	@Override
	public void deleteQuestion(long id) {

		 Transaction transaction = null;
		 Question question = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			
			 question = session.get(Question.class, id);
			 
			 session.delete(question);
			
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
		
	}

}
