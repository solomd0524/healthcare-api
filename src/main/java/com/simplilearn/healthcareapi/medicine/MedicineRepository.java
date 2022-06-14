package com.simplilearn.healthcareapi.medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {

    @Query(value = "select m.medicineId as medicineId, " +
            "              m.medicineName as medicineName, " +
            "              m.manufacturer as manufacturer, " +
            "              m.price as price, " +
            "              m.quantity as quantity, " +
            "              m.discount as discount, " +
            "              m.uses as uses, " +
            "              m.expirationDate as expirationDate " +
            "         from MedicineEntity m " +
            "        where m.uses = :uses")
    List<MedicineProjection> findMedicineByUses(String uses);
}