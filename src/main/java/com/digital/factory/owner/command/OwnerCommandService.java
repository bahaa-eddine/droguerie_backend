package com.digital.factory.owner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.command.Command;
import com.digital.factory.command.CommandDTO;
import com.digital.factory.command.CommandService;
import com.digital.factory.owner.Owner;
import com.digital.factory.owner.OwnerService;

@Service
public class OwnerCommandService {

	
	@Autowired
	private OwnerService ownerService;
	@Autowired 
	private CommandService commandService;
	
	public Owner requestCommandForOwner(long idOwner, CommandDTO commandDTO) {
		Command command = commandService.saveCommand(commandDTO);
		Owner owner = ownerService.getOwnerById(idOwner);
		owner.getCommands().add(command);
		return ownerService.createOwner(owner);
	}
}
