package com.example.daycare;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
//b
public class LoggedInController implements Initializable
{
    //Danny is cool
    private static String currentDefaultText = "Roskilde Kindergarten";
    private static int currentSpeechXCoordinate = 197;
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
    @FXML
    Button search;
    @FXML
    Label speech;
    @FXML
    ImageView childImageUpdate;
    @FXML
    TableColumn<ModelTableEmployee, Integer> empID;
    @FXML
    TableColumn<ModelTableEmployee, String> empGroup;
    @FXML
    TableColumn<ModelTableEmployee, String> empName;
    @FXML
    TableColumn<ModelTableEmployee, String> empSurname;
    @FXML
    TableColumn<ModelTableEmployee, String> empPhone;
    @FXML
    TableColumn<ModelTableChild, Integer> kidId;
    @FXML
    TableColumn<ModelTableChild, String> kidName;
    @FXML
    TableColumn<ModelTableChild, String> kidSurname;
    @FXML
    TableColumn<ModelTableChild, String> kidBirthday;
    @FXML
    TableColumn<ModelTableChild, String> parentPhoneNumber;
    @FXML
    TableColumn<ModelTableChild, String> parentsName;
    @FXML
    TableColumn<ModelTableChild, String> parentsSurname;
    @FXML
    TableColumn<ModelTableChild, String> kidAddress;
    @FXML
    TableColumn<ModelTableChild, String> kidGroup;
    @FXML
    TableColumn<ModelTableChild, String> kidCPR;
    @FXML
    TableColumn<ModelTableChild, String> kidWait;
    @FXML
    TableColumn<ModelTableSchedule, String> viewWorkDay;
    @FXML
    TableColumn<ModelTableSchedule, String> viewStartHour;
    @FXML
    TableColumn<ModelTableSchedule, String> viewEndHour;
    @FXML
    TableColumn<ModelTableSchedule, Integer> employeeId;
    @FXML
    TextField teacherNameUpdate;
    @FXML
    TextField teacherSurnameUpdate;
    @FXML
    TextField teacherPhoneUpdate;
    @FXML
    TextField groupNumberUpdate;
    @FXML
    ImageView teachersImageUpdate;
    @FXML
    TextField teacherIDUpdate;
    @FXML
    Button searchTeacher;
    @FXML
    TextField teacherIDSearch;
    @FXML
    TextField workDayUpdate;
    @FXML
    TextField startHourUpdate;
    @FXML
    TextField endHourUpdate;
    @FXML
    ImageView calendar;
    @FXML
    ImageView calendarUpdate;
    @FXML
    AnchorPane userPane;
    @FXML
    TextField addUTeacherID;
    @FXML
    TextField addUsername;
    @FXML
    Button commitAddUser;
    @FXML
    Button commitUpdateUser;
    @FXML
    Button commitRemoveUser;
    @FXML
    TextField accountRemove;
    @FXML
    TextField updateUsername;
    @FXML
    TextField passwordTeacherUpdate;
    @FXML
    Button searchSchedule;
    @FXML
    Button commitChangePassword;
    @FXML
    TextField changePassword;
    
