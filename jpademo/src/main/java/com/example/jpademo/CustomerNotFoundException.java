package com.example.jpademo;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long id){
        super("Could not find customer "+id);
    }
}
