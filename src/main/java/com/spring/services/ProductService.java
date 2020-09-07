package com.spring.services;

import com.spring.entities.Product;
import com.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(int page) {
        return productRepository.findAll(PageRequest.of(page, 5));
    }

    public Product getMinProduct() {
        return productRepository.minProduct();
    }

    public Product getMaxProduct() {
        return productRepository.maxProduct();
    }

    public List<Product> getMinMaxProduct() {
        List<Product> products = new ArrayList<>();
        products.add(productRepository.minProduct());
        products.add(productRepository.maxProduct());
        return products;
    }
}