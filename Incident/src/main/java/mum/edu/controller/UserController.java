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

import mum.edu.dataaccess.IDepartmentDAO;
import mum.edu.dataaccess.IRoleDAO;
import mum.edu.model.Department;
import mum.edu.model.Employee;
import mum.edu.model.Role;
import mum.edu.model.User;
import mum.edu.service.IDepartmentService;
import mum.edu.service.IRoleService;
import mum.edu.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IDepartmentService departmentService;
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/users")
	public String getAllUsers(){
		return "users";
	}
	@GetMapping("/signup")
	public String signupGet(@ModelAttribute("employee") Employee employee,Model model){
		List<Role> roles = roleService.findAll();
		List<String> dep = new ArrayList<>();
		List<Department> departments = departmentService.findAll();
		
		dep.add("--Select Department--");
		for (Department department : departments) {
			dep.add(department.getName());
		}
		model.addAttribute("departments", dep);
		model.addAttribute("roles",roles);
		
		return "signup";
	}
	@PostMapping("/signup")
	public String signupPost(@ModelAttribute("employee") Employee employee ,BindingResult bindingResult){
		/*if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
			
		}
		user.setDepartment(new Department("IT", "224", "200"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("USER"));
		roles.add(new Role("ADMIN"));
		user.setRoles(roles);*/
		
		Department department = departmentService.findByName(employee.getDepartment().getName());
		employee.setDepartment(department);
		
		User user = new User(employee.getUsername(), employee.getPassword(), true);
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("USEER"));
		
		user.setRoles(roles);
		
		System.out.println("username "+employee.getUsername());
		System.out.println("password "+employee.getPassword());
		System.out.println(employee);
		
		userService.saveUser(user);
		userService.saveUser(user);
		
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
