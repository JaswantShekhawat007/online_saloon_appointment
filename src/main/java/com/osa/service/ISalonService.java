package com.osa.service;

import java.util.List;

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;

public interface ISalonService {
	
	SalonServiceDTO addService(SalonServiceDTO serviceDTO);
	SalonServiceDTO removeService(long id);
	SalonServiceDTO updateService(long id, SalonServiceDTO serviceDTO);
	SalonServiceDTO getService(long id);
	List<SalonServiceDTO> getAllServices();
	List<SalonServiceDTO> getServicesByName(String name);
	List<SalonServiceDTO> getServicesByPrice(String price);
	List<SalonServiceDTO> getServicesByDuration(String duration);
}