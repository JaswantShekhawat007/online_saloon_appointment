package com.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osa.model.SalonService;

@Repository
public interface ISalonRepository extends JpaRepository<SalonService,String>{
	
	@Query("select s.serviceName from SalonService s")
	List<SalonService> getServicesByName();
	
	@Query("select s.servicePrice from SalonService s")
	List<SalonService> getServicesByPrice();
	
	@Query("select s.serviceDuration from SalonService s")
	List<SalonService> getServicesByDuration();
	
}