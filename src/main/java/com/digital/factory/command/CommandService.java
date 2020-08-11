package com.digital.factory.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.product.ProductRepository;
import com.digital.factory.stock.Stock;
import com.digital.factory.stock.StockRepository;
import com.digital.factory.stock.produit.ProductStock;

@Service
public class CommandService {
	
	@Autowired
    private CommandRepository commandRepository;
	@Autowired
    private StockRepository stockRepository;
	@Autowired
    private ProductRepository productRepository;
	Command command;
	Stock stock;
	ProductStock productStock;
	List<ProductStock> productStocks;
	
	
	public Command saveCommand(CommandDTO commandDTO) {
		stock = stockRepository.findById(commandDTO.getIdStock()).get();
		System.out.println(stock.toString());
		System.out.println(commandDTO.toString());
		productStocks = new ArrayList<ProductStock>();
		commandDTO.getProductQuantities().forEach((productQuantity) -> {
			productStock = new ProductStock();
			productStock.setProduct(productRepository.findById(productQuantity.getIdProduct()).get());
			productStock.setQuantity((Integer) productQuantity.getQuantity());
			productStocks.add(productStock);
		});
		
		command = new Command();
		command.setStock(stock);
		command.setProducts(productStocks);
		return commandRepository.save(command);
	}
	
	public Command updateCommandStatus(Command command) {
		return commandRepository.save(command);
	}
	
	public String deleteCommandById(long id) {
		commandRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Command> getAllCommand(){
		return commandRepository.findAll();
	}
	
	public Command getCommandById(long id) {
		Optional<Command> command = commandRepository.findById(id);
		return command.get();
	}
	
	

}
