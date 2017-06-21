package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Role;

@Repository
public interface IRoleDAO extends JpaRepository<Role, Integer>{
	
}
