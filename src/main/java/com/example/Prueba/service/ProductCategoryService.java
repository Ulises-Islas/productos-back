package com.example.Prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Prueba.entity.Historical;
import com.example.Prueba.entity.ProductCategory;
import com.example.Prueba.repository.IHistorialRepository;
import com.example.Prueba.repository.IProductCategoryRepository;

@Service
public class ProductCategoryService {

    @Autowired
    private IProductCategoryRepository productCategoryRepository;
    @Autowired
    private IHistorialRepository historialRepository;

    @Transactional(readOnly = true)
    public List<ProductCategory> findAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ProductCategory findProductCategoryById(long id) {
        return productCategoryRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<ProductCategory> findAllActives() {
        return productCategoryRepository.findAllActives();
    }

    @Transactional
    public boolean saveProductCategory(ProductCategory obj) {
        ProductCategory tmp = productCategoryRepository.save(obj);
        Historical hTmp = new Historical();
        hTmp.setCategory(tmp);
        hTmp.setAction("Registro");
        historialRepository.save(hTmp);
        return tmp != null;
    }

    @Transactional
    public ProductCategory saveProductCategoryReturn(ProductCategory obj) {
        ProductCategory tmp = productCategoryRepository.save(obj);
        Historical hTmp = new Historical();
        hTmp.setCategory(tmp);
        hTmp.setAction("Registro - Productos");
        historialRepository.save(hTmp);
        return tmp;
    }

    @Transactional
    public boolean updateProductCategory(ProductCategory obj) {
        ProductCategory tmp = productCategoryRepository.save(obj);
        Historical hTmp = new Historical();
        hTmp.setCategory(tmp);
        hTmp.setAction("Actualización");
        historialRepository.save(hTmp);
        return tmp != null;
    }

    @Transactional
    public void deactivateCategory(long id) {
        productCategoryRepository.deactivateCategory(id);
        productCategoryRepository.deactivateCategoryProducts(id);
        Historical hTmp = new Historical();
        hTmp.setCategory(findProductCategoryById(id));
        hTmp.setAction("Inhabilitación");
        historialRepository.save(hTmp);
    }

    @Transactional
    public void activateCategory(long id) {
        productCategoryRepository.activateCategory(id);
        Historical hTmp = new Historical();
        hTmp.setCategory(findProductCategoryById(id));
        hTmp.setAction("Habilitación");
        historialRepository.save(hTmp);
    }

    @Transactional
    public boolean deleteProductCategory(long id) {
        ProductCategory tmp = findProductCategoryById(id);
        if (tmp != null) {
            productCategoryRepository.delete(tmp);
            return true;
        }
        return false;
    }

}
