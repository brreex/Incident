package mum.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mum.edu.model.Department;
@Service
public interface IDepartmentService {
	public Department saveDepartment(Department department);
	public List<Department> findAll();
	public Department findByName(String name);
}
