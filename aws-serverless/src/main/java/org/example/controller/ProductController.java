package org.example.controller;

import org.example.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    List<Product> allProducts=List.of(new Product(101, "Mobile"),new Product(102,"Laptop"));

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return allProducts;
    }
}
