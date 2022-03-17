package com.example.daycare;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilities
{

    private static PreparedStatement preparedStatement = null;
    private static PreparedStatement preparedStatementInsert = null;
    private static PreparedStatement preparedStatementUserExists = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static String url = System.getenv("URL");
    private static String user = System.getenv("user");
    private static String password = System.getenv("password");

    public static void removeTeacher(int ID)
    {
        try
        {
            connection();
            preparedStatementUserExists = connection.prepareStatement("DELETE FROM sql11478968.Employees WHERE ID = ?");
            preparedStatementUserExists.setInt(1, ID);
            preparedStatement = connection.prepareStatement("SELECT * FROM Employees");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Employee doesn't exist!");
                alert.show();
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("ID");
                    if (retrieveID == ID)
                    {
                        preparedStatementUserExists.executeUpdate();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void removeKid(int CPR)
    {
        try
        {
            connection();
            preparedStatementUserExists = connection.prepareStatement("DELETE FROM sql11478968.Children WHERE CPR = ?");
            preparedStatementUserExists.setInt(1, CPR);
            preparedStatement = connection.prepareStatement("SELECT * FROM Children");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Child doesn't exist!");
                alert.show();
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveCPR = resultSet.getInt("ID");
                    if (retrieveCPR == CPR)
                    {
                        preparedStatementUserExists.executeUpdate();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void removeSchedule(int ID)
    {
        try
        {
            connection();
            preparedStatementUserExists = connection.prepareStatement("DELETE FROM sql11478968.Schedule WHERE ID = ?");
            preparedStatementUserExists.setInt(1, ID);
            preparedStatement = connection.prepareStatement("SELECT * FROM Schedule");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Schedule doesn't exist!");
                alert.show();
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("ID");
                    if (retrieveID == ID)
                    {
                        preparedStatementUserExists.executeUpdate();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void addChild(ActionEvent event, String name, String surname, Date date, String cpr ,String parentPhone ,String parentName, String parentSurname, String address, String groupNumber, boolean waitingList)
    {
        try
        {
            connection();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO Children (Name, Surname, DateOfBirth, CPR ,ParentPhone, ParentName, ParentSurname, Address, GroupNumber, onWaitingList) VALUES (?,?,?,?,?,?,?,?,?,?) ");
            preparedStatementInsert.setString(1, name);
            preparedStatementInsert.setString(2, surname);
            preparedStatementInsert.setDate(3, date);
            preparedStatementInsert.setString(4, cpr);
            preparedStatementInsert.setString(5, parentPhone);
            preparedStatementInsert.setString(6, parentName);
            preparedStatementInsert.setString(7, parentSurname);
            preparedStatementInsert.setString(8, address);
            preparedStatementInsert.setString(9, groupNumber);
            preparedStatementInsert.setBoolean(10, waitingList);
            preparedStatement = connection.prepareStatement("SELECT CPR FROM Children");
            resultSet = preparedStatement.executeQuery();
            boolean kidExists = false;
            if(!resultSet.isBeforeFirst())
            {
                preparedStatementInsert.executeUpdate();
            }
            else
            {
                while(resultSet.next())
                {
                    String retrieveCPR = resultSet.getString("CPR");
                    if(retrieveCPR.equals(cpr))
                    {
                        kidExists = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Child already listed in a group");
                        alert.show();
                    }
                }
                if(!kidExists)
                {
                    preparedStatementInsert.executeUpdate();
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully added a child");
            alert.show();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void addTeacher(ActionEvent event, String name, String surname, String phoneNumber, String GroupNumber)
    {
        try
        {
            boolean teacherExists = false;
            connection();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO Employees (GroupNumber, Name, Surname, PhoneNumber) VALUES (?, ?, ?, ? )");
            preparedStatementInsert.setString(1, GroupNumber);
            preparedStatementInsert.setString(2, name);
            preparedStatementInsert.setString(3, surname);
            preparedStatementInsert.setString(4, phoneNumber);
            preparedStatement = connection.prepareStatement("SELECT PhoneNumber FROM Employees");
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst())
            {
                preparedStatementInsert.executeUpdate();
            }
            else
            {
                while(resultSet.next())
                {
                    String retrievePhoneNumber = resultSet.getString("PhoneNumber");
                    if(retrievePhoneNumber.equals(phoneNumber))
                    {
                        teacherExists = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Teacher already hired");
                        alert.show();
                    }
                }
                if(!teacherExists)
                {
                    preparedStatementInsert.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully hired teacher");
                    alert.show();
                }
            }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void addSchedule(ActionEvent event, Date workDay, Time startHour, Time endHour, int employeeID)
    {
        try
        {
            connection();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO Schedule VALUES (?,?,?,?)");
            preparedStatementInsert.setDate(1, workDay);
            preparedStatementInsert.setTime(2, startHour);
            preparedStatementInsert.setTime(3, endHour);
            preparedStatementInsert.setInt(4, employeeID);
            preparedStatement = connection.prepareStatement("SELECT WorkDay, EmployeeID FROM Schedule");
            resultSet = preparedStatement.executeQuery();
            boolean empAlreadyWorking = false;
            if(!resultSet.isBeforeFirst())
            {
                preparedStatementInsert.executeUpdate();
            }
            else
            {
                while (resultSet.next())
                {
                    Date retrieveWorkDay = resultSet.getDate("WorkDay");
                    int retrieveEmployeeID = resultSet.getInt("EmployeeID");
                    if(retrieveEmployeeID == employeeID && retrieveWorkDay.equals(workDay))
                    {
                        empAlreadyWorking = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Employee is already working on that day");
                        alert.show();
                    }
                }
                if(!empAlreadyWorking)
                {
                    preparedStatementInsert.executeUpdate();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    public static void returnToLogin(ActionEvent event)
    {
        Parent root = null;
        try
        {
            FXMLLoader loader = new FXMLLoader(Utilities.class.getResource("main.fxml"));
            root = loader.load();
            MainController mainController = loader.getController();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 750, 500);
        scene.setFill(Color.TRANSPARENT);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title ,String username, String password)
    {
        Parent root = null;

        if(username != null)
        {
            try
            {
                LoggedInController.setUsername(username);
                FXMLLoader loader = new FXMLLoader(Utilities.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
        }
        else
        {
            try
            {
                root = FXMLLoader.load(Utilities.class.getResource(fxmlFile));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        stage.setScene(new Scene(root, Double.MAX_VALUE,Double.MAX_VALUE));
        stage.sizeToScene();
        stage.setFullScreen(true);
        stage.show();
    }

    public static void loginUser(ActionEvent event, String username, String password)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT password from Users where username = ?; ");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst())
            {
                System.out.println("User not found");
                Alert alert = new Alert(Alert.AlertType.ERROR, "User not found!");
                alert.show();
            }
            else
            {
                while (resultSet.next())
                {
                    String retrievePassword = resultSet.getString("password");
                    if(retrievePassword.equals(password))
                    {
                        changeScene(event, "logged-in.fxml", "Welcome!", username, password);
                    }
                    else
                    {
                        System.out.println("Credentials do not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid credentials!");
                        alert.show();
                    }
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection();
        }
    }

    private static void connection()
    {
        try
        {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private static void closeConnection()
    {
        if(resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null)
        {
            try
            {
                preparedStatement.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(preparedStatementInsert != null)
        {
            try
            {
                preparedStatementInsert.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(preparedStatementUserExists != null)
        {
            try
            {
                preparedStatementUserExists.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
