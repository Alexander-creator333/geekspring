package com.geekbrains.service;

import com.geekbrains.entites.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setStudentsRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ArrayList<Product> AllProduct() {
        return productRepository.AllProduct();
    }

    public Product ProductById(int id) {
        return productRepository.ProductById(id);
    }

    public void AddNewProduct(Product product) {
        productRepository.AddNewProduct(product);
    }
}