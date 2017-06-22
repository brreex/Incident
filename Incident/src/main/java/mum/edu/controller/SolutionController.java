package mum.edu.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.edu.model.Incident;
import mum.edu.model.Solution;
import mum.edu.model.User;
import mum.edu.service.IIncidentService;
import mum.edu.service.ISolutionService;
import mum.edu.service.IUserService;

@Controller
@SessionAttributes(value={"id"})
public class SolutionController {
	@Autowired
	IIncidentService incidentService;
	@Autowired
	IUserService userService;
	@Autowired
	ISolutionService solutionService;
	
	@GetMapping("/solution/{id}")
	public String resolveGet(@PathVariable int id,Model model){
		model.addAttribute("solution", new Solution());
		model.addAttribute("id", id);
		return "solution";
	}
	
	@GetMapping("/solution/solution/{id}")
	public String getIncidentSolution(@PathVariable int id,Model model){
		Incident incident = incidentService.findById(id);
		Solution solution = solutionService.findByIncident(incident);
		System.out.println("solution"+solution);
		System.out.println("incident "+incident);
		model.addAttribute("solution", solution);
		model.addAttribute("incident", incident);
		return "incidentsolution";
	}
	
	@PostMapping("/solution/{id}")
	public String resolvePost(@ModelAttribute Solution solution,HttpSession session){
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userService.findByUsername(loggedInUser.getName());
		Incident incident = incidentService.findById((int) session.getAttribute("id"));
		
		System.out.println("incident "+incident);
		
		Solution newSolution = new Solution(solution.getDescription(), new Date(), new Date());
		
		newSolution.setUser(currentUser);
		newSolution.setCreatedDate(new Date());
		newSolution.setUpdatedDate(new Date());
		newSolution.setIncident(incident);
		
		incident.setStatus("Solved");
		
		Solution savedSolution = solutionService.saveSolution(newSolution);
		
		System.out.println("id is : "+session.getAttribute("id"));
		System.out.println("soultion  "+savedSolution);
		
		return "redirect:/incidents";
	}
}





