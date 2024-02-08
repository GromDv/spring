package ru.gb.demoAOP.domen;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Сущность "резервирование товара"
 */
@Data
@Entity
@Table(name = "product_actions")
public class ProductTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    private int quantity;

    @Column(name = "type_tr")
    private String type;
}
