package com.example.Prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Prueba.entity.Historical;

public interface IHistorialRepository extends JpaRepository<Historical, Long> {

    @Query(value = "SELECT * FROM historical h ORDER BY h.id DESC", nativeQuery = true)
    public List<Historical> findAllOrdered();
    
}
