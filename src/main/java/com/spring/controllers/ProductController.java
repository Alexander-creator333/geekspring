package com.spring.controllers;

import com.spring.entities.Product;
import com.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    @ResponseBody
    public Page<Product> getAllProducts(@RequestParam("page") int page) {
        return productService.getAllProducts(page);
    }

    @RequestMapping(path = "/minproducts", method = RequestMethod.GET)
    @ResponseBody
    public Product getMinProducts() {
        return productService.getMinProduct();
    }
    @RequestMapping(path = "/maxproducts", method = RequestMethod.GET)
    @ResponseBody
    public Product getMaxProducts() {
        return productService.getMaxProduct();
    }

    @RequestMapping(path = "/minmaxproducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getMinMaxProducts() {
        return productService.getMinMaxProduct();
    }

}