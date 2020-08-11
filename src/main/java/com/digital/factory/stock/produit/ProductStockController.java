package com.digital.factory.stock.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.generale.ResponseEntity;
import com.digital.factory.product.Product;

@RestController
@RequestMapping("/products")
public class ProductStockController {
	
	@Autowired
	ProductStockService produitStockService;
    Product produit;
    ResponseEntity responseEntity;
	
//    @PostMapping("/stocks/")
//    public ResponseEntity addProductToCommande(@RequestBody ProductStockDTO productStockDTO) {
//    	responseEntity = new ResponseEntity();
//    	try{
//			return responseEntity.setMessage(produitStockService.addProductToStock(productStockDTO), 200);
//    	}catch(Exception e) {
//    		return responseEntity.setErrorMessage(e.getMessage(),403);
//    	}
//    }
    
}