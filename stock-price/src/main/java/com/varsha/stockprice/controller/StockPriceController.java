package com.varsha.stockprice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.stockprice.dto.CompareDto;
import com.varsha.stockprice.dto.CompareResponseDto;
import com.varsha.stockprice.dto.StockPriceDto;
import com.varsha.stockprice.service.StockPriceService;

@RestController
@CrossOrigin
@RequestMapping("/stockprice")
public class StockPriceController {

	@Autowired
	private StockPriceService stockPriceService;

	@GetMapping(value = "/allStockPrices")
	public ResponseEntity<List<StockPriceDto>> allStockPriceDetails() {
		return ResponseEntity.ok(stockPriceService.findAll());
	}

	@PostMapping(value = "/stockPriceById/{id}")
	public ResponseEntity<StockPriceDto> stockPriceDetails(@PathVariable String id) {
		return ResponseEntity.ok(stockPriceService.findById(id));
	}

	@PutMapping(value = "/updateStockPrice")
	public ResponseEntity<StockPriceDto> updateStockPrice(@RequestBody StockPriceDto stockPriceDto) {
		return ResponseEntity.ok(stockPriceService.update(stockPriceDto));
	}

	@DeleteMapping(value = "/deleteStockPrice/{id}")
	public ResponseEntity<String> deleteStockPrice(@PathVariable String id) {
		return ResponseEntity.ok(stockPriceService.deleteById(id));
	}

	@PostMapping(value = "uploadExcel")
	public ResponseEntity<List<StockPriceDto>> addCompany(@RequestBody List<StockPriceDto> stockPriceDtos) {
		return ResponseEntity.ok(stockPriceService.save(stockPriceDtos));
	}

	@PostMapping(value = "/compareCompany")
	public ResponseEntity<CompareResponseDto> compareCompany(@RequestBody CompareDto compareDto)
			throws ParseException {
		return ResponseEntity.ok(stockPriceService.companyComparison(compareDto));
	}

	@PostMapping(value = "/compareSector")
	public ResponseEntity<CompareResponseDto> compareSector(@RequestBody CompareDto compareDto) throws ParseException {
		return ResponseEntity.ok(stockPriceService.sectorComparison(compareDto));
	}

}