    private ObservableList listChild;
    private ObservableList listEmployee;
    private ObservableList listSchedule;

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
        empID.setCellValueFactory(new PropertyValueFactory<>("id"));
        empGroup.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));
        empName.setCellValueFactory(new PropertyValueFactory<>("name"));
        empSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        empPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        kidId.setCellValueFactory(new PropertyValueFactory<>("id"));
        kidCPR.setCellValueFactory(new PropertyValueFactory<>("cpr"));
        kidName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kidSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        kidGroup.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));
        kidAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        kidBirthday.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        kidWait.setCellValueFactory(new PropertyValueFactory<>("onWaitList"));
        parentPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("parentPhone"));
        parentsName.setCellValueFactory(new PropertyValueFactory<>("parentName"));
        parentsSurname.setCellValueFactory(new PropertyValueFactory<>("parentSurname"));

        viewWorkDay.setCellValueFactory(new PropertyValueFactory<>("workday"));
        viewStartHour.setCellValueFactory(new PropertyValueFactory<>("startHour"));
        viewEndHour.setCellValueFactory(new PropertyValueFactory<>("endHour"));
        employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    
        Platform.runLater( () -> image.requestFocus() );
        passwordTeacherUpdate.setVisible(false);
        accountRemove.setVisible(false);
        updateUsername.setVisible(false);
        userPane.setVisible(false);
        addUsername.setVisible(false);
        addUTeacherID.setVisible(false);
        commitAddUser.setVisible(false);
        commitRemoveUser.setVisible(false);
        commitUpdateUser.setVisible(false);
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

        if(!username.equals("director") & !username.equals("admin"))
        {

            addButton.setVisible(false);
            removeButton.setVisible(false);
            updateButton.setText("Change password");
            updateButton.setLayoutY(685);
            viewButton.setLayoutX(659);
            viewButton.setLayoutY(685);
            viewKid.setLayoutY(620);
            viewKid.setLayoutX(660);
            viewSchedule.setLayoutY(620);
            viewSchedule.setLayoutX(794);
        }

        commitAddKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitAddKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitAddTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitAddTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitAddSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitAddSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitUpdateKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitUpdateKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitUpdateSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitUpdateSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitUpdateTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitUpdateTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitRemoveKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitRemoveKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitRemoveTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitRemoveTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        commitRemoveSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Commit changes");
                speech.setLayoutX(219);
            }
        });
        commitRemoveSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        addButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to add information");
                speech.setLayoutX(189);
                if(username.equals("admin"))
                {
                    speech.setText("Click to add account");
                    speech.setLayoutX(202);
                }
            }
        });
        addButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        addKidButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to add children");
                speech.setLayoutX(207);
            }
        });
        addKidButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        addTeacherButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to add employee");
                speech.setLayoutX(199);
            }
        });
        addTeacherButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        addScheduleButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to add workdays");
                speech.setLayoutX(201);
            }
        });
        addScheduleButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        updateButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to update information");
                speech.setLayoutX(172);
                if(!username.equals("director"))
                {
                    speech.setText("Change your password");
                    speech.setLayoutX(190);
                }
                if(username.equals("admin"))
                {
                    speech.setText("Click to update account");
                    speech.setLayoutX(190);
                }
            }
        });
        updateButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        updateKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to update children");
                speech.setLayoutX(189);
            }
        });
        updateKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        updateTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to update employees");
                speech.setLayoutX(174);
            }
        });
        updateTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        updateSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to update workdays");
                speech.setLayoutX(181);
            }
        });
        updateSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        removeButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to remove information");
                speech.setLayoutX(169);
                if(username.equals("admin"))
                {
                    speech.setText("Click to remove account");
                    speech.setLayoutX(185);
                }
            }
        });
        removeButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        removeKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to remove children");
                speech.setLayoutX(188);
            }
        });
        removeKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        removeTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to remove employees");
                speech.setLayoutX(171);
            }
        });
        removeTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        removeSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to remove workdays");
                speech.setLayoutX(178);
            }
        });
        removeSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        viewButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to view information");
                speech.setLayoutX(185);
                if(username.equals("admin"))
                {
                    speech.setText("Click to view accounts");
                    speech.setLayoutX(198);
                }
            }
        });
        viewButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        viewKid.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to view children");
                speech.setLayoutX(203);
            }
        });
        viewKid.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        viewTeacher.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to view employees");
                speech.setLayoutX(190);
            }
        });
        viewTeacher.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        viewSchedule.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Click to view schedules");
                speech.setLayoutX(191);
            }
        });
        viewSchedule.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });

        search.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Search for child");
                speech.setLayoutX(223);
            }
        });
        search.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });
        backButton.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText("Log out");
                speech.setLayoutX(270);
            }
        });
        backButton.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                speech.setText(currentDefaultText);
                speech.setLayoutX(currentSpeechXCoordinate);
            }
        });

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
                currentDefaultText = "Add information";
                currentSpeechXCoordinate = 226;
                if(username.equals("admin"))
                {
                    accountRemove.setVisible(false);
                    commitRemoveUser.setVisible(false);
                    currentDefaultText = "Add user";
                    currentSpeechXCoordinate = 255;
                    userPane.setVisible(true);
                    addUTeacherID.setVisible(true);
                    addUsername.setVisible(true);
                    commitAddUser.setVisible(true);
                }
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
                if(username.equals("admin"))
                {
                    addKidButton.setVisible(false);
                    addScheduleButton.setVisible(false);
                    addTeacherButton.setVisible(false);
                }
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
                currentDefaultText = "View information";
                currentSpeechXCoordinate = 220;
                if(username.equals("admin"))
                {
                    currentDefaultText = "View user";
                    currentSpeechXCoordinate = 258;
                }
                addKidButton.setVisible(false);
                addTeacherButton.setVisible(false);
                addScheduleButton.setVisible(false);
                updateKid.setVisible(false);
                updateTeacher.setVisible(false);
                updateSchedule.setVisible(false);
                viewKid.setVisible(true);
                if(username.equals("director"))
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
                if(username.equals("admin"))
                {
                    viewKid.setVisible(false);
                    viewSchedule.setVisible(false);
                }
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
                currentDefaultText = "Update information";
                currentSpeechXCoordinate = 212;
                if(!username.equals("director") && !username.equals("admin"))
                {
                    speech.setText("Change your password");
                    speech.setLayoutX(190);
                }
                if(username.equals("admin"))
                {
                    currentDefaultText = "Update user";
                    currentSpeechXCoordinate = 246;
                }
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

                updatePane.setVisible(false);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                removePane.setVisible(false);
                if(!username.equals("director"))
                {
                    updateKid.setVisible(false);
                    updateSchedule.setVisible(false);
                    updateTeacher.setVisible(false);
                }
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
                currentDefaultText = "Remove information";
                currentSpeechXCoordinate = 207;
                if(username.equals("admin"))
                {
                    addUTeacherID.setVisible(false);
                    commitAddUser.setVisible(false);
                    addUsername.setVisible(false);
                    currentDefaultText = "Remove user";
                    currentSpeechXCoordinate = 246;
                    userPane.setVisible(true);
                    accountRemove.setVisible(true);
                    commitRemoveUser.setVisible(true);
                }
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

                removePane.setVisible(false);
                updatePane.setVisible(false);
                viewPane.setVisible(false);
                addPane.setVisible(false);
                if(username.equals("admin"))
                {
                    removeKid.setVisible(false);
                    removeTeacher.setVisible(false);
                    removeSchedule.setVisible(false);
                }
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
                currentDefaultText = "Add child information";
                currentSpeechXCoordinate = 205;
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
                childImage.setVisible(true);

                addPane.setVisible(true);

                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                teachersImage.setVisible(false);

                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);
                calendar.setVisible(false);
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
                currentDefaultText = "Add teacher information";
                currentSpeechXCoordinate = 187;
                teacherName.setVisible(true);
                teacherSurname.setVisible(true);
                teacherPhone.setVisible(true);
                groupNumber.setVisible(true);
                teachersImage.setVisible(true);

                addPane.setVisible(true);

                cpr.setVisible(false);
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

                teacherID.setVisible(false);
                workDay.setVisible(false);
                startHour.setVisible(false);
                endHour.setVisible(false);
                calendar.setVisible(false);
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
                currentDefaultText = "Add schedule information";
                currentSpeechXCoordinate = 179;
                teacherID.setVisible(true);
                workDay.setVisible(true);
                startHour.setVisible(true);
                endHour.setVisible(true);
                calendar.setVisible(true);

                addPane.setVisible(true);

                cpr.setVisible(false);
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

                teacherName.setVisible(false);
                teacherSurname.setVisible(false);
                teacherPhone.setVisible(false);
                groupNumber.setVisible(false);
                teachersImage.setVisible(false);
            }
        });

        viewKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewKid.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                currentDefaultText = "View children information";
                currentSpeechXCoordinate = 180;
                tableKid.setVisible(true);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(false);
                listChild = Utilities.getChildData();
                tableKid.setItems(listChild);

                viewPane.setVisible(true);
            }
        });

        viewTeacher.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                resetButtons();
                viewButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                viewTeacher.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                currentDefaultText = "View teacher information";
                currentSpeechXCoordinate = 182;
                tableKid.setVisible(false);
                tableEmp.setVisible(true);
                tableSchedule.setVisible(false);
                listEmployee = Utilities.getEmployeeData();
                tableEmp.setItems(listEmployee);

                viewPane.setVisible(true);
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
                currentDefaultText = "View schedule information";
                currentSpeechXCoordinate = 174;
                tableKid.setVisible(false);
                tableEmp.setVisible(false);
                tableSchedule.setVisible(true);
                listSchedule = Utilities.getScheduleData();
                tableSchedule.setItems(listSchedule);

                viewPane.setVisible(true);
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
                currentDefaultText = "Update children information";
                currentSpeechXCoordinate = 167;
                updatePane.setVisible(true);

                cprUpdate.setVisible(true);
                search.setVisible(true);
                childImageUpdate.setVisible(true);
                search.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        if (Utilities.search(event, cprUpdate.getText()))
                        {
                            cprUpdate.setVisible(false);
                            search.setVisible(false);
                            nameUpdate.setVisible(true);
                            surnameUpdate.setVisible(true);
                            dateOfBirthUpdate.setVisible(true);
                            parentPhoneUpdate.setVisible(true);
                            parentNameUpdate.setVisible(true);
                            parentSurnameUpdate.setVisible(true);
                            addressUpdate.setVisible(true);
                            groupUpdate.setVisible(true);
                            waitingListUpdate.setVisible(true);

                            commitUpdateKid.setVisible(true);

                            nameUpdate.setText(Utilities.name(event, cprUpdate.getText()));
                            surnameUpdate.setText(Utilities.surname(event, cprUpdate.getText()));
                            dateOfBirthUpdate.setText(Utilities.dateOfBirth(event, cprUpdate.getText()));
                            parentPhoneUpdate.setText(Utilities.parentPhone(event, cprUpdate.getText()));
                            parentNameUpdate.setText(Utilities.parentName(event, cprUpdate.getText()));
                            parentSurnameUpdate.setText(Utilities.parentSurname(event, cprUpdate.getText()));
                            addressUpdate.setText(Utilities.address(event, cprUpdate.getText()));
                            groupUpdate.setText(Utilities.groupNumber(event, cprUpdate.getText()));
                            if(Utilities.waitingList(event,cprUpdate.getText()))
                            {
                                waitingListUpdate.setSelected(true);
                            }
                            else
                            {
                                waitingListUpdate.setSelected(false);
                            }
                            Platform.runLater( () -> image.requestFocus() );
                        }
                        else
                        {
                            speech.setText("No child with this CPR.");
                        }
                    }
                });

                nameUpdate.setVisible(false);
                surnameUpdate.setVisible(false);
                dateOfBirthUpdate.setVisible(false);
                parentPhoneUpdate.setVisible(false);
                parentNameUpdate.setVisible(false);
                parentSurnameUpdate.setVisible(false);
                addressUpdate.setVisible(false);
                groupUpdate.setVisible(false);
                waitingListUpdate.setVisible(false);

                teacherNameUpdate.setVisible(false);
                teacherSurnameUpdate.setVisible(false);
                teacherPhoneUpdate.setVisible(false);
                groupNumberUpdate.setVisible(false);
                teachersImageUpdate.setVisible(false);
                teacherIDUpdate.setVisible(false);
                searchTeacher.setVisible(false);

                teacherIDSearch.setVisible(false);
                workDayUpdate.setVisible(false);
                startHourUpdate.setVisible(false);
                endHourUpdate.setVisible(false);
                calendarUpdate.setVisible(false);
                searchSchedule.setVisible(false);
            }
        });

        updateTeacher.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                currentDefaultText = "Update teacher information";
                currentSpeechXCoordinate = 169;
                updatePane.setVisible(true);
                resetButtons();
                updateTeacher.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");
                updateButton.setStyle("-fx-background-color:#005918; -fx-text-fill:white; -fx-background-radius: 12px");

                teacherIDUpdate.setVisible(true);
                searchTeacher.setVisible(true);
                teacherNameUpdate.setVisible(false);
                teacherSurnameUpdate.setVisible(false);
                teacherPhoneUpdate.setVisible(false);
                groupNumberUpdate.setVisible(false);
                teachersImageUpdate.setVisible(true);

                searchTeacher.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        if (Utilities.searchTeacher(event, parseString(teacherIDUpdate.getText())))
                        {
                            teacherIDUpdate.setVisible(false);
                            searchTeacher.setVisible(false);
                            teacherNameUpdate.setVisible(true);
                            teacherSurnameUpdate.setVisible(true);
                            teacherPhoneUpdate.setVisible(true);
                            groupNumberUpdate.setVisible(true);
                            teachersImageUpdate.setVisible(true);

                            commitUpdateTeacher.setVisible(true);

                            teacherNameUpdate.setText(Utilities.teacherName(event, parseString(teacherIDUpdate.getText())));
                            teacherSurnameUpdate.setText(Utilities.teacherSurname(event, parseString(teacherIDUpdate.getText())));
                            teacherPhoneUpdate.setText(Utilities.teacherPhone(event, parseString(teacherIDUpdate.getText())));
                            groupNumberUpdate.setText(Utilities.teacherGroup(event, parseString(teacherIDUpdate.getText())));
                        }
                        else
                        {
                            System.out.println("No teacher with this ID");
                        }
                        Platform.runLater( () -> image.requestFocus() );
                    }
                });

                cprUpdate.setVisible(false);
                search.setVisible(false);
                nameUpdate.setVisible(false);
                surnameUpdate.setVisible(false);
                dateOfBirthUpdate.setVisible(false);
                parentPhoneUpdate.setVisible(false);
                parentNameUpdate.setVisible(false);
                parentSurnameUpdate.setVisible(false);
                addressUpdate.setVisible(false);
                groupUpdate.setVisible(false);
                waitingListUpdate.setVisible(false);
                childImageUpdate.setVisible(false);

                teacherIDSearch.setVisible(false);
                workDayUpdate.setVisible(false);
                startHourUpdate.setVisible(false);
                endHourUpdate.setVisible(false);
                calendarUpdate.setVisible(false);
                searchSchedule.setVisible(false);
            }
        });

        updateSchedule.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                updatePane.setVisible(true);
                currentDefaultText = "Update schedule information";
                currentSpeechXCoordinate = 163;

                teacherIDSearch.setVisible(true);
                workDayUpdate.setVisible(true);
                searchSchedule.setVisible(true);
                startHourUpdate.setVisible(false);
                endHourUpdate.setVisible(false);
                calendarUpdate.setVisible(true);

               searchSchedule.setOnAction(new EventHandler<ActionEvent>()
               {
                   @Override
                   public void handle(ActionEvent event)
                   {
                       if (Utilities.searchSchedule(event, parseString(teacherIDSearch.getText()), Date.valueOf(workDayUpdate.getText())))
                       {
                           teacherIDSearch.setVisible(false);
                           workDayUpdate.setVisible(false);
                           searchSchedule.setVisible(false);
                           startHourUpdate.setVisible(true);
                           endHourUpdate.setVisible(true);

                           commitUpdateSchedule.setVisible(true);

                           startHourUpdate.setText(Utilities.startTime(event, parseString(teacherIDSearch.getText()), Date.valueOf(workDayUpdate.getText())));
                           endHourUpdate.setText(Utilities.endTime(event, parseString(teacherIDSearch.getText()), Date.valueOf(workDayUpdate.getText())));
                       }
                   }
               });

                cprUpdate.setVisible(false);
                search.setVisible(false);
                nameUpdate.setVisible(false);
                surnameUpdate.setVisible(false);
                dateOfBirthUpdate.setVisible(false);
                parentPhoneUpdate.setVisible(false);
                parentNameUpdate.setVisible(false);
                parentSurnameUpdate.setVisible(false);
                addressUpdate.setVisible(false);
                groupUpdate.setVisible(false);
                waitingListUpdate.setVisible(false);
                childImageUpdate.setVisible(false);

                teacherIDUpdate.setVisible(false);
                searchTeacher.setVisible(false);
                teacherNameUpdate.setVisible(false);
                teacherSurnameUpdate.setVisible(false);
                teacherPhoneUpdate.setVisible(false);
                groupNumberUpdate.setVisible(false);
                teachersImageUpdate.setVisible(false);
            }
        });

        commitAddTeacher.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                int result =Utilities.addTeacher(event, teacherName.getText(), teacherSurname.getText(),teacherPhone.getText(), groupNumber.getText());
                if(result == 1)
                {
                    speech.setText("Teacher already in database");
                    currentDefaultText = "Teacher already in database";
                    speech.setLayoutX(165);
                }
                else if(result == 0)
                {
                    speech.setText("Successfully added teacher");
                    currentDefaultText = "Successfully added teacher";
                    speech.setLayoutX(174);
                    resetButtons();
                    addPane.setVisible(false);
                    addTeacherButton.setVisible(false);
                    addKidButton.setVisible(false);
                    addScheduleButton.setVisible(false);
                    commitAddTeacher.setVisible(false);
                }
                else
                {
                    speech.setText("No such group");
                    currentDefaultText = "No such group";
                    speech.setLayoutX(232);
                }
            }
        });

        commitAddKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                int result = Utilities.addChild(event, name.getText(), surname.getText(), Date.valueOf(dateOfBirth.getText()),
                        cpr.getText(), parentPhone.getText(), parentName.getText(), parentSurname.getText(), address.getText(), group.getText(), waitingList.isSelected());
                if(result == 0)
                {
                    speech.setText("Child already in a group");
                    currentDefaultText = "Child already in a group";
                    speech.setLayoutX(190);
                }
                else if (result == 1)
                {
                    speech.setText("Successfully added child");
                    currentDefaultText = "Successfully added child";
                    speech.setLayoutX(188);
                    addPane.setVisible(false);
                    addKidButton.setVisible(false);
                    addTeacherButton.setVisible(false);
                    addScheduleButton.setVisible(false);
                    commitAddKid.setVisible(false);
                    resetButtons();
                }
                else
                {
                    speech.setText("No such group");
                    currentDefaultText = "No such group";
                    speech.setLayoutX(232);
                }
            }
        });

        commitAddSchedule.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(Utilities.addSchedule(event, Date.valueOf(workDay.getText()), Time.valueOf(startHour.getText()), Time.valueOf(endHour.getText()), parseString(teacherID.getText())))
                {
                    speech.setText("Employee already working on date");
                    currentDefaultText = "Employee already working on date";
                }
                else
                {
                    speech.setText("Added a working day for employee");
                    currentDefaultText = "Added a working day for employee";
                    resetButtons();
                    addPane.setVisible(false);
                    addTeacherButton.setVisible(false);
                    addKidButton.setVisible(false);
                    addScheduleButton.setVisible(false);
                    commitAddTeacher.setVisible(false);
                }
            }
        });

        commitUpdateKid.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(Utilities.updateChild(event, nameUpdate.getText(),surnameUpdate.getText(), Date.valueOf(dateOfBirthUpdate.getText()),
                    cprUpdate.getText(), parentPhoneUpdate.getText(), parentNameUpdate.getText(), parentSurnameUpdate.getText(), addressUpdate.getText(), groupNumberUpdate.getText(), waitingListUpdate.isSelected()))
                {
                    speech.setText("Successfully update child");
                    commitUpdateKid.setVisible(false);
                    resetButtons();
                    updatePane.setVisible(false);
                    updateKid.setVisible(false);
                    updateTeacher.setVisible(false);
                    updateSchedule.setVisible(false);
                }
                else
                {
                    speech.setText("No such group");
                }
            }
        });

        commitUpdateTeacher.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.updateTeacher(event, teacherNameUpdate.getText(), teacherSurnameUpdate.getText(), teacherPhoneUpdate.getText(), groupNumberUpdate.getText());
            }
        });

        commitUpdateSchedule.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Utilities.updateSchedule(event, Time.valueOf(startHourUpdate.getText()), Time.valueOf(endHourUpdate.getText()));
            }
        });

        commitAddUser.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                accountRemove.setVisible(false);
                commitRemoveUser.setVisible(false);
                int result = Utilities.adminAdd(event, addUsername.getText() ,parseString(addUTeacherID.getText()));
                if(result == 0)
                {
                    speech.setText("Account with this id exists");
                    speech.setLayoutX(176);
                }
                else if(result == 1)
                {
                    speech.setText("Username already exists");
                    speech.setLayoutX(184);
                }
                else if(result == 3)
                {
                    speech.setText("No teacher with such ID");
                    speech.setLayoutX(189);
                }
                else
                {
                    speech.setText("Account successfully created");
                    speech.setLayoutX(159);
                    userPane.setVisible(false);
                    resetButtons();
                }
            }
        });
        commitRemoveUser.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(Utilities.removeAccount(event, accountRemove.getText()))
                {
                    speech.setText("Successfully removed account");
                    currentDefaultText = "Successfully removed account";
                    speech.setLayoutX(152);
                    resetButtons();
                    accountRemove.setVisible(false);
                    userPane.setVisible(false);
                }
                else
                {
                    speech.setText("No such user");
                    currentDefaultText = "No such user";
                    speech.setLayoutX(241);
                }
            }
        });

        commitChangePassword.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               Utilities.changePassword(event, changePassword.getText());
           }
        });
    }

    private int parseString(String number)
    {
        try
        {
            int returnValue = Integer.parseInt(number);
            return returnValue;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
