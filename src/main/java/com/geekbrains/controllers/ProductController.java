package com.geekbrains.controllers;

import com.geekbrains.entites.Product;
import com.geekbrains.repositories.ProductRepository;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        productRepository.AddProduct();
    }

    @RequestMapping(path = "/allproduct")
    public String showAllProduct(Model uiModel) {
        uiModel.addAttribute("products", productService.AllProduct());
        return "products";
    }

    @RequestMapping(path = "/findbyid")
    @ResponseBody
    public Product findAllId(Model uiModel, @RequestParam int id) {
        return productService.ProductById(id);
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "addproductform";
    }

    @RequestMapping("/addProduct")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.AddNewProduct(product);
        return "addproduct";
    }
}