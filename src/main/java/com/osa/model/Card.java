package com.osa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
	
	@Id
	private long id;
	
	private String cardName;
	private String cardNumber;
	private LocalDate expiryDate;
	private String bankName;
}
