package com.st.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.st.model.Employee;
import com.st.repo.EmployeeRepository;
import com.st.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	@Transactional
	public Integer empSave(Employee employee) {
		Employee emp=repo.save(employee);
		return emp.getEid();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		List<Employee> list=repo.findAll();
		list.stream().sorted((e1,e2)->e1.getEname().compareTo(e2.getEname()));
		if(list!=null && !list.isEmpty()) {
		return list;
	}
	return null;
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch(Exception e) {
			throw new RuntimeException(e.toString()+"No Data Found/ Id not Found");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			
			return opt.get();
		}
	return null;

	}

	@Override
	@Transactional
	public Integer updateEmployee(Employee employee) {
		Integer id;
		if(repo.existsById(employee.getEid())) {
		 id=repo.save(employee).getEid();
		 return id;
		}
		else
			throw new RuntimeException("This Employee details Not Found");
	}

}
