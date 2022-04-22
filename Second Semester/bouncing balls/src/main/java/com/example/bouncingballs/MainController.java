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
import java.util.ResourceBundle;

public class MainController implements Initializable
{

    @FXML
    AnchorPane mainPane;
    @FXML
    BorderPane backPane;
    @FXML
    AnchorPane bottomBorder;
    BouncingCircle circle;

    @FXML
    public void press(MouseEvent event)
    {
        circle = new BouncingCircle(event.getX(), event.getY(), 150);
        circle.setStyle("-fx-fill: url('https://media.discordapp.net/attachments/883248953666199625/966633139126534164/unknown.png?width=934&height=934')");
        mainPane.getChildren().add(circle);
//        circle.setCenterY(50);
    }




    @FXML
    public void bounce()
    {
//        circle.setCenterY(circle.getCenterY() + circle.getSpeed());

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(circle != null)
                {
                    circle.setCenterY(circle.getCenterY() + circle.getSpeed());
                    final Bounds bounds = backPane.getBoundsInLocal();
                    final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
                    final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
                    final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
                    final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());
                    if (atBottomBorder || atTopBorder)
                    {
                        circle.setSpeed(circle.getSpeed()*-1);
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