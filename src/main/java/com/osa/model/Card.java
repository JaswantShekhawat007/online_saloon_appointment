package com.osa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
=======
import javax.persistence.OneToOne;
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cards")
public class Card {
<<<<<<< HEAD
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private long id;
		
		@NotEmpty
		@Column(name="card_name")
		private String cardName;
		
		@NotEmpty(message = "Card Number Field Empty")
	    @Size(min = 10, max = 19, message = "Invalid Card Number")
		@Column(name="card_number")
		private String cardNumber;
		
		
		@FutureOrPresent(message = "Invalid Expiry Date")
		@Column(name="expiry_date")
		private LocalDate expiryDate;
		
		@NotEmpty
		@Column(name="bank_name")
		private String bankName;		
}
=======
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String cardName;
	
	
    private String cardNumber;
	
	
	private LocalDate expiryDate;
	
	
	private String bankName;
	
	@OneToOne(mappedBy = "card")
    private Payment payment;
	
//	@Transient
//	private long payment_id;
}
>>>>>>> 2845cb1dc5a94995c9b0e89081c61302729671fd
