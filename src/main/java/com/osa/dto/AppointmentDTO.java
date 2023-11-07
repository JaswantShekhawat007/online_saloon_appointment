package com.osa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.osa.enums.ServiceName;
import com.osa.enums.VisitType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
	
	private long appointmentId;
	@NotEmpty
	private String location;
	@NotEmpty
	private VisitType visitType;
	@Future
	private LocalDate prefferedDate;
	@Future
	private LocalTime prefferedTime;
	@NotEmpty
	private ServiceName serviceName;
	@Valid
	private CustomerDTO customer;
	@Valid
	private PaymentDTO payment;
	
}
