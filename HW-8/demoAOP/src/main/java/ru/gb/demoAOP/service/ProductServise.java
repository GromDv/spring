package ru.gb.demoAOP.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.demoAOP.aspects.LoggedExecution;
import ru.gb.demoAOP.domen.Product;
import ru.gb.demoAOP.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServise {
    private final ProductRepository productRepository;

    /**
     * Метод получения списка товаров
     * @return
     */
    @LoggedExecution
    public List<Product> showListProducts() {
        return productRepository.findAll();
    }
}
