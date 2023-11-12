package com.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osa.model.Customer;
import com.osa.model.SalonService;



@Repository
public interface ISalonRepository extends JpaRepository<SalonService,String>{

}
