package com.example.Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.entity.Historical;
import com.example.Prueba.service.HistoricalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/historical")
public class HistoricalController {

    @Autowired
    private HistoricalService historicalService;

    @GetMapping()
    public List<Historical> findAll() {
        return historicalService.findAllHistoricals();
    }

    @GetMapping("/{id}")
    public Historical findById(@PathVariable("id") long id) {
        return historicalService.findHistoricalById(id);
    }

    @PostMapping()
    public boolean save(@RequestBody Historical obj) {
        return historicalService.saveHistorical(obj);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return historicalService.deleteHistorical(id);
    }
    
}
