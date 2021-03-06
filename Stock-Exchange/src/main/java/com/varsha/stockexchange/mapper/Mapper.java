package com.varsha.stockexchange.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.varsha.stockexchange.dto.CompanyDto;
import com.varsha.stockexchange.dto.StockExchangeDto;
import com.varsha.stockexchange.entities.Company;
import com.varsha.stockexchange.entities.StockExchange;

@Component
public class Mapper {

	public StockExchange toStockExchange(StockExchangeDto stockExchangeDto) {
		ModelMapper mapper = new ModelMapper();
		StockExchange stockExchange = mapper.map(stockExchangeDto, StockExchange.class);
		return stockExchange;
	}

	public StockExchangeDto toStockExchangeDto(StockExchange stockExchange) {
		ModelMapper mapper = new ModelMapper();
		StockExchangeDto stockExchangeDto = mapper.map(stockExchange, StockExchangeDto.class);
		return stockExchangeDto;
	}

	public List<StockExchangeDto> toStockExchangeDtoList(List<StockExchange> stockExchanges) {
		ModelMapper mapper = new ModelMapper();
		List<StockExchangeDto> stockExchangeDtoList = Arrays
				.asList(mapper.map(stockExchanges, StockExchangeDto[].class));
		return stockExchangeDtoList;
	}

	public List<StockExchange> toStockExchangeList(List<StockExchangeDto> stockExchangeDtos) {
		ModelMapper mapper = new ModelMapper();
		List<StockExchange> stockExchangeList = Arrays.asList(mapper.map(stockExchangeDtos, StockExchange[].class));
		return stockExchangeList;
	}

	public Company toCompany(CompanyDto companyDto) {
		ModelMapper mapper = new ModelMapper();
		Company company = mapper.map(companyDto, Company.class);
		return company;
	}

	public List<CompanyDto> toCompanyDtoList(List<Company> companies) {
		ModelMapper mapper = new ModelMapper();
		List<CompanyDto> companyDtoList = Arrays.asList(mapper.map(companies, CompanyDto[].class));
		return companyDtoList;
	}

}
