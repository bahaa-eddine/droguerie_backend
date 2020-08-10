package com.digital.factory.owner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.command.CommandDTO;
import com.digital.factory.generale.ResponseEntity;

@RestController
@RequestMapping("/owners")
public class OwnerCommandController {

	@Autowired
	private OwnerCommandService ownerCommandService;
	ResponseEntity responseEntity;
	
    @PostMapping("/commands")
    public ResponseEntity requestCommandForOwner(@RequestHeader long idOwner, @RequestBody CommandDTO commandDTO) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(ownerCommandService.requestCommandForOwner(idOwner, commandDTO),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
}
