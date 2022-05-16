package com.example.nordicmotorhome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Extras {

    @Id
    @GeneratedValue
    private int id;

    private String extra;
    private int quantity;
    private float proce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getProce() {
        return proce;
    }

    public void setProce(float proce) {
        this.proce = proce;
    }
}
