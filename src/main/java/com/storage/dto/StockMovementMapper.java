package com.storage.dto;

import com.storage.entity.StockMovement;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "cdi")
public interface StockMovementMapper {

    @InheritInverseConfiguration
    StockMovement stockMovementDtoToStockMovement(StockMovementDto stockMovementDto);

    @Mapping(source = "noOfUnits", target = "stockUnits")
    @Mapping(source = "operationDate", target = "stockOperationDate")
   // @Mapping(source = "product", target = "")
    StockMovementDto stockMovementToStockMovementDto(StockMovement stockMovement);

    List<StockMovementDto> stockMovementListToStockMovementDtoList(List<StockMovement> stockMovementList);

}
