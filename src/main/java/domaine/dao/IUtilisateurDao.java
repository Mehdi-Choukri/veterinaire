package domaine.dao;

import java.util.List;

import domaine.model.Utilisateur;

public interface IUtilisateurDao {

	public void saveUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public Utilisateur getUtilisateurById(long id);
	public List<Utilisateur> getAllUtilisateurs();
	public void deleteUtilisateur(long id);
}
