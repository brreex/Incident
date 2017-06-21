package mum.edu.dataaccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Department;
import mum.edu.model.Incident;
import mum.edu.model.User;

@Repository
public interface IIncidentDAO extends JpaRepository<Incident, Integer> {

	Incident findByStatus(String status);

	Incident findByPriority(String priority);

	Incident findByCategory(String category);

	Incident findByCreatedDate(Date createDate);
	
	List<Incident> findByUser(User user);
	
	List<Incident> findByDepartment(Department department);
}
