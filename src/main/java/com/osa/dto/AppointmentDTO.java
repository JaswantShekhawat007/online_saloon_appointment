package com.osa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message = "Empty Field Location")
	private String location;
	
	@NotNull(message = "Please Enter Visit Type")
	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	
	@NotEmpty(message = "Empty Field Preffered Date")
	@Future(message = "Invalid Preffered Date")
	private LocalDate prefferedDate;
	
	@NotEmpty(message = "Empty Field Preffered Time")
	private LocalTime prefferedTime;
	
	@JsonIgnore
	private SalonServiceDTO salon_service;
	
	@NotBlank
	private long service_id;
	
	@JsonIgnore
	private CustomerDTO customer;
	
	@NotBlank
	private String customer_userId;
	
	@JsonIgnore
	private PaymentDTO payment;
	
	
	
}
