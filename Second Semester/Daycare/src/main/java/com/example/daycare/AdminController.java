package com.example.daycare;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;
//a
public class AdminController implements Initializable
{

    @FXML
    private Button view;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button remove;

    @FXML
    private Button back;

    @FXML
    private AnchorPane toView;

    @FXML
    private AnchorPane toAdd;

    @FXML
    private AnchorPane toUpdate;

    @FXML
    private AnchorPane toRemove;


    public void initialize(URL url, ResourceBundle resourceBundle){

        toView.setVisible(false);
        toAdd.setVisible(false);
        toUpdate.setVisible(false);
        toRemove.setVisible(false);

        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toView.setVisible(true);
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toAdd.setVisible(true);
            }
        });

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toUpdate.setVisible(true);
            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                toRemove.setVisible(true);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    }

}
