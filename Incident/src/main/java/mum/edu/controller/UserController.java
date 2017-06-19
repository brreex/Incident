package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import mum.edu.model.User;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginget(){
		return "login";
	}
	
	@PostMapping(value="/")
	public String loginpost(@ModelAttribute User user){
		return "redirect:/home";
	}
	@GetMapping("/signup")
	public String signupget(){
		return "signup";
	}
	@PostMapping("/signup")
	public String signuppost(){
		return "redirect:/signup";
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id){
		return "";
	}
	@PutMapping("/user/{id}")
	public String update(@ModelAttribute User user){
		return "";
	}
}
