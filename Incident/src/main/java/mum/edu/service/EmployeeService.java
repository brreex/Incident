package mum.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IEmployeeDAO;
import mum.edu.model.Employee;
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeDAO employeeDAO;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDAO.save(employee);
	}
}
