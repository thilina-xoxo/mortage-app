package com.example.mortage_app.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MortgageDTO {

    private Long id;
    private String borrowerName;
    private BigDecimal loanAmount;
    private Double interestRate;
    private Integer termYears;

}
