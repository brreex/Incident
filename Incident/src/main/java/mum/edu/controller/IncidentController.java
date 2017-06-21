package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mum.edu.dataaccess.IDepartmentDAO;
import mum.edu.dataaccess.IIncidentDAO;
import mum.edu.dataaccess.IUserDAO;
import mum.edu.model.Department;
import mum.edu.model.Incident;
import mum.edu.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class IncidentController {
	
	@Autowired
	IUserDAO userDAO;
	@Autowired
	IIncidentDAO incidentDAO;
	@Autowired
	IDepartmentDAO departmentDAO;
	
	
	@GetMapping("/incidents")
	public String allIncidnets(){
		return "incidents";
	}
	
	@GetMapping("/myincidents")
	public String myIncidents(){
		return "myincidents";
	}
	
	@GetMapping("/incident")
	public String newIncidentGet(@ModelAttribute("incident") Incident incident,Model model){
		
		List<String> priorityList = new ArrayList<>();
		priorityList.add("--Select Priority--");
		priorityList.add("Low");
		priorityList.add("Mediuim");
		priorityList.add("High");
		
		List<String> dep = new ArrayList<>();
		List<Department> departments = departmentDAO.findAll();
		
		dep.add("--Select Department--");
		for (Department department : departments) {
			dep.add(department.getName());
		}
		
		List<String> categories = new ArrayList<>();
		categories.add("--Select Category--");
		categories.add("DataBase");
		categories.add("Network");
		categories.add("System");
		
		model.addAttribute("incident", new Incident());
		model.addAttribute("priorityList", priorityList);
		model.addAttribute("categories", categories);
		model.addAttribute("departments", dep);
		
		return "newincident";
	}
	
	@PostMapping(value="/incident"/*,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE*/)
	public String newIncidentPost(@ModelAttribute Incident incident,BindingResult bindingResult/*,Incident incident*/){
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		
		User currentUser = userDAO.findByUsername(loggedInUser.getName());
		Department department = departmentDAO.findByName(incident.getDepartment().getName());
		
		incident.setUser(currentUser);
		incident.setStatus("New");
		incident.setCreatedDate(new Date());
		incident.setUpdatedDate(new Date());
		incident.setDepartment(department);
		
		incidentDAO.save(incident);
		
		System.out.println(incident);
		
		return "redirect:/incident";
	}
	
	@DeleteMapping("/incident/{id}")
	public String deleteIncident(@PathVariable int id){
		return "incident";
	}
	
	/*@PutMapping("/incident/{id}")
	public String updateIncident(@ModelAttribute Incident incident,@PathVariable int id){
		return "";
	}
	
	@PostMapping("/incident/{id}")
	public String resolveIncident(@PathVariable int id){
		return "";
	}*/
	
}
