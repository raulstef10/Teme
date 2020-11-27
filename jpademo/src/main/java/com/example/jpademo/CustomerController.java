package com.example.jpademo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private CustomerRepository repository;

    CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/customers")
    List<Customer> all(){
        return (List<Customer>) repository.findAll();
    }
    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }
    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(id));
    }
    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return repository.findById(id)
           .map(customer ->{
               customer.setFirstName(newCustomer.getFirstName());
               customer.setLastName(newCustomer.getLastName());
               return repository.save(customer);
           })
                .orElseGet(()->{
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id){
        repository.deleteById(id);
    }

}
