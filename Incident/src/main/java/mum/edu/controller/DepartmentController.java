package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class DepartmentController {
	
	@GetMapping("/departments")
	public String departments(){
		return "departments";
	}
	
	@GetMapping("/department/{id}")
	public String getDepartment(){
		return "department";
	}
	
	@PostMapping("/department")
	public String addDepartment(){
		return "redirect:/department";
	}

	@DeleteMapping("/department/{id}")
	public String deleteDepartment(@PathVariable int id){
		return "redirect:/departments";
	}

	@PutMapping("/department/{id}")
	public String updateDepartment(){
		return "redirect:/departments";
	}
}
