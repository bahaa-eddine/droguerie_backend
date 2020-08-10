package com.digital.factory.supplier.comand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.generale.ResponseEntity;

@RestController
@RequestMapping("/suppliers")
public class SupplierCommandController {

	@Autowired
	private SupplierCommandService supplierCommandService;
	ResponseEntity responseEntity;
	
    @PostMapping("/commands")
    public ResponseEntity validateOrRefuseCommand(@RequestHeader long idSupplier, @RequestBody SupplierCommandDTO supplierCommandDTO) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(supplierCommandService.validateOrRefuseCommand(idSupplier, supplierCommandDTO),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }
}
