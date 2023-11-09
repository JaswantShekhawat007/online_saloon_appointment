package com.osa.dto;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDTO {
	
	private String userId;
	
	/*
		Password should contains at least 8 characters and at most 20 characters.
		It should contains at least one digit.
		It should contains at least one upper case alphabet.
		It should contains at least one lower case alphabet.
		It should contains at least one special character which includes !@#$%&*()-+=^.
		It should doesn’t contain any white space.
		
		where:
		^ represents starting character of the string.
		(?=.*[0-9]) represents a digit must occur at least once.
		(?=.*[a-z]) represents a lower case alphabet must occur at least once.
		(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
		(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
		(?=\\S+$) white spaces don’t allowed in the entire string.
		.{8, 20} represents at least 8 characters and at most 20 characters.
		$ represents the end of the string.
	 */
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$")
	private String password;
	
}
