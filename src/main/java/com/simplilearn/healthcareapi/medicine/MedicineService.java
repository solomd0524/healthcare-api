package com.simplilearn.healthcareapi.medicine;

import com.simplilearn.healthcareapi.medicine.exceptions.MedicineForUsesNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineService {

    MedicineRepository medicineRepository;

    MedicineMapper medicineMapper;

    public List<Medicine> findMedicineByUses(String uses) {
        List<Medicine> medicineList = medicineMapper.MAPPER.map(medicineRepository.findMedicineByUses(uses));
        if (ObjectUtils.isEmpty(medicineList)) throw new MedicineForUsesNotFoundException(uses);
        return medicineList;
    }
}
