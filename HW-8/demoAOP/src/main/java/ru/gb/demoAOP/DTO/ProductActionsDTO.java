package ru.gb.demoAOP.DTO;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class ProductActionsDTO {
    private Long userId;
    private Long productId;
    private int quantity;
    private String type;
}

