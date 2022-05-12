package com.example.nordicmotorhome.model;

import javax.persistence.Id;

public class Motorhome
{
    @Id
    String licenseNumber, model;
    int fuel, kilometrage;
    short beds;
    boolean isClean, isBroken;
    float price;

    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber)
    {
        this.licenseNumber = licenseNumber;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getFuel()
    {
        return fuel;
    }

    public void setFuel(int fuel)
    {
        this.fuel = fuel;
    }

    public int getKilometrage()
    {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage)
    {
        this.kilometrage = kilometrage;
    }

    public short getBeds()
    {
        return beds;
    }

    public void setBeds(short beds)
    {
        this.beds = beds;
    }

    public boolean isClean()
    {
        return isClean;
    }

    public void setClean(boolean clean)
    {
        isClean = clean;
    }

    public boolean isBroken()
    {
        return isBroken;
    }

    public void setBroken(boolean broken)
    {
        isBroken = broken;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
}
