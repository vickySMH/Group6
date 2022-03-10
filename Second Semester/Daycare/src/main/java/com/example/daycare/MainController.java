package com.example.daycare;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    @FXML
    ImageView image;

    @FXML
    Label thumbnail;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    Button cancelButton;

    @FXML
    ImageView cancelImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        cancelImage.setVisible(false);
        Platform.runLater( () -> image.requestFocus() );

        usernameField.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                usernameField.clear();
                image.requestFocus();
            }
        });

        usernameField.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                thumbnail.setText("Enter username");
                thumbnail.setLayoutX(365);
                image.setVisible(true);
            }
        });
        passwordField.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                thumbnail.setText("Enter password");
                thumbnail.setLayoutX(365);
                cancelImage.setVisible(false);
                image.setVisible(true);
            }
        });

        loginButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if(usernameField.isFocused())
                {
                    thumbnail.setText("Enter username");
                    thumbnail.setLayoutX(365);
                }
                else if(passwordField.isFocused())
                {
                    thumbnail.setText("Enter password");
                    thumbnail.setLayoutX(365);
                }
                else
                {
                    thumbnail.setText("Roskilde Kindergarten");
                    thumbnail.setLayoutX(310);
                }
                cancelImage.setVisible(false);
                image.setVisible(true);
            }
        });

        loginButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                thumbnail.setText("Press to login");
                thumbnail.setLayoutX(365);
                cancelImage.setVisible(false);
                image.setVisible(true);
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.loginUser(event, usernameField.getText(), passwordField.getText());
                usernameField.setText("");
                passwordField.setText("");
                cancelImage.setVisible(false);
                image.setVisible(true);
            }
        });

        cancelButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                Platform.runLater( () -> cancelImage.requestFocus() );
                thumbnail.setText("Don't leave");
                thumbnail.setLayoutX(400);
                cancelImage.setVisible(true);
                image.setVisible(false);
            }
        });
        cancelButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                Platform.runLater( () -> image.requestFocus() );
                if(usernameField.isFocused())
                {
                    thumbnail.setText("Enter username");
                    thumbnail.setLayoutX(365);
                }
                else if(passwordField.isFocused())
                {
                    thumbnail.setText("Enter password");
                    thumbnail.setLayoutX(365);
                }
                else
                {
                    thumbnail.setText("Roskilde Kindergarten");
                    thumbnail.setLayoutX(310);
                }
                cancelImage.setVisible(false);
                image.setVisible(true);
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.exit(0);
            }
        });
    }
}