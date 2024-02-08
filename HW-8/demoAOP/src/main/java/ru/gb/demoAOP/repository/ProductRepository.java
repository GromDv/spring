package ru.gb.demoAOP.repository;

import org.springframework.stereotype.Repository;
import ru.gb.demoAOP.domen.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);

}
