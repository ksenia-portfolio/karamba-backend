package com.karamba.games.services;

import com.karamba.games.entities.Customer;
import com.karamba.games.entities.Product;
import com.karamba.games.entities.Purchase;
import com.karamba.games.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public void createPurchase(Purchase purchase){
        purchaseRepository.save(purchase);}

    public List<Purchase> findAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> findPurchaseById(Long id){
        return purchaseRepository.findPurchaseById(id);}

    public Optional<Purchase> findPurchaseByPurchaseCode(String purchaseCode){
        return purchaseRepository.findPurchaseByPurchaseCode(purchaseCode);}

    public List<Purchase> findPurchasesByCustomerId(Long id){
        return purchaseRepository.findPurchasesByCustomerId(id);}

    public List<Purchase> findPurchasesByDate(LocalDate localDate){
        return purchaseRepository.findPurchasesByDate(localDate);}

    public List<Product> findProductsByPurchaseId(Long purchaseId){
        return purchaseRepository.findPurchaseProductsById(purchaseId);}

    public void updatePurchase(Purchase purchase) {
        purchaseRepository.saveAndFlush(purchase);
    }

    public void deletePurchaseById(Long id){
        findPurchaseById(id).ifPresent(purchase -> {
            purchaseRepository.delete(purchase);
        });
    }


}
