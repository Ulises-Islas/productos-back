package com.example.Prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Prueba.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "UPDATE product p SET p.is_active=false WHERE p.id=:id", nativeQuery= true)
    void deactivateProduct(@Param("id")long id);

    @Modifying
    @Query(value = "UPDATE product p SET p.is_active=true WHERE p.id=:id", nativeQuery= true)
    void activateProduct(@Param("id")long id);

    @Query(value = "SELECT * FROM product p WHERE p.category = :id", nativeQuery = true)
    List<Product> findProductsByCategory(@Param("id") long id);
    
}
