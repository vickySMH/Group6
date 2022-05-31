package com.example.nordicmotorhome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExtraDetails {

    @Id
    @GeneratedValue
    private int id;

    private int bookingId;
    private int extraId;
    private int quantity;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public int getExtraId()
    {
        return extraId;
    }

    public void setExtraId(int extraId)
    {
        this.extraId = extraId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
