package org.example.eetest04.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.example.eetest04.model.Product;
import org.example.eetest04.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class ProductService {
    public void saveAll(Product ... product) throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            for (Product p : product) {
                repository.save(p);
            }
        }
    }


    public void save(Product product) throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            repository.save(product);
        }
    }

    public void update(Product product) throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            repository.update(product);
        }
    }


    public void delete(Long id) throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            repository.delete(id, Product.class);
        }
    }


    public List<Product> findAll() throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            return repository.findAll(Product.class);
        }
    }

    public Product findById(Long id) throws Exception {
        try(CrudRepository<Product, Long> repository = new CrudRepository<>()){
            return repository.findById(id, Product.class);
        }
    }
}