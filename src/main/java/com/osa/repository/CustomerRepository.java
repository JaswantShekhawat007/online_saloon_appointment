package com.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String>{

}
