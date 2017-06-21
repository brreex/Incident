package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Department;

@Repository
public interface IDepartmentDAO extends JpaRepository<Department, Integer>{
	public Department findByName(String name);
}
