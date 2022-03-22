package com.example.daycare;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Random;


public class Utilities
{

    private static PreparedStatement preparedStatement = null;
    private static PreparedStatement preparedStatementInsert = null;
    private static PreparedStatement preparedStatementUserExists = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;
    private static final String url = System.getenv("URL");
    private static final String user = System.getenv("user");
    private static final String password = System.getenv("password");

    public static boolean removeTeacher(int ID)
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
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("ID");
                    if (retrieveID == ID)
                    {
                        preparedStatementUserExists.executeUpdate();
                        return true;
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
        return false;
    }

    public static boolean removeKid(String CPR)
    {
        try
        {
            connection();
            preparedStatementUserExists = connection.prepareStatement("DELETE FROM sql11478968.Children WHERE CPR = ?");
            preparedStatementUserExists.setString(1, CPR);
            preparedStatement = connection.prepareStatement("SELECT * FROM Children");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    String retrieveCPR = resultSet.getString("CPR");
                    if (retrieveCPR.equals(CPR))
                    {
                        preparedStatementUserExists.executeUpdate();
                        return true;
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
        return false;
    }

    public static boolean removeSchedule(int ID, Date date)
    {
        boolean remove = false;
        try
        {
            connection();
            preparedStatementUserExists = connection.prepareStatement("DELETE FROM sql11478968.Schedule WHERE EmployeeID = ? AND WorkDay = ?");
            preparedStatementUserExists.setInt(1, ID);
            preparedStatementUserExists.setDate(2, date);
            preparedStatement = connection.prepareStatement("SELECT * FROM Schedule");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("EmployeeID");
                    Date retrieveDate = resultSet.getDate("WorkDay");
                    if (retrieveID == ID && retrieveDate.equals(date))
                    {
                        preparedStatementUserExists.executeUpdate();
                        return remove = true;
                    }
                }
            }
        }
        catch (SQLException e)
        {
            return remove;
        }
        catch (IllegalArgumentException e)
        {
            return remove;
        }
        finally
        {
            closeConnection();
        }
        return remove;
    }

