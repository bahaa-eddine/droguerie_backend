package com.digital.factory.supplier.comand;

import java.util.List;

import com.digital.factory.stock.produit.ProductQuantityDTO;

import lombok.Data;

@Data
public class SupplierCommandDTO {
	private long idCommand;
	private boolean status;
	private List<ProductQuantityDTO> products;
}
