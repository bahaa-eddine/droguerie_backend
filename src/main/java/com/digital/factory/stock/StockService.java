package com.digital.factory.stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.product.Product;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	Map<Product, Integer> products;

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
