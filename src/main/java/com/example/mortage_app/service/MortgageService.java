package com.example.mortage_app.service;

import com.example.mortage_app.dto.MortgageDTO;
import com.example.mortage_app.models.Mortgage;
import com.example.mortage_app.repository.MortgageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MortgageService {
    @Autowired
    private MortgageRepository mortgageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Mortgage> getAllMortgages() {
        return mortgageRepository.findAll();
    }

    public Optional<MortgageDTO> getMortgageById(Long id) {
        Optional<Mortgage> mortgage = mortgageRepository.findById(id);
        return mortgage.map(m -> modelMapper.map(m, MortgageDTO.class));
    }


    public MortgageDTO saveMortgage(MortgageDTO mortgageDTO) {
        Mortgage mortgage = modelMapper.map(mortgageDTO, Mortgage.class);
        mortgage = mortgageRepository.save(mortgage);
        return modelMapper.map(mortgage, MortgageDTO.class);
    }

    public void deleteMortgage(Long id) {
        mortgageRepository.deleteById(id);
    }
}

