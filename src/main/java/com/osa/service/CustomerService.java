package com.osa.service;

import java.util.List;

import com.osa.dto.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO addCustomer(CustomerDTO customerDTO);
	
	CustomerDTO removeCustomer(String custId);
	
	CustomerDTO updateCustomer(String custId, CustomerDTO customerDTO);
	
	CustomerDTO getCustomer(String custId);
	
	List<CustomerDTO> getAllCustomer();
	
}
