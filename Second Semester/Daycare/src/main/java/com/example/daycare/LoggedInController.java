package com.example.daycare;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable
{
    //Danny is cool
    private static String username;
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
    Button viewSchedule;
    @FXML
    Button removeKid;
    @FXML
    Button removeTeacher;
    @FXML
    Button removeSchedule;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField dateOfBirth;
    @FXML
    TextField parentPhone;
    @FXML
    TextField parentName;
    @FXML
    TextField parentSurname;
    @FXML
    TextField address;
    @FXML
    TextField group;
    @FXML
    RadioButton waitingList;
    @FXML
    ImageView childImage;
    @FXML
    TextField teacherName;
    @FXML
    TextField teacherSurname;
    @FXML
    TextField teacherPhone;
    @FXML
    TextField groupNumber;
    @FXML
    ImageView teachersImage;
    @FXML
    TextField teacherID;
    @FXML
    TextField workDay;
    @FXML
    TextField startHour;
    @FXML
    TextField endHour;
    @FXML
    TableView tableKid;
    @FXML
    TableView tableEmp;
    @FXML
    TableView tableSchedule;
    @FXML
    Button commitAddKid;
    @FXML
    Button commitAddTeacher;
    @FXML
    Button commitAddSchedule;
    @FXML
    Button commitUpdateKid;
    @FXML
    Button commitUpdateTeacher;
    @FXML
    Button commitUpdateSchedule;
    @FXML
    Button commitRemoveKid;
    @FXML
    Button commitRemoveTeacher;
    @FXML
    Button commitRemoveSchedule;
    @FXML
    TextField nameUpdate;
    @FXML
    TextField surnameUpdate;
    @FXML
    TextField dateOfBirthUpdate;
    @FXML
    TextField parentPhoneUpdate;
    @FXML
    TextField parentNameUpdate;
    @FXML
    TextField parentSurnameUpdate;
    @FXML
    TextField addressUpdate;
    @FXML
    TextField groupUpdate;
    @FXML
    RadioButton waitingListUpdate;
    @FXML
    TextField cpr;
    @FXML
    TextField cprUpdate;

    public static void setUsername(String newUsername)
    {
        username = newUsername;
    }

    private void resetButtons()
    {
        addButton.setStyle(null);
        addKidButton.setStyle(null);
        addTeacherButton.setStyle(null);
        addScheduleButton.setStyle(null);
        updateButton.setStyle(null);
        updateKid.setStyle(null);
        updateTeacher.setStyle(null);
        updateSchedule.setStyle(null);
        removeButton.setStyle(null);
        removeKid.setStyle(null);
        removeTeacher.setStyle(null);
        removeSchedule.setStyle(null);
        viewButton.setStyle(null);
        viewKid.setStyle(null);
        viewSchedule.setStyle(null);
        viewTeacher.setStyle(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Platform.runLater( () -> image.requestFocus() );
        commitAddKid.setVisible(false);
        commitAddTeacher.setVisible(false);
        commitAddSchedule.setVisible(false);
        commitRemoveKid.setVisible(false);
        commitRemoveSchedule.setVisible(false);
        commitRemoveTeacher.setVisible(false);
        commitUpdateKid.setVisible(false);
        commitUpdateTeacher.setVisible(false);
        commitUpdateSchedule.setVisible(false);
        addKidButton.setVisible(false);
        addTeacherButton.setVisible(false);
        addScheduleButton.setVisible(false);
        updateKid.setVisible(false);
        updateTeacher.setVisible(false);
        updateSchedule.setVisible(false);
        viewKid.setVisible(false);
        viewTeacher.setVisible(false);
        viewSchedule.setVisible(false);
        removeKid.setVisible(false);
        removeTeacher.setVisible(false);
        removeSchedule.setVisible(false);
        addPane.setVisible(false);
        viewPane.setVisible(false);
        updatePane.setVisible(false);
        removePane.setVisible(false);
        if(!username.equals("admin"))
        {
            addButton.setVisible(false);
            removeButton.setVisible(false);
            updateButton.setVisible(false);
            viewButton.setLayoutX(700);
            viewButton.setLayoutY(685);
            viewKid.setLayoutY(620);
            viewKid.setLayoutX(700);
            viewSchedule.setLayoutY(620);
            viewSchedule.setLayoutX(833);
        }
        addButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                addButton.setStyle("-fx-background-color:#005918;-fx-text-fill:white;-fx-background-radius: 12px");
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addKidButton.setVisible(true);
                addTeacherButton.setVisible(true);
                addScheduleButton.setVisible(true);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);


                addPane.setVisible(false);
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
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918;-fx-text-fill:white;-fx-background-radius: 12px");
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(true);
                if(username.equals("admin"))
                {
                    viewTeacher.setVisible(true);
                }
                viewSchedule.setVisible(true);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
                viewPane.setVisible(false);
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
                resetButtons();
                updateButton.setStyle("-fx-background-color:#005918;-fx-text-fill:white;-fx-background-radius: 12px");
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(true);
                updateTeacher.setVisible(true);
                updateSchedule.setVisible(true);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
                removeKid.setVisible(false);
                removeTeacher.setVisible(false);
                removeSchedule.setVisible(false);
                updatePane.setVisible(true);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                removePane.setVisible(false);
                nameUpdate.setVisible(false);
                surnameUpdate.setVisible(false);
                dateOfBirthUpdate.setVisible(false);
                parentPhoneUpdate.setVisible(false);
                parentNameUpdate.setVisible(false);
                parentSurnameUpdate.setVisible(false);
                addressUpdate.setVisible(false);
                groupUpdate.setVisible(false);
                waitingListUpdate.setVisible(false);
            }
        });
        removeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                removeButton.setStyle("-fx-background-color:#005918;-fx-text-fill:white;-fx-background-radius:12px");
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(false);
                viewTeacher.setVisible(false);
                viewSchedule.setVisible(false);
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

        addKidButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                commitAddKid.setVisible(true);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                addKidButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                cpr.setVisible(true);
                name.setVisible(true);
                surname.setVisible(true);
                dateOfBirth.setVisible(true);
                parentPhone.setVisible(true);
                parentName.setVisible(true);
                parentSurname.setVisible(true);
                address.setVisible(true);
                group.setVisible(true);
                waitingList.setVisible(true);
                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(true);
                teachersImage.setVisible(false);
                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);

            }
        });

        addTeacherButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(true);
                commitAddSchedule.setVisible(false);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addTeacherButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                teacherName.setVisible(true);
                teacherSurname.setVisible(true);
                teacherPhone.setVisible(true);
                groupNumber.setVisible(true);
                name.setVisible(false);
                surname.setVisible(false);
                dateOfBirth.setVisible(false);
                parentPhone.setVisible(false);
                parentName.setVisible(false);
                parentSurname.setVisible(false);
                address.setVisible(false);
                group.setVisible(false);
                waitingList.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(false);
                teachersImage.setVisible(true);
                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);
            }
        });

        viewKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");;
                viewKid.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");;
                viewPane.setVisible(true);
                tableKid.setVisible(true);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(false);
            }
        });

        viewTeacher.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewTeacher.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewPane.setVisible(true);
                tableKid.setVisible(false);
                tableEmp.setVisible(true);
                tableSchedule.setVisible(false);
            }
        });

        addScheduleButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                commitAddKid.setVisible(false);
                commitAddTeacher.setVisible(false);
                commitAddSchedule.setVisible(true);
                commitRemoveKid.setVisible(false);
                commitRemoveSchedule.setVisible(false);
                commitRemoveTeacher.setVisible(false);
                commitUpdateKid.setVisible(false);
                commitUpdateTeacher.setVisible(false);
                commitUpdateSchedule.setVisible(false);
                addScheduleButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                addButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                teacherID.setVisible(true);
                workDay.setVisible(true);
                startHour.setVisible(true);
                endHour.setVisible(true);
                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                name.setVisible(false);
                surname.setVisible(false);
                dateOfBirth.setVisible(false);
                parentPhone.setVisible(false);
                parentName.setVisible(false);
                parentSurname.setVisible(false);
                address.setVisible(false);
                group.setVisible(false);
                waitingList.setVisible(false);
                addPane.setVisible(true);
                viewPane.setVisible(false);
                updatePane.setVisible(false);
                removePane.setVisible(false);
                childImage.setVisible(false);
                teachersImage.setVisible(false);
            }
        });

        viewSchedule.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewSchedule.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewPane.setVisible(true);
                tableKid.setVisible(false);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(true);
            }
        });
        commitAddTeacher.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.addTeacher(event, teacherName.getText(), teacherSurname.getText(),teacherPhone.getText(), groupNumber.getText());
            }
        });

        commitAddKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //Utilities.addChild(event, name.getText(), surname.getText(), dateOfBirth);
            }
        });

        updateKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                updateKid.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                updatePane.setVisible(true);
                cprUpdate.setVisible(true);
                nameUpdate.setVisible(true);
                surnameUpdate.setVisible(true);
                dateOfBirthUpdate.setVisible(true);
                parentPhoneUpdate.setVisible(true);
                parentNameUpdate.setVisible(true);
                parentSurnameUpdate.setVisible(true);
                addressUpdate.setVisible(true);
                groupUpdate.setVisible(true);
                waitingListUpdate.setVisible(true);
            }
        });

        updateTeacher.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                updatePane.setVisible(true);
            }
        });

        updateSchedule.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                updatePane.setVisible(true);
            }
        });
    }
}
