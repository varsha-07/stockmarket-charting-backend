package com.varsha.stockprice.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompareDto {

	private String name;
	private String stockExchange;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String fromDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String toDate;
	private String periodicity;
}
