package com.example.daycare;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable
{
    //todo add buttons to the panes;
    @FXML
    Button addButton;
    @FXML
    AnchorPane addPane;
    @FXML
    Button viewButton;
    @FXML
    AnchorPane viewPane;
    @FXML
    Button updateButton;
    @FXML
    AnchorPane updatePane;
    @FXML
    Button removeButton;
    @FXML
    AnchorPane removePane;
    @FXML
    ImageView image;
    @FXML
    Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater( () -> image.requestFocus() );
        addPane.setVisible(false);
        viewPane.setVisible(false);
        updatePane.setVisible(false);
        removePane.setVisible(false);
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
            }
        });
        viewButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                viewPane.setVisible(true);
                addPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
            }
        });
        updateButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                updatePane.setVisible(true);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                removePane.setVisible(false);
            }
        });
        removeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                removePane.setVisible(true);
                updatePane.setVisible(false);
                viewPane.setVisible(false);
                addPane.setVisible(false);
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.changeScene(event, "main.fxml", "login", null, null);
            }
        });
    }
}
