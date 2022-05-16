package com.example.nordicmotorhome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue
    private int orderId;

    private int bookingId, extraDetailsId;
    private float totalPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getExtraDetailsId() {
        return extraDetailsId;
    }

    public void setExtraDetailsId(int extraDetailsId) {
        this.extraDetailsId = extraDetailsId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
