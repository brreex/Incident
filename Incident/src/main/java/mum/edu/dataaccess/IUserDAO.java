package mum.edu.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.model.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	User getByFirstname(String firstName);
}
