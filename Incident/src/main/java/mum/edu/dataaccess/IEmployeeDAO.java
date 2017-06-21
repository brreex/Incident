package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.edu.model.Employee;

public interface IEmployeeDAO extends JpaRepository<Employee,Integer> {
	
}
