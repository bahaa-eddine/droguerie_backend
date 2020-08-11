package com.digital.factory.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.factory.generale.ResponseEntity;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
    ProductService productService;
	ResponseEntity responseEntity;
    
    @GetMapping("/")
    public ResponseEntity getProducts() {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(productService.getAllProduit(),200);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(productService.getProductById(id),200);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity getProductByNom(@PathVariable("name") final String name ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(productService.getProductByName(name),200);
    }
    
    @GetMapping("/categorie/{categorie}")
    public ResponseEntity getProductByType(@PathVariable("categorie") final String categorie ) {
    	responseEntity = new ResponseEntity();
    	return responseEntity.setMessage(productService.getProductByCategorie(categorie),200);
    }
    
    @PostMapping("")
    public ResponseEntity createProduct(@RequestBody Product produit) {
    	try {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setMessage(productService.saveProduit(produit),200);
    	}catch(Exception e) {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setErrorMessage(e.getMessage(), 403);
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") final long id ) {
    	responseEntity = new ResponseEntity();
    	productService.deleteProductById(id);
    	return responseEntity.setMessage("deleted successful:",200);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") final long id, @RequestBody Product product) {
    	try{
    		responseEntity = new ResponseEntity();
        	return responseEntity.setMessage(productService.updateProduct(id, product),200);
    	}catch(Exception e) {
    		responseEntity = new ResponseEntity();
        	return responseEntity.setErrorMessage("update unsuccessful", 403);
    	}
    }
    


}
