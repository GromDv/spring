package ru.gb.demoAOP.domen;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Сущность "денежный перевод"
 */
@Data
@Entity
@Table(name = "money_actions")
public class MoneyTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private BigDecimal amount;
}
