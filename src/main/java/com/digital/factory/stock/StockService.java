package com.digital.factory.stock;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public Stock saveStock(Stock stock) {
		return stockRepository.save(stock);
	}

	public String deleteStockById(long id) {
		stockRepository.deleteById(id);
		return "delete successful!";
	}

	public Iterable<Stock> getAllStock() {
		return stockRepository.findAll();
	}

	public Stock getStocktById(long id) {
		Optional<Stock> stock = stockRepository.findById(id);
		return stock.get();
	}

	public Object findStockByName(String name) {
		Optional<Stock> stock = stockRepository.findStockByName(name);
		return stock.get();
	}

}
