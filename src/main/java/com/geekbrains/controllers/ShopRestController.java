package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restshop/**")
public class ShopRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/{id}")
    public Product productById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/api")
    public List<Product> shopPage() {
        return productService.getAllProducts();
    }
}
