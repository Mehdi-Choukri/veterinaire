package domaine.dao;

import java.util.List;

import domaine.model.Question;

public interface IQuestionDao {
	

	public void saveQuestion(Question question);
	public void updateQuestion(Question question);
	public Question getQuestionById(long id);
	public List<Question> getAllQuestion();
	public void deleteQuestion(long id);

}
