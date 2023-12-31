package com.osa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
	
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
