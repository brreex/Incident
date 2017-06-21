package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IDepartmentDAO;
import mum.edu.model.Department;

@Service
public class DepartmentService implements IDepartmentService{
	@Autowired
	IDepartmentDAO departmentDAO;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentDAO.save(department);
	}

	@Override
	public List<Department> findAll() {
		return departmentDAO.findAll();
	}

	@Override
	public Department findByName(String name) {
		return departmentDAO.findByName(name);
	}
	
}
