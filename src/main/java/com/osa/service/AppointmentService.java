package com.osa.service;

import java.util.List;

import com.osa.dto.AppointmentDTO;

public interface AppointmentService {
	
	AppointmentDTO addAppointment(AppointmentDTO appointmentDTO);
	
	AppointmentDTO removeAppointment(long id);
	
	AppointmentDTO updateAppointment(long id, AppointmentDTO appointmentDTO);
	
	AppointmentDTO getAppointment(long id);
	
	List<AppointmentDTO> getAllAppointment();
	
	List<AppointmentDTO> getOpenAppointment();
	
}
