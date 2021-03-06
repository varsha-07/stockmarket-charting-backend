package com.varsha.zuulgateway.registration.token;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.varsha.zuulgateway.appuser.AppUser;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(value = "confirmation_token")
@NoArgsConstructor
public class ConfirmationToken {

	private AppUser appUser;

	private String id = UUID.randomUUID().toString();
	private String token;
	private LocalDateTime createdAt;
	private LocalDateTime expiresAt;
	private LocalDateTime confirmedAt;

	public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, AppUser appUser) {
		this.token = token;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
		this.appUser = appUser;
	}

}
