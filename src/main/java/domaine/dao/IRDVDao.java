package domaine.dao;

import java.util.List;

import domaine.model.RDV;

public interface IRDVDao {
	public void saveRDV(RDV rdv);
	public void updateRDV(RDV rdv);
	public RDV getRDVById(long id);
	public List<RDV> getAllRDVS();
	public void deleteRDV(long id);

}
