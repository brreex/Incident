package mum.edu.dataaccess;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Incident;

@Repository
public interface IIncidentDAO extends JpaRepository<Incident, Integer> {

	Incident findByStatus(String status);

	Incident findByPriority(String priority);

	Incident findByCategory(String category);

	Incident findByCreatedDate(Date createDate);
}
