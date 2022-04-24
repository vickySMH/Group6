package com.example.bouncingballs;

import javafx.scene.shape.Circle;

public class BouncingCircle extends Circle implements Runnable
{
    private double deltaX = 0.3;
    private double deltaY = 5;
    BouncingCircle(double x, double y, int radius)
    {
        super(x,y,radius);
    }

    public double getDeltaY()
    {
        return deltaY;
    }

    public void setDeltaY(double deltaY)
    {
        this.deltaY = deltaY;
    }

    public double getDeltaX()
    {
        return deltaX;
    }

    public void setDeltaX(double deltaX)
    {
        this.deltaX = deltaX;
    }

    @Override
    public void run()
    {
        setCenterY(getCenterY() + deltaY);
        setCenterX(getCenterX() + deltaX);
        if(getCenterY() >= 680)
        {
            deltaY *=-1;
        }
        if(getCenterY() < 100)
        {
            deltaY *=-1;
        }
        if(getCenterX() > 100)
        {
            deltaX *=-1;
        }
        if(getCenterX() < 1500)
        {
            deltaX *=-1;
        }
    }
}
