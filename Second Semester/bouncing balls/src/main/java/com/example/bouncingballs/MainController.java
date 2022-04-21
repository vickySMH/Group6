package com.example.bouncingballs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{

    @FXML
    AnchorPane mainPane;
    BouncingCircle circle;

    @FXML
    public void press(MouseEvent event)
    {
        circle = new BouncingCircle(event.getX(), event.getY(), 150);
        circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
        mainPane.getChildren().add(circle);
        circle.setCenterY(50);
    }

    @FXML
    public void bounce()
    {
        circle.setCenterY(circle.getCenterY() + circle.getSpeed());
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