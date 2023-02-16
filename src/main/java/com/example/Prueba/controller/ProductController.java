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

import com.example.Prueba.entity.Product;
import com.example.Prueba.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/category/{id}")
    public List<Product> findProductsByCategory(@PathVariable("id") long id){
        return productService.findProductsByCategory(id);
    }

    @PostMapping()
    public boolean saveProduct(@RequestBody Product obj) {
        return productService.saveProduct(obj);
    }

    @PutMapping()
    public boolean updateProductProduct(@RequestBody Product obj) {
        return productService.updateProduct(obj);
    }

    @PutMapping("/deactivate")
    public void deactivateProduct(@RequestBody long id) {
        productService.deactivateProduct(id);
    }

    @PutMapping("/activate")
    public void activateProduct(@RequestBody long id) {
        productService.activateProduct(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }
    
}
