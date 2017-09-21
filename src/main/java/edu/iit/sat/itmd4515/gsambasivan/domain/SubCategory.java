/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Swathi
 */
@Entity
@Table(name = "subcategory")
@NamedQueries({
    @NamedQuery(name = "SubCategory.findAll", query = "select o from SubCategory o")
    ,
    @NamedQuery(name = "SubCategory.findByName", query = "select o from SubCategory o where o.categoryName = :categoryName")
})
public class SubCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotNull(message = "Category Name can not be null")
    @Column(unique = true)
    private String categoryName;
    private String description;
    @OneToMany
    private List<Product> product = new ArrayList<>();
    
     public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
    public void addProduct(Product product) {
        this.product.add( product);
    }
    public SubCategory() {
    }

    public SubCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + '}';
    }

}
