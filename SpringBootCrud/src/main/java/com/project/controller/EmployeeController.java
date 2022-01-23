package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.Employee;
import com.project.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService ;
//listOfEmployees
	@GetMapping("/")
	public String viewPage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmpolyees());
		return "index";
	}
	
	@GetMapping ("/showNewEmployeeForm")
	public String showNewEmployeeForm (Model model){
		//create model attribute to build form data
		Employee employee =new Employee ();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee( @ModelAttribute ("employee") Employee employee){
	//save Employee to Data Base	
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	//
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model)	{
	//get Employee from the service 
		Employee employee =  employeeService.getEmployeeById(id);
		//set employee as a model attribute to pre-populate th form
		model.addAttribute("employee",employee);
		return "update_employee";	
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee (@PathVariable ( value = "id") long id) {
		//call delete employee
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
