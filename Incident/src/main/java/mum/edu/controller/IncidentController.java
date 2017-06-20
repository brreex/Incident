package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import mum.edu.model.Incident;



@Controller
public class IncidentController {
	
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
		model.addAttribute("incident", new Incident());
		return "newincident";
	}
	
	@PostMapping("/incident")
	public String newIncidentPost(@ModelAttribute Incident incident){
		return "newincident";
	}
	
	@DeleteMapping("/incident/{id}")
	public String deleteIncident(@PathVariable int id){
		return "";
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
