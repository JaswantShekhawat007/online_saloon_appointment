package com.osa.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.osa.enums.VisitType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	
	private String location;
	
	@Enumerated(EnumType.STRING)
	private VisitType visitType;
	
	private LocalDate prefferedDate;
	
	private LocalTime prefferedTime;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "serviceName")
	private SalonService serviceName;
	
	//One to Many Relationship Between Customer and Appointment
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "userId")
	private Customer customer;
	
	//Mapping Appointment and Payment Entity
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
	private Payment payment;
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "serviceId")
//	private SalonService service;
	
}
