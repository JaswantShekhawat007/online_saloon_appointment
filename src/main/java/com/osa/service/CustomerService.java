package com.osa.service;

import java.util.List;

import com.osa.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(long custId);
	
	Customer updateCustomer(long custId, Customer customer);
	
	Customer getCustomer(long custId);
	
	List<Customer> getAllCustomer();
	
}
