package com.osa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment removeAppointment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment getAppointment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getOpenAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

}
