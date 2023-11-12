package com.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osa.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
