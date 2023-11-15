package com.osa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.dto.AppointmentDTO;
import com.osa.exception.CustomerNotFoundException;
import com.osa.exception.NoSuchAppointmentException;
import com.osa.model.Appointment;
import com.osa.model.Customer;
import com.osa.model.SalonService;
import com.osa.repository.AppointmentRepository;
import com.osa.repository.CustomerRepository;
import com.osa.repository.ISalonRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	//Appointment Repository
	private AppointmentRepository appointmentRepository;
		
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	//Customer Repository
	private CustomerRepository customerRepository;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	//SalonService Repository
	private ISalonRepository salonRepository;

	@Autowired
	public void setSalonRepository(ISalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}

	
	@Override
	public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
		
		Appointment appointment = new Appointment();
		BeanUtils.copyProperties(appointmentDTO, appointment);
		
		Customer customer = customerRepository.findById(appointmentDTO.getCustomer_userId())
				.orElseThrow(()->new CustomerNotFoundException("Employee With ID :"+appointmentDTO.getCustomer_userId()+" Not Exist!"));
		appointment.setCustomer(customer);
		
		SalonService s_service = salonRepository.findById(appointmentDTO.getService_id()).get();
		appointment.setSalon_service(s_service);
		
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
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(()->new NoSuchAppointmentException("Appointment With ID :"+id+" does Not Exist!"));
		
		appointment.setLocation(appointmentDTO.getLocation());
		appointment.setPrefferedDate(appointmentDTO.getPrefferedDate());
		appointment.setPrefferedTime(appointmentDTO.getPrefferedTime());
		appointment.setServiceName(appointmentDTO.getServiceName());
		appointment.setVisitType(appointmentDTO.getVisitType());
		
		
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
