package mum.edu.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String description;
	private String priority;
	private String status;
	private String category;
	private String possibleCause;
	private String suggestion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedDate;
	@ManyToOne
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;

	public Incident() {
	}


	public Incident(String description, String priority, String status, String category, String possibleCause,
			String suggestion, Date createdDate, Date updatedDate) {
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.category = category;
		this.possibleCause = possibleCause;
		this.suggestion = suggestion;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPossibleCause() {
		return possibleCause;
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setPossibleCause(String possibleCause) {
		this.possibleCause = possibleCause;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ ", category=" + category + ", possibleCause=" + possibleCause + ", suggestion=" + suggestion
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", user=" + user + ", departmet="
				+ department + "]";
	}

}
