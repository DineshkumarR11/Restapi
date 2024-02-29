package com.example.day4cw3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw3.model.Product;
import com.example.day4cw3.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    public ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product product) {
        if(productService.saveProduct(product))
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> list =  productService.getProducts();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getMethodName(@PathVariable("productId") int id) {
        Product p =  productService.getProductById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
}
