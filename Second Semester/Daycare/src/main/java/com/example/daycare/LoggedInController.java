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
    private static int counter = 0;
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
    @FXML
    Button addKidButton;
    @FXML
    Button addTeacherButton;
    @FXML
    Button addScheduleButton;
    @FXML
    Button updateKid;
    @FXML
    Button updateTeacher;
    @FXML
    Button updateSchedule;
    @FXML
    Button viewKid;
    @FXML
    Button viewTeacher;
    @FXML
    Button vieSchedule;
    @FXML
    Button removeKid;
    @FXML
    Button removeTeacher;
    @FXML
    Button removeSchedule;

    private void resetButtons()
    {
        addButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-border-radius: 12px");
        viewButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-border-radius: 12px");
        updateButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-border-radius: 12px");
        removeButton.setStyle("-fx-background-color: #00ff44; -fx-text-fill:black; -fx-border-radius: 12px");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater( () -> image.requestFocus() );
        addKidButton.setVisible(false);
        addTeacherButton.setVisible(false);
        addScheduleButton.setVisible(false);
        updateKid.setVisible(false);
        updateTeacher.setVisible(false);
        updateSchedule.setVisible(false);
        viewKid.setVisible(false);
        viewTeacher.setVisible(false);
        vieSchedule.setVisible(false);
        removeKid.setVisible(false);
        removeTeacher.setVisible(false);
        removeSchedule.setVisible(false);
        addPane.setVisible(false);
        viewPane.setVisible(false);
        updatePane.setVisible(false);
        removePane.setVisible(false);
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                addKidButton.setVisible(true);
                addTeacherButton.setVisible(true);
                addScheduleButton.setVisible(true);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                vieSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
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
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(true);
                viewTeacher.setVisible(true);
                vieSchedule.setVisible(true);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
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
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(true);
                updateTeacher.setVisible(true);
                updateSchedule.setVisible(true);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                vieSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
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
                if(counter == 2)
                {
                    counter = 0;
                    resetButtons();
                }
                else
                {
                    ++counter;
                    removeButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px");
                }
                if(counter == 0)
                {
                    ++counter;
                    removeButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-border-radius: 12px;");
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                vieSchedule.setVisible(false);
                removeKid.setVisible(true);
                removeTeacher.setVisible(true);
                removeSchedule.setVisible(true);
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
                Utilities.returnToLogin(event);
            }
        });
    }
}
