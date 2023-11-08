package com.osa.service;

import com.osa.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(long custId);
	
}
