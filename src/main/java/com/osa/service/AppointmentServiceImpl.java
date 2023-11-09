package com.osa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.AppointmentDTO;
import com.osa.model.Appointment;
import com.osa.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private AppointmentRepository appointmentRepository;
		
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		BeanUtils.copyProperties(appointmentDTO, appointment);
		appointmentRepository.save(appointment);
		return appointmentDTO;
	}

	@Override
	public AppointmentDTO removeAppointment(long id) {
		AppointmentDTO appointmentDTO = getAppointment(id);
		Appointment appointment = new Appointment();
		BeanUtils.copyProperties(appointmentDTO, appointment);
		appointmentRepository.delete(appointment);
		return appointmentDTO;
	}

	@Override
	public AppointmentDTO updateAppointment(long id, AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		BeanUtils.copyProperties(appointmentDTO, appointment);
		appointmentRepository.save(appointment);
		return appointmentDTO;
	}

	@Override
	public AppointmentDTO getAppointment(long id) {
		AppointmentDTO appointmentDTO = new AppointmentDTO() ;
		Appointment appointment = appointmentRepository.findById(id).get();
		BeanUtils.copyProperties(appointment, appointmentDTO);
        //customerRepository.findById(String.valueOf(custId)).get();/*.orElseThrow(()->new CustomerNotFoundException("Employee With ID :"+eid+" Not Exist!"))*/
		return appointmentDTO;
	}

	@Override
	public List<AppointmentDTO> getAllAppointment() {
		List<Appointment> appointments = appointmentRepository.findAll();
		List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		for (Appointment appointment : appointments) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			BeanUtils.copyProperties(appointment, appointmentDTO);
			appointmentDTOs.add(appointmentDTO);
		}
		return appointmentDTOs;
	}

	@Override
	public List<AppointmentDTO> getOpenAppointment() {
		List<Appointment> appointments = appointmentRepository.findAll();
		List<AppointmentDTO> appointmentDTOs = new ArrayList<AppointmentDTO>();
		for (Appointment appointment : appointments) {
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			if(appointment.getPrefferedDate().compareTo(LocalDate.now()) >= 0 &&  appointment.getPrefferedTime().compareTo(LocalTime.now())>=0 ) {
				BeanUtils.copyProperties(appointment, appointmentDTO);
				appointmentDTOs.add(appointmentDTO);
			}
		}
		return appointmentDTOs;
	}

}
