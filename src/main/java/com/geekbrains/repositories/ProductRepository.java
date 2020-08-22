package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductRepository {
    ArrayList<Product> products = new ArrayList<>();

    public void AddProduct(){
        products.add(new Product(1, "fist", 111));
        products.add(new Product(2, "second", 222));
        products.add(new Product(3, "thirt", 333));
        products.add(new Product(4, "fouth", 444));
        products.add(new Product(5, "fivth", 555));
    }

    public ArrayList<Product> AllProduct(){
        return products;
    }

    public Product ProductById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                return products.get(i);
        }
        return null;
    }

    public void AddNewProduct(Product product){
        product.setId(products.size() + 1);
        products.add(product);
    }
}