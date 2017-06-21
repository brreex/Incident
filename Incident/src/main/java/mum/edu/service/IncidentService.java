package mum.edu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IIncidentDAO;
import mum.edu.model.Incident;

@Service
public class IncidentService implements IIncidentService {

	@Autowired
	IIncidentDAO incidentDAO;

	@Override
	public Incident saveIncident(Incident incident) {
		return incidentDAO.save(incident);
	}

	@Override
	public List<Incident> getAllIncident() {
		return incidentDAO.findAll();
	}

	@Override
	public Incident findById(int id) {
		return incidentDAO.findOne(id);
	}

	@Override
	public void removeIncident(Incident incident) {
		incidentDAO.delete(incident);
	}

	@Override
	public Incident updateIncident(Incident incident) {
		return incidentDAO.save(incident);
	}

	@Override
	public Incident findByStatus(String status) {
		return incidentDAO.findByStatus(status);
	}

	@Override
	public Incident findByPriority(String priority) {
		return incidentDAO.findByPriority(priority);
	}

	@Override
	public Incident findByCategory(String category) {
		return incidentDAO.findByCategory(category);
	}

	@Override
	public Incident findByCreatedDate(Date createDate) {
		return incidentDAO.findByCreatedDate(createDate);
	}
}
