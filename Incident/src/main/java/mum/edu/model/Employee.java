package mum.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private String firstname;

	private String lastname;

	private String position;

	private String phone;

	@Email
	private String email;

	@Transient
	private String username;
	@Transient
	private String password;
	
	
	@ManyToOne
	private Department department;

	public Employee() {
	}

	public Employee(String firstname, String lastname, String position, String phone, String email, String username,
			String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.position = position;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
