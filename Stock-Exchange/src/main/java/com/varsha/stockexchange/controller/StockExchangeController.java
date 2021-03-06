package com.varsha.stockexchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.stockexchange.dto.CompanyDto;
import com.varsha.stockexchange.dto.StockExchangeDto;
import com.varsha.stockexchange.exceptions.StockExchangeNotFoundException;
import com.varsha.stockexchange.service.StockExchangeService;

@RestController
@CrossOrigin
@RequestMapping("/stockExchange")
public class StockExchangeController {

	@Autowired
	private StockExchangeService stockExchangeService;

	@GetMapping(value = "/allStockExchanges")
	public ResponseEntity<List<StockExchangeDto>> allStockExchanges() {
		return ResponseEntity.ok(stockExchangeService.allStockExchanges());
	}

	@PostMapping(value = "/stockExchangeById/{id}")
	public ResponseEntity<StockExchangeDto> stockExchangeById(@PathVariable String id) {
		StockExchangeDto stockExchangeDto = stockExchangeService.findById(id);
		if (stockExchangeDto == null)
			throw new StockExchangeNotFoundException("stock exchange with id: " + id);
		return ResponseEntity.ok(stockExchangeDto);
	}

	@PostMapping(value = "/addStockExchange")
	public ResponseEntity<StockExchangeDto> addStockExchange(@RequestBody StockExchangeDto stockExchangeDto) {
		return ResponseEntity.ok(stockExchangeService.addStockExchange(stockExchangeDto));
	}

	@PutMapping(value = "/editStockExchange/{id}")
	public ResponseEntity<StockExchangeDto> editStockExchange(@PathVariable String id,
			@RequestBody StockExchangeDto stockExchangeDto) {
		StockExchangeDto stockExchange = stockExchangeService.editStockExchange(id, stockExchangeDto);
		if (stockExchange == null)
			throw new StockExchangeNotFoundException("stock exchange with id: " + id);
		return ResponseEntity.ok(stockExchange);
	}

	@PostMapping(value = "/addCompany/{stockExchange}/{id}/companyDto")
	public void addCompany(@PathVariable String stockExchange, @PathVariable String id,
			@RequestBody CompanyDto companyDto) {
		StockExchangeDto stockExchangeDto = stockExchangeService.addCompany(stockExchange, id, companyDto);
		if (stockExchangeDto == null)
			throw new StockExchangeNotFoundException("stock exchange with id: " + id);
	}

	@PostMapping(value = "/getCompanies/{id}")
	public ResponseEntity<List<CompanyDto>> getCompaniesById(@PathVariable String id) {
		List<CompanyDto> companiesDto = stockExchangeService.getCompaniesById(id);
		if (companiesDto == null)
			throw new StockExchangeNotFoundException("stock exchange with id: " + id);
		return ResponseEntity.ok(stockExchangeService.getCompaniesById(id));
	}

}
