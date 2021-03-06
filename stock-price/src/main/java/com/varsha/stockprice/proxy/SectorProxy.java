package com.varsha.stockprice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varsha.stockprice.dto.CompanyDto;

@FeignClient(name = "sector-app")
public interface SectorProxy {

	@PostMapping(value = "/sector/{sectorName}/getCompanies/")
	public List<CompanyDto> getCompaniesBySector(@PathVariable String sectorName);

}