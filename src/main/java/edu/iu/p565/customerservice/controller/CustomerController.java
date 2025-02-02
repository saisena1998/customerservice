package edu.iu.p565.customerservice.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository repository;
    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    //Post localhost:8080/customers
    @PostMapping
    public int create (@Valid  @RequestBody Customer customer){
        return repository.create(customer);
    }
    @PutMapping("/{id}")
    public void update (@Valid @RequestBody Customer customer,@PathVariable int id){
        repository.update(customer,id);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable int id){
        repository.delete(id);
    }

}
