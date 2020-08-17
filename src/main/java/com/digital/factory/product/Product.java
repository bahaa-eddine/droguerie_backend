package com.digital.factory.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.digital.factory.enums.Categorie;
import com.digital.factory.enums.Fragility;
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
    @Enumerated(EnumType.STRING)
	private Fragility fragility;
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
	private Categorie categorie;
}
