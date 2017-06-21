package mum.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String costCenter;
	@NotNull
	private String parentConstCenter;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	@OneToMany
	private List<Incident> incidents;

	 
	public Department(){}
	
	public Department(String name, String costCenter, String parentConstCenter) {
		this.name = name;
		this.costCenter = costCenter;
		this.parentConstCenter = parentConstCenter;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getParentConstCenter() {
		return parentConstCenter;
	}

	public void setParentConstCenter(String parentConstCenter) {
		this.parentConstCenter = parentConstCenter;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}

	@Override
	public String toString() {
		return "Departmet [id=" + id + ", name=" + name + ", costCenter=" + costCenter + ", parentConstCenter="
				+ parentConstCenter + ", employees=" + employees + ", incidents=" + incidents + "]";
	}
	
}
