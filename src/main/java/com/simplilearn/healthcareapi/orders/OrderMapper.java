package com.simplilearn.healthcareapi.orders;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderMapper {

    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "medicineId", source = "medicineId")
    @Mapping(target = "medicineName", source = "medicineName")
    @Mapping(target = "orderNumber", source = "orderNumber")
    @Mapping(target = "orderQty", source = "orderQty")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "status", source = "status")
    Order map(OrderProjection source);

    default List<Order> map(List<OrderProjection> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}