package mum.edu.controller;

import static org.assertj.core.api.Assertions.in;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("incidentsolution")
	public String incidentsolution(ModelMap modelMap ,Model model){
		Incident incident = (Incident) modelMap.get("incident");
		Solution solution = (Solution) modelMap.get("solution");
		
		model.addAttribute("incident", incident);
		model.addAttribute("solution", solution);

		return "incidentsolution";
	}
	
	@GetMapping("/solution/solution/{id}")
	public String getIncidentSolution(@PathVariable int id,RedirectAttributes redirectAttributes){
		Incident incident = incidentService.findById(id);
		Solution solution = solutionService.findByIncidentId(id);
		redirectAttributes.addAttribute("solution", solution);
		redirectAttributes.addAttribute("incident", incident);
		return "redirect:/incidentsolution";
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





