package com.example.bouncingballs;

import javafx.scene.shape.Circle;

public class BouncingCircle extends Circle implements Runnable
{
    private double speed = 50;
    BouncingCircle(double x, double y, int radius)
    {
        super(x,y,radius);
    }

    public double getSpeed()
    {
        return speed;
    }

    @Override
    public void run()
    {

    }
}
