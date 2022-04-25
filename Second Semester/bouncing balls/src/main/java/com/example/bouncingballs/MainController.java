package com.example.bouncingballs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable
{

    @FXML
    AnchorPane mainPane;
    @FXML
    BorderPane backPane;
    @FXML
    AnchorPane bottomBorder;
    ArrayList<BouncingCircle> circles = new ArrayList<>();
    double distanceX = 0;
    double distanceY = 0;
    double distanceBetweenCenter = 0;
    double topLine = 708, bottomLine = 65, leftLine = 67, rightLine = 1390;
    int ballCounter = 0;

    @FXML
    public boolean press(MouseEvent event)
    {
        BouncingCircle circle;
        if (!circles.isEmpty())
        {
            for (BouncingCircle c:circles)
            {
                if(c.getCenterX() >= event.getX())
                {
                    distanceX = c.getCenterX() - event.getX();
                }
                else
                {
                    distanceX = event.getX() - c.getCenterX();
                }
                if(c.getCenterY() >= event.getY())
                {
                    distanceY = c.getCenterY() - event.getY();
                }
                else
                {
                    distanceY = event.getY() - c.getCenterY();
                }
                distanceBetweenCenter = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
                if(distanceBetweenCenter <= 140)
                {
                    return false;
                }
            }
            if(distanceBetweenCenter > 140 && (event.getY() > bottomLine && event.getY() < topLine) && (event.getX() <= rightLine && event.getX() > leftLine))
            {
                circle = new BouncingCircle(event.getX(), event.getY(), 100);
                if(ballCounter % 2 == 0)
                {
                    circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
                }
                ++ballCounter;
                circles.add(circle);
                mainPane.getChildren().add(circle);
            }
            return true;
        }
        else
        {
            if(event.getY() > bottomLine && event.getY() < topLine && event.getX() <= rightLine && event.getX() > leftLine)
            {
                circle = new BouncingCircle(event.getX(), event.getY(), 100);
                if(ballCounter % 2 == 0)
                {
                    circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
                }
                else
                {
                    circle.setStyle("-fx-fill: url('https://media.discordapp.com/attachments/883248953666199625/968067924600434738/Lovepik_com-401246548-basketball.png')");
                }
                ++ballCounter;
                mainPane.getChildren().add(circle);
                circles.add(circle);
            }
        }
        return true;
    }

    @FXML
    public void bounce()
    {
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(!circles.isEmpty())
                {
                    for (BouncingCircle c: circles)
                    {
                        c.run();
                        for(BouncingCircle c1: circles)
                        {
                            if(c.getCenterX() >= c1.getCenterX())
                            {
                                distanceX = c.getCenterX() - c1.getCenterX();
                            }
                            else
                            {
                                distanceX = c1.getCenterX() - c.getCenterX();
                            }
                            if(c.getCenterY() >= c1.getCenterY())
                            {
                                distanceY = c.getCenterY() - c1.getCenterY();
                            }
                            else
                            {
                                distanceY = c1.getCenterY() - c.getCenterY();
                            }
                            distanceBetweenCenter = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
                            if(distanceBetweenCenter <= 140)
                            {
                                c.setDeltaY(c.getDeltaY()*(-1));
                                c1.setDeltaY(c1.getDeltaY()*(-1));
                                if(c.getCenterX() < c1.getCenterX())
                                {
                                    if(c.getDeltaX() > 0 && c.getCenterX() > leftLine)
                                    {
                                        c.setDeltaX(c.getDeltaX() * (-1));
                                        if(c1.getDeltaX() < 0 && c1.getCenterX() < rightLine)
                                        {
                                            c1.setDeltaX(c.getDeltaX() * (-1));
                                        }
                                    }
                                }
                                if(c.getCenterX() > c1.getCenterX())
                                {
                                    if(c.getDeltaX() < 0 && c.getCenterX() < rightLine)
                                    {
                                        c.setDeltaX(c.getDeltaX()* (-1));
                                        if(c1.getDeltaX() > 0 && c.getCenterX() > leftLine)
                                        {
                                            c1.setDeltaX(c1.getDeltaX() *(-1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        bounce();
        mainPane.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                press(mouseEvent);
            }
        });
    }
}