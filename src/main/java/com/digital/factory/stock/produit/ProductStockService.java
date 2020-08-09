package com.digital.factory.stock.produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.factory.produit.Product;
import com.digital.factory.produit.ProductRepository;
import com.digital.factory.stock.Stock;
import com.digital.factory.stock.StockRepository;

@Service
public class ProductStockService {

	@Autowired
	private ProductRepository produitRepository;
	@Autowired
	private StockRepository stockRepository;

	ProduitStock produitStock;
	Product produit;
	List<ProduitStock> produitStocks = new ArrayList<>();

//	public Optional<Stock> addProductToStock(ProductStockDTO productStockDTO) {
//
//		return stockRepository.findById(productStockDTO.getIdStock()).map(stock -> {
//			System.out.println(stock.toString());
//			for (ProductQuantiteDTO productQuantiteDTO : productStockDTO.getProductQuantities()) {
//				produit = produitRepository.findById(productQuantiteDTO.getIdProduct()).get();
//				produitStock = new ProduitStock();
//				produitStock.setProduit(produit);
//				produitStock.setQuantity((Integer) productQuantiteDTO.getQuantity());
//				produitStocks.add(produitStock);
//				System.out.println(produitStocks.toArray().toString());
//			}
//			stock.getProductsStock().addAll(produitStocks);
//			return stockRepository.save(stock);
//		});
//	}

}
