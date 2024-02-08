package ru.gb.demoAOP.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyActionsDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
}
