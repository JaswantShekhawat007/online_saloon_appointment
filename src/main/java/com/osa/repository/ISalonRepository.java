package com.osa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;

@Repository
public interface ISalonRepository extends JpaRepository<SalonService, Long> {
	
	@Query("select s from SalonService s where s.serviceName = ?1")
	List<SalonService> getServicesByName(String serviceName);
	
	@Query("select s from SalonService s where s.servicePrice = ?1")
	List<SalonService> getServicesByPrice(String servicePrice);
	
	@Query("select s from SalonService s where s.serviceDuration = ?1")
	List<SalonService> getServicesByDuration(String serviceDuration);
	
}