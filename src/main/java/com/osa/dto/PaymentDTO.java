package com.osa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osa.enums.PaymentStatus;
import com.osa.enums.PaymentType;
import com.osa.model.Card;
import com.osa.model.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDTO {
	private long paymentId;
	
	@NotEmpty(message = "Payment Type Required")
	private String type;
	
	@NotEmpty(message = "Payment Status Required")
	private String status;

	
<<<<<<< HEAD
	private Card card;

=======
	@Valid
	private CardDTO card;
	
	private long appointmentId;
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd
}
