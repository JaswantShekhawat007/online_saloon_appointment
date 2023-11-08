package com.osa.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.osa.enums.PaymentStatus;
import com.osa.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
	
	private long paymentId;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Valid
	private CardDTO card;
}
