package com.simplilearn.healthcareapi.medicine;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MedicineController {
    MedicineRepository medicineRepository;
    MedicineService medicineService;

    @GetMapping(value = "/api/user/medicines")
    public Iterable<MedicineEntity> findAllMedicine() {
        return medicineRepository.findAll();
    }

    @GetMapping(value = "/api/user/medicines", params = {"uses"})
    public List<Medicine> findMedicineForUses(@RequestParam("uses") String uses) {
        return medicineService.findMedicineByUses(uses);
    }

    @PostMapping(value = "/api/admin/medicines")
    public MedicineEntity addMedicine(@RequestBody MedicineEntity medicine) {
        return medicineRepository.save(medicine);
    }

    @PutMapping(value = "/api/admin/medicines")
    public MedicineEntity updateMedicine(@RequestBody MedicineEntity medicine) {
        return medicineRepository.save(medicine);
    }

    @DeleteMapping(value = "/api/admin/medicines")
    public void deleteMedicine(@RequestBody MedicineEntity medicine) {
        medicineRepository.delete(medicine);
    }
}
