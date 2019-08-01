package com.st.service;

import java.util.List;

import com.st.model.Employee;

public interface IEmployeeService {

	public Integer empSave(Employee employee);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(Integer id);
	public Employee getOneEmployee(Integer id);
	public Integer updateEmployee(Employee employee); 
}
