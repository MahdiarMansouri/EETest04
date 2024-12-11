package org.example.eetest04.api;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.eetest04.model.Customer;
import org.example.eetest04.model.Invoice;
import org.example.eetest04.model.InvoiceItem;
import org.example.eetest04.model.Product;
import org.example.eetest04.service.CustomerService;
import org.example.eetest04.service.InvoiceService;
import org.example.eetest04.service.ProductService;

@Slf4j
@Path("/test")
public class TestApi {
    @Inject
    private ProductService productService;

    @Inject
    private InvoiceService invoiceService;

    @Inject
    private CustomerService customerService;

    @GET
    public String test() throws Exception {
        Product p1 = Product.builder().name("p1").build();
        Product p2 = Product.builder().name("p2").build();
        Product p3 = Product.builder().name("p3").build();

        productService.saveAll(p1, p2, p3);
        log.info("Products Saved");

        Customer customer = Customer.builder().name("customer").build();
        customerService.save(customer);
        log.info("Customers Saved");

        InvoiceItem item1 = InvoiceItem.builder().product(p1).quantity(5).price(2000).build();
        InvoiceItem item2 = InvoiceItem.builder().product(p2).quantity(4).price(6000).build();
        InvoiceItem item3 = InvoiceItem.builder().product(p3).quantity(3).price(7500).build();
        log.info("InvoiceItems Saved");

        Invoice invoice = Invoice
                .builder()
                .customer(customer)
                .discount(2500)
                .build();
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);
        invoiceService.save(invoice);
        log.info("Invoices Saved");

        return String.valueOf(invoice.getNetPrice());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInvoice(@PathParam("id") Long id) throws Exception {
        return Response.ok(invoiceService.findById(id)).build();
    }
}

