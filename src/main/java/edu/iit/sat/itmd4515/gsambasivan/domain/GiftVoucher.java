/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Swathi
 */
@Entity
@Table(name = "GiftVoucher")
@NamedQueries({
    @NamedQuery(name = "GiftVoucher.findAll", query = "select o from GiftVoucher o")
    ,
    @NamedQuery(name = "GiftVoucher.findByVoucherName", query = "select o from GiftVoucher o where o.giftvoucherName = :giftvoucherName")
})

public class GiftVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giftVoucherId;
    @NotNull(message = "Gift Voucher Name can not be null")
    private String giftvoucherName;
    private double discountPercentage;

    public GiftVoucher() {
    }

    public GiftVoucher(String giftvoucherName, double discountPercentage) {
        this.giftvoucherName = giftvoucherName;
        this.discountPercentage = discountPercentage;
    }

    public Long getGiftVoucherId() {
        return giftVoucherId;
    }

    public void setGiftVoucherId(Long giftVoucherId) {
        this.giftVoucherId = giftVoucherId;
    }

    public String getGiftvoucherName() {
        return giftvoucherName;
    }

    public void setGiftvoucherName(String giftvoucherName) {
        this.giftvoucherName = giftvoucherName;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "GiftVoucher{" + "giftVoucherId=" + giftVoucherId + ", giftvoucherName=" + giftvoucherName + ", discountPercentage=" + discountPercentage + '}';
    }
    
    
}
