package com.simplilearn.healthcareapi.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = "select o.orderId as orderId, " +
            "              o.orderNumber as orderNumber, " +
            "              m.medicineId as medicineId, " +
            "              m.medicineName as medicineName, " +
            "              o.orderQty as orderQty, " +
            "              o.total as total, " +
            "              o.status as status " +
            "         from OrderEntity o " +
            "         join MedicineEntity m on m.medicineId = o.medicineId " +
            "        where o.userId= :userId")
    List<OrderProjection> findOrdersByUserId(Long userId);
}
