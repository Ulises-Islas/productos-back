package com.example.Prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Prueba.entity.Historical;
import com.example.Prueba.entity.Product;
import com.example.Prueba.repository.IHistorialRepository;
import com.example.Prueba.repository.IProductRepository;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IHistorialRepository historialRepository;

    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findProductById(long id) {
        return productRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Product> findProductsByCategory(long id){
        return productRepository.findProductsByCategory(id);
    }

    @Transactional
    public boolean saveProduct(Product obj) {
        Product tmp = productRepository.save(obj);
        Historical hTmp = new Historical();
        hTmp.setProduct(tmp);
        hTmp.setAction("Registro");
        historialRepository.save(hTmp);
        return tmp != null;
    }

    @Transactional
    public boolean updateProduct(Product obj) {
        Product tmp = productRepository.save(obj);
        Historical hTmp = new Historical();
        hTmp.setProduct(tmp);
        hTmp.setAction("Actualización");
        historialRepository.save(hTmp);
        return tmp != null;
    }

    @Transactional
    public void deactivateProduct(long id) {
        productRepository.deactivateProduct(id);
        Historical hTmp = new Historical();
        hTmp.setProduct(findProductById(id));
        hTmp.setAction("Inhabilitación");
        historialRepository.save(hTmp);
    }

    @Transactional
    public void activateProduct(long id) {
        productRepository.activateProduct(id);
        Historical hTmp = new Historical();
        hTmp.setProduct(findProductById(id));
        hTmp.setAction("Habilitación");
        historialRepository.save(hTmp);
    }

    @Transactional
    public boolean deleteProduct(long id) {
        Product tmp = findProductById(id);
        if (tmp != null) {
            productRepository.delete(tmp);
            return true;
        }
        return false;
    }
    
}
