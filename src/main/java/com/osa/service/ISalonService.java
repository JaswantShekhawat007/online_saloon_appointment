package com.osa.service;

import java.util.List;

import com.osa.dto.SalonServiceDTO;
public interface ISalonService {
	SalonServiceDTO addService(SalonServiceDTO serviceDTO);
	SalonServiceDTO removeService(long id);
	SalonServiceDTO updateService(long id, SalonServiceDTO serviceDTO);
	SalonServiceDTO getService(long id);
	List<SalonServiceDTO> getAllServices();
	List<SalonServiceDTO> getServicesByName();
	List<SalonServiceDTO> getServicesByPrice();
	List<SalonServiceDTO> getServicesByDuration();
}