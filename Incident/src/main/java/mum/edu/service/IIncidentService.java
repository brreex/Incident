package mum.edu.service;

import java.util.Date;
import java.util.List;

import mum.edu.model.Department;
import mum.edu.model.Incident;
import mum.edu.model.User;

public interface IIncidentService {
	public Incident saveIncident(Incident user);
	public List<Incident> getAllIncident();
	List<Incident> getUserIncidnets(User user);
	public Incident findById(int id);
	public void removeIncident(int id);
	public List<Incident> findByDescriptionLike(String description);
	public Incident updateIncident(Incident incident);
	public Incident findByStatus(String status);
	public Incident findByPriority(String priority);
	public Incident findByCategory(String category);
	public Incident findByCreatedDate(Date createDate);
	public Incident save(Incident incident);
	public List<Incident> findByDepartment(Department department);
}
