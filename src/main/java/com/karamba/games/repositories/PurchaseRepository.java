package com.karamba.games.repositories;

import com.karamba.games.entities.Product;
import com.karamba.games.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    Optional<Purchase> findPurchaseById(Long id);
    Optional<Purchase> findPurchaseByPurchaseCode(String purchaseCode);
    List<Purchase> findPurchasesByCustomerId(Long id);
    List<Purchase> findPurchasesByDate(LocalDate localDate);
    List<Product> findPurchaseProductsById(Long id);
}
