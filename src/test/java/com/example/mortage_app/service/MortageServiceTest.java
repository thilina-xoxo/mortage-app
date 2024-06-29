package com.example.mortage_app.service;

import com.example.mortage_app.models.Mortgage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.mortage_app.repository.MortgageRepository;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MortageServiceTest {

    @InjectMocks
    private MortgageService mortgageService;

    @Mock
    private MortgageRepository mortgageRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMortgages() {
        Mortgage mortgage1 = new Mortgage();
        mortgage1.setId(1L);
        mortgage1.setBorrowerName("John Doe");
        mortgage1.setLoanAmount(new BigDecimal("250000"));
        mortgage1.setInterestRate(3.5);
        mortgage1.setTermYears(30);

        Mortgage mortgage2 = new Mortgage();
        mortgage2.setId(2L);
        mortgage2.setBorrowerName("Jane Smith");
        mortgage2.setLoanAmount(new BigDecimal("150000"));
        mortgage2.setInterestRate(2.8);
        mortgage2.setTermYears(15);

        when(mortgageRepository.findAll()).thenReturn(Arrays.asList(mortgage1, mortgage2));

        List<Mortgage> result = mortgageService.getAllMortgages();
        assertEquals(2, result.size());
        verify(mortgageRepository, times(1)).findAll();
    }

    @Test
    void testGetMortgageById() {
        Mortgage mortgage = new Mortgage();
        mortgage.setId(1L);
        mortgage.setBorrowerName("John Doe");
        mortgage.setLoanAmount(new BigDecimal("250000"));
        mortgage.setInterestRate(3.5);
        mortgage.setTermYears(30);

        when(mortgageRepository.findById(1L)).thenReturn(Optional.of(mortgage));

        Mortgage result = mortgageService.getMortgageById(1L);
        assertEquals("John Doe", result.getBorrowerName());
        verify(mortgageRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveMortgage() {
        Mortgage mortgage = new Mortgage();
        mortgage.setBorrowerName("Jane Doe");
        mortgage.setLoanAmount(new BigDecimal("200000"));
        mortgage.setInterestRate(2.5);
        mortgage.setTermYears(20);

        when(mortgageRepository.save(any(Mortgage.class))).thenReturn(mortgage);

        Mortgage result = mortgageService.saveMortgage(mortgage);
        assertEquals("Jane Doe", result.getBorrowerName());
        verify(mortgageRepository, times(1)).save(mortgage);
    }

    @Test
    void testDeleteMortgage() {
        Long mortgageId = 1L;

        doNothing().when(mortgageRepository).deleteById(mortgageId);

        mortgageService.deleteMortgage(mortgageId);
        verify(mortgageRepository, times(1)).deleteById(mortgageId);
    }

}
