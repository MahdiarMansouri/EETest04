package org.example.eetest04.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.eetest04.model.Customer;
import org.example.eetest04.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    public void save(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            repository.save(customer);
        }
    }

    public void update(Customer customer) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            repository.update(customer);
        }

    }

    public void delete(Long id) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            repository.delete(id, Customer.class);
        }

    }

    public List<Customer> findAll() throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.findAll(Customer.class);
        }
    }

    public Customer findById(Long id) throws Exception {
        try (CrudRepository<Customer, Long> repository = new CrudRepository<>()) {
            return repository.findById(id, Customer.class);
        }
    }
}
