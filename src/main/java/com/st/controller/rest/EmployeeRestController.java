package com.st.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.model.Employee;
import com.st.service.IEmployeeService;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Employee employee) {
		Integer id=service.empSave(employee);
		ResponseEntity<String> resp=new ResponseEntity<String>(
			"Employee Saved with id :"+id,HttpStatus.OK	);
			return resp;	
	}
	
	@GetMapping("/all")
	public  ResponseEntity<?> getAllEmp(){
		ResponseEntity<?> res=null;
		List<Employee> list=service.getAllEmployee();
		if(list!=null && !list.isEmpty()) {
			res=new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}
		else {
			res=new ResponseEntity<String>("No Data Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOneEmp(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		try {
			Employee employee= service.getOneEmployee(id);
			resp=new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> doUpdate(@RequestBody Employee emp){
		ResponseEntity<String> resp=null;
		try {
		Integer id=service.updateEmployee(emp);
		resp=new ResponseEntity<String>(
			"Updated with id :"+id,HttpStatus.OK	
				);
		}catch (Exception e) {
			resp=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCust(@PathVariable Integer id){
		ResponseEntity<String> response=null;
		try {
		service.deleteEmployee(id);
		response=new ResponseEntity<String>("Employee Deleted with id"+id,HttpStatus.OK);
		}
		catch(Exception e) {
			response=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
}


