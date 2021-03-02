package domaine.dao;

import java.util.List;

 
import domaine.model.Reponse;

public interface IReponseDao {
	
	
	public void saveReponse(Reponse reponse);
	public void updateReponse(Reponse reponse);
	public Reponse getReponseById(long id);
	public List<Reponse> getAllReponse();
	public void deleteReponse(long id);
	public List<Reponse> getAllReponseByIdQuestion(int idQuestion);
}
