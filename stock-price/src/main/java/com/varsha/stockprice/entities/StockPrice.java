package com.varsha.stockprice.entities;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class StockPrice {

	@Id
	private String id = UUID.randomUUID().toString();

	private String companyCode;
	private String stockExchange;
	private double currentPrice;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String date;
	private String time;

}