package com.example.mortage_app.controllers;

import com.example.mortage_app.dto.MortgageDTO;
import com.example.mortage_app.models.Mortgage;
import com.example.mortage_app.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<MortgageDTO> getMortgageById(@PathVariable Long id) {
        Optional<MortgageDTO> mortgage = mortgageService.getMortgageById(id);
        return mortgage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MortgageDTO> createMortgage(@RequestBody MortgageDTO mortgageDTO) {
        MortgageDTO savedMortgage = mortgageService.saveMortgage(mortgageDTO);
        return ResponseEntity.ok(savedMortgage);
    }


    @DeleteMapping("/{id}")
    public void deleteMortgage(@PathVariable Long id) {
        mortgageService.deleteMortgage(id);
    }
}
