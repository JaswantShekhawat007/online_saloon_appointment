package com.osa.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osa.enums.VisitType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	
	private String location;
	
	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	
	private LocalDate prefferedDate;
	
	private LocalTime prefferedTime;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_name",referencedColumnName = "serviceId", nullable = true)
	private SalonService salon_service;
	
	@Transient
	private long service_id;
	
	//One to Many Relationship Between Customer and Appointment
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "userId", nullable = true)
	private Customer customer;
	
//	//Mapping Appointment and Payment Entity
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId", nullable = true)
//	private Payment payment;

	@Transient
	private String customer_userId;
	
	//Mapping Appointment and Payment Entity
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId", nullable = true)
	private Payment payment;

	
	
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(referencedColumnName = "serviceId")
//	private SalonService service;
	
}
