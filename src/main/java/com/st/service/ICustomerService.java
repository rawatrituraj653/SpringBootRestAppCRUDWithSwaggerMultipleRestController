package com.st.service;

import java.util.List;

import com.st.model.Customer;

public interface ICustomerService {

	public Integer custSave(Customer customer);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(Integer id);
	public Customer getOneCustomer(Integer id);
	public Integer updateCustomer(Customer cust); 
	
}
