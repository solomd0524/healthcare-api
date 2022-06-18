package com.simplilearn.healthcareapi.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "select a.accountId as accountId, " +
            "              a.accountNumber as accountNumber, " +
            "              a.accountName as accountName, " +
            "              a.userId as userId, " +
            "              a.fundsAvailable as fundsAvailable " +
            "         from AccountEntity a " +
            "        where a.userId = :userId")
    Optional<AccountProjection> getAccountByUserId(Long userId);
}
