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
                if(distanceBetweenCenter <= 215)
                {
                    return false;
                }
            }
            if(distanceBetweenCenter > 215 && (event.getY() > 100 && event.getY() < 690))
            {
                circle = new BouncingCircle(event.getX(), event.getY(), 150);
                circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
                circles.add(circle);
                mainPane.getChildren().add(circle);
            }
            return true;
        }
        else
        {
            if(event.getY() > 100 && event.getY() < 690)
            {
                circle = new BouncingCircle(event.getX(), event.getY(), 150);
                circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
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
                            if(distanceBetweenCenter <= 215)
                            {
                                c.setDeltaY(c.getDeltaY()*(-1));
                                c1.setDeltaY(c1.getDeltaY()*(-1));
                                c1.setDeltaX(c1.getDeltaX()*(-1));
                                c.setDeltaX(c.getDeltaX()*(-1));
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