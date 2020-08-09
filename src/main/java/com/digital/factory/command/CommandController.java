package com.digital.factory.command;

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
@RequestMapping("/commands")
public class CommandController {
	
	@Autowired
	private CommandService commandService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getCommands() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(commandService.getAllCommand(),200);
    }
    @GetMapping("/{id}")
    public ResponseEntity getCommandById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(commandService.getCommandById(id),200);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommandById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(commandService.deleteCommandById(id),200);
    }
    
    @PostMapping("/")
    public ResponseEntity createCommand(@RequestBody CommandDTO commandDTO) {
    	try {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setMessage(commandService.saveCommand(commandDTO),200);
    	}catch(Exception e) {
    		System.out.println(e);
    		responseEntity = new ResponseEntity();
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

}
