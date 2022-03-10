package com.example.daycare;

import javafx.event.ActionEvent;

import java.sql.*;

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
    
//    public static void changeScene(ActionEvent event, String fmxlFile, String username, String password){
//        Parent root = null;
//
//        if(user != null && password != null){
//            try {
//                FXMLLoader loader = new FXMLLoader(Utilities.class.getResource(fmxlFile));
//                root = loader.load();
//                LoggedInController loggedInController = loader.getController();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        else{
//            try{
//                root = FXMLLoader.load(Utilities.class.getResource(fmxlFile));
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }

    public static void loginUser(ActionEvent event, String username, String password)
    {
        try
        {
            connection();
            preparedStatement = connection.prepareStatement("SELECT password, from Daycare.users where username = ?; ");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {

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

}
