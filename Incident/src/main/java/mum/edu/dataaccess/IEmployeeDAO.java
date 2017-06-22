package mum.edu.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.Department;
import mum.edu.model.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee,Integer> {

	Employee findByfirstname(String firstname);

	Employee findBylastname(String lastname);

	Employee findByEmail(String email);

	List<Employee> findByDepartment(Department department);
}
