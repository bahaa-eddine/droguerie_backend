package com.digital.factory.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	Product newProduct;
	
	public Product saveProduit(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(long id) {
		productRepository.deleteById(id);
	}
	
	public Iterable<Product> getAllProduit(){
		return productRepository.findAll();
	}
	
	public Product getProductById(long id) {
		Optional<Product> produit = productRepository.findById(id);
		return produit.get();
	}
	
	public Product updateProduct(long id,Product produit) {
		newProduct = productRepository.findById(id).get();
		newProduct.setName(produit.getName());
		newProduct.setPrice(produit.getPrice());
		newProduct.setFragility(produit.getFragility());
		newProduct.setDescription(produit.getDescription());
		return productRepository.save(newProduct);
	}

	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	public Iterable<Product> getProductByCategorie(String categorie) {
		return productRepository.findByCategorie(categorie);
	}

}
