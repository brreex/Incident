package mum.edu.service;

import org.springframework.stereotype.Service;

import mum.edu.model.Employee;
@Service
public interface IEmployeeService {
	public Employee saveEmployee(Employee employee);
}
