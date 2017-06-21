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
import mum.edu.model.Department;
import mum.edu.model.Employee;
import mum.edu.model.Role;
import mum.edu.model.User;
import mum.edu.service.IDepartmentService;
import mum.edu.service.IEmployeeService;
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
	@Autowired
	IEmployeeService employeeService;
	
	
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
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
		}
		
		Department department = departmentService.findByName(employee.getDepartment().getName());
		employee.setDepartment(department);
		Employee savedEmployee = employeeService.saveEmployee(employee);
		
		String username = savedEmployee.getUsername();
		String password = savedEmployee.getPassword();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(true);
		
		user.setId(savedEmployee.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEnabled());
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("USER"));
		
		user.setRoles(roles);
		user.setDepartment(department);
		
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
