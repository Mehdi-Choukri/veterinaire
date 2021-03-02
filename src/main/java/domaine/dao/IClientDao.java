package domaine.dao;

import java.util.List;

import domaine.model.Client;

public interface IClientDao {
	
	public void saveClient(Client client);
	public void updateClient(Client client);
	public Client getClientById(long id);
	public List<Client> getAllClients();
	public void deleteClient(long id);

}
