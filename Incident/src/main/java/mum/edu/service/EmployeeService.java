package mum.edu.service;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.dataaccess.IEmployeeDAO;
import mum.edu.model.Employee;

public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeDAO employeeDAO;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDAO.save(employee);
	}
}
