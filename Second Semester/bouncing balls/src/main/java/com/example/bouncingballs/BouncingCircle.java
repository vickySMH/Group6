package com.example.bouncingballs;

import javafx.scene.shape.Circle;

public class BouncingCircle extends Circle implements Runnable
{
    private double speed = 2;
    BouncingCircle(double x, double y, int radius)
    {
        super(x,y,radius);
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    @Override
    public void run()
    {
        setCenterY(getCenterY() + speed);
        if(getCenterY() >= 690)
        {
            speed *=-1;
        }
        if(getCenterY() < 100)
        {
            speed *=-1;
        }
    }
}
