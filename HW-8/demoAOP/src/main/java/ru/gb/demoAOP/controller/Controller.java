package ru.gb.demoAOP.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.demoAOP.DTO.MoneyActionsDTO;
import ru.gb.demoAOP.DTO.PaymentDTO;
import ru.gb.demoAOP.DTO.ProductActionsDTO;
import ru.gb.demoAOP.domen.MoneyTransaction;
import ru.gb.demoAOP.domen.Product;
import ru.gb.demoAOP.domen.ProductTransactions;
import ru.gb.demoAOP.domen.User;
import ru.gb.demoAOP.service.MoneyActionService;
import ru.gb.demoAOP.service.ProductActionService;
import ru.gb.demoAOP.service.ProductServise;
import ru.gb.demoAOP.service.UserService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private final ProductActionService prodActionService;
    private final ProductServise productServise;
    private final UserService userService;
    private final MoneyActionService moneyActionService;

    /**
     * Обработка запроса на вывод пользователей и их аккаунтов
     *
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> showListUsers() {
        return ResponseEntity.ok().body(userService.showUsers());
    }

    /**
     * Обработка запроса на вывод списка продуктов
     *
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> showListProducts() {
        return ResponseEntity.ok().body(productServise.showListProducts());
    }

    /**
     * Обработка запроса на оплату (оплата - это перевод денег на счет админа магазина)
     *
     * @param request {
     *                "fromAccountId": 3,
     *                "amount": 100
     *                }
     * @return
     */
    @PostMapping("/payment")
    public ResponseEntity<?> actionTransferMoney(@RequestBody PaymentDTO request) {
        MoneyActionsDTO transfer = new MoneyActionsDTO();
        transfer.setFromAccountId(request.getFromAccountId());
        // оплата - зто перевод на счет магазина, id = 1
        transfer.setToAccountId(1L);
        transfer.setAmount(request.getAmount());
        moneyActionService.TransferMoney(transfer);
        return ResponseEntity.ok().build();
    }

    /**
     * Обработка запроса на вывод списка резервов
     *
     * @return
     */
    @GetMapping("/reserves")
    public ResponseEntity<List<ProductTransactions>> showReserves() {
        return ResponseEntity.ok().body(prodActionService.showProdTranfers());
    }

    /**
     * Обработка запроса по созданию резерва
     *
     * @param request {
     *                "userId": 3,
     *                "productId": 1,
     *                "quantity": 10,
     *                "type":"order"
     *                }
     * @return
     */
    @PostMapping("/reserve")
    public ResponseEntity<?> makeReserve(@RequestBody ProductActionsDTO request) {
        prodActionService.reserveProductForUser(request);
        return ResponseEntity.ok().build();
    }
}
