package com.example.Prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Prueba.entity.Historical;
import com.example.Prueba.repository.IHistorialRepository;

@Service
public class HistoricalService {

    @Autowired
    private IHistorialRepository historialRepository;

    @Transactional(readOnly = true)
    public List<Historical> findAllHistoricals() {
        return historialRepository.findAllOrdered();
    }

    @Transactional(readOnly = true)
    public Historical findHistoricalById(long id) {
        return historialRepository.findById(id).get();
    }

    @Transactional
    public boolean saveHistorical(Historical obj) {
        return historialRepository.save(obj) != null;
    }

    @Transactional
    public boolean deleteHistorical(long id) {
        Historical tmp = findHistoricalById(id);
        if (tmp != null) {
            historialRepository.delete(tmp);
            return true;
        }
        return false;
    }
    
}
