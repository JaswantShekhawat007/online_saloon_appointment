package com.osa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;
import com.osa.repository.ISalonRepository;

public class ISalonServiceImpl implements ISalonService{
	
	private ISalonRepository salonRepository;
	
	@Autowired
	public void setSalonRepository(ISalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}

	@Override
	public SalonServiceDTO addService(SalonServiceDTO serviceDTO) {
		SalonService service = new SalonService();
		BeanUtils.copyProperties(serviceDTO, service);
		salonRepository.save(service);
		return serviceDTO;
			
	}
	
	@Override
	public SalonServiceDTO removeService(long id) {
		SalonServiceDTO serviceDTO = getService(id);
		SalonService service = new SalonService();
		BeanUtils.copyProperties(serviceDTO, service);
		salonRepository.delete(service);
		return serviceDTO;
	}

	@Override
	public SalonServiceDTO updateService(long id, SalonServiceDTO serviceDTO) {
		SalonService service= new SalonService();
		BeanUtils.copyProperties(serviceDTO, service);
		salonRepository.save(service);
		return serviceDTO;
	}
	
	@Override
	public SalonServiceDTO getService(long id) {
		SalonServiceDTO serviceDTO = new SalonServiceDTO();
		SalonService service = salonRepository.findById(String.valueOf(id)).get();
		BeanUtils.copyProperties(service, serviceDTO);
		//return salonRepository.findById(String.valueOf(id)).get();
		return serviceDTO;
	} 
	
	@Override
	public List<SalonServiceDTO> getAllServices() {
		List<SalonService> services = salonRepository.findAll();
		List<SalonServiceDTO> serviceDTOs = new ArrayList<SalonServiceDTO>();
		for(SalonService service : services) {
			SalonServiceDTO serviceDTO = new SalonServiceDTO();
			BeanUtils.copyProperties(service, serviceDTO);
			serviceDTOs.add(serviceDTO);
		}
		return serviceDTOs;
	}
	
	@Override
	public List<SalonServiceDTO> getServicesByName() {
		return null;
		// TODO Auto-generated method stub
		//return salonRepository.find();
	}

	@Override
	public List<SalonServiceDTO> getServicesByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalonServiceDTO> getServicesByDuration() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
