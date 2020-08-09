package com.digital.factory.stock.produit;

import java.util.List;

import lombok.Data;

@Data
public class ProductStockDTO {
	private List<ProductQuantityDTO> productQuantities;
	private long idStock;
}
