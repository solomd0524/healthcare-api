package com.simplilearn.healthcareapi.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    @Query(value = "select c.id as id, " +
            "              u.userId as userId, " +
            "              u.firstName as firstName, " +
            "              u.lastName as lastName, " +
            "              u.address as address, " +
            "              m.medicineId as medicineId, " +
            "              m.medicineName as medicineName, " +
            "              m.price as price, " +
            "              c.quantityOrdered as quantityOrdered, " +
            "              m.discount as discount, " +
            "              m.price * c.quantityOrdered * (1-m.discount) as subTotal" +
            "         from CartEntity c " +
            "         join MedicineEntity m on m.medicineId = c.medicineId" +
            "         join UserEntity u on u.userId = c.userId" +
            "        where c.userId = :userId")
    Optional<CartProjection> getCartByUserId(Long userId);
}
