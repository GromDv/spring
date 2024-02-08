package ru.gb.demoAOP.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTO {
    private Long fromAccountId;
    private BigDecimal amount;
}
