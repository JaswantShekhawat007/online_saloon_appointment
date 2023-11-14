package com.osa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.osa.dto.CustomerDTO;
import com.osa.model.Customer;
import com.osa.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceUnitTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private CustomerDTO sampleCustomerDTO;
    private Customer sampleCustomer;

    @BeforeEach
    public void setUp() {
        // Initialize sample CustomerDTO and Customer for testing
        sampleCustomerDTO = new CustomerDTO();
        sampleCustomerDTO.setUserId("1");
        sampleCustomerDTO.setName("John Doe");
        sampleCustomerDTO.setContactNo("1234567890");
        sampleCustomerDTO.setEmail("john@example.com");
        sampleCustomerDTO.setDob(LocalDate.of(1985, 7, 15));
//        sampleCustomerDTO.setAddress("123 Street, City");

        sampleCustomer = new Customer();
        BeanUtils.copyProperties(sampleCustomerDTO, sampleCustomer);
    }

    @Test
    public void testAddCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(sampleCustomer);

        CustomerDTO result = customerService.addCustomer(sampleCustomerDTO);

        assertNotNull(result);
        assertEquals(sampleCustomerDTO.getUserId(), result.getUserId());
        assertEquals(sampleCustomerDTO.getName(), result.getName());
        // Add more assertions for other properties
    }

    @Test
    public void testRemoveCustomer() {
        when(customerRepository.findById("1")).thenReturn(Optional.of(sampleCustomer));

        CustomerDTO result = customerService.removeCustomer("1");

        assertNotNull(result);
        assertEquals(sampleCustomerDTO.getUserId(), result.getUserId());
        assertEquals(sampleCustomerDTO.getName(), result.getName());
        // Add more assertions for other properties
    }

    @Test
    public void testUpdateCustomer() {
        when(customerRepository.findById("1")).thenReturn(Optional.of(sampleCustomer));

        CustomerDTO updatedCustomerDTO = new CustomerDTO();
        updatedCustomerDTO.setUserId("1");
        updatedCustomerDTO.setName("Jane Smith");
        updatedCustomerDTO.setContactNo("9876543210");
        // Set other properties as needed

        CustomerDTO result = customerService.updateCustomer("1", updatedCustomerDTO);

        assertNotNull(result);
        assertEquals(updatedCustomerDTO.getUserId(), result.getUserId());
        assertEquals(updatedCustomerDTO.getName(), result.getName());
        // Add more assertions for other properties
    }

    @Test
    public void testGetCustomer() {
        when(customerRepository.findById("1")).thenReturn(Optional.of(sampleCustomer));

        CustomerDTO result = customerService.getCustomer("1");

        assertNotNull(result);
        assertEquals(sampleCustomerDTO.getUserId(), result.getUserId());
        assertEquals(sampleCustomerDTO.getName(), result.getName());
        // Add more assertions for other properties
    }

    @Test
    public void testGetAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers.add(sampleCustomer);

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> result = customerService.getAllCustomer();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(sampleCustomerDTO.getUserId(), result.get(0).getUserId());
        assertEquals(sampleCustomerDTO.getName(), result.get(0).getName());
        // Add more assertions for other properties
    }
}
