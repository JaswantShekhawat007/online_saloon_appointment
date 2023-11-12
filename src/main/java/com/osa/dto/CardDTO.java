package com.osa.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
	
	private long id;
	
	@NotEmpty
	private String cardName;
	
	/*
	 * Credit Card Number ranges between 10 to 19
	 * Debit Card Number ranges between 14 to 16
	 * */
	@NotEmpty(message = "Card Number Field Empty")
    @Size(min = 10, max = 19, message = "Invalid Card Number")
	private String cardNumber;
	
	@NotEmpty
	@FutureOrPresent(message = "Invalid Expiry Date")
	private LocalDate expiryDate;
	
	@NotEmpty
	private String bankName;
	
}
