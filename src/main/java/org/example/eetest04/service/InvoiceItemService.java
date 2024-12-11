package org.example.eetest04.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.example.eetest04.model.InvoiceItem;
import org.example.eetest04.repository.CrudRepository;

import java.util.List;

@ApplicationScoped
public class InvoiceItemService {
    public void save(InvoiceItem invoiceItem) throws Exception {
        try(CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
            repository.save(invoiceItem);
        }
    }

    public void update(InvoiceItem invoiceItem) throws Exception {
        try(CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
            repository.update(invoiceItem);
        }
    }


    public void delete(Long id) throws Exception {
        try(CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
            repository.delete(id, InvoiceItem.class);
        }
    }


    public List<InvoiceItem> findAll() throws Exception {
        try(CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
            return repository.findAll(InvoiceItem.class);
        }
    }

    public InvoiceItem findById(Long id) throws Exception {
        try(CrudRepository<InvoiceItem, Long> repository = new CrudRepository<>()){
            return repository.findById(id, InvoiceItem.class);
        }
    }
}