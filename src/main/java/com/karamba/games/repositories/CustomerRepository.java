package com.karamba.games.repositories;

import com.karamba.games.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long id);
    Optional<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
    Optional<Customer> findCustomerByEmail(String email);
}
