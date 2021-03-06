package com.varsha.zuulgateway.registration;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {

	@NotNull
	@Length(min = 3)
	private final String username;

	@NotNull
	@Email
	private final String email;

	@NotNull
	@Length(min = 5)
	private final String password;

	@NotNull
	@Length(min = 10, max = 10)
	private final String mobileNumber;
}
