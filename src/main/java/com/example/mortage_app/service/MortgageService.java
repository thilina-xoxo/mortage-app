package com.example.mortage_app.service;

import com.example.mortage_app.models.Mortgage;
import com.example.mortage_app.repository.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageService {
    @Autowired
    private MortgageRepository mortgageRepository;

    public List<Mortgage> getAllMortgages() {
        return mortgageRepository.findAll();
    }

    public Mortgage getMortgageById(Long id) {
        return mortgageRepository.findById(id).orElse(null);
    }

    public Mortgage saveMortgage(Mortgage mortgage) {
        return mortgageRepository.save(mortgage);
    }

    public void deleteMortgage(Long id) {
        mortgageRepository.deleteById(id);
    }
}

