package com.storage.controller;

import com.storage.dto.StockMovementDto;
import com.storage.dto.StockMovementMapper;
import com.storage.entity.StockMovement;
import com.storage.service.StockMovementService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    @Transactional
    public Response getProduct(@QueryParam("productId") Long productId) {
        List<StockMovement> stockMovementList = stockMovementService.getStockMovementForId(productId);
        List<StockMovementDto> stockMovementDtos = stockMovementMapper.stockMovementListToStockMovementDtoList(stockMovementList);
        return Response.ok(stockMovementDtos).build();
    }

}
