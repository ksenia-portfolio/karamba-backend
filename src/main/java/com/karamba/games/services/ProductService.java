package com.karamba.games.services;

import com.karamba.games.entities.Product;
import com.karamba.games.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);}

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);}

    public Optional<Product> findProductByName(String name){
        return productRepository.findByName(name);}

    public List<Product> findProductsByNameContains(String name){
        return productRepository.findProductsByNameContains(name);}

    public List<Product> findProductsByCategoryId(Long id){
        return productRepository.findByCategory_Id(id);}

    public void updateProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    public void deleteProductById(Long id){
        findProductById(id).ifPresent(product -> {
            productRepository.delete(product);
        });
    }


}
