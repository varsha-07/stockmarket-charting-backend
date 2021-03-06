package com.varsha.stockexchange.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "stock_exchange")
public class StockExchange {

	@Id
	private String id = UUID.randomUUID().toString();

	private String stockExchange;
	private String writeUp;
	private String contactAddress;
	private String remarks;

	@DBRef
	private List<Company> companies = new ArrayList<>();

}
