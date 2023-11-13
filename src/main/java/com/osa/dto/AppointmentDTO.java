package com.osa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osa.enums.VisitType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
	
	private long appointmentId;
	
	@NotEmpty(message = "Empty Field Location")
	private String location;
	
	@NotEmpty(message = "Please Enter Visit Type")
	private VisitType visitType;
	
	@NotEmpty(message = "Empty Field Preffered Date")
	@Future(message = "Invalid Preffered Date")
	private LocalDate prefferedDate;
	
	@NotEmpty(message = "Empty Field Preffered Time")
	@Future(message = "Invalid Preffered Time")
	private LocalTime prefferedTime;
	
	@JsonIgnore
	private SalonServiceDTO serviceName;
	
	private long service_id;
	
	@JsonIgnore
	private CustomerDTO customer;
	
	@JsonIgnore
	private PaymentDTO payment;
	
	
	private String customer_userId;
	
}