    public static boolean removeAccount(ActionEvent event, String username)
    {
        try
        {
            connection();
            preparedStatementUserExists = connection().prepareStatement("DELETE FROM Users WHERE Username = ?");
            preparedStatementUserExists.setString(1, username);
            preparedStatement = connection().prepareStatement("SELECT Username FROM Users");
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while(resultSet.next())
                {
                    String retrieveUsername = resultSet.getString("Username");
                    if(retrieveUsername.equals(username))
                    {
                        preparedStatementUserExists.executeUpdate();
                        return true;
                    }
                }
                return false;
            }
        }
        catch (SQLException e)
        {
            return false;
        }
        finally
        {
            closeConnection();
        }
    }

    public static int addChild(ActionEvent event, String name, String surname, Date date, String cpr ,String parentPhone ,String parentName, String parentSurname, String address, String groupNumber, boolean waitingList)
    {
        try
        {
            connection();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO Children (Name, Surname, DateOfBirth, CPR ,ParentPhone, ParentName, ParentSurname, Address, GroupNumber, onWaitingList) VALUES (?,?,?,?,?,?,?,?,?,?)");
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
                closeConnection();
                return 0;
            }
            else
            {
                while(resultSet.next())
                {
                    String retrieveCPR = resultSet.getString("CPR");
                    if(retrieveCPR.equals(cpr))
                    {
                        kidExists = true;
                        closeConnection();
                        return 1;
                    }
                }
                if(!kidExists)
                {
                    preparedStatementInsert.executeUpdate();
                    closeConnection();
                    return 0;
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 2;
        }
        finally
        {
            closeConnection();
        }
        return 0;
    }

    public static int addTeacher(ActionEvent event, String name, String surname, String phoneNumber, String GroupNumber)
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
                return 0;
            }
            else
            {
                while(resultSet.next())
                {
                    String retrievePhoneNumber = resultSet.getString("PhoneNumber");
                    if(retrievePhoneNumber.equals(phoneNumber))
                    {
                        teacherExists = true;
                        closeConnection();
                        return 1;
                    }
                }
                if(!teacherExists)
                {
                    preparedStatementInsert.executeUpdate();
                    closeConnection();
                    return 0;
                }
            }
        }
        catch (SQLException e)
        {
            return 2;
        }
        finally
        {
            closeConnection();
        }
        return 0;
    }

    public static boolean addSchedule(ActionEvent event, Date workDay, Time startHour, Time endHour, int employeeID)
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
                closeConnection();
                return empAlreadyWorking;
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
                        closeConnection();
                        return empAlreadyWorking;
                    }
                }
                if(!empAlreadyWorking)
                {
                    preparedStatementInsert.executeUpdate();
                    closeConnection();
                    return empAlreadyWorking;
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
        return false;
    }

    public static boolean updateChild(ActionEvent event, String name, String surname, Date date, String cpr ,String parentPhone ,String parentName, String parentSurname, String address, String groupNumber, boolean waitingList)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("UPDATE Children SET NAME = ?, Surname = ?, DateOfBirth = ?, ParentPhone = ?, ParentName = ?, ParentSurname = ?, Address = ?, GroupNumber = ?, onWaitingList = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,surname);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, parentPhone);
            preparedStatement.setString(5, parentName);
            preparedStatement.setString(6, parentSurname);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, groupNumber);
            preparedStatement.setBoolean(9, waitingList);
            preparedStatement.executeUpdate();
            closeConnection();
            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
        finally
        {
            closeConnection();
        }
    }

    public static boolean updateTeacher(ActionEvent event, String name, String surname, String phoneNumber, String GroupNumber)
    {
        boolean update = false;
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("UPDATE Employees SET Name = ?, Surname = ?, PhoneNumber = ?, GroupNumber = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, GroupNumber);
            preparedStatement.executeUpdate();
            return update = true;
        }
        catch (SQLException e)
        {
            return update;
        }
        finally
        {
            closeConnection();
        }
    }

    public static boolean updateSchedule(ActionEvent event, Time startHour, Time endHour)
    {
        boolean update = false;
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("UPDATE Schedule SET StartHour = ?, EndHour = ?");
            preparedStatement.setTime(1, startHour);
            preparedStatement.setTime(2, endHour);
            preparedStatement.executeUpdate();
            return update = true;
        }
        catch (SQLException e)
        {
            return update;
        }
        catch (IllegalArgumentException e)
        {
            return update;
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

    public static boolean search(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT CPR FROM Children");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    String retrieveCPR = resultSet.getString("CPR");
                    if (retrieveCPR.equals(CPR))
                    {
                        return true;
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
        return false;
    }

    public static String name(ActionEvent event,String CPR )
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT NAME, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if(retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("Name");
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
        return "";
    }

    public static String surname(ActionEvent event, String CPR)
    {
        try
        {
        connection();
        preparedStatement = connection.prepareStatement("SELECT Surname, CPR FROM Children WHERE CPR = ?");
        preparedStatement.setString(1, CPR);
        resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("Surname");
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
        return "";
    }

    public static String dateOfBirth(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT DateOfBirth, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("DateOfBirth");
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
        return "";
    }

    public static String parentPhone(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT ParentPhone, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("ParentPhone");
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
        return "";
    }

    public static String parentName(ActionEvent event,String CPR )
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT ParentName, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if(retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("ParentName");
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
        return "";
    }

    public static String parentSurname(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT ParentSurname, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("ParentSurname");
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
        return "";
    }

    public static String address(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT Address, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("Address");
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
        return "";
    }

    public static String groupNumber(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT GroupNumber, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getString("GroupNumber");
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
        return "";
    }

    public static boolean waitingList(ActionEvent event, String CPR)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT onWaitingList, CPR FROM Children WHERE CPR = ?");
            preparedStatement.setString(1, CPR);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                String retrieveCPR = resultSet.getString("CPR");
                if (retrieveCPR.equals(CPR))
                {
                    return resultSet.getBoolean("onWaitingList");
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
        return false;
    }

    public static boolean searchTeacher(ActionEvent event, int ID)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT ID FROM Employees");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("ID");
                    if (retrieveID == ID)
                    {
                        return true;
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
        return false;
    }

    public static String teacherName(ActionEvent event, int ID)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT Name, ID FROM Employees WHERE ID = ? ");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("ID");
                if (retrieveID == ID)
                {
                    return resultSet.getString("Name");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection();
        }
        return "";
    }

    public static String teacherSurname(ActionEvent event, int ID)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT Surname, ID FROM Employees WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("ID");
                if (retrieveID == ID)
                {
                    return resultSet.getString("Surname");
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
        return "";
    }

    public static String teacherPhone(ActionEvent event, int ID)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT PhoneNumber, ID FROM Employees WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("ID");
                if (retrieveID == ID)
                {
                    return resultSet.getString("PhoneNumber");
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
        return "";
    }

    public static String teacherGroup(ActionEvent event, int ID)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT GroupNumber, ID FROM Employees WHERE ID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("ID");
                if (retrieveID == ID)
                {
                    return resultSet.getString("GroupNumber");
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
        return "";
    }

    public static boolean searchSchedule(ActionEvent event, int EmployeeID, Date WorkDay)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT EmployeeID, WorkDay FROM Schedule");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
            {
                while (resultSet.next())
                {
                    int retrieveID = resultSet.getInt("EmployeeID");
                    Date retrieveDay = resultSet.getDate("WorkDay");
                    if(retrieveID == EmployeeID && retrieveDay.equals(WorkDay))
                    {
                        return true;
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
        return false;
    }

    public static String startTime(ActionEvent event, int EmployeeID, Date WorkDay)
    {
        try
        {
            String time;
            connection();
            preparedStatement = connection.prepareStatement("SELECT StartHour, EmployeeID, WorkDay FROM Schedule WHERE EmployeeID = ? AND WorkDay = ?");
            preparedStatement.setInt(1, EmployeeID);
            preparedStatement.setDate(2, WorkDay);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("EmployeeID");
                Date retrieveDay = resultSet.getDate("WorkDay");
                if (retrieveID == EmployeeID && retrieveDay.equals(WorkDay))
                {
                    time = resultSet.getTime("StartHour").toString();
                    return time;
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
        return "";
    }

    public static String endTime(ActionEvent event, int EmployeeID, Date WorkDay)
    {
        try
        {
            String time;
            connection();
            preparedStatement = connection.prepareStatement("SELECT EndHour, EmployeeID, WorkDay FROM Schedule WHERE EmployeeID = ? AND WorkDay = ?");
            preparedStatement.setInt(1, EmployeeID);
            preparedStatement.setDate(2, WorkDay);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int retrieveID = resultSet.getInt("EmployeeID");
                Date retrieveDay = resultSet.getDate("WorkDay");
                if (retrieveID == EmployeeID && retrieveDay.equals(WorkDay))
                {
                    time = resultSet.getTime("EndHour").toString();
                    return time;
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
        return "";
    }

    public static boolean accountSearch(ActionEvent event, String username)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT Username FROM Users");
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst())
            {
                return false;
            }
            else
                while (resultSet.next())
                {
                    String retrieveUsername = resultSet.getString("Username");
                    if (retrieveUsername.equals(username))
                    {
                        return true;
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
        return false;
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

    private static Connection connection()
    {
        try
        {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
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

    public static ObservableList<ModelTableAccount> getAccountsData()
    {
        connection = connection();
        ObservableList<ModelTableAccount> accounts = FXCollections.observableArrayList();
        try
        {
            preparedStatement = connection.prepareStatement("SELECT * FROM Users");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                accounts.add(new ModelTableAccount(resultSet.getString("Username"),
                        resultSet.getString("Password"),
                        resultSet.getInt("EmployeeID")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return accounts;
    }
    
    public static ObservableList<ModelTableEmployee> getEmployeeData()
    {
        connection = connection();
        ObservableList<ModelTableEmployee> empList = FXCollections.observableArrayList();
        try
        {
            preparedStatement = connection.prepareStatement("SELECT * FROM Employees");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                empList.add(new ModelTableEmployee(resultSet.getInt("ID"),
                        resultSet.getString("Name"), resultSet.getString("Surname"),
                        resultSet.getString("PhoneNumber"), resultSet.getString("GroupNumber")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return empList;
    }

    public static ObservableList<ModelTableChild> getChildData(){
        connection = connection();
        ObservableList<ModelTableChild> childList = FXCollections.observableArrayList();
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Children");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                childList.add(new ModelTableChild(Integer.parseInt(resultSet.getString("ID")),
                        resultSet.getString("CPR"), resultSet.getString("Name"),
                        resultSet.getString("Surname"), resultSet.getString("DateOfBirth"),
                        resultSet.getString("ParentPhone"), resultSet.getString("ParentName"),
                        resultSet.getString("ParentSurname"), resultSet.getString("Address"),
                        resultSet.getString("GroupNumber"), resultSet.getString("onWaitingList")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return childList;
    }

    public static ObservableList<ModelTableSchedule> getScheduleData(){
        connection = connection();
        ObservableList<ModelTableSchedule> scheduleList = FXCollections.observableArrayList();
        try
        {
            preparedStatement = connection.prepareStatement("SELECT * FROM Schedule");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                scheduleList.add(new ModelTableSchedule(resultSet.getString("WorkDay"),
                        resultSet.getString("StartHour"), resultSet.getString("EndHour"),
                        resultSet.getInt("EmployeeID")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return scheduleList;
    }

    public static ObservableList<ModelTableTeacherChild> viewChildData(String username)
    {
        connection = connection();
        ObservableList<ModelTableTeacherChild> teacherChildList = FXCollections.observableArrayList();
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Children, Users, Employees WHERE Users.username = ? AND Users.EmployeeID = Employees.ID AND Employees.GroupNumber =  Children.GroupNumber");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                teacherChildList.add(new ModelTableTeacherChild(Integer.parseInt(resultSet.getString("ID")),
                        resultSet.getString("CPR"), resultSet.getString("Name"),
                        resultSet.getString("Surname"), resultSet.getString("DateOfBirth"),
                        resultSet.getString("ParentPhone"), resultSet.getString("ParentName"),
                        resultSet.getString("ParentSurname"), resultSet.getString("Address"), resultSet.getString("onWaitingList")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return teacherChildList;
    }

    public static ObservableList<ModelTableTeacherSchedule> viewTeacherSchedule(String teacher)
    {
        connection = connection();
        ObservableList<ModelTableTeacherSchedule> teacherScheduleList = FXCollections.observableArrayList();
        try
        {
            preparedStatement = connection.prepareStatement("SELECT * FROM Schedule, Users, Employees WHERE Users.Username = ? AND Employees.ID = Users.EmployeeID AND Schedule.EmployeeID = Employees.ID");
            preparedStatement.setString(1, teacher);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                teacherScheduleList.add(new ModelTableTeacherSchedule(resultSet.getString("WorkDay"),
                        resultSet.getString("StartHour"), resultSet.getString("EndHour")));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return teacherScheduleList;
    }

    public static int adminAdd(ActionEvent event, String username, int id)
    {
        try
        {
            connection();
            String password = generatePass();
            preparedStatementInsert = connection.prepareStatement("INSERT INTO Users (username, password, employeeid) VALUES (?, ?, ?)");
            preparedStatementInsert.setString(1, username);
            preparedStatementInsert.setString(2, password);
            preparedStatementInsert.setInt(3, id);
            preparedStatement = connection.prepareStatement("SELECT Employees.ID, Users.EmployeeID, Users.Username FROM Employees, Users");
            resultSet = preparedStatement.executeQuery();
            boolean suchUserExists = false;
            if(!resultSet.isBeforeFirst())
            {
                preparedStatementInsert.executeUpdate();
                closeConnection();
                return 2;
            }
            else
            {
                while(resultSet.next())
                {
                    String retrieveUsername = resultSet.getString("Username");
                    int retrieveUEmpID = resultSet.getInt("EmployeeID");
                    if(retrieveUEmpID == (id))
                    {
                        suchUserExists = true;
                        closeConnection();
                        return 0;
                    }
                    else if(retrieveUsername.equals(username))
                    {
                        closeConnection();
                        suchUserExists = true;
                        return 1;
                    }
                }
                if(!suchUserExists)
                {
                    preparedStatementInsert.executeUpdate();
                    closeConnection();
                    return 2;
                }
            }

        }
        catch (SQLException e)
        {
            return 3;
        }
        finally
        {
            closeConnection();
        }
        return 2;
    }
    private static String generatePass()
    {
        Random random = new Random();
        String password = random.ints(48,123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(7)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }

    public static void changePassword(ActionEvent event, String password, String username) {

        try
        {
            connection();
            preparedStatement = connection.prepareStatement("UPDATE Users SET Password = ? WHERE Username = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }
    
}
