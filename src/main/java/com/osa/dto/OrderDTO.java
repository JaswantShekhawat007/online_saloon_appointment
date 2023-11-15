package com.osa.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osa.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private long orderId;
	
	@NotNull(message = "Please Enter Amount")
	private double amount;
	
	//@NotEmpty
	@FutureOrPresent(message = "Invalid Billing Date")
	private LocalDate billingDate;
	


	@Valid
	@JsonIgnore
	private CustomerDTO customer;

//	@Valid
//	private CustomerDTO customer;

	
	

	private String customer_userId;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	private long payment_id;
	
}
