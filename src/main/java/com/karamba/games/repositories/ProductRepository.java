package com.karamba.games.repositories;

import com.karamba.games.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Id(Long id);
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> findProductsByNameContains(String name);
}
