package com.digital.factory.enums;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.generale.ResponseEntity;


@RestController
@RequestMapping("/fragilities")
public class FragilityController {
	
	ResponseEntity responseEntity;
	
    @GetMapping("/")
    public ResponseEntity getProducts() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(
    			Fragility.values()
    			,200);
    }
	
}
	