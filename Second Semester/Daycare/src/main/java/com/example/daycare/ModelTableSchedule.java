package com.example.daycare;

public class ModelTableSchedule {

    String workday, startHour, endHour;
    int employeeId;

    public ModelTableSchedule(String workday, String startHour, String endHour, int employeeId) {
        this.workday = workday;
        this.startHour = startHour;
        this.endHour = endHour;
        this.employeeId = employeeId;
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

    public int getEmployeeId() {
        return employeeId;
    }
}
