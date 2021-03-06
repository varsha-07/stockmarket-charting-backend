package com.varsha.stockexchange.initializingdata;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.varsha.stockexchange.dao.StockExchangeDao;
import com.varsha.stockexchange.entities.Company;
import com.varsha.stockexchange.entities.StockExchange;

@Component
public class StockExchangeInitilizer implements CommandLineRunner {

	@Autowired
	private StockExchangeDao stockExchangeDao;

	@Override
	public void run(String... args) throws Exception {

		stockExchangeDao.deleteAll();

		StockExchange stockExchange = new StockExchange(UUID.randomUUID().toString(), "BSE",
				"BSE Limited, also known as the Bombay Stock Exchange", "Mumbai, India",
				"It is South Asia's second oldest stock exchange", new ArrayList<Company>());
		stockExchangeDao.save(stockExchange);

		StockExchange stockExchange2 = new StockExchange(UUID.randomUUID().toString(), "NSE",
				"National Stock Exchange of India Limited (NSE) is the leading stock exchange of India",
				"Mumbai, Maharashtra, India", "It is under the ownership of Ministry of Finance , Government of India",
				new ArrayList<Company>());
		stockExchangeDao.save(stockExchange2);

	}
}
