package mum.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import mum.edu.model.Departmet;
import mum.edu.model.Role;
import mum.edu.model.User;
import mum.edu.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/users")
	public String getAllUsers(){
		return "users";
	}
	
	@GetMapping("/signup")
	public String signupGet(@ModelAttribute("user") User user,Model model){
		List<Role> roles = new ArrayList<>();
		Departmet departmet = new Departmet();
		roles.add(new Role("User"));
		roles.add(new Role("Admin"));
		model.addAttribute("department", departmet);
		model.addAttribute("roleList",roles);
		return "signup";
	}
	@PostMapping("/signup")
	public String signupPost(@ModelAttribute("user") User user ,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
			System.out.println(user.getRoles());
		}
		 
		user.setDepartment(new Departmet("IT", "224", "200"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("USER"));
		roles.add(new Role("ADMIN"));
		user.setRoles(roles);
		
		userService.saveUser(user);
		
		System.out.println(user);
		return "redirect:/signup";
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id){
		return "";
	}
	@PutMapping("/user/{id}")
	public String updateUser(@ModelAttribute User user){
		return "";
	}
	
	@GetMapping("/profile")
	public String profile(){
		return "profile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		//session.invalidate();
		return "home";
	}
	
}
