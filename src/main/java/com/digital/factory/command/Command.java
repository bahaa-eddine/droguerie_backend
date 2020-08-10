package com.digital.factory.command;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.digital.factory.generale.StatusCommandeConstants;
import com.digital.factory.stock.Stock;
import com.digital.factory.stock.produit.ProduitStock;

import lombok.Data;

@Data
@Entity
public class Command {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date date = new Date();
	@Column
	private String status = StatusCommandeConstants.pending;
	@OneToOne(cascade = CascadeType.ALL)
	private Stock stock;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProduitStock> products;
}
