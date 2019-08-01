package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
