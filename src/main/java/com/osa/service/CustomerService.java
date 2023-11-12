package com.osa.service;

import java.util.List;

import com.osa.dto.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO addCustomer(CustomerDTO customerDTO);
	
	CustomerDTO removeCustomer(long custId);
	
	CustomerDTO updateCustomer(long custId, CustomerDTO customerDTO);
	
	CustomerDTO getCustomer(long custId);
	
	List<CustomerDTO> getAllCustomer();
	
}
