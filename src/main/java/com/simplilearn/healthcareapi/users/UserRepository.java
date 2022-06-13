package com.simplilearn.healthcareapi.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              u.emailAddress as emailAddress, " +
            "              u.dateOfBirth as dateOfBirth, " +
            "              u.userName as userName, " +
            "              u.password as password " +
            "         from UserEntity u " +
            "        where u.userId= :userId")
    Optional<UserProjection> getUserByUserId(Long userId);

    @Query(value = "select u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              u.emailAddress as emailAddress, " +
            "              u.dateOfBirth as dateOfBirth, " +
            "              u.userName as userName, " +
            "              u.password as password " +
            "         from UserEntity u " +
            "        where u.userName= :userName and u.password= :password")
    Optional<UserProjection> getUserByUserNameAndPassword(String userName, String password);

    @Query(value = "select u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              u.emailAddress as emailAddress, " +
            "              u.dateOfBirth as dateOfBirth, " +
            "              u.userName as userName, " +
            "              u.password as password " +
            "         from UserEntity u " +
            "        where u.userName= :userName ")
    Optional<List<UserProjection>> getUserByUserName(String userName);
}
