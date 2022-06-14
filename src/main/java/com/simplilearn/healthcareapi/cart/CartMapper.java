package com.simplilearn.healthcareapi.cart;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CartMapper {

    CartMapper MAPPER = Mappers.getMapper(CartMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "medicineName", source = "medicineName")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantityOrdered", source = "quantityOrdered")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "subTotal", source = "subTotal")
    Cart map(CartProjection source);
}