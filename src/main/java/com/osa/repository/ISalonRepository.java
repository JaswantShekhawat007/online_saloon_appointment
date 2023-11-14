package com.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;

@Repository
public interface ISalonRepository extends JpaRepository<SalonService, Long> {
	
	@Query("select s.serviceName from SalonService s")
	List<SalonService> getServicesByName();
	
	@Query("select s.serviceName, servicePrice from SalonService s")
	List<SalonService> getServicesByPrice();
	
	@Query("select s.serviceName,s.serviceDuration from SalonService s")
	List<SalonService> getServicesByDuration();
	
}