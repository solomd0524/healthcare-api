package com.simplilearn.healthcareapi.users;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "emailAddress", source = "emailAddress")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "isAdmin", source = "isAdmin")
    User map(UserProjection source);

    default List<User> map(List<UserProjection> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }
}