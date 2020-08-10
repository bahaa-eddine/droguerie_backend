package com.digital.factory.owner;

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
@RequestMapping("/owners")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getOwners() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ownerService.getAllOwner(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOwnerById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ownerService.getOwnerById(id),200);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwnerById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(ownerService.deleteOwnerById(id),200);
    }
    
    
    @PostMapping("/")
    public ResponseEntity createOwner(@RequestBody Owner owner) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(ownerService.createOwner(owner),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

}
