package com.example.Prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Prueba.entity.ProductCategory;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    
    @Modifying
    @Query(value = "UPDATE product_category pc SET pc.is_active=false WHERE pc.id=:id", nativeQuery= true)
    void deactivateCategory(@Param("id")long id);

    @Modifying
    @Query(value = "UPDATE product_category pc SET pc.is_active=true WHERE pc.id=:id", nativeQuery= true)
    void activateCategory(@Param("id")long id);

    @Modifying
    @Query(value = "UPDATE product p SET p.is_active=false WHERE p.category=:id", nativeQuery = true)
    void deactivateCategoryProducts(@Param("id") long id);

    @Query(value = "SELECT * FROM product_category pc WHERE pc.is_active = true", nativeQuery = true)
    List<ProductCategory> findAllActives();

}
