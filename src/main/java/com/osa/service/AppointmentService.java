package com.osa.service;

import java.util.List;

import com.osa.model.Appointment;

public interface AppointmentService {
	
	Appointment addAppointment(Appointment appointment);
	
	Appointment removeAppointment(long id);
	
	Appointment updateAppointment(long id, Appointment appointment);
	
	Appointment getAppointment(long id);
	
	List<Appointment> getAllAppointment();
	
	List<Appointment> getOpenAppointment();
	
}
