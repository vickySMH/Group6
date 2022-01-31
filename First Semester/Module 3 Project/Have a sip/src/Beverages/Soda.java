package Beverages;

import Beverages.Beverage;

public class Soda extends Beverage
{
    String name;
    int mililiters;

    public Soda(String name, int mililiters, String color)
    {
        super(color);
        setName(name);
        setMililiters(mililiters);
    }

    public void drinkASip(int takeASip)
    {
        if(takeASip > mililiters)
        {
            System.out.println("You cannot drink more than you have");
            setMililiters(0);
        }
        else
        {
            mililiters -=takeASip;
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMililiters(int mililiters)
    {
        this.mililiters = mililiters;
    }

    public int getMililiters()
    {
        return mililiters;
    }
}
