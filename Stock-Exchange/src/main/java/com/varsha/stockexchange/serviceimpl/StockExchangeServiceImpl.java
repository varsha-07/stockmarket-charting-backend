package com.varsha.stockexchange.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varsha.stockexchange.dao.StockExchangeDao;
import com.varsha.stockexchange.dto.CompanyDto;
import com.varsha.stockexchange.dto.StockExchangeDto;
import com.varsha.stockexchange.entities.Company;
import com.varsha.stockexchange.entities.StockExchange;
import com.varsha.stockexchange.mapper.Mapper;
import com.varsha.stockexchange.service.StockExchangeService;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeDao stockExchangeDao;

	@Autowired
	private Mapper mapper;

	@Override
	public List<StockExchangeDto> allStockExchanges() {
		List<StockExchange> allStockExchanges = stockExchangeDao.findAll();
		return mapper.toStockExchangeDtoList(allStockExchanges);
	}

	@Override
	public StockExchangeDto findById(String id) {
		if (!stockExchangeDao.existsById(id))
			return null;
		StockExchange stockExchange = stockExchangeDao.findById(id).get();
		return mapper.toStockExchangeDto(stockExchange);
	}

	@Override
	public StockExchangeDto addStockExchange(StockExchangeDto stockExchangeDto) {
		StockExchange stockExchange = mapper.toStockExchange(stockExchangeDto);
		stockExchange = stockExchangeDao.save(stockExchange);
		return mapper.toStockExchangeDto(stockExchange);
	}

	@Override
	public StockExchangeDto editStockExchange(String id, StockExchangeDto stockExchangeDto) {
		if (!stockExchangeDao.existsById(id))
			return null;
		StockExchange stockExchange = mapper.toStockExchange(stockExchangeDto);
		stockExchange.setId(id);
		stockExchange = stockExchangeDao.save(stockExchange);
		return mapper.toStockExchangeDto(stockExchange);
	}

	@Override
	public StockExchangeDto addCompany(String stockExchange, String id, CompanyDto companyDto) {
		StockExchange stockExchangeData = stockExchangeDao.findByStockExchange(stockExchange);
		if (stockExchange == null)
			return null;
		Company company = mapper.toCompany(companyDto);
		company.setId(id);
		stockExchangeData.getCompanies().add(company);
		stockExchangeData = stockExchangeDao.save(stockExchangeData);
		return mapper.toStockExchangeDto(stockExchangeData);
	}

	@Override
	public List<CompanyDto> getCompaniesById(String id) {
		if (!stockExchangeDao.existsById(id))
			return null;
		StockExchange stockExchange = stockExchangeDao.findById(id).get();
		List<Company> companies = stockExchange.getCompanies();
		return mapper.toCompanyDtoList(companies);
	}
}
