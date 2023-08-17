package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Employee;
import com.project.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeRepository employeeRepositroy;

	@Override
	public List<Employee> getAllEmpolyees() {
		return employeeRepositroy.findAll();
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepositroy.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepositroy.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}
		else { throw new RuntimeException("employee not found for id ::"+id);
	}
	return employee;

	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepositroy.deleteById(id);
		
	}

}
