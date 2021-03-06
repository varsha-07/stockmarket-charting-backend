package com.varsha.zuulgateway.registration.token;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenDao extends MongoRepository<ConfirmationToken, String> {

	public Optional<ConfirmationToken> findByToken(String token);

}
