
package com.iesvirgendelcarmen.app4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesvirgendelcarmen.app4.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
