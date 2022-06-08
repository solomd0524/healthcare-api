package com.simplilearn.healthcareapi.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    @Query(value = "select u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              u.emailAddress as emailAddress, " +
            "              u.dateOfBirth as dateOfBirth, " +
            "              u.accountId as accountId, " +
            "              u.userName as userName, " +
            "              u.password as password, " +
            "              u.isAdmin as isAdmin" +
            "         from UserEntity u " +
            "        where u.userName= :userName and u.password= :password")
    Optional<UserProjection> getUserByUserNameAndPassword(String userName, String password);

    @Query(value = "select u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              u.emailAddress as emailAddress, " +
            "              u.dateOfBirth as dateOfBirth, " +
            "              u.accountId as accountId, " +
            "              u.fundsAvailable as fundsAvailable," +
            "              u.userName as userName, " +
            "              u.password as password, " +
            "              u.isAdmin as isAdmin" +
            "         from UserEntity u " +
            "        where u.userName= :userName ")
    List<UserProjection> getUserByUserName(String userName);
}
