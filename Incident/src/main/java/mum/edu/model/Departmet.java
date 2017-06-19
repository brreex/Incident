package mum.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Departmet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String costCenter;
	@NotNull
	private String parentConstCenter;
	
	@OneToMany
	private List<User> users;
	
	@OneToMany
	private List<Incident> incidents;
	
}
