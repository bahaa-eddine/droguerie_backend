package com.digital.factory.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.produit.ProductRepository;
import com.digital.factory.stock.Stock;
import com.digital.factory.stock.StockRepository;
import com.digital.factory.stock.produit.ProduitStock;

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
	ProduitStock productStock;
	List<ProduitStock> productStocks = new ArrayList<ProduitStock>();;
	
	
	public Command saveCommand(CommandDTO commandDTO) {
		stock = stockRepository.findById(commandDTO.getIdStock()).get();
		commandDTO.getProductQuantities().forEach((productQuantity) -> {
			productStock = new ProduitStock();
			productStock.setProduit(productRepository.findById(productQuantity.getIdProduct()).get());
			productStock.setQuantity((Integer) productQuantity.getQuantity());
			productStocks.add(productStock);
		});
		command = new Command();
		command.setStock(stock);
		command.setProducts(productStocks);
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
