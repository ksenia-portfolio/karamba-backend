package com.karamba.games.controllers;

import com.karamba.games.entities.Product;
import com.karamba.games.services.CategoryService;
import com.karamba.games.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();}

    @GetMapping("findByCategory/{id}")
    public List<Product> getProductsByCategoryId(@RequestParam Long id){
        System.out.println(productService.findProductsByCategoryId(id));
        return productService.findProductsByCategoryId(id);}

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
