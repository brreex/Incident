package mum.edu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

@Entity
@SecondaryTable(name="UserInfo")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull @Column(table="UserInfo")
	private String firstname;
	@NotNull @Column(table="UserInfo")
	private String lastname;
	@NotNull @Column(table="UserInfo")
	private String position;
	@NotNull @Column(table="UserInfo")
	private String phone;
	
	@NotNull @Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private boolean enabled;
	
	@ManyToOne
	private Departmet department;
	@ManyToMany
	private List<Role> roles;
	
	public User(){
		
	}

	public User(String firstname, String lastname, String position, String phone, String email, String password,
			boolean enabled) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.position = position;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Departmet getDepartment() {
		return department;
	}

	public void setDepartment(Departmet department) {
		this.department = department;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
