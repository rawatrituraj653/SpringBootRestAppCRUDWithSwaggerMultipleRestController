package com.st.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.model.Customer;
import com.st.repo.CustomerRepository;
import com.st.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Override
	@Transactional
	public Integer custSave(Customer customer) {
		Customer cust=repo.save(customer);
		
		return cust.getCid();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomer() {
		List<Customer> list=repo.findAll();
		list.stream().sorted((c1,c2)->c1.getCustName().compareTo(c1.getCustName()));
		if(list!=null && !list.isEmpty()) {
		return list;
	}
	return null;
	}
	
	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
	try {
		repo.deleteById(id);
	}
	catch(Exception e) {
		throw new RuntimeException(e.toString()+"No Data Found/ Id not Found");
	}
	}

	@Override
	@Transactional(readOnly = true)
	public Customer getOneCustomer(Integer id) {
		Optional<Customer> opt=repo.findById(id);
			if(opt.isPresent()) {
				
				return opt.get();
			}
		return null;
	}

	@Override
	@Transactional
	public Integer updateCustomer(Customer cust) {
		Integer id;
		if(repo.existsById(cust.getCid())) {
		 id=repo.save(cust).getCid();
		 return id;
		}
		else
			throw new RuntimeException("This Customer details Not Found");
	}

	
}
