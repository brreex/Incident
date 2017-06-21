package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IRoleDAO;
import mum.edu.model.Role;

@Service
public class RoleService implements IRoleService {
	@Autowired
	IRoleDAO roleDAO;
	
	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}
}
