package com.karamba.games.services;

import com.karamba.games.entities.Customer;
import com.karamba.games.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    public void createCustomer(@Valid Customer customer){
        customerRepository.save(customer);}

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id){
        return customerRepository.findCustomerById(id);}

    public Optional<Customer> findCustomerByFullName(String firstName, String lastName){
        return customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName);}

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);}

    public void updateCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    public void deleteCustomerById(Long id){
        findCustomerById(id).ifPresent(customer -> {
            customerRepository.delete(customer);
        });
    }


}
