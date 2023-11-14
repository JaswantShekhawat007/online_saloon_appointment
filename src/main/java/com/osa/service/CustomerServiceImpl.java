package com.osa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.CustomerDTO;
import com.osa.exception.CustomerNotFoundException;
import com.osa.model.Customer;
import com.osa.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customerRepository.save(customer);
		return customerDTO;
	}

	@Override
	public CustomerDTO removeCustomer(String custId) {
		CustomerDTO customerDTO = getCustomer(custId);
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customerRepository.delete(customer);
		return customerDTO;
	}

	@Override
	public CustomerDTO updateCustomer(String custId, CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(custId)
				.orElseThrow(()->new CustomerNotFoundException("Employee With ID :"+custId+" Not Exist!"));
		
		customer.setName(customerDTO.getName());
		customer.setContactNo(customerDTO.getContactNo());
		customer.setDob(customerDTO.getDob());
		customer.setEmail(customerDTO.getEmail());
		customer.setAddress(customerDTO.getAddress());
				
		customerRepository.save(customer);
		return customerDTO;
	}

	@Override
	public CustomerDTO getCustomer(String custId) {
		CustomerDTO customerDTO = new CustomerDTO() ;
		Customer customer = customerRepository.findById(custId)
				.orElseThrow(()->new CustomerNotFoundException("Employee With ID :"+custId+" Not Exist!"));
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
		
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		for (Customer customer : customers) {
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO);
			customerDTOs.add(customerDTO);
		}
		return customerDTOs;
	}

	

}
