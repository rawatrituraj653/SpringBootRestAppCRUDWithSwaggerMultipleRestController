package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
