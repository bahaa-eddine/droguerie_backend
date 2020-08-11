package com.digital.factory.stock;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.digital.factory.stock.produit.ProductStock;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull
	private String name;
	@OneToMany
	private List<ProductStock> products;
	
}
