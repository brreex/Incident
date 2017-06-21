package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee,Integer> {
	
}
