package com.digital.factory.stock.produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.command.Command;
import com.digital.factory.stock.Stock;
import com.digital.factory.stock.StockRepository;
import com.digital.factory.supplier.comand.SupplierCommandDTO;

@Service
public class ProductStockService {

	@Autowired
	private StockRepository stockRepository;
	List<ProductStock> products;
	boolean exist = false;
	
	public Optional<Stock> addProductToStock(Command command, SupplierCommandDTO supplierCommandDTO) {
		return stockRepository.findById(command.getStock().getId()).map(stock -> {
			if (stock.getProducts().isEmpty()) {
				stock.getProducts().addAll(command.getProducts());
			} else {
				products = new ArrayList<>();
				command.getProducts().forEach(productCommand -> {
					exist = false;
					stock.getProducts().forEach(productStock -> {
						if(productStock.getProduct().getId() == productCommand.getProduct().getId()) {
							productStock.setQuantity(productStock.getQuantity() + productCommand.getQuantity());
							exist = true;
						}
					});
					if(!exist) {						
						stock.getProducts().add(productCommand);
					}
				});
			}
			return stockRepository.save(stock);
		});
	}

}
