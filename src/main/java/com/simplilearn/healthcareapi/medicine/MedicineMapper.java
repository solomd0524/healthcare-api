package com.simplilearn.healthcareapi.medicine;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MedicineMapper {

    MedicineMapper MAPPER = Mappers.getMapper(MedicineMapper.class);

    @Mapping(target = "medicineId", source = "medicineId")
    @Mapping(target = "medicineName", source = "medicineName")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "discount", source = "discount")
    @Mapping(target = "uses", source = "uses")
    @Mapping(target = "expirationDate", source = "expirationDate")
    Medicine map(MedicineProjection source);

    default List<Medicine> map(List<MedicineProjection> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}