package com.storage.controller;

import com.storage.dto.ProductDto;
import com.storage.dto.ProductMapper;
import com.storage.entity.Product;
import com.storage.service.ProductService;
import global.exception.EntityNotFoundException;
import global.exception.WrongUsageException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ProductController {

    @Inject
    ProductService productService;

    @Inject
    ProductMapper productMapper;

    @GET
    public Response getAllProducts(){
        List<ProductDto> productsDtoList = productMapper.productListToProductDtoList(productService.getAllProducts());
        return Response.ok(productsDtoList).build();
    }

    @GET
    @Path("/{productId}")
    public Response getProduct(@PathParam("productId") Long productId){
        Product productFound = productService.findById(productId).orElseThrow(()->new EntityNotFoundException("Product not found"));
        ProductDto productDto = productMapper.productToProductDto(productFound);
        return Response.ok(productDto).build();
    }

    @POST
    @Transactional
    public Response addProduct(@Valid ProductDto productDto, @Context UriInfo uriInfo){
        Product product = productMapper.productDtoToProduct(productDto);
        Product productSaved = productService.save(product);
        URI uri = uriInfo.getAbsolutePathBuilder().path(productSaved.getId().toString()).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("/{productId}")
    @Transactional
    public Response updateProduct(@Valid ProductDto productDto, @PathParam("productId") Long productId){
       if (!Objects.equals(productId, productDto.getId())){
           throw new WrongUsageException("ProductId does not match for update");
       }
       Product productToUpdate = productService.findById(productDto.getId()).orElseThrow(()->new EntityNotFoundException("Product not found"));
       productMapper.updateProductFromProductDto(productDto, productToUpdate);
       productService.save(productToUpdate);
       return Response.status(Response.Status.ACCEPTED).build();
    }

    @DELETE
    @Transactional
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") Long productId){
        Product productToUpdate = productService.findById(productId).orElseThrow(()->new EntityNotFoundException("Product not found"));
        productService.inactivate(productToUpdate);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
