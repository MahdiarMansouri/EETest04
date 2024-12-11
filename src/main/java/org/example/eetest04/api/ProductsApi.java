package org.example.eetest04.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.eetest04.model.Product;
import org.example.eetest04.service.ProductService;

@Slf4j
@Path("/products")
public class ProductsApi {
    @Inject
    private ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() throws Exception {
        log.info("getProducts");
        return Response.ok().entity(productService.findAll()).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getProductById(@PathParam("id") long id) throws Exception {
        log.info("getProductById");
        return Response.ok().entity(productService.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) throws Exception {
        log.info("addProduct");
        productService.save(product);
        return Response.ok().entity(product).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) throws Exception {
        log.info("updateProduct");
        productService.update(product);
        return Response.ok().entity(product).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") long id) throws Exception {
        log.info("deleteProduct");
        productService.delete(id);
        return Response.ok().entity(productService.findById(id)).build();
    }
}
