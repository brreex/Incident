package mum.edu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IIncidentDAO;
import mum.edu.model.Department;
import mum.edu.model.Incident;
import mum.edu.model.User;

@Service
public class IncidentService implements IIncidentService {

	@Autowired
	IIncidentDAO incidentDAO;
	@Autowired
	IDepartmentService departmetService;
	
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
	public void removeIncident(int id) {
		Incident incident = incidentDAO.findOne(id);
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

	@Override
	public List<Incident> getUserIncidnets(User user) {
		return incidentDAO.findByUser(user);
	}

	@Override
	public Incident save(Incident incident) {
		return incidentDAO.save(incident);
	}

	@Override
	public List<Incident> findByDepartment(Department department) {
		return incidentDAO.findByDepartment(department);
	}
}
