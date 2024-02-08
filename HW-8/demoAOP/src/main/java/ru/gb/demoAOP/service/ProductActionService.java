package ru.gb.demoAOP.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.demoAOP.DTO.ProductActionsDTO;
import ru.gb.demoAOP.aspects.TimeLoggedExecution;
import ru.gb.demoAOP.domen.Product;
import ru.gb.demoAOP.domen.ProductTransactions;
import ru.gb.demoAOP.domen.User;
import ru.gb.demoAOP.repository.ProductActionsRepository;
import ru.gb.demoAOP.repository.ProductRepository;
import ru.gb.demoAOP.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductActionService {
    private final UserRepository userRepo;
    private final ProductRepository prodRepo;
    private final ProductActionsRepository prodActionsRepo;

    /**
     * Главный метод резервирования товара за пользователем
     *
     * @param order
     */
    @TimeLoggedExecution
    public void reserveProductForUser(ProductActionsDTO order) {
        User customer = userRepo.findById(order.getUserId()).orElse(null);
        Product product = prodRepo.findById(order.getProductId()).orElse(null);

        if (customer != null && product != null && product.getQuantity() > order.getQuantity()) {
            List<ProductTransactions> prevTranferList = findProdTransferByProductIdAndUserId(order.getProductId(), order.getUserId());
            if (prevTranferList.isEmpty()) {
                makeReserve(order, product);
            }
        }
    }

    /**
     * Метод только резервирует товар (выделен для транзакции)
     *
     * @param order
     * @param product
     */
    @Transactional
    void makeReserve(ProductActionsDTO order, Product product) {
        ProductTransactions transaction = new ProductTransactions();
        transaction.setProductId(order.getProductId());
        transaction.setUserId(order.getUserId());
        transaction.setQuantity(order.getQuantity());
        transaction.setType(order.getType());
        prodActionsRepo.save(transaction);
        product.setQuantity(product.getQuantity() - order.getQuantity());
        prodRepo.save(product);
    }

    public List<ProductTransactions> showProdTranfers() {
        return prodActionsRepo.findAll();
    }

    List<ProductTransactions> findProdTransferByProductId(Long id) {
        return prodActionsRepo.findByProductId(id).stream().toList();
    }

    List<ProductTransactions> findProdTransferByProductIdAndUserId(Long prodId, Long userId) {
        return prodActionsRepo.findAllByProductIdAndUserId(prodId, userId);
    }
}
