package com.example.Prueba.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Temporal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;

@Table(name = "historical")
@Entity
public class Historical implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action", nullable = false, length = 45)
    private String action;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category")
    private ProductCategory category;

    @Column(name = "action_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;

    public Historical() {
        this.actionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    
}
