package com.digital.factory.command;

import java.util.List;

import com.digital.factory.stock.produit.ProductQuantityDTO;

import lombok.Data;

@Data
public class CommandDTO {

	private Long idStock;
	private List<ProductQuantityDTO> productQuantities;
}
