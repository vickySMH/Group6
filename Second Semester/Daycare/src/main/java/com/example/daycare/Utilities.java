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

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
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

    public static void removeTeacher(int ID) throws SQLException{
        PreparedStatement stmt = null;
        try
        {
            stmt = connection.prepareStatement("DELETE FROM sql11478968.Employees WHERE ID = ?");
            stmt.setInt(1, ID);
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void removeKid(int CPR) throws SQLException{
        PreparedStatement stmt = null;
        try
        {
            stmt = connection.prepareStatement("DELETE FROM sql11478968.Children WHERE CPR = ?");
            stmt.setInt(1, CPR);
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void removeSchedule(int EmployeeID) throws SQLException{
        PreparedStatement stmt = null;
        try
        {
            stmt = connection.prepareStatement("DELETE FROM sql11478968.Schedule WHERE EmployeeID = ?");
            stmt.setInt(1, EmployeeID);
            stmt.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void addTeacher(ActionEvent event, String name, String surname, String phoneNumber, String GroupNumber)
    {
        try
        {
            boolean teacherExists = false;
            connection();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO sql11478968.Employees (GroupNumber, Name, Surname, PhoneNumber) VALUES (?, ?, ?, ? )");
            preparedStatementInsert.setString(1, GroupNumber);
            preparedStatementInsert.setString(2, name);
            preparedStatementInsert.setString(3, surname);
            preparedStatementInsert.setString(4, phoneNumber);
            preparedStatement = connection.prepareStatement("SELECT PhoneNumber FROM sql11478968.Employees");
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
            preparedStatement = connection.prepareStatement("SELECT password from sql11478968.Users where username = ?; ");
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
