package com.digital.factory.supplier.comand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.command.Command;
import com.digital.factory.command.CommandService;
import com.digital.factory.generale.StatusCommandeConstants;

@Service
public class SupplierCommandService {
	
	@Autowired
	private CommandService commandService;
	Command command;

	public Command validateOrRefuseCommand(long idSupplier, SupplierCommandDTO supplierCommandDTO) {
		
		if(supplierCommandDTO.isStatus()) {
			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
			command.setStatus(StatusCommandeConstants.accepted);
		}else {
			command = commandService.getCommandById(supplierCommandDTO.getIdCommand());
			command.setStatus(StatusCommandeConstants.failed);
		}
		return commandService.updateCommandStatus(command);
	}

}
