package com.simplilearn.healthcareapi.accounts;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AccountMapper {

    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "accountName", source = "accountName")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "fundsAvailable", source = "fundsAvailable")
    Account map(AccountProjection source);
}

