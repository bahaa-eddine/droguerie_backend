package com.digital.factory.supplier.comand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.command.Command;
import com.digital.factory.command.CommandService;
import com.digital.factory.generale.StatusCommandeConstants;
import com.digital.factory.stock.produit.ProductQuantityDTO;
import com.digital.factory.stock.produit.ProductStockService;

@Service
public class SupplierCommandService {
	
	@Autowired
	private CommandService commandService;
	@Autowired
	private ProductStockService productStockService;
	Command command;
	List<ProductQuantityDTO> productQuantityDTOs;
	ProductQuantityDTO productQuantityDTO;

	public Command validateOrRefuseCommand(long idSupplier, SupplierCommandDTO supplierCommandDTO) {
		
		if(supplierCommandDTO.isStatus()) {
			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
			command.setStatus(StatusCommandeConstants.accepted);
			productStockService.addProductToStock(command, supplierCommandDTO);
		}else {
			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
			command.setStatus(StatusCommandeConstants.failed);
		}
		return commandService.updateCommandStatus(command);
	}

}
