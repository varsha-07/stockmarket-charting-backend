package com.varsha.sector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.sector.dto.CompanyDto;
import com.varsha.sector.dto.SectorDto;
import com.varsha.sector.exceptions.SectorNotFoundException;
import com.varsha.sector.service.SectorService;

@RestController
@CrossOrigin
@RequestMapping("/sector")
public class SectorController {

	@Autowired
	private SectorService sectorService;

	@GetMapping(value = "/allSectors")
	public ResponseEntity<List<SectorDto>> allSectors() {
		return ResponseEntity.ok(sectorService.findAll());
	}

	@PostMapping(value = "/sectorById/{id}")
	public ResponseEntity<SectorDto> sectorDetails(@PathVariable String id) {
		SectorDto sectorDto = sectorService.findById(id);
		if (sectorDto == null)
			throw new SectorNotFoundException("Unable to find Ipo with id: " + id);
		return ResponseEntity.ok(sectorDto);
	}

	@PostMapping(value = "addSector")
	public ResponseEntity<SectorDto> addSector(@RequestBody SectorDto stockPriceDtos) {
		return ResponseEntity.ok(sectorService.addSector(stockPriceDtos));
	}

	@DeleteMapping(value = "/deleteSector/{id}")
	public ResponseEntity<SectorDto> deleteSector(@PathVariable String id) {
		SectorDto sectorDto = sectorService.deleteById(id);
		if (sectorDto == null)
			throw new SectorNotFoundException("Unable to find Ipo with id: " + id);
		return ResponseEntity.ok(sectorDto);
	}

	@PostMapping(value = "/addCompany/{sectorName}/{id}/companyDto")
	public void addCompany(@PathVariable String sectorName, @PathVariable String id,
			@RequestBody CompanyDto companyDto) {
		SectorDto sectorDto = sectorService.addCompany(sectorName, id, companyDto);
		if (sectorDto == null)
			throw new SectorNotFoundException("Unable to find Ipo with id: " + id);
	}

	@PostMapping(value = "/getCompanies/{id}")
	public ResponseEntity<List<CompanyDto>> getCompaniesById(@PathVariable String id) {
		List<CompanyDto> companiesDto = sectorService.getCompaniesById(id);
		if (companiesDto == null)
			throw new SectorNotFoundException("Unable to find Ipo with id: " + id);
		return ResponseEntity.ok(companiesDto);
	}

	@PostMapping(value = "{sectorName}/getCompanies/")
	public List<CompanyDto> getCompaniesBySector(@PathVariable String sectorName) {
		return sectorService.getCompaniesBySector(sectorName);
	}

}
