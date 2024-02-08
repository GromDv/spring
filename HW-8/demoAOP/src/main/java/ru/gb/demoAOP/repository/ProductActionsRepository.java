package ru.gb.demoAOP.repository;


import org.springframework.stereotype.Repository;
import ru.gb.demoAOP.domen.ProductTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductActionsRepository extends JpaRepository<ProductTransactions, Long> {
    List<ProductTransactions> findByProductId(Long id);

    List<ProductTransactions> findAllByProductIdAndUserId(Long prodId, Long userId);
}
