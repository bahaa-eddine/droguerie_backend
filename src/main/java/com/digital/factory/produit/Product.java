package com.digital.factory.produit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Column
    @NotNull
	private String name;
    @Column
	private String description;
    @Column
    @NotNull
	private Double price;
    @Column
    @NotNull
	private String fragility;
    @Column
    @NotNull
	private String categorie;
}
