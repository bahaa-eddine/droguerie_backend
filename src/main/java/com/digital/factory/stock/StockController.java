package com.digital.factory.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.generale.ResponseEntity;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	StockService stockService;
	ResponseEntity responseEntity;

	@GetMapping("/")
	public ResponseEntity getStocks() {
		responseEntity = new ResponseEntity();
		return responseEntity.setMessage(stockService.getAllStock(), 200);
	}

	@GetMapping("/{id}")
	public ResponseEntity getStockById(@PathVariable("id") final long id) {
		responseEntity = new ResponseEntity();
		return responseEntity.setMessage(stockService.getStocktById(id), 200);
	}

	@GetMapping("/{name}")
	public ResponseEntity getStockByName(@PathVariable("name") final String name) {
		responseEntity = new ResponseEntity();
		return responseEntity.setMessage(stockService.findStockByName(name), 200);
	}

	@PostMapping("")
	public ResponseEntity createStock(@RequestBody Stock stock) {
		try {
			responseEntity = new ResponseEntity();
			return responseEntity.setMessage(stockService.saveStock(stock), 200);
		} catch (Exception e) {
			responseEntity = new ResponseEntity();
			return responseEntity.setErrorMessage(e.getMessage(), 403);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteStock(@PathVariable("id") final long id) {
		responseEntity = new ResponseEntity();
		stockService.deleteStockById(id);
		return responseEntity.setMessage("deleted successful:", 200);
	}
}