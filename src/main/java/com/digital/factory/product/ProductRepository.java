package com.digital.factory.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);
	Iterable<Product> findByCategorie(String categorie);

}
