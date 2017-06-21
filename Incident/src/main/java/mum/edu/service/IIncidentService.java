package mum.edu.service;

import java.util.Date;
import java.util.List;

import mum.edu.model.Incident;

public interface IIncidentService {
	public Incident saveIncident(Incident user);
	public List<Incident> getAllIncident();
	public Incident findById(int id);
	public void removeIncident(Incident user);
	public Incident updateIncident(Incident incident);
	public Incident findByStatus(String status);
	public Incident findByPriority(String priority);
	public Incident findByCategory(String category);
	public Incident findByCreatedDate(Date createDate);
}
