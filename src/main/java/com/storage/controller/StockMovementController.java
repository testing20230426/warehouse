package com.storage.controller;

import com.storage.dto.ProductDto;
import com.storage.dto.ProductMapper;
import com.storage.dto.StockMovementDto;
import com.storage.dto.StockMovementMapper;
import com.storage.entity.Product;
import com.storage.entity.StockMovement;
import com.storage.service.ProductService;
import com.storage.service.StockMovementService;
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

@Path("/stock_movements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class StockMovementController {

    @Inject
    StockMovementService stockMovementService;

    @Inject
    StockMovementMapper stockMovementMapper;

    @GET
    public Response getProduct(@QueryParam("productId") Long productId){
        List<StockMovement> stockMovementList = stockMovementService.getStockMovementForId(productId);
        List<StockMovementDto> stockMovementDtos = stockMovementMapper.stockMovementListToStockMovementDtoList(stockMovementList);
        return Response.ok(stockMovementDtos).build();
    }

//    @POST
//    @Transactional
//    public Response addStockMovement(@Valid ProductDto productDto, @Context UriInfo uriInfo){
//        Product product = productMapper.productDtoToProduct(productDto);
//        Product productSaved = productService.save(product);
//        URI uri = uriInfo.getAbsolutePathBuilder().path(productSaved.getId().toString()).build();
//        return Response.created(uri).build();
//    }

}
