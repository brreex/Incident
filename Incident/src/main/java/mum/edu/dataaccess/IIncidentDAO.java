package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Incident;

@Repository
public interface IIncidentDAO extends JpaRepository<Incident, Integer>{
	
}
