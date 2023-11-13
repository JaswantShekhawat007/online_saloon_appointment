package com.osa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.SalonServiceDTO;
import com.osa.model.SalonService;
import com.osa.repository.ISalonRepository;

@Service
public class ISalonServiceImpl implements ISalonService{

	private ISalonRepository salonRepository;

	@Autowired
	public void setSalonRepository(ISalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}

	@Override
	public SalonServiceDTO addService(SalonServiceDTO serviceDTO) {
		SalonService s_service = new SalonService();
		BeanUtils.copyProperties(serviceDTO, s_service);
		salonRepository.save(s_service);
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
		List<SalonServiceDTO> serviceDTOs = new ArrayList<SalonServiceDTO>();
		List<SalonService> services = salonRepository.getServicesByName();
		
		for(SalonService service: services) {
			SalonServiceDTO serviceDTO = new SalonServiceDTO();
			BeanUtils.copyProperties(service, serviceDTO);
			serviceDTOs.add(serviceDTO);
		}
		
		return serviceDTOs;
	}

	@Override
	public List<SalonServiceDTO> getServicesByPrice() {
		List<SalonServiceDTO> serviceDTOs = new ArrayList<SalonServiceDTO>();
		List<SalonService> services = salonRepository.getServicesByPrice();
		
		for(SalonService service: services) {
			SalonServiceDTO serviceDTO = new SalonServiceDTO();
			BeanUtils.copyProperties(service, serviceDTO);
			serviceDTOs.add(serviceDTO);
		}
		
		return serviceDTOs;
	}

	@Override
	public List<SalonServiceDTO> getServicesByDuration() {
		List<SalonServiceDTO> serviceDTOs = new ArrayList<SalonServiceDTO>();
		List<SalonService> services = salonRepository.getServicesByDuration();
		
		for(SalonService service: services) {
			SalonServiceDTO serviceDTO = new SalonServiceDTO();
			BeanUtils.copyProperties(service, serviceDTO);
			serviceDTOs.add(serviceDTO);
		}
		
		return serviceDTOs;
	}


}