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

import com.st.model.Customer;
import com.st.service.ICustomerService;

@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust) {
		Integer id=service.custSave(cust);
		ResponseEntity<String> resp=new ResponseEntity<String>(
			"Customer Saved with id :"+id,HttpStatus.OK	);
			return resp;	
	}
	
	@GetMapping("/all")
	public  ResponseEntity<?> getAllCust(){
		ResponseEntity<?> res=null;
		List<Customer> list=service.getAllCustomer();
		if(list!=null && !list.isEmpty()) {
			res=new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		}
		else {
			res=new ResponseEntity<String>("No Data Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOneCust(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		try {
			Customer cust= service.getOneCustomer(id);
			resp=new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> doUpdate(@RequestBody Customer cust){
		ResponseEntity<String> resp=null;
		try {
		Integer id=service.updateCustomer(cust);
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
		service.deleteCustomer(id);
		response=new ResponseEntity<String>("Customer Deleted with id"+id,HttpStatus.OK);
		}
		catch(Exception e) {
			response=new ResponseEntity<String>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		return response;
	}
}
