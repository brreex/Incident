package mum.edu.service;

import java.util.List;

import mum.edu.model.User;

public interface IUserService {
	public User saveUser(User user);
	public List<User> getAllUsers();
	User findByUsername(String username);
	public User findById(int id);
	public void removeUser(User user) ;
}
