package com.simplilearn.healthcareapi.medicine;

import com.simplilearn.healthcareapi.medicine.exceptions.MedicineByNameNotFoundException;
import com.simplilearn.healthcareapi.medicine.exceptions.MedicineForUsesNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineService {

    MedicineRepository medicineRepository;

    MedicineMapper medicineMapper;

    public List<Medicine> findMedicineByName(String medicineName) {
        return medicineMapper.MAPPER.map(medicineRepository.findMedicineByName(medicineName)
                .orElseThrow(() -> new MedicineByNameNotFoundException(medicineName)));
    }

    public List<Medicine> findMedicineByUses(String uses) {
        return medicineMapper.MAPPER.map(medicineRepository.findMedicineByUses(uses)
                .orElseThrow(() -> new MedicineForUsesNotFoundException(uses)));
    }
}
