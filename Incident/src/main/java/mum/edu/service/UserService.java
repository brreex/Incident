package mum.edu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.dataaccess.IRoleDAO;
import mum.edu.dataaccess.IUserDAO;
import mum.edu.model.Role;
import mum.edu.model.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	IRoleDAO roleDAO;
	
	@Override
	public User saveUser(User user) {
		User savedUser = userDAO.save(user);
		List<Role> roles = user.getRoles();
		for(Role role:roles){
			role.setUser(savedUser);
			roleDAO.save(role);
		}
		return savedUser;
	}
	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}
	@Override
	public User findById(int id) {
		return userDAO.findOne(id);
	}
	@Override
	public void removeUser(User user) {
		userDAO.delete(user.getId());
	}
	@Override
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
}
