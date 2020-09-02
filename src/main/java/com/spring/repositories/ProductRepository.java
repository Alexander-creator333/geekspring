package com.spring.repositories;


import com.spring.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAll();

    @Query(value = "select * from products where price = (select min(price) from products)", nativeQuery = true)
    Product minProduct();

    @Query(value = "select * from products where price = (select max(price) from products)", nativeQuery = true)
    Product maxProduct();
}