/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Swathi
 */
@Entity
@Table(name = "customer_order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;    
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private double totAmount;
    private double discAmount;
    private String paymentType;
    private double billAmount;
    @OneToMany
    private List<OrderDetails> orderDetails = new ArrayList<>();
    @OneToOne
    private GiftVoucher giftVoucher;
    @OneToOne(mappedBy = "customer_order")
    private BillDetails billDetails;

    public BillDetails getBillDetails() {
        return billDetails;
        
    }

    public void setBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }
    public void addBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }
    
    public GiftVoucher getGiftVoucher() {
        return giftVoucher;
    }

    public void setGiftVoucher(GiftVoucher giftVoucher) {
        this.giftVoucher = giftVoucher;
    }
    public void addGiftVoucher(GiftVoucher giftVoucher) {
        this.giftVoucher = giftVoucher;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
     public void addOrderDetails(OrderDetails orderDetails) {
        this.orderDetails.add( orderDetails);
    }
    public Order() {
    }

    public Order(Date orderDate, double totAmount, double discAmount, String paymentType, double billAmount) {
        this.orderDate = orderDate;
        this.totAmount = totAmount;
        this.discAmount = discAmount;
        this.paymentType = paymentType;
        this.billAmount = billAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotAmount() {
        return totAmount;
    }

    public void setTotAmount(double totAmount) {
        this.totAmount = totAmount;
    }

    public double getDiscAmount() {
        return discAmount;
    }

    public void setDiscAmount(double discAmount) {
        this.discAmount = discAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderDate=" + orderDate + ", totAmount=" + totAmount + ", discAmount=" + discAmount + ", paymentType=" + paymentType + ", billAmount=" + billAmount + ", orderDetails=" + orderDetails + ", giftVoucher=" + giftVoucher + ", billDetails=" + billDetails + '}';
    }

    
    
}
