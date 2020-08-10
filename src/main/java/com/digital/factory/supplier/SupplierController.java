package com.digital.factory.supplier;

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
@RequestMapping("/suppliers")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getSuppliers() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(supplierService.getAllSupplier(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getSupplierById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(supplierService.getSupplierById(id),200);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSupplierById(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(supplierService.deleteSupplierById(id),200);
    }
    
    
    @PostMapping("/")
    public ResponseEntity createSupplier(@RequestBody Supplier supplier) {
    	responseEntity = new ResponseEntity();
    	try {
        	return responseEntity.setMessage(supplierService.createSupplier(supplier),200);
    	}catch(Exception e) {
        	return responseEntity.setErrorMessage(e.toString(), 403);
    	}
    }

}
