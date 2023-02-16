package com.example.Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.entity.ProductCategory;
import com.example.Prueba.service.ProductCategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping()
    public List<ProductCategory> findAllProductCategories() {
        return categoryService.findAllProductCategories();
    }

    @GetMapping("/{id}")
    public ProductCategory findProductCategoryById(@PathVariable("id") long id){
        return categoryService.findProductCategoryById(id);
    }

    @GetMapping("/actives")
    public List<ProductCategory> findAllActives() {
        return categoryService.findAllActives();
    }

    @PostMapping()
    public boolean saveProductCategory(@RequestBody ProductCategory obj) {
        return categoryService.saveProductCategory(obj);
    }

    @PostMapping("/return")
    public ProductCategory saveProductCategoryReturn(@RequestBody ProductCategory obj) {
        return categoryService.saveProductCategoryReturn(obj);
    }

    @PutMapping()
    public boolean updateProductCategory(@RequestBody ProductCategory obj) {
        return categoryService.updateProductCategory(obj);
    }
    

    @PutMapping("/deactivate")
    public void deactivateCategory(@RequestBody long id) {
        categoryService.deactivateCategory(id);
    }

    @PutMapping("/activate")
    public void activateCategory(@RequestBody long id) {
        categoryService.activateCategory(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductCategory(@PathVariable("id") long id) {
        return categoryService.deleteProductCategory(id);
    }
    
}
