package com.karamba.games.controllers;

import com.karamba.games.entities.Purchase;
import com.karamba.games.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> createPurchase(@RequestBody Purchase purchase){
        purchaseService.createPurchase(purchase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Purchase> findAllPurchases(){
        return purchaseService.findAllPurchases();}

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase purchase){
        purchaseService.updatePurchase(purchase);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(purchase, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
