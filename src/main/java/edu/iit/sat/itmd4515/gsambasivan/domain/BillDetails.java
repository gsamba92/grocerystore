/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

/**
 *
 * @author Swathi
 */
@Entity
@Table(name = "billdetails")
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Past
    @Temporal(TemporalType.DATE)
    private Date bilDate;
    private String cardNumber;
    private String bankName;
    private Double amount;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id")
    private Order customer_order;
    
    public Order getOrder() {
        return customer_order;
    }

    public void setOrder(Order customer_order) {
        this.customer_order = customer_order;
    }
    
    public void addOrder(Order customer_order) {
        this.customer_order = customer_order;
    }
    
    public BillDetails() {
    }

    public BillDetails(Date bilDate, String cardNumber, String bankName, Double amount) {
        this.bilDate = bilDate;
        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBilDate() {
        return bilDate;
    }

    public void setBilDate(Date bilDate) {
        this.bilDate = bilDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BillDetails{" + "id=" + id + ", bilDate=" + bilDate + ", cardNumber=" + cardNumber + ", bankName=" + bankName + ", amount=" + amount + ", customer_order=" + customer_order + '}';
    }

    
    
}
