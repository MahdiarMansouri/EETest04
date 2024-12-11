package org.example.eetest04.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.example.eetest04.model.Invoice;
import org.example.eetest04.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class InvoiceService {
    public void save(Invoice invoice) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            repository.save(invoice);
        }
    }

    public void update(Invoice invoice) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            repository.update(invoice);
        }
    }


    public void delete(Long id) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            repository.delete(id, Invoice.class);
        }
    }


    public List<Invoice> findAll() throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.findAll(Invoice.class);
        }
    }

    public Invoice findById(Long id) throws Exception {
        try(CrudRepository<Invoice, Long> repository = new CrudRepository<>()){
            return repository.findById(id, Invoice.class);
        }
    }
}
