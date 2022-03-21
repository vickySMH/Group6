package com.example.daycare;

public class ModelTableAccount
{
    String username, password;
    int employeeID;

    public ModelTableAccount(String username, String password, int employeeID)
    {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

}
