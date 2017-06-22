package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mum.edu.model.Department;
import mum.edu.model.Incident;
import mum.edu.model.User;
import mum.edu.service.IDepartmentService;
import mum.edu.service.IIncidentService;
import mum.edu.service.IUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IncidentController {

	@Autowired
	IUserService userService;
	@Autowired
	IIncidentService incidentService;
	@Autowired
	IDepartmentService departmentService;

	@GetMapping("/incidents")
	public String allIncidnets(Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.findByUsername(loggedInUser.getName());
		List<Incident> incidents = incidentService.findByDepartment(currentUser.getDepartment());
		model.addAttribute("incidents", incidents);

		return "incidents";
	}

	@GetMapping("/myincidents")
	public String myIncidents(Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.findByUsername(loggedInUser.getName());
		List<Incident> incidents = incidentService.getUserIncidnets(currentUser);
		
		model.addAttribute("incidents", incidents);
		return "myincidents";
	}

	@GetMapping("/incident")
	public String newIncidentGet(@ModelAttribute("incident") Incident incident, Model model) {

		List<String> priorityList = new ArrayList<>();
		priorityList.add("--Select Priority--");
		priorityList.add("Low");
		priorityList.add("Mediuim");
		priorityList.add("High");

		List<String> dep = new ArrayList<>();
		List<Department> departments = departmentService.findAll();

		dep.add("--Select Department--");
		for (Department department : departments) {
			dep.add(department.getName());
		}

		List<String> categories = new ArrayList<>();
		categories.add("--Select Category--");
		categories.add("DataBase");
		categories.add("Network");
		categories.add("System");
		categories.add("Developement");

		model.addAttribute("incident", new Incident());
		model.addAttribute("priorityList", priorityList);
		model.addAttribute("categories", categories);
		model.addAttribute("departments", dep);

		return "newincident";
	}

	@PostMapping(value = "/incident")
	public String newIncidentPost(@ModelAttribute Incident incident, BindingResult bindingResult) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.findByUsername(loggedInUser.getName());
		
		Department department = departmentService.findByName(incident.getDepartment().getName());

		incident.setUser(currentUser);
		incident.setStatus("New");
		incident.setCreatedDate(new Date());
		incident.setUpdatedDate(new Date());
		incident.setDepartment(department);

		incidentService.save(incident);
		
		return "redirect:/incident";
	}

	@GetMapping("/incident/{id}")
	public String editIncident(@PathVariable int id,Model model,ModelMap map) {
		
		List<String> dep = new ArrayList<>();
		List<Department> departments = departmentService.findAll();

		dep.add("--Select Department--");
		for (Department department : departments) {
			dep.add(department.getName());
		}
		
		List<String> priorityList = new ArrayList<>();
		priorityList.add("--Select Priority--");
		priorityList.add("Low");
		priorityList.add("Mediuim");
		priorityList.add("High");
		
		List<String> categories = new ArrayList<>();
		categories.add("--Select Category--");
		categories.add("DataBase");
		categories.add("Network");
		categories.add("System");
		categories.add("Developement");
		
		if(map.containsAttribute("incident"))
			model.addAttribute("incident", map);
		else
			model.addAttribute("incident", incidentService.findById(id));
		model.addAttribute("departments", dep);
		model.addAttribute("priorityList", priorityList);
		model.addAttribute("categories", categories);
		
		return "incident";
	}

	@DeleteMapping("/incident/{id}")
	public String deleteIncident(@PathVariable int id) {
		//incidentService.removeIncident(id);
		return "redirect:/myincidents";
	}

	@PostMapping("/incident/incident/{id}")
	public String updateIncident(@ModelAttribute Incident incident, @PathVariable int id,RedirectAttributes redirectAttributes) {
		incident.setDepartment(departmentService.findByName(incident.getDepartment().getName()));
		incident.setUpdatedDate(new Date());
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.findByUsername(loggedInUser.getName());
		incident.setUser(currentUser);
		incident.setStatus("In-Progress");
		Incident SavedIncident = incidentService.save(incident);
		
		redirectAttributes.addAttribute("incident", SavedIncident);
		return "redirect:/incident/"+id;
	}
	@GetMapping(value="/search",params={"searchText"})
	public String search (@RequestParam String searchText){
		System.out.println(searchText);
		return "search";
	}
}
