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
@Table(name = "productcategory")
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "select o from ProductCategory o")
    ,
    @NamedQuery(name = "ProductCategory.findByName", query = "select o from ProductCategory o where o.categoryName = :categoryName")
})

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotNull(message = "Category Name can not be null")
    @Column(unique = true)
    private String categoryName;
    private String description;
    @OneToMany
    private List<SubCategory> subCategory = new ArrayList<>();
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
    /**
     * Get the value of subCategory
     *
     * @return the value of subCategory
     */
    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    /**
     * Set the value of subCategory
     *
     * @param subCategory new value of subCategory
     */
    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }
 public void addSubCategory(SubCategory subCategory) {
        this.subCategory.add(subCategory);
    }
    public ProductCategory() {
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of categoryName
     *
     * @return the value of categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Set the value of categoryName
     *
     * @param categoryName new value of categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description + '}';
    }

}
