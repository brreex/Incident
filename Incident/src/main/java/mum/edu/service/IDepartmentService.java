package mum.edu.service;

import java.util.List;

import mum.edu.model.Department;

public interface IDepartmentService {
	public Department saveDepartment(Department department);
	public List<Department> findAll();
	public Department findByName(String name);
}
