package com.example.mortage_app.controllers;

import com.example.mortage_app.models.Mortgage;
import com.example.mortage_app.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mortgages")
public class MortgageController {

    @Autowired
    private MortgageService mortgageService;

    @GetMapping
    public List<Mortgage> getAllMortgages() {
        return mortgageService.getAllMortgages();
    }

    @GetMapping("/{id}")
    public Mortgage getMortgageById(@PathVariable Long id) {
        return mortgageService.getMortgageById(id);
    }

    @PostMapping
    public Mortgage createMortgage(@RequestBody Mortgage mortgage) {
        return mortgageService.saveMortgage(mortgage);
    }

    @DeleteMapping("/{id}")
    public void deleteMortgage(@PathVariable Long id) {
        mortgageService.deleteMortgage(id);
    }
}
