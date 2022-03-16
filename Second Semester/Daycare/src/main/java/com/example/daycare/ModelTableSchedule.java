package com.example.daycare;

public class ModelTableSchedule {

    String workday, startHour, endHour, employeeID;

    public ModelTableSchedule(String workday, String startHour, String endHour, String employeeID) {
        this.workday = workday;
        this.startHour = startHour;
        this.endHour = endHour;
        this.employeeID = employeeID;
    }

    public String getWorkday() {
        return workday;
    }

    public String getStartHour() {
        return startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}
