package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Departmet;

@Repository
public interface IDepartmentDAO extends JpaRepository<Departmet, Integer>{
	
}
