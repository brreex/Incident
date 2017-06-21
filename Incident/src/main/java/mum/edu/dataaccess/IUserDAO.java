package mum.edu.dataaccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.model.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer>{
	/*@Query(value="SELECT U FROM  USER U JOIN EMPLOYEE WHERE USERNAME = ?1",nativeQuery=true)*/
	@Query("select u from User u where u.username = :username")
	User findByUsername(@Param("username") String username); 
}
