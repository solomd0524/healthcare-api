package com.simplilearn.healthcareapi.medicine;

import com.simplilearn.healthcareapi.medicine.exceptions.MedicineForUsesNotFoundException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MedicineService.class})
@Tag("UnitTest")
class MedicineServiceTest {

    @Autowired
    private MedicineService medicineService;

    @MockBean
    private MedicineRepository medicineRepository;

    @MockBean
    private MedicineMapper medicineMapper;

    private static final String USES = "Pain Management";
    private static final Medicine medicine = new MedicineStub();
    private static final List<Medicine> medicineList = Collections.singletonList(medicine);
    private static final MedicineProjectionStub medicineProjection = new MedicineProjectionStub();
    private static final List<MedicineProjection> medicineProjectionList = Collections.singletonList(medicineProjection);

    @Test
    void whenFindMedicineByUses_thenReturnMedicine() {

        given(medicineRepository.findMedicineByUses(anyString())).willReturn(Optional.of(medicineProjectionList));
        given(medicineMapper.map(medicineProjectionList)).willReturn(medicineList);
        List<Medicine> result = medicineService.findMedicineByUses(USES);

        assertThat(result).isNotNull();
        assertThat(result.get(0)).isNotNull();
        assertThat(result.get(0).getMedicineId()).isEqualTo(1L);

        verify(medicineRepository, times(1)).findMedicineByUses(anyString());
    }

    @Test
    void whenGetOrdersByUserId_whereNoOrderIsFound_thenThrowEntityNotFoundException() {
        given(medicineRepository.findMedicineByUses(anyString())).willReturn(Optional.empty());
        assertThrows(MedicineForUsesNotFoundException.class, () -> medicineService.findMedicineByUses(USES));
    }
}