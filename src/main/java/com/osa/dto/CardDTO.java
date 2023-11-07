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
	@NotEmpty
    @Size(min = 10, max = 19)
	private String cardNumber;
	@FutureOrPresent
	private LocalDate expiryDate;
	@NotEmpty
	private String bankName;
	
}
