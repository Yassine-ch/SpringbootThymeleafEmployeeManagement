package com.project.service;

import java.util.List;


import com.project.model.Employee;

public interface EmployeeService {
List<Employee> getAllEmpolyees();
void saveEmployee(Employee employee );
Employee getEmployeeById(long id);
void deleteEmployeeById(long id);
}
